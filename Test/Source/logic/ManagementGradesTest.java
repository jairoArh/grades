package logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagementGradesTest {
    ManagementGrades managementGrades;
    Student daniel;
    Student alejandro;
    Matter calc;
    Matter progra;
    Matter baseData;

    public void setup() {
        daniel = new Student("202021543", "Daniel Guerra");
        alejandro = new Student("234235253", "Alejandro Muñoz");
        calc = new Matter("Calculo I", (byte)4);
        progra = new Matter("Programación II", (byte)4);
        baseData = new Matter("Bases de datos", (byte)3);
        managementGrades = new ManagementGrades();
        managementGrades.addInscription(daniel, calc);
        managementGrades.addInscription(daniel, progra);
        managementGrades.addInscription(daniel, baseData);
        managementGrades.addInscription(alejandro, calc);
        managementGrades.addInscription(alejandro, progra);
        managementGrades.addInscription(alejandro, baseData);

    }

    public void setupTwo(){
        setup();
        managementGrades.addGrade(daniel, calc, 3.3f, 30f);
        managementGrades.addGrade(daniel, calc, 4.1f, 40f);
        managementGrades.addGrade(daniel, calc, 2.5f, 30f);

        managementGrades.addGrade(daniel, progra, 3.7f, 10f);
        managementGrades.addGrade(daniel, progra, 3.6f, 50);
        managementGrades.addGrade(daniel, progra, 1.1f, 25f);
        managementGrades.addGrade(daniel, progra, 4.1f, 15f);

        managementGrades.addGrade(daniel, baseData, 2.5f, 60);
        managementGrades.addGrade(daniel, baseData, 4.5f, 40f);

        managementGrades.addGrade(alejandro, progra, 3.2f, 20f);
        managementGrades.addGrade(alejandro, progra, 2.6f, 35);
        managementGrades.addGrade(alejandro, progra, 1.8f, 25f);
        managementGrades.addGrade(alejandro, progra, 3.7f, 20f);

        managementGrades.addGrade(alejandro, calc, 3.7f, 40f);
        managementGrades.addGrade(alejandro, calc, 3.6f, 30f);
        managementGrades.addGrade(alejandro, calc, 1.1f, 30f);

        managementGrades.addGrade(alejandro, baseData, 3.9f, 31f);
        managementGrades.addGrade(alejandro, baseData, 4.6f, 34f);
        managementGrades.addGrade(alejandro, baseData, 2.1f, 5f);
        managementGrades.addGrade(alejandro, baseData, 4.5f, 30f);

    }

    @Test
    void addGrade() {
        setup();
        assertTrue(managementGrades.addGrade(daniel, calc, 3.3f, 30f));
        assertTrue(managementGrades.addGrade(daniel, calc, 4.1f, 40f));
        assertTrue(managementGrades.addGrade(daniel, calc, 2.5f, 30f));
        assertFalse(managementGrades.addGrade(daniel, calc, 2.5f, 0.30f));

        assertTrue(managementGrades.addGrade(daniel, progra, 3.7f, 10f));
        assertTrue(managementGrades.addGrade(daniel, progra, 3.6f, 50));
        assertTrue(managementGrades.addGrade(daniel, progra, 1.1f, 25f));
        assertTrue(managementGrades.addGrade(daniel, progra, 4.1f, 15f));
        assertFalse(managementGrades.addGrade(daniel, progra, 4.1f, 0.3f));

        assertTrue(managementGrades.addGrade(alejandro, progra, 3.2f, 20f));
        assertTrue(managementGrades.addGrade(alejandro, progra, 2.6f, 35));
        assertTrue(managementGrades.addGrade(alejandro, progra, 1.8f, 25f));
        assertTrue(managementGrades.addGrade(alejandro, progra, 3.7f, 20f));
        assertFalse(managementGrades.addGrade(alejandro, progra, 3.7f, 20f));
        assertFalse(managementGrades.addGrade(alejandro, progra, 3.7f, 20f));
    }

    @Test
    void calcDefinitve() {
        setupTwo();
        assertEquals(3.4f,managementGrades.calcDefinitve(daniel, calc));
        assertEquals(3.1f, managementGrades.calcDefinitve(daniel, progra));
        assertEquals(3.3f, managementGrades.calcDefinitve(daniel, baseData));

        assertEquals(2.7f, managementGrades.calcDefinitve(alejandro, progra));
        assertEquals(2.9f, managementGrades.calcDefinitve(alejandro, calc));
        assertEquals(4.2f, managementGrades.calcDefinitve(alejandro, baseData));
    }

    @Test
    void calcAverageStudent() {
        setupTwo();
        assertEquals(3.3f, managementGrades.calcAverageStudent(daniel));
        assertEquals(3.3f, managementGrades.calcAverageStudent(alejandro));

    }

    @Test
    void calcAverageMatter() {
        setupTwo();
        assertEquals(3.2f, managementGrades.calcAverageMatter(calc));
        assertEquals(2.9f, managementGrades.calcAverageMatter(progra));
        assertEquals(3.8f, managementGrades.calcAverageMatter(baseData));
    }
}