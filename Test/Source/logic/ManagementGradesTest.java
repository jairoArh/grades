package logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagementGradesTest {
    private ManagementGrades grades;

    void setup(){
        grades = new ManagementGrades();
        grades.addStudent( new Student("20102410","Martha Ines López"));
        grades.addStudent( new Student("20130932","Claudia Marcela Rios"));
        grades.addStudent( new Student("20141054","Luis Antonio Perez"));

        grades.addMatter( new Matter("8108321","Calculo I",(byte)4));
        grades.addMatter( new Matter("8108255","Programación I",(byte)4));
        grades.addMatter( new Matter("8108256","Programación II",(byte)4));
        grades.addMatter( new Matter("8108257","Programación III",(byte)4));
        grades.addMatter( new Matter("8108265","Bases de Datos",(byte)3));
        grades.addMatter( new Matter("8108453","Catedra Universidad y Entorno",(byte)2));

        //Inscripciones para Martha Ines Lopez
        grades.addInscription( grades.findStudent("20102410"),grades.findMatter("8108321"));
        grades.addInscription( grades.findStudent("20102410"),grades.findMatter("8108256"));
        grades.addInscription( grades.findStudent("20102410"),grades.findMatter("8108265"));

        //Inscripciones para Claudia Marcela
        grades.addInscription( grades.findStudent("20130932"),grades.findMatter("8108321"));
        grades.addInscription( grades.findStudent("20130932"),grades.findMatter("8108256"));
        grades.addInscription( grades.findStudent("20130932"),grades.findMatter("8108265"));
        grades.addInscription( grades.findStudent("20130932"),grades.findMatter("8108453"));

        //Inscripciones para Luis Antonio Perez
        grades.addInscription( grades.findStudent("20141054"),grades.findMatter("8108321"));
        grades.addInscription( grades.findStudent("20141054"),grades.findMatter("8108257"));
        grades.addInscription( grades.findStudent("20141054"),grades.findMatter("8108265"));
        grades.addInscription( grades.findStudent("20141054"),grades.findMatter("8108453"));

    }

    @Test
    void findStudent() {
        setup();
        assertNull( grades.findStudent("45244"));
        assertNotNull(grades.findStudent("20141054"));
        assertEquals("Luis Antonio Perez",grades.findStudent("20141054").getName());
        assertNotNull(grades.findStudent("20102410"));
        assertNotNull(grades.findStudent("20130932"));
    }

    @Test
    void addStudent(){
        setup();
        assertFalse(grades.addStudent(new Student("20102410","Martha Ines López")));
        assertFalse(grades.addStudent(new Student("20130932","Claudia Marcela Rios")));
        assertTrue(grades.addStudent( new Student("5436466","Lola")));
        assertEquals(4, grades.getStudents().size());
    }

    @Test
    void addMatter(){
        setup();
        assertTrue(grades.addMatter( new Matter("3434534","Redes de Datos",(byte)3)));
        assertFalse(grades.addMatter( new Matter("8108321","Calculo I",(byte)4)));
        assertTrue(grades.addMatter( new Matter("5353434","Algrebra Lineal",(byte)4)));
        assertFalse(grades.addMatter( new Matter("8108453","Catedra Universidad y Entorno",(byte)2)));
        assertEquals(8,grades.getMatters().size());
    }

    @Test
    void findMatter() {
        setup();
        assertNull(grades.findMatter("645734646"));
        assertNotNull(grades.findMatter("8108321"));
        assertNotNull(grades.findMatter("8108255"));
        assertNotNull(grades.findMatter("8108256"));
        assertEquals("Programación II",grades.findMatter("8108256").getDescription());
    }

    @Test
    void inscriptions(){
        setup();
        //Probar las inscripciones que tiene cada estudiante
        assertEquals(3,grades.findStudent("20102410").getInscriptions().size());
        assertEquals(4,grades.findStudent("20130932").getInscriptions().size());
        assertEquals(4,grades.findStudent("20141054").getInscriptions().size());

        //Probar las inscripciones que tiene cada materia
        assertEquals(3,grades.findMatter("8108321").getInscriptions().size());
        assertEquals(2,grades.findMatter("8108256").getInscriptions().size());
        assertEquals(3,grades.findMatter("8108265").getInscriptions().size());
        assertEquals(2,grades.findMatter("8108453").getInscriptions().size());
        assertEquals(1,grades.findMatter("8108257").getInscriptions().size());
    }

    @Test
    void addGrade() {
        setup();

    }

    @Test
    void calcDefinitive() {
    }

    @Test
    void calcAvg() {
    }

    @Test
    void testCalcAvg() {
    }
}