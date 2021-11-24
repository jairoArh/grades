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

    }

    public ArrayList<Inscription> getInscriptions() {
        return (ArrayList<Inscription>) inscriptions.clone();
    }

    public boolean addGrade(Matter matter, float grade, float percent ){

        return false;
    }

    public float calcDefinitive( Matter matter ){

        return 0.0f;
    }

    public float calcAverage(){

        return 0.0f;
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
