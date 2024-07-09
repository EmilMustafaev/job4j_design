package ru.job4j.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;

public class CSVReader {
    public static void handle(ArgsName argsName) throws Exception {
        String path = argsName.get("path");
        String delimiter = argsName.get("delimiter");
        String out = argsName.get("out");
        List<String> filters = Arrays.asList(argsName.get("filter").split(","));

        List<String> lines = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileInputStream(path))) {
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        }

        List<String> headers = Arrays.asList(lines.get(0).split(delimiter));
        List<Integer> filterIndexes = filters.stream()
                .map(headers::indexOf)
                .toList();

        List<String> filteredLines = new ArrayList<>();
        for (String line : lines) {
            String[] values = line.split(delimiter);
            StringJoiner joiner = new StringJoiner(delimiter);
            for (Integer index : filterIndexes) {
                joiner.add(values[index]);
            }
            filteredLines.add(joiner.toString());
        }

        if ("stdout".equals(out)) {
            filteredLines.forEach(System.out::println);
        } else {
            try (PrintStream ps = new PrintStream(new FileOutputStream(out))) {
                for (String line : filteredLines) {
                    ps.println(line);
                }
            }
        }

    }

    public static void main(String[] args) {
        if (args.length < 4) {
            throw new IllegalArgumentException("Insufficient arguments. Usage: -path= -delimiter= -out= -filter=");
        }
        ArgsName argsName = ArgsName.of(args);
        try {
            handle(argsName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
