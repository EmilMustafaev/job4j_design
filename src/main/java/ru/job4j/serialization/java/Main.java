package ru.job4j.serialization.java;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Student student = new Student(true, 3, "Emil",
                new String[]{"5, 4, 5, 3"}, new Faculty("Programmer"));

        JSONObject jsonFaculty = new JSONObject("{\"facultyName\":\"Programmer\"}");

        List<String> list = new ArrayList<>();
        list.add("5");
        list.add("4");
        JSONArray jsonAssessments = new JSONArray(list);


        JSONObject jsonObject = new JSONObject();
        jsonObject.put("isStudent", student.getIsStudent());
        jsonObject.put("course", student.getCourse());
        jsonObject.put("name", student.getName());
        jsonObject.put("assessments", jsonAssessments);
        jsonObject.put("faculty", jsonFaculty);

        System.out.println(jsonObject.toString());

        System.out.println(new JSONObject(student).toString());
    }
}
