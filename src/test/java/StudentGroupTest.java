import com.example.project1.StudentGroup;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentGroupTest {

    StudentGroup studentGroup1 = new StudentGroup(1, List.of("A A A", "A B C", "C C C"));
    StudentGroup studentGroup2 = new StudentGroup(2, new HashMap<>() {{
        HashMap<String, Integer> put1 = put("D D D", new HashMap<>() {{
            Integer math = put("math", 4);
            Integer eng = put("eng", 3);
        }});
        HashMap<String, Integer> put2 = put("R H T", new HashMap<>() {{
            Integer math = put("math", 5);
            Integer eng = put("eng", 5);
            Integer his = put("his", 5);
        }});
        HashMap<String, Integer> put3 = put("M M M", new HashMap<>() {{
            Integer eng = put("eng", 3);
        }});
    }});
    StudentGroup studentGroup3 = new StudentGroup(3, List.of("B C C", "X X X", "L L L"), List.of("math", "eng", "his"));

    @Test
    void getGroupNumber() {
        assertEquals(1, studentGroup1.getGroupNumber());
        assertEquals(2, studentGroup2.getGroupNumber());
        assertEquals(3, studentGroup3.getGroupNumber());
    }

    @Test
    void setGroupNumber() {
        studentGroup1.setGroupNumber(2);
        assertEquals(2, studentGroup1.getGroupNumber());
    }

    @Test
    void getStudents() {
        assertEquals(new HashMap<>(){{
            put("A A A", new HashMap<>());
            put("A B C", new HashMap<>());
            put("C C C", new HashMap<>());
        }}, studentGroup1.getStudents());
        assertEquals(new HashMap<>() {{
            put("D D D", new HashMap<>() {{
                put("math", 4);
                put("eng", 3);
                put("his", null);
            }});
            put("R H T", new HashMap<>() {{
                put("math", 5);
                put("eng", 5);
                put("his", 5);
            }});
            put("M M M", new HashMap<>() {{
                put("eng", 3);
                put("math", null);
                put("his", null);
            }});
        }}, studentGroup2.getStudents());
        assertEquals(new HashMap<>() {{
            put("B C C", new HashMap<>() {{
                put("math", null);
                put("eng", null);
                put("his", null);
            }});
            put("L L L", new HashMap<>() {{
                put("math", null);
                put("eng", null);
                put("his", null);
            }});
            put("X X X", new HashMap<>() {{
                put("math", null);
                put("eng", null);
                put("his", null);
            }});
        }}, studentGroup3.getStudents());
    }

    @Test
    void deleteStudent() {
        studentGroup1.deleteStudent("A A A");
        studentGroup1.deleteStudent("K");
        studentGroup2.deleteStudent("D D D");
        studentGroup3.deleteStudent("B C C");
        studentGroup3.deleteStudent("L L L");
        studentGroup3.deleteStudent("X X X");
        assertEquals(new HashMap<>(){{
            put("A B C", new HashMap<>());
            put("C C C", new HashMap<>());
        }}, studentGroup1.getStudents());
        assertEquals(new HashMap<>() {{
            put("R H T", new HashMap<>() {{
                put("math", 5);
                put("eng", 5);
                put("his", 5);
            }});
            put("M M M", new HashMap<>() {{
                put("eng", 3);
                put("math", null);
                put("his", null);
            }});
        }}, studentGroup2.getStudents());
        assertEquals(new HashMap<>(), studentGroup3.getStudents());
    }

    @Test
    void addStudent() {
        studentGroup2.addStudent("V V V");
        studentGroup2.addStudent("D D D");
        assertEquals(new HashMap<>() {{
            put("D D D", new HashMap<>() {{
                put("math", 4);
                put("eng", 3);
                put("his", null);
            }});
            put("V V V", new HashMap<>() {{
                put("math", null);
                put("eng", null);
                put("his", null);
            }});
            put("R H T", new HashMap<>() {{
                put("math", 5);
                put("eng", 5);
                put("his", 5);
            }});
            put("M M M", new HashMap<>() {{
                put("eng", 3);
                put("math", null);
                put("his", null);
            }});
        }}, studentGroup2.getStudents());
    }

    @Test
    void testAddStudent() {
        studentGroup2.addStudent("V V V", new HashMap<>(){{ put("math", 3);}});
        studentGroup2.addStudent("D D D", new HashMap<>(){{put("his", 3);}});
        studentGroup2.addStudent("H H H", new HashMap<>(){{put("lit", 3);}});
        assertEquals(new HashMap<>() {{
            put("D D D", new HashMap<>() {{
                put("math", 4);
                put("eng", 3);
                put("his", null);
            }});
            put("H H H", new HashMap<>() {{
                put("math", null);
                put("eng", null);
                put("his", null);
            }});
            put("V V V", new HashMap<>() {{
                put("math", 3);
                put("eng", null);
                put("his", null);
            }});
            put("R H T", new HashMap<>() {{
                put("math", 5);
                put("eng", 5);
                put("his", 5);
            }});
            put("M M M", new HashMap<>() {{
                put("eng", 3);
                put("math", null);
                put("his", null);
            }});
        }}, studentGroup2.getStudents());
    }

    @Test
    void deleteSubject() {
        studentGroup2.deleteSubject("math");
        studentGroup2.deleteSubject("lit");
        assertEquals(new HashMap<>() {{
            put("D D D", new HashMap<>() {{
                put("eng", 3);
                put("his", null);
            }});
            put("R H T", new HashMap<>() {{
                put("eng", 5);
                put("his", 5);
            }});
            put("M M M", new HashMap<>() {{
                put("eng", 3);
                put("his", null);
            }});
        }}, studentGroup2.getStudents());
        studentGroup2.deleteSubject("his");
        studentGroup2.deleteSubject("eng");
        assertEquals(new HashMap<>() {{
            put("D D D", new HashMap<>());
            put("R H T", new HashMap<>());
            put("M M M", new HashMap<>());
        }}, studentGroup2.getStudents());
    }

    @Test
    void addSubject() {
        studentGroup1.addSubject("eng");
        assertEquals(new HashMap<>() {{
            put("A A A", new HashMap<>() {{
                put("eng", null);
            }});
            put("A B C", new HashMap<>() {{
                put("eng", null);
            }});
            put("C C C", new HashMap<>() {{
                put("eng", null);
            }});
        }}, studentGroup1.getStudents());
    }

    @Test
    void addOrChangeScore() {
        studentGroup2.addOrChangeScore("D D D", "his", 3);
        assertEquals(new HashMap<>() {{
            put("D D D", new HashMap<>() {{
                put("math", 4);
                put("eng", 3);
                put("his", 3);
            }});
            put("R H T", new HashMap<>() {{
                put("math", 5);
                put("eng", 5);
                put("his", 5);
            }});
            put("M M M", new HashMap<>() {{
                put("eng", 3);
                put("math", null);
                put("his", null);
            }});
        }}, studentGroup2.getStudents());
    }

    @Test
    void deleteScore() {
        studentGroup2.deleteScore("D D D", "eng");
        studentGroup2.deleteScore("D D A", "eng");
        assertEquals(new HashMap<>() {{
            put("D D D", new HashMap<>() {{
                put("math", 4);
                put("eng", null);
                put("his", null);
            }});
            put("R H T", new HashMap<>() {{
                put("math", 5);
                put("eng", 5);
                put("his", 5);
            }});
            put("M M M", new HashMap<>() {{
                put("eng", 3);
                put("math", null);
                put("his", null);
            }});
        }}, studentGroup2.getStudents());
    }
}