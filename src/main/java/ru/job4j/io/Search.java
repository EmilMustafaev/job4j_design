package ru.job4j.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class Search {

    public static void main(String[] args) throws IOException {
        validateArgs(args);

        Path start = Paths.get(args[0]);
        String fileExtension = args[1];
        search(start, path -> path.toFile().getName().endsWith(fileExtension)).forEach(System.out::println);
    }

    public static void validateArgs(String[] args) {
        if (args.length < 2) {
            throw new IllegalArgumentException("Root folder or file extension is null. Usage: ROOT_FOLDER FILE_EXTENSION.");
        }
        File file = new File(args[0]);
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
        if (!args[1].startsWith(".")) {
            throw new IllegalArgumentException("Invalid file extension format. It should start with a dot.");
        }
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }
}
