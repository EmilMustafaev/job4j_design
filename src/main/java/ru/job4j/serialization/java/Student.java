package ru.job4j.serialization.java;

import java.util.Arrays;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Student {
    private final boolean isStudent;
    private final int course;
    private final String name;
    private final String[] assessments;
    private final Faculty faculty;

    public Student(boolean isStudent, int course, String name, String[] assessments, Faculty faculty) {
        this.isStudent = isStudent;
        this.course = course;
        this.name = name;
        this.assessments = assessments;
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return "Student{"
                +
                "isStudent=" + isStudent
                +
                ", course=" + course
                +
                ", name='" + name + '\''
                +
                ", assessments=" + Arrays.toString(assessments)
                +
                ", faculty=" + faculty
                +
                '}';
    }

    public static void main(String[] args) {

        Student student = new Student(true, 3, "Emil",
                new String[]{"5, 4, 5, 3"}, new Faculty("Programmer"));

        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(student));

        final String studentJson =
                "{"
                        +
                        "\"isStudent\": true,"
                        +
                        "\"course\": 3,"
                        +
                        "\"name\": \"Emil\","
                        +
                        "\"assessments\": [\"5, 4, 5, 3\"],"
                        +
                        "\"faculty\": {"
                        +
                        "\"facultyName\": \"Programmer\""
                        +
                        "}"
                        +
                        "}";

        final Student studentMod = gson.fromJson(studentJson, Student.class);
        System.out.println(studentMod);
    }

}
