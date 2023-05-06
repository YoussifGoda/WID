package WID_Classes;

import static org.junit.Assert.*;

import org.junit.Test;

public class ParticipantTest {

    @Test
    public void testGetName() {
        Participant p = new Participant("John");
        assertEquals("John", p.getName());
    }
    
    @Test
    public void testSetName() {
        Participant p = new Participant("John");
        p.setName("Jane");
        assertEquals("Jane", p.getName());
    }
    
}
