public class StudenManagement implements StudentManagementInterface{
    @Override
    public int countStudents() {
        return 0;
    }

    @Override
    public boolean insertStudent(Student student) {
        return false;
    }

    @Override
    public Student searchStudent(int matrNo) throws IllegalArgumentException {
        return null;
    }

    @Override
    public boolean isStudent(Student s) throws NullPointerException {
        return false;
    }
}
