package ru.job4j.serialization.java;

import java.util.Arrays;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "student")
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {
    @XmlAttribute
    private boolean isStudent;
    @XmlAttribute
    private int course;
    @XmlAttribute
    private String name;
    @XmlElementWrapper
    @XmlElement(name = "assessment")
    private String[] assessments;
    @XmlElement
    private Faculty faculty;


    public Student() { };

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

}
