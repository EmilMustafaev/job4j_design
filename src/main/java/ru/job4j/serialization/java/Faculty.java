package ru.job4j.serialization.java;

public class Faculty {
    private final String facultyName;

    public Faculty(String facultyName) {
        this.facultyName = facultyName;
    }

    @Override
    public String toString() {
        return "Faculty{"
                +
                "facultyName='"
                + facultyName + '\''
                +
                '}';
    }
}
