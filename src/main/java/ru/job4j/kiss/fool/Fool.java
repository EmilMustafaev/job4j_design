package ru.job4j.kiss.fool;

import java.util.Scanner;

public class Fool {
    public static String getExpectedAnswer(int number) {
        String result;
        if (number % 3 == 0 && number % 5 == 0) {
            result = "FizzBuzz";
        } else if (number % 3 == 0) {
            result = "Fizz";
        } else if (number % 5 == 0) {
            result = "Buzz";
        } else {
            result = String.valueOf(number);
        }
        return result;
    }
    public static boolean isAnswerCorrect(int number, String answer) {
        return getExpectedAnswer(number).equals(answer);
    }
    public static void main(String[] args) {
        System.out.println("Игра FizzBuzz.");
        var startAt = 1;
        var input = new Scanner(System.in);

        while (startAt <= 100) {
            System.out.println(getExpectedAnswer(startAt));
            startAt++;

            String answer = input.nextLine();

            if (!isAnswerCorrect(startAt, answer)) {
                System.out.println("Ошибка. Начинай снова.");
                startAt = 1;
            } else {
                startAt++;
            }
        }

        System.out.println("Поздравляем! Игра окончена.");
    }
}

