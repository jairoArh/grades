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

        return student.addGrade( matter,grade,percent) && matter.addGrade(student,grade,percent);
    }

    public float calcDefinitive(Student student, Matter matter){

        return student.calcDefinitive( matter );

    }

    public float calcDefinitive(Matter matter, Student student ){

        return matter.calcDefinitive( student );
    }

    public float calcAvg(Student student){

        return student.calcAverage();
    }

    public float calcAvg(Matter matter){

        return matter.calcAverage();
    }

    public ArrayList<Student> getStudents() {
        return (ArrayList<Student>) students.clone();
    }

    public ArrayList<Matter> getMatters() {
        return (ArrayList<Matter>) matters.clone();
    }
}
