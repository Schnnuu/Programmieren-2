import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentManagementTest {

    private Student student1;
    private Student student2;
    private Student student3;
    private Student student4;
    private StudentManagement studentManagement;

    @BeforeEach
    public void setup(){
        student1 = new Student(100001, "Charlie", "Physics");
        student2 = new Student(100002, "Bob", "Mathematics");
        student3 = new Student(100003, "Alice", "Computer Science");
        student4 = new Student(100004,"David", "English");

        studentManagement = new StudentManagement();
    }




    @Test
    void countStudents() {
    }

    @Test
    void insertStudent() {
        studentManagement.insertStudent(student1);
        studentManagement.insertStudent(student2);
        studentManagement.insertStudent(student3);
        studentManagement.insertStudent(student4);
        studentManagement.insertStudent(student1);
        studentManagement.toString();
    }

    @Test
    void searchStudent() {
    }

    @Test
    void isStudent() {
    }
}