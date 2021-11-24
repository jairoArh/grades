package logic;

import java.util.ArrayList;

public class Matter {
    private String description;
    private byte credits;
    private ArrayList<Inscription> inscriptions;


    public Matter(String description, byte credits) {
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

    public void addInscription(){

    }

    public boolean addGrade( Student student, float grade, float percent ){

        return false;
    }

    public ArrayList<Inscription> getInscriptions() {
        return (ArrayList<Inscription>) inscriptions.clone();
    }

    public float calcAverage(){

        return 0.0f;
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
