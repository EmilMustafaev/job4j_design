
package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        List<String> botPhrases = readPhrases();
        List<String> chatLog = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean isChatting = true;
        boolean isMuted = false;
        while (isChatting) {
            String userMessage = scanner.nextLine();
            chatLog.add("User: " + userMessage);
            if (OUT.equals(userMessage)) {
                isChatting = false;
            } else if (STOP.equals(userMessage)) {
                isMuted = true;
            } else if (CONTINUE.equals(userMessage)) {
                isMuted = false;
            } else if (!isMuted) {
                String botResponse = getRandomPhrase(botPhrases);
                System.out.println(botResponse);
                chatLog.add("Bot: " + botResponse);
            }
        }
        saveLog(chatLog);
    }

    private List<String> readPhrases() {
        List<String> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(botAnswers))) {
            result = reader
                    .lines()
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private void saveLog(List<String> log) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            for (String line : log) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getRandomPhrase(List<String> phrases) {
        Random random = new Random();
        return phrases.get(random.nextInt(phrases.size()));
    }

    public static void main(String[] args) {
        ConsoleChat consoleChat = new ConsoleChat("data/chat_log.txt", "data/bot_phrases.txt");
        consoleChat.run();
    }
}
