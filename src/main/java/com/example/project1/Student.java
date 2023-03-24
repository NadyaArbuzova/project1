package com.example.project1;

import java.util.HashMap;

public class Student {
    private String name;
    private HashMap<String, Integer> grades;

    public Student(String name, HashMap<String, Integer> grades) {
        this.name = name;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, Integer> getGrades() {
        return grades;
    }

    public String getGrade(String subject) {
        if(grades.containsKey(subject)) return String.valueOf(grades.get(subject));
        else return "No grade";
    }

    public void addGrade(String subject, Integer grade) {
        grades.put(subject, grade);
    }

    public void deleteGrade(String subject) {
        grades.remove(subject);
    }
}
