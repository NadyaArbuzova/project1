package com.example.project1;

import java.util.ArrayList;
import java.util.HashMap;

public class StudentGroup2 {

    private String groupNumber;
    private final ArrayList<Student> students;

    public StudentGroup2(String groupNumber, ArrayList<Student> students) {
        this.groupNumber = groupNumber;
        this.students = students;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public ArrayList<String> getStudents() {
        ArrayList<String> names = new ArrayList<>();
        for (Student student: students){
            names.add(student.getName());
        }
        return names;
    }
    public HashMap<String, Integer> getScores(String name) {
       return getStudentByName(name).getGrades();
    }

    public Student getStudentByName(String name) {
        return students.stream().filter(s -> s.getName().equals(name)).findFirst().get();
    }

    public  void addStudent(String name){
        students.add(new Student(name, new HashMap<String, Integer>()));
    }

    public  void addStudent(String name, HashMap<String, Integer> scores){
        students.add(new Student(name, scores));
    }

    public void deleteStudent(String name){
        this.students.remove(getStudentByName(name));
    }

    public void addOrChangeScore(String studentName, String subject, Integer grade) {
        getStudentByName(studentName).addGrade(subject, grade);
    }

    public  void deleteScore(String studentName, String subject){
        getStudentByName(studentName).deleteGrade(subject);
    }

    public  void deleteSubject(String subject){
        for (Student student: students){
            deleteScore(student.getName(), subject);
        }
    }
}
