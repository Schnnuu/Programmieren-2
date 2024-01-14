/**
 * Klasse, die eine Studentenverwaltung repräsentiert und BinTreeGen und StudentManagementInterface implementiert.
 */
public class StudentManagement extends BinTreeGen implements StudentManagementInterface {

    // Wurzel des Binärbaums
    private BinNodeGen<Student> root = null;

    // Standardkonstruktor
    StudentManagement() {
        super();
    }

    StudentManagement(BinNodeGen<Student> s) {
        super(s);
    }

    /**
     * Methode, die die Anzahl der Studenten im Binärbaum zählt.
     *
     * @return Anzahl der Studenten
     */
    @Override
    public int countStudents() {
        return countNodes(root);
    }

    /**
     * Methode zum Einfügen eines Studenten in den Binärbaum.
     *
     * @param student Student, der eingefügt werden soll
     * @return true, wenn das Einfügen erfolgreich war, false sonst
     * @throws IllegalArgumentException wenn die Matrikelnummer bereits vergeben ist
     */
    @Override
    public boolean insertStudent(Student student) {
        if (find(student.matrikelNummer) != null) throw new IllegalArgumentException("Matrikelnummer ist bereits vergeben");
        return insertNode(student);
    }

    /**
     * Methode zum Suchen eines Studenten im Binärbaum anhand der Matrikelnummer.
     *
     * @param matrNo Matrikelnummer des zu suchenden Studenten
     * @return Student mit der angegebenen Matrikelnummer oder null, wenn nicht gefunden
     * @throws IllegalArgumentException wenn die Matrikelnummer kleiner als 100000 ist
     */
    @Override
    public Student searchStudent(int matrNo) throws IllegalArgumentException {
        if (matrNo < 100000) throw new IllegalArgumentException("Matrikelnummer muss größer als 100.000 sein");
        return searchStudent(root, matrNo);
    }

    /**
     * Hilfsmethode zum rekursiven Suchen eines Studenten im Binärbaum.
     *
     * @param nodeGen BinNodeGen-Objekt, das durch den Binärbaum traversiert wird
     * @param matrNo  Matrikelnummer des zu suchenden Studenten
     * @return Student mit der angegebenen Matrikelnummer oder null, wenn nicht gefunden
     */
    public Student searchStudent(BinNodeGen<Student> nodeGen, int matrNo) {
//        if (nodeGen == null || nodeGen.data.matrikelNummer == matrNo) {
//            return (nodeGen != null) ? nodeGen.data : null;
//        }
//        if (matrNo < nodeGen.data.matrikelNummer) {
//            return searchStudent(root.left, matrNo);
//        }
//        return searchStudent(root.right, matrNo);
        return (Student) find(nodeGen.data.matrikelNummer == matrNo);
    }

    /**
     * Methode zum Überprüfen, ob ein Student im Binärbaum vorhanden ist.
     *
     * @param s zu überprüfender Student
     * @return true, wenn der Student vorhanden ist, false sonst
     * @throws NullPointerException wenn der überprüfende Student null ist
     */
    @Override
    public boolean isStudent(Student s) throws NullPointerException {
        if (s == null) throw new NullPointerException("Student kann nicht null sein");
        return searchStudent(root, s.getMatriculationNo()) != null;
    }
}
