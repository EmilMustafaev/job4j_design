package ru.job4j.serialization.java;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "faculty")
public class Faculty {
    @XmlAttribute
    private String facultyName;


    public Faculty() { };

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
