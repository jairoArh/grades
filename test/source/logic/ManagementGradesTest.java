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

    void setupOne(){
        setup();
        /**
         * Inscripciones y Notas de Martha Inés
         * Promedio 9.65 / 3.21
         */
        //Notas Para Calculo-I - Definitiva 3.0
        grades.addGrade( grades.findStudent("20102410"),grades.findMatter("8108321"),2.5f,30f);
        grades.addGrade( grades.findStudent("20102410"),grades.findMatter("8108321"),3.5f,30f);
        grades.addGrade( grades.findStudent("20102410"),grades.findMatter("8108321"),3.0f,40f);

        //Notas de Programación II - Definitiva 2.25
        grades.addGrade( grades.findStudent("20102410"),grades.findMatter("8108256"),2.0f,25f);
        grades.addGrade( grades.findStudent("20102410"),grades.findMatter("8108256"),1.0f,25f);
        grades.addGrade( grades.findStudent("20102410"),grades.findMatter("8108256"),4.0f,25f);
        grades.addGrade( grades.findStudent("20102410"),grades.findMatter("8108256"),2.0f,25f);

        //Notas para Bases de Datos - Definitiva 4.4
        grades.addGrade( grades.findStudent("20102410"),grades.findMatter("8108265"),4.0f,30f);
        grades.addGrade( grades.findStudent("20102410"),grades.findMatter("8108265"),5.0f,40f);
        grades.addGrade( grades.findStudent("20102410"),grades.findMatter("8108265"),4.0f,30f);

        /**
         * Notas de Cludia Marcela
         * Promedio 13.55 / 4 = 3.3837
         */

        //Notas de Programación II - Definitiva 3.0
        grades.addGrade( grades.findStudent("20130932"),grades.findMatter("8108256"),3.0f,25f);
        grades.addGrade( grades.findStudent("20130932"),grades.findMatter("8108256"),2.0f,25f);
        grades.addGrade( grades.findStudent("20130932"),grades.findMatter("8108256"),3.0f,25f);
        grades.addGrade( grades.findStudent("20130932"),grades.findMatter("8108256"),4.0f,25f);

        //Notas para Bases de Datos - Definitiva 3.2
        grades.addGrade( grades.findStudent("20130932"),grades.findMatter("8108265"),3.5f,30f);
        grades.addGrade( grades.findStudent("20130932"),grades.findMatter("8108265"),2.0f,40f);
        grades.addGrade( grades.findStudent("20130932"),grades.findMatter("8108265"),4.5f,30f);

        //Notas Para Calculo-I - Definitiva 2.75
        grades.addGrade( grades.findStudent("20130932"),grades.findMatter("8108321"),1.5f,30f);
        grades.addGrade( grades.findStudent("20130932"),grades.findMatter("8108321"),3.0f,30f);
        grades.addGrade( grades.findStudent("20130932"),grades.findMatter("8108321"),3.5f,40f);

        //Notas para Cátedra Universidad y Entorno - Definitiva 4.6
        grades.addGrade( grades.findStudent("20130932"),grades.findMatter("8108453"),5.0f,60f);
        grades.addGrade( grades.findStudent("20130932"),grades.findMatter("8108453"),4.0f,40f);

        /**
         * Notas para Luis Antonio
         * Promedio 13.85 / 4 = 3.4625
         */

        //Notas de Calculo I - Definitiva 2.85
        grades.addGrade( grades.findStudent("20141054"),grades.findMatter("8108321"),2.5f,30f);
        grades.addGrade( grades.findStudent("20141054"),grades.findMatter("8108321"),3.0f,30f);
        grades.addGrade( grades.findStudent("20141054"),grades.findMatter("8108321"),3.0f,40f);

        //Notas para Programacion 3 - 2.6
        grades.addGrade( grades.findStudent("20141054"),grades.findMatter("8108257"),2.0f,10f);
        grades.addGrade( grades.findStudent("20141054"),grades.findMatter("8108257"),3.0f,30f);
        grades.addGrade( grades.findStudent("20141054"),grades.findMatter("8108257"),1.5f,20f);
        grades.addGrade( grades.findStudent("20141054"),grades.findMatter("8108257"),2.0f,20f);
        grades.addGrade( grades.findStudent("20141054"),grades.findMatter("8108257"),4.0f,20f);

        //Notas para Bases de Datos - Definitiva 4.0
        grades.addGrade( grades.findStudent("20141054"),grades.findMatter("8108265"),4.5f,30f);
        grades.addGrade( grades.findStudent("20141054"),grades.findMatter("8108265"),4.0f,40f);
        grades.addGrade( grades.findStudent("20141054"),grades.findMatter("8108265"),3.5f,30f);

        //Notas para Cátedra Universidad y Entorno - Definitiva 4.4
        grades.addGrade( grades.findStudent("20141054"),grades.findMatter("8108453"),4.0f,60f);
        grades.addGrade( grades.findStudent("20141054"),grades.findMatter("8108453"),5.0f,40f);

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
        /**
         * Inscripciones y Notas de Martha Inés
         */
        //Notas Para Calculo-I - Definitiva 3.0
        assertTrue(grades.addGrade( grades.findStudent("20102410"),grades.findMatter("8108321"),2.5f,30f));
        assertTrue(grades.addGrade( grades.findStudent("20102410"),grades.findMatter("8108321"),3.5f,30f));
        assertTrue(grades.addGrade( grades.findStudent("20102410"),grades.findMatter("8108321"),3.0f,40f));
        assertFalse(grades.addGrade( grades.findStudent("20102410"),grades.findMatter("8108321"),3.0f,1f));
        assertEquals(3,grades.findStudent("20102410").getInscriptions().get(0).getGrades().size());
        assertEquals(2.5,grades.findStudent("20102410").getInscriptions().get(0).getGrades().get(0).getGrade());
        assertEquals(3.5,grades.findStudent("20102410").getInscriptions().get(0).getGrades().get(1).getGrade());
        assertEquals(3.0,grades.findStudent("20102410").getInscriptions().get(0).getGrades().get(2).getGrade());

    }

    @Test
    void calcDefinitive() {
        setupOne();
        Student mil = grades.findStudent("20102410");
        Student cmr = grades.findStudent("20130932");
        Student lap = grades.findStudent("20141054");

        Matter calc = grades.findMatter("8108321");
        Matter bd = grades.findMatter("8108265");
        Matter prog2 = grades.findMatter("8108256");
        Matter prog3 = grades.findMatter("8108257");
        Matter cue = grades.findMatter("8108453");

        //Definitivas de Martha Ines
        assertEquals(3.0, grades.calcDefinitive(mil,calc),0.1);
        assertEquals(2.25, grades.calcDefinitive(mil,prog2),0.1);
        assertEquals(4.4, grades.calcDefinitive(mil,bd),0.1);

        //Definitivas de Claudia Marcela
        assertEquals(3.0,grades.calcDefinitive(cmr,prog2),0.1);
        assertEquals(3.2,grades.calcDefinitive(cmr,bd),0.1);
        assertEquals(2.75,grades.calcDefinitive(cmr,calc),0.1);
        assertEquals(4.6,grades.calcDefinitive(cmr,cue),0.1);

        //Definitiva de Luis Antonio
        assertEquals(2.85,grades.calcDefinitive(lap,calc),0.1);
        assertEquals(2.6,grades.calcDefinitive(lap,prog3),0.1);
        assertEquals(4.0,grades.calcDefinitive(lap,bd),0.1);
        assertEquals(4.4,grades.calcDefinitive(lap,cue),0.1);

        //Definitivas de Calculo I
        assertEquals(3.0,grades.calcDefinitive(calc,mil),0.1);
        assertEquals(2.75,grades.calcDefinitive(calc,cmr),0.1);
        assertEquals(2.85,grades.calcDefinitive(calc,lap),0.1);

        //Definitivas de Bases de Datos
        assertEquals(4.4,grades.calcDefinitive(bd,mil),0.1);
        assertEquals(3.2,grades.calcDefinitive(bd,cmr),0.1);
        assertEquals(4.0,grades.calcDefinitive(bd,lap),0.1);

        //Definitivas de Progra2
        assertEquals(2.25,grades.calcDefinitive(prog2,mil),0.1);
        assertEquals(3.0,grades.calcDefinitive(prog2,cmr),0.1);

        //Definitivas de Cátedra Universidad y Entorno
        assertEquals(4.6,grades.calcDefinitive(cue,cmr),0.1);
        assertEquals(4.4,grades.calcDefinitive(cue,lap),0.1);

        //Definitivas de Progra 3
        assertEquals(2.6,grades.calcDefinitive( prog3,lap),0.1);

    }

    @Test
    void calcAvg() {
        setupOne();
        Student mil = grades.findStudent("20102410");
        Student cmr = grades.findStudent("20130932");
        Student lap = grades.findStudent("20141054");

        Matter calc = grades.findMatter("8108321");
        Matter bd = grades.findMatter("8108265");
        Matter prog2 = grades.findMatter("8108256");
        Matter prog3 = grades.findMatter("8108257");
        Matter cue = grades.findMatter("8108453");

        assertEquals(3.3837,grades.calcAvg(cmr),0.1);
        assertEquals(3.4625, grades.calcAvg(lap),0.1);
        assertEquals(3.21, grades.calcAvg(mil),0.1);

        assertEquals(2.86, grades.calcAvg( calc ),0.1);
        assertEquals(3.86, grades.calcAvg( bd ),0.1);
        assertEquals(4.5, grades.calcAvg( cue ),0.1);
        assertEquals(2.625, grades.calcAvg( prog2),0.1);
        assertEquals(2.6, grades.calcAvg( prog3),0.1);
    }

    @Test
    void testCalcAvg() {
    }
}