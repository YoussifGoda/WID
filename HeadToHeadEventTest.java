package WID_Classes;

import static org.junit.Assert.*;

import org.junit.Test;

public class HeadToHeadEventTest {

    @Test
    public void testAddScoreAndGetScore() {
        HeadToHeadEvent event = new HeadToHeadEvent("Tennis");
        Participant p1 = new Participant("John");
        Participant p2 = new Participant("Jane");
        event.addScore(p1, p2, 6, 4);
        assertEquals(6, event.getScore(p1));
        assertEquals(4, event.getScore(p2));
        assertEquals(10, event.getScore(p1, p2));
    }

    @Test
    public void testGetScoreInvalid() {
        HeadToHeadEvent event = new HeadToHeadEvent("Tennis");
        Participant p1 = new Participant("John");
        Participant p2 = new Participant("Jane");
        event.addScore(p1, -1);
        event.addScore(p2, 3);
        assertEquals(-1, event.getScore(p1, p2));
    }
}
