public class Student implements StudentInterface{
    @Override
    public int getMatriculationNo() {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) throws NullPointerException, IllegalArgumentException {

    }

    @Override
    public String getCourse() {
        return null;
    }

    @Override
    public void setCourse(String course) throws NullPointerException, IllegalArgumentException {

    }
}
