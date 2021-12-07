package logic;

import java.util.ArrayList;

public class Matter {
    private String code;
    private String description;
    private byte credits;
    private ArrayList<Inscription> inscriptions;


    public Matter(String code, String description, byte credits) {
        this.code = code;
        this.description = description;
        this.credits = credits;
        inscriptions = new ArrayList<>();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte getCredits() {
        return credits;
    }

    public void setCredits(byte credits) {
        this.credits = credits;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void addInscription(Student student){
        inscriptions.add( new Inscription( student, this ) );
    }

    public boolean addGrade( Student student, float grade, float percent ){

        for( Inscription inscription : inscriptions ){
            if ( inscription.getStudent() == student ){
                return inscription.addGrade( inscription.new Grade( grade, percent));
            }
        }

        return false;
    }

    public ArrayList<Inscription> getInscriptions() {
        return (ArrayList<Inscription>) inscriptions.clone();
    }

    public float calcDefinitive( Student student ){
        for( Inscription inscription : inscriptions ){
            if ( inscription.getStudent() == student ){
                return inscription.calcDefinitive();
            }
        }

        return 0.0f;
    }

    public float calcAverage(){
        float avg = 0.0f;
        for( Inscription inscription : inscriptions ){
            avg += inscription.calcDefinitive();
        }

        return avg / inscriptions.size();
    }

    @Override
    public String toString() {
        return "Matter{" +
                "description='" + description + '\'' +
                ", credits=" + credits +
                ", inscriptions=" + inscriptions +
                '}';
    }
}
