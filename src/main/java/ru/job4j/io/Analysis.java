package ru.job4j.io;

import java.io.*;

public class Analysis {
    public void unavailable(String source, String target) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(target)))) {
            String line;
            String start = null;
            StringBuilder result = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                String status = parts[0];
                String time = parts[1];

                if (start == null && ("400".equals(status) || "500".equals(status))) {
                    start = time;
                } else if (start != null && ("200".equals(status) || "300".equals(status))) {
                    result.setLength(0);
                    result.append(start).append(";").append(time).append(";");
                    writer.println(result);
                    start = null;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("data/server.log", "data/target.csv");
    }
}
