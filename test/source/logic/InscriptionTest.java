package logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InscriptionTest {

    private Inscription inscription;

    private void setup(){
        inscription = new Inscription(new Student("3453","Jhon Alexander"),new Matter("323424","Calculo I",(byte)4));
    }

    @Test
    void addGrade() {
        setup();
        Inscription.Grade grade1 = inscription.new Grade(3.0f,30f);
        Inscription.Grade grade2 = inscription.new Grade(3.5f,40f);
        assertTrue( inscription.addGrade( grade1 ) );
        assertTrue( inscription.addGrade( grade2 ) );
        assertFalse( inscription.addGrade( grade2 ) );
        assertEquals(70.0,inscription.getSumPercents());
        assertTrue( inscription.addGrade( grade1 ) );
        assertEquals(100.0,inscription.getSumPercents());
        assertFalse( inscription.addGrade( grade1 ) );
        assertFalse( inscription.addGrade( grade2 ) );
    }

    @Test
    void calcDefinitive() {
        setup();
        Inscription.Grade grade1 = inscription.new Grade(3.0f,30f);
        Inscription.Grade grade2 = inscription.new Grade(3.5f,40f);
        inscription.addGrade( grade1 );
        inscription.addGrade( grade2 );
        assertEquals(2.3,inscription.calcDefinitive(),0.1);
        inscription.addGrade( grade1 );
        assertEquals(3.2,inscription.calcDefinitive(),0.1);
    }

    @Test
    void getSumPercents() {
        setup();
        assertEquals(0.0, inscription.getSumPercents());
        Inscription.Grade grade1 = inscription.new Grade(3.0f,30f);
        Inscription.Grade grade2 = inscription.new Grade(3.5f,40f);
        inscription.addGrade( grade1 );
        inscription.addGrade( grade2 );
        inscription.addGrade( grade1 );
        assertEquals(100.0,inscription.getSumPercents());
    }

    @Test
    void getCualification(){
        setup();
        Inscription.Grade grade1 = inscription.new Grade(4.0f,30f);
        Inscription.Grade grade2 = inscription.new Grade(3.5f,40f);
        Inscription.Grade grade3 = inscription.new Grade(5.0f,30f);
        inscription.addGrade( grade1 );
        assertEquals("INSUFICIENTE",inscription.getCualification());
        inscription.addGrade( grade2 );
        assertEquals("NO APROBADO",inscription.getCualification());
        inscription.addGrade( grade3 );
        assertEquals("EXCELENTE",inscription.getCualification());
    }
}