package logic;

import java.util.ArrayList;

public class ManagementGrades {
    private ArrayList<Student> students;
    private ArrayList<Matter> matters;

    public ManagementGrades() {
        students = new ArrayList<>();
        matters = new ArrayList<>();
    }

    public Student findStudent(String code ){

        for( Student student : students ){
            if (student.getCode().equals(code)){
                return student;
            }
        }

        return null;
    }

    public Matter findMatter(String code){

        for( Matter matter : matters ){
            if( matter.getCode().equals( code ) ){
                return matter;
            }
        }

        return null;
    }

    public boolean addStudent( Student student ){
        if ( findStudent( student.getCode()) == null ){
            students.add( student );

            return true;
        }

        return false;
    }

    public boolean addMatter( Matter matter){
        if( findMatter( matter.getCode()) == null ){

            matters.add( matter );

            return true;
        }

        return false;
    }

    public void addInscription( Student student, Matter matter ){

            student.addInscription( matter);
            matter.addInscription( student );

    }

    public boolean addGrade( Student student, Matter matter, float grade, float percent ){

        return false;
    }

    public float calcDefinitive(Student student, Matter matter){

        return 0.0f;
    }

    public float calcAvg(Student student){

        return 0.0f;
    }

    public float calcAvg(Matter matter){

        return 0.0f;
    }

    public ArrayList<Student> getStudents() {
        return (ArrayList<Student>) students.clone();
    }

    public ArrayList<Matter> getMatters() {
        return (ArrayList<Matter>) matters.clone();
    }
}
