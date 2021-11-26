package logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    Matter math;
    Matter physic;
    Student student;
    public void setup() {
        math = new Matter("Calculo I", (byte) 4);
        physic = new Matter("Física I", (byte) 4);
        student = new Student("72489", "Daniel Guerra");
        student.addInscription(math);
        student.addInscription(physic);
    }
    @Test
    void addGrade() {
        setup();
        assertTrue(student.addGrade(math, 3.0f, 30f));
        assertTrue(student.addGrade(math, 3.5f, 50f));
        assertTrue(student.addGrade(physic, 4.0f, 80f));
        assertFalse(student.addGrade(math, 3.2f, 30f));
        assertFalse(student.addGrade(physic, 3.4f, 30f));

    }

    @Test
    void calcDefinitive() {
        setup();
        student.addGrade(math, 3.0f, 30f);
        student.addGrade(math, 4.0f, 40f);
        student.addGrade(math, 3.2f, 30f);
        student.addGrade(physic, 3.0f, 50f);
        student.addGrade(physic, 2.8f, 20f);
        assertEquals(3.4, student.calcDefinitive(math), 0.1);
        assertEquals(2.0, student.calcDefinitive(physic), 0.1);

    }

    @Test
    void calcAverage() {
        setup();
        student.addGrade(math, 3.0f, 30f);
        student.addGrade(math, 4.0f, 40f);
        student.addGrade(math, 3.2f, 30f);
        student.addGrade(physic, 3.0f, 50f);
        student.addGrade(physic, 2.8f, 20f);
        student.addGrade(physic, 3.5f, 20f);
        assertEquals(3.1, student.calcAverage(), 0.1);
    }
}