/**
 * Klasse, die einen Studenten repräsentiert und das StudentInterface, Comparable und BinNodeGen implementiert.
 *
 * @param <E> Typ der Daten im Binärbaumknoten muss Comparable sein.
 */
public class Student extends BinNodeGen implements StudentInterface, Comparable<Student> {

    // Matrikelnummer des Studenten
    public int matrikelNummer;

    // Name des Studenten
    private String name;

    // Studiengang des Studenten
    private String course;


    /**
     * Konstruktor, der einen Studenten mit einer eindeutigen 6-stelligen Matrikelnummer, Namen und Studiengang erstellt.
     *
     * @param m Matrikelnummer, muss größer oder gleich 100000 sein
     * @param n Name, darf nicht null oder ein leerer String sein
     * @param c Studiengang, darf nicht null oder ein leerer String sein
     * @throws IllegalArgumentException wenn Matrikelnummer, Name oder Studiengang ungültig sind
     * @throws NullPointerException     wenn Name oder Studiengang null sind
     */
    public Student(int m, String n, String c) throws IllegalArgumentException, NullPointerException {
        matrikelNummer = m;
        name = n;
        course = c;
    }

    // Getter für die Matrikelnummer
    @Override
    public int getMatriculationNo() {
        return matrikelNummer;
    }

    // Getter für den Namen
    @Override
    public String getName() {
        return name;
    }

    /**
     * Setter für den Namen.
     *
     * @param name neuer Name, darf nicht null oder ein leerer String sein
     * @throws NullPointerException     wenn der Name null ist
     * @throws IllegalArgumentException wenn der Name ein leerer String ist
     */
    @Override
    public void setName(String name) throws NullPointerException, IllegalArgumentException {
        if (name == null) throw new NullPointerException("Name kann nicht null sein");
        if (name.isEmpty()) throw new IllegalArgumentException("Name kann nicht leer sein");
        this.name = name;
    }

    // Getter für den Studiengang
    @Override
    public String getCourse() {
        return course;
    }

    /**
     * Setter für den Studiengang.
     *
     * @param course neuer Studiengang, darf nicht null oder ein leerer String sein
     * @throws NullPointerException     wenn der Studiengang null ist
     * @throws IllegalArgumentException wenn der Studiengang ein leerer String ist
     */
    @Override
    public void setCourse(String course) throws NullPointerException, IllegalArgumentException {
        if (course == null) throw new NullPointerException("Studiengang kann nicht null sein");
        if (course.isEmpty()) throw new IllegalArgumentException("Studiengang kann nicht leer sein");
        this.course = course;
    }

    // ToString-Methode für die Klasse Student
    @Override
    public String toString() {
        return  "Student{" +
                "matriculationNumber=" + matrikelNummer +
                ", name='" + name + '\'' +
                ", course='" + course + '\'' +
                '}' +
                "\n";
    }

    // Vergleichsmethode für die Sortierung nach Matrikelnummer
    @Override
    public int compareTo(Student student) {
        int compare;
        if (matrikelNummer < student.matrikelNummer){
            compare = -1;
        }
        if (matrikelNummer > student.matrikelNummer){
            compare = 1;
        }
        else compare = 0;
        return compare;
    }
}
