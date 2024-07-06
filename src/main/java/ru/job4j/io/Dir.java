package ru.job4j.io;

import java.io.File;

import static java.lang.String.format;

public class Dir {
    public static void main(String[] args) {
        File file = new File("c:\\projects");
        System.out.println(format("File name : %s", file.getName()));
        System.out.println(format("File Length : %d", file.length()));

    }
}
