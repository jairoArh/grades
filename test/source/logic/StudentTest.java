package logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    private Student lina;
    private Matter calc1;
    private Matter progra2;
    private Matter bd;
    private Matter net;

    void setup(){
        lina = new Student("201332464","Lina María Barrera");
        calc1 = new Matter("232342","Calculo I",(byte)4);
        progra2 = new Matter("356465","Programación II",(byte)4);
        bd = new Matter("456344","Bases de Dtos",(byte)3);
        net = new Matter("754565","Redes",(byte)3);

        lina.addInscription(calc1);
        lina.addInscription(progra2);
        lina.addInscription(bd);
        lina.addInscription(net);
    }

    void setupTwo(){
        setup();
        //calc1=3.5
        lina.addGrade( calc1, 3.5f,60 );
        lina.addGrade( calc1, 3.5f,40 );
        lina.addGrade( calc1, 4.2f,0.5f );

        //progra2 = 3.0
        lina.addGrade( progra2,2.0f,25 ); //0.5
        lina.addGrade( progra2,3.0f,30 ); //0.9
        lina.addGrade( progra2,4.0f,25 ); //1.0
        lina.addGrade( progra2,3.0f,20 ); //0.6

        //bd 4.0
        lina.addGrade( bd,4.0f, 100 ); //4.0

        //net 2.7
        lina.addGrade( net,1.5f,20); //0.3
        lina.addGrade( net,2.0f,20); //0.4
        lina.addGrade( net,3.5f,20); //0.7
        lina.addGrade( net,2.5f,20); //0.5
        lina.addGrade( net,4.0f,20); //0.8
    }

    @Test
    void addGrade() {
        //calc1=3.5
        setup();
        assertTrue( lina.addGrade( calc1, 3.5f,60 ) );
        assertTrue( lina.addGrade( calc1, 3.5f,40 ) );
        assertFalse( lina.addGrade( calc1, 4.2f,0.5f ) );

        //progra2 = 3.0
        assertTrue(lina.addGrade( progra2,2.0f,25 )); //0.5
        assertTrue(lina.addGrade( progra2,3.0f,30 )); //0.9
        assertTrue(lina.addGrade( progra2,4.0f,25 )); //1.0
        assertTrue(lina.addGrade( progra2,3.0f,20 )); //0.6

        assertTrue( lina.addGrade( bd,4.0f, 100 )); //4.0

        //2.7
        assertTrue( lina.addGrade( net,1.5f,20)); //0.3
        assertTrue( lina.addGrade( net,2.0f,20)); //0.4
        assertTrue( lina.addGrade( net,3.5f,20)); //0.7
        assertTrue( lina.addGrade( net,2.5f,20)); //0.5
        assertTrue( lina.addGrade( net,4.0f,20)); //0.8

    }

    @Test
    void calcDefinitive() {
        setupTwo();
        assertEquals(3.5,lina.calcDefinitive( calc1 ) );
        assertEquals(3.0,lina.calcDefinitive( progra2 ) );
        assertEquals(4.0,lina.calcDefinitive( bd ) );
        assertEquals(2.7,lina.calcDefinitive( net ),0.1 );
    }

    @Test
    void calcAverage() {
        setupTwo();
        assertEquals(3.3,lina.calcAverage(  ),0.1 );
    }

    @Test
    void sumCredits(){
        setupTwo();
        assertEquals(14,lina.sumCredits());
    }
}