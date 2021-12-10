package logic;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ManagementGrades {

    private ArrayList<Student> students;
    private ArrayList<Matter> matters;

    public ManagementGrades() {
        students = new ArrayList<>();
        matters = new ArrayList<>();
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Matter> getMatters() {
        return matters;
    }

    public Student findStudent(String code){

        for(Student student: students){
            if (student.getCode().equals(code)) {
                return student;
            }
        }
        return null;
    }

    public Matter findMatter(String code){
        for (Matter matter : matters){
            if(matter.getCode() == code){
                return matter;
            }
        }
        return null;
    }

    public boolean addStudent(Student student){
        if(findStudent(student.getCode()) == null){
            return students.add(student);
        }
        return false;
    }

    public boolean addMatter(Matter matter){
        if (findMatter(matter.getCode()) == null){
            return matters.add(matter);
        }
        return false;
    }

    public void addInscription(Student student, Matter matter){
        student.addInscription(matter);
        matter.addInscription(student);
    }

    public boolean addGrade(Student student, Matter matter, float grade, float percent){

        return student.addGrade(matter, grade, percent) && matter.addGrade(student, grade, percent);
    }

    public float calcDefinitve(Student student, Matter matter){
        if (findStudent(student.getCode()) != null && findMatter(matter.getCode()) != null){

        }
        return 0.0f;
    }

    public float calcAverageStudent(Student student){

        return 0;
    }

    public float calcAverageMatter(Matter matter){
        float avg = 0.0f;
        float count = 0;
        return  0;
    }

}
