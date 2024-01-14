public class Student extends BinTreeGen implements StudentInterface{
    private int matrikelNummer;
    private String name;
    private String course;
    public Student(){

    }
    /**
     * a unique 6-digits matriculation number is assigned to each student
     * upon enrollment
     * each student has a name
     * each student has a course he/she has enrolled for
     *
     * @param m matriculation number, must be greater than or equal to 100000
     * @param n name, cannot be null or empty string
     * @param c course, cannot be null or empty string
     * @throws IllegalArgumentException if matriculationNo, name or course is
     *                                  not valid
     * @throws NullPointerException     if name or course is null
     */
    public Student(int m, String n, String c)
            throws IllegalArgumentException, NullPointerException {
        if (find(m) != null) throw new IllegalArgumentException("Matrikelnummer ist bereits vergeben");
        matrikelNummer = m;
        name = n;
        course = c;

    }

    @Override
    public int getMatriculationNo() {
        return matrikelNummer;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) throws NullPointerException, IllegalArgumentException {
        if (name == null)throw new NullPointerException("Name can't be null");
        if (name.equals("")) throw new IllegalArgumentException("Name can't be empty");
        this.name = name;
    }

    @Override
    public String getCourse() {
        return course;
    }

    @Override
    public void setCourse(String course) throws NullPointerException, IllegalArgumentException {
    if (course == null) throw new NullPointerException("Course can't be null");
    if(course.equals(""))throw new IllegalArgumentException("Course can't be empty");
    this.course = course;
    }
}
