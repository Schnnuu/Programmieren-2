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

        studentManagement.insertStudent(student1);
        studentManagement.insertStudent(student2);
        studentManagement.insertStudent(student3);
        studentManagement.insertStudent(student4);
    }




    @Test
    void countStudents() {
        int test = studentManagement.countStudents();
        System.out.println(test);
    }

    @Test
    void insertStudent() {
        //
        Student student5 = new Student(100006,"Jochen","Biology");
        // act
        studentManagement.insertStudent(student5);
        // assert
        studentManagement.toString();

    }
    @Test
    void insertStudentAlreadyExists() {
        //
        Student student5 = new Student(100004,"Jochen","Biology");
        // act & assert
        assertThrows(IllegalArgumentException.class, ()->studentManagement.insertStudent(student5));

    }

    @Test
    void searchStudent() {
        // act
        System.out.println(studentManagement.searchStudent(100004));

    }

    @Test
    void isStudent() {
        studentManagement.isStudent(student1);
    }
}