package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path source : sources) {
                String zipEntryName = source.toString();
                zip.putNextEntry(new ZipEntry(zipEntryName));
                try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(source.toFile()))) {
                    zip.write(input.readAllBytes());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream output = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(output.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void validateArgs(String[] args) {
        ArgsName argsName = ArgsName.of(args);
        String directory = argsName.get("d");
        String exclude = argsName.get("e");
        String output = argsName.get("o");

        if (!Files.isDirectory(Paths.get(directory))) {
            throw new IllegalArgumentException(String.format("Not a directory: %s", directory));
        }
        if (!exclude.startsWith(".")) {
            throw new IllegalArgumentException(String.format("Invalid exclude extension: %s", exclude));
        }
        if (!output.endsWith(".zip")) {
            throw new IllegalArgumentException(String.format("Output file must have .zip extension: %s", output));
        }
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Arguments not passed to program");
        }
        validateArgs(args);

        ArgsName argsName = ArgsName.of(args);
        String directory = argsName.get("d");
        String exclude = argsName.get("e");
        String output = argsName.get("o");

        try {
            List<Path> sources = Search.search(Paths.get(directory), path -> !path.toString().endsWith(exclude));
            new Zip().packFiles(sources, new File(output));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

