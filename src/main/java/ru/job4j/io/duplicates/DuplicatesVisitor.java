package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {

    Map<FileProperty, List<Path>> files = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attributes) throws IOException {
        FileProperty fileProperty = new FileProperty(attributes.size(), file.getFileName().toString());
        files.putIfAbsent(fileProperty, new ArrayList<>());
        files.get(fileProperty).add(file);
        return FileVisitResult.CONTINUE;
    }

    public void printDuplicates() {
        files.forEach((fileProperty, paths) -> {
            if (paths.size() > 1) {
                System.out.println("File: " + fileProperty.getName() + " Size: " + fileProperty.getSize());
                paths.forEach(System.out::println);
            }
        });
    }
}
