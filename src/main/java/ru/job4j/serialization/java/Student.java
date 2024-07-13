package ru.job4j.serialization.java;

import java.util.Arrays;

import jakarta.xml.bind.annotation.*;
import org.json.JSONObject;
import org.json.JSONPropertyIgnore;

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

    public boolean getIsStudent() {
        return isStudent;
    }

    public int getCourse() {
        return course;
    }

    public String getName() {
        return name;
    }

    public String[] getAssessments() {
        return assessments;
    }

     @JSONPropertyIgnore
    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public static void main(String[] args) {
        Student student = new Student(true, 3, "Emil",
                new String[]{"5, 4, 5, 3"}, new Faculty("Programmer"));
        Faculty faculty = new Faculty("Programmer");
        student.setFaculty(faculty);
        faculty.setStudent(student);

        System.out.println(new JSONObject(student));
    }
}
