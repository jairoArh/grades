package logic;

import java.util.ArrayList;

public class Student {
    private String code;
    private String name;
    private ArrayList<Inscription> inscriptions;

    public Student(String code, String name) {
        this.code = code;
        this.name = name;
        inscriptions = new ArrayList<>();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addInscription( Matter matter){
        inscriptions.add( new Inscription( this, matter ) );
    }

    public ArrayList<Inscription> getInscriptions() {
        return (ArrayList<Inscription>) inscriptions.clone();
    }

    public boolean addGrade( Matter matter, float grade, float percent ){

        for( Inscription inscription : inscriptions ){
            if( inscription.getMatter() == matter ){
                return inscription.addGrade( inscription.new Grade(grade,percent));
            }
        }

        return false;
    }

    public float calcDefinitive( Matter matter ){

        for( Inscription inscription : inscriptions ){
            if( inscription.getMatter() == matter ){
                return inscription.calcDefinitive();
            }
        }

        return 0.0f;
    }

    public float calcAverage(){

        float avg = 0.0f;

        for( Inscription inscription : inscriptions ){
            avg += inscription.calcDefinitive(); // avg = avg + inscription.calcDefinitive()
        }

        return avg / inscriptions.size();
    }

    public byte sumCredits(){
        byte sum = 0;
        for( Inscription inscription : inscriptions ){
            sum += inscription.getMatter().getCredits();
        }

        return sum;
    }

    @Override
    public String toString() {
        return "Student{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", inscriptions=" + inscriptions +
                '}';
    }
}
