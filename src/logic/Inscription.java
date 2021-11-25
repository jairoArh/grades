package logic;

import java.util.ArrayList;

public class Inscription {
    private Student student;
    private Matter matter;
    private ArrayList<Grade> grades;

    public Inscription(Student student, Matter matter) {
        this.student = student;
        this.matter = matter;
        grades = new ArrayList<>();
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Matter getMatter() {
        return matter;
    }

    public void setMatter(Matter matter) {
        this.matter = matter;
    }

    public boolean addGrade(Grade grade){

        if( getSumPercents() + grade.getPercent() <= 100 ){
            grades.add( grade );

            return true;
        }

        return false;
    }

    public ArrayList<Grade> getGrades() {
        return (ArrayList<Grade>) grades.clone();
    }

    public float calcDefinitive(){
        float definitive = 0.0f;

        for( Grade grade : grades ){
            definitive += grade.getGrade() * ( grade.getPercent() / 100 );
        }

        return definitive;
    }

    public float getSumPercents(){
        float sum = 0.0f;
        for ( Grade grade : grades ){
            sum += grade.getPercent(); // sum = sum + grade.getPercent()
        }

        return sum;
    }

    public String getCualification(){

        float definitive = calcDefinitive();
        if( definitive >= 0 && definitive <= 2 )
            return "INSUFICIENTE";
        else if( definitive > 2 && definitive < 3 )
            return "NO APROBADO";
        else if( definitive >= 3 && definitive < 4 )
            return "APROBADO";
        else
            return "EXCELENTE";
    }

    public class Grade{
        private float grade;
        private float percent;

        public Grade(float grade, float percent) {
            this.grade = grade;
            this.percent = percent;
        }

        public float getGrade() {
            return grade;
        }

        public void setGrade(float grade) {
            this.grade = grade;
        }

        public float getPercent() {
            return percent;
        }

        public void setPercent(float percent) {
            this.percent = percent;
        }

        @Override
        public String toString() {
            return "Grade{" +
                    "grade=" + grade +
                    ", percent=" + percent +
                    '}';
        }
    }
}
