package ru.job4j.io;

import java.io.FileOutputStream;
import java.io.IOException;

public class ResultFile {
    public static void main(String[] args) {
        try (FileOutputStream output = new FileOutputStream("data/dataresult.txt")) {
            output.write("1 * 2 = 2".getBytes());
            output.write(System.lineSeparator().getBytes());
            output.write("1 * 3 = 3".getBytes());
            output.write(System.lineSeparator().getBytes());
            output.write("1 * 4 = 4".getBytes());
            output.write(System.lineSeparator().getBytes());
            output.write("1 * 5 = 5".getBytes());
            output.write(System.lineSeparator().getBytes());
            output.write("1 * 6 = 6".getBytes());
            output.write(System.lineSeparator().getBytes());
            output.write("1 * 7 = 7".getBytes());
            output.write(System.lineSeparator().getBytes());
            output.write("1 * 8 = 8".getBytes());
            output.write(System.lineSeparator().getBytes());
            output.write("1 * 9 = 9".getBytes());
            output.write(System.lineSeparator().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
