package ru.job4j.io;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.*;

class AnalysisTest {

    @Test
    void unavailable(@TempDir Path tempDir) throws IOException {
        File source = tempDir.resolve("server1.log").toFile();
        try (PrintWriter writerOut = new PrintWriter(source)) {
            writerOut.println("200 10:56:01\n" +
                    "500 10:57:01\n" +
                    "400 10:58:01\n" +
                    "500 10:59:01\n" +
                    "400 11:01:02\n" +
                    "200 11:02:02");
        }

        File target = tempDir.resolve("target1.csv").toFile();

        Analysis analysis = new Analysis();
        analysis.unavailable(source.getAbsolutePath(), target.getAbsolutePath());

        StringBuilder result = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(target))) {
            reader.lines().forEach(line -> result.append(line).append(System.lineSeparator()));
        }
        String expected = "10:57:01;11:02:02;" + System.lineSeparator();
        assertThat(result.toString()).isEqualTo(expected);
    }
}