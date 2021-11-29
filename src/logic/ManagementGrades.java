package logic;

import java.util.ArrayList;

public class ManagementGrades {

    private Student student;
    private Matter matter;
    private ArrayList<Inscription> inscriptions;

    public ManagementGrades() {
        inscriptions = new ArrayList<>();
    }

    public void addInscription(Student student, Matter matter){
        inscriptions.add(new Inscription(student, matter));
    }

    public boolean addGrade(Student student, Matter matter, float grade, float percent){
        for (Inscription inscription : inscriptions){
            if (inscription.getStudent() == student && inscription.getMatter() == matter){
                return inscription.addGrade(inscription.new Grade(grade, percent));
            }
        }
        return false;
    }

    public float calcDefinitve(Student student, Matter matter){
        for (Inscription inscription : inscriptions){
            if (inscription.getStudent() == student && inscription.getMatter() == matter){
                return inscription.calcDefinitive();
            }
        }
        return 0.0f;
    }

    public float calcAverageStudent(Student student){
        float avg = 0.0f;
        float count = 0;
        for (Inscription inscription : inscriptions){
            if (inscription.getStudent() == student){
                avg += inscription.calcDefinitive();
                count++;
            }
        }
        avg = avg / count;
        return Math.round(avg * 10.0f)/10.0f;
    }

    public float calcAverageMatter(Matter matter){
        float avg = 0.0f;
        float count = 0;
        for (Inscription inscription : inscriptions){
            if (inscription.getMatter() == matter){
                avg += inscription.calcDefinitive();
                count++;
            }
        }
        avg = avg / count;
        return Math.round(avg * 10.0f)/10.0f;
    }

}
