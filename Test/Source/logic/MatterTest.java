package logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatterTest {
    private Matter matter;
    private Student lola;
    private Student mateo;

    private void setup(){
        matter = new Matter("673874","Calculo I",(byte)4);
        lola = new Student("4563563","Dolores Diaz");
        mateo =  new Student("8374462","Mateo Suárez");
        matter.addInscription( lola );
        matter.addInscription( mateo );
    }

    @Test
    void addGrade() {
        setup();
        assertTrue(matter.addGrade(lola,2.5f,20f));
        assertFalse(matter.addGrade(lola,2.5f,81f));
        assertTrue(matter.addGrade(lola,3.5f,40f));
        assertTrue(matter.addGrade(lola,4.0f,40f));
        assertFalse(matter.addGrade(lola,2.5f,1f));
    }

    @Test
    void calcAverage() {
        setup();
        matter.addGrade(lola,2.5f,20f);
        matter.addGrade(lola,3.5f,40f);
        matter.addGrade(lola,4.0f,40f);
        assertEquals(3.5,matter.calcDefinitive(lola));

        matter.addGrade(mateo,2.0f,20f); // 0.4
        matter.addGrade(mateo,3.0f,30f); // 0.9
        matter.addGrade(mateo,2.0f,30f); //0.6
        matter.addGrade(mateo,1.5f,20f); //0.3
        assertEquals(2.2,matter.calcDefinitive( mateo ),0.1);

        assertEquals(2.85,matter.calcAverage(), 0.1);
    }

    @Test
    void calcDefinitive(){
        setup();
        matter.addGrade(lola,2.5f,20f);
        matter.addGrade(lola,3.5f,40f);
        matter.addGrade(lola,4.0f,40f);
        assertEquals(3.5,matter.calcDefinitive( lola ) );
        assertEquals(0.0,matter.calcDefinitive( mateo ));
        matter.addGrade(mateo,2.5f,20f);
        assertEquals(0.5,matter.calcDefinitive( mateo ));
    }

    @Test
    void getInscriptions(){
        setup();
        assertEquals(2,matter.getInscriptions().size());
        assertNotNull( matter.getInscriptions().get(0).getStudent());
        assertNotNull( matter.getInscriptions().get(1).getStudent());
    }
}