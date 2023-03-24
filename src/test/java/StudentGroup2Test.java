import com.example.project1.Student;
import com.example.project1.StudentGroup2;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentGroup2Test {

    ArrayList<Student> students = new ArrayList<>() {{
        add(new Student("A A A", new HashMap<>() {{
            put("math", 5);
            put("eng", 3);
            put("his", 4);
        }}));
        add(new Student("A B B", new HashMap<>()));
        add(new Student("V V V", new HashMap<>() {{
            put("lit", 2);
        }}));
        add(new Student("A N E", new HashMap<>() {{
            put("lit", 5);
            put("math", 5);
            put("eng", 5);
            put("his", 5);
        }}));
    }};
    StudentGroup2 studentGroup = new StudentGroup2("5656", students);

    @Test
    void addStudent() {
        studentGroup.addStudent("A N N");
        studentGroup.addStudent("N N A", new HashMap<>(){{
            put("lit", 5);
            put("his", 4);
        }});
        assertEquals(List.of("A A A", "A B B", "V V V", "A N E", "A N N", "N N A"), studentGroup.getStudents());
    }

    @Test
    void deleteStudent() {
        studentGroup.deleteStudent("V V V");
        assertEquals(List.of("A A A", "A B B", "A N E"), studentGroup.getStudents());
    }

    @Test
    void addOrChangeScore() {
        studentGroup.addOrChangeScore("A A A", "math", 4);
        studentGroup.addOrChangeScore("V V V", "math", 3);
        assertEquals(new HashMap<>() {{
            put("math", 4);
            put("eng", 3);
            put("his", 4);
        }}, studentGroup.getScores("A A A"));
        assertEquals(new HashMap<>() {{
            put("math", 3);
            put("lit", 2);
        }}, studentGroup.getScores("V V V"));
    }

    @Test
    void deleteScore() {
        studentGroup.deleteScore("V V V", "lit");
        assertEquals(new HashMap<>(), studentGroup.getScores("V V V"));
    }

    @Test
    void deleteSubject() {
        studentGroup.deleteSubject("math");
        studentGroup.deleteSubject("progr");
        assertEquals(new HashMap<>() {{
            put("eng", 3);
            put("his", 4);
        }}, studentGroup.getScores("A A A"));
        assertEquals(new HashMap<>() {{
            put("lit", 5);
            put("eng", 5);
            put("his", 5);
        }}, studentGroup.getScores("A N E"));
    }
}