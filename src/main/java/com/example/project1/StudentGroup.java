package com.example.project1;

import java.util.HashMap;
import java.util.List;

public class StudentGroup {
    private int groupNumber;
    private final HashMap<String, HashMap<String, Integer>> students = new HashMap<String, HashMap<String, Integer>>();
    private final HashMap<String, Integer> subject = new HashMap<String, Integer>();

    public StudentGroup(int groupNumber, HashMap<String, HashMap<String, Integer>> students) {
        this.groupNumber = groupNumber;
        for (HashMap<String, Integer> val: students.values()){
            subject.putAll(val);
        }
        subject.replaceAll((key, val) ->  null);
        for (String key: students.keySet()){
            this.students.put(key, new HashMap<>() {{putAll(subject);}});
            this.students.get(key).putAll(students.get(key));
        }
    }

    public StudentGroup(int groupNumber, List<String> students) {
        this.groupNumber = groupNumber;
        for (String student : students) {
            this.students.put(student, new HashMap<String, Integer>());
        }
    }

    public StudentGroup(int groupNumber, List<String> students, List<String> subjectList) {
        this.groupNumber = groupNumber;
        for (String key: subjectList){
            this.subject.put(key, null);
        }
        for (String key: students){
            this.students.put(key, new HashMap<>() {{putAll(subject);}});
        }
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    public HashMap<String, HashMap<String, Integer>> getStudents() {
        return students;
    }

    public void deleteStudent(String fio){
        this.students.keySet().remove(fio);
    }

    public  void addStudent(String fio){
        if(!students.containsKey(fio)) {
            this.students.put(fio, new HashMap<>(){{putAll(subject);}});
        }
    }

    public  void addStudent(String fio, HashMap<String, Integer> scores){
        if(!students.containsKey(fio)) {
            addStudent(fio);
            for (String key: scores.keySet()) {
                if(this.subject.containsKey(key)) this.students.get(fio).put(key, scores.get(key));
            }
        }
    }

    public  void deleteSubject(String name){
        this.subject.remove(name);
        for (String key: this.students.keySet()) {
            this.students.get(key).keySet().remove(name);
        }
    }

    public  void addSubject(String name){
        for (String key: this.students.keySet()) {
            this.students.get(key).put(name, null);
        }
    }

    public  void addOrChangeScore(String fio, String subject, int score){
        if(students.containsKey(fio) && this.subject.containsKey(subject)) {
            this.students.get(fio).put(subject, score);
        }
    }

    public  void deleteScore(String fio, String subject){
        if(students.containsKey(fio) && this.subject.containsKey(subject)) {
            this.students.get(fio).put(subject, null);
        }
    }
}
