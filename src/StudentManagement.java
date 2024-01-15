/**
 * Klasse, die eine Studentenverwaltung repräsentiert und BinTreeGen und StudentManagementInterface implementiert.
 *
 * @param <E> Typ der Daten im Binärbaumknoten muss Student sein.
 */
public class StudentManagement extends BinTreeGen<Student> implements StudentManagementInterface {

    // Wurzel des Binärbaums
    private BinNodeGen<Student> root;

    // Standardkonstruktor
    StudentManagement() {
        super();
        // Initialisiert die Basisklasse BinTreeGen
    }

    /**
     * Konstruktor zum Erstellen einer Studentenverwaltung mit einem anfänglichen Studenten.
     *
     * @param s Der anfängliche Student, der in den Binärbaum eingefügt wird.
     */
    StudentManagement(Student s) {
        super();
        insertNode(s);
    }

    /**
     * Methode, die die Anzahl der Studenten im Binärbaum zählt.
     *
     * @return Anzahl der Studenten
     */
    @Override
    public int countStudents() {
        return countNodes();
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
        if (find(student) != null) throw new IllegalArgumentException("Matrikelnummer ist bereits vergeben");
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
        Student compareStudent = new Student(matrNo, "Test", "Test");
        return find(compareStudent).data;
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
        return searchStudent(s.getMatriculationNo()) != null;
    }
}
