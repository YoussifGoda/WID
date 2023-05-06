package WID_Classes;

import org.junit.Test;
import static org.junit.Assert.*;

public class EventTest {

    @Test
    public void testGetName() {
        Event event = new HeadToHeadEvent("Tennis");
        assertEquals("Tennis", event.getName());
    }

    @Test
    public void testAddScoreAndGetScore() {
        Event event = new HeadToHeadEvent("Tennis");
        Participant p1 = new Participant("John");
        Participant p2 = new Participant("Jane");
        event.addScore(p1, 6);
        event.addScore(p2, 4);
        assertEquals(6, event.getScore(p1));
        assertEquals(4, event.getScore(p2));
        assertEquals(10, event.getScores());
    }

    @Test
    public void testGetScores() {
        Event event = new IndividualEvent("Running");
        Participant p1 = new Participant("John");
        Participant p2 = new Participant("Jane");
        event.addScore(p1, 10);
        event.addScore(p2, 20);
        assertEquals(30, event.getScores());
    }

    @Test
    public void testPlayedIn() {
        Event event = new HeadToHeadEvent("Tennis");
        Participant p1 = new Participant("John");
        Participant p2 = new Participant("Jane");
        event.addScore(p1, 6);
        event.addScore(p2, 4);
        assertTrue(event.playedIn(p1));
        assertTrue(event.playedIn(p2));
        assertFalse(event.playedIn(new Participant("Jim")));
    }

    @Test
    public void testGetWinners() {
        Event event = new IndividualEvent("Running");
        Event event2 = new IndividualEvent("Swimming");
        Participant p1 = new Participant("John");
        Participant p2 = new Participant("Jane");
        Participant p3 = new Participant("Youssif");
        event.addScore(p1, 10);
        event.addScore(p2, 20);
        event.addScore(p3, 0);
        assertEquals(p2, event.getWinners().get(0));
        assertEquals(null, event2.getWinners().get(0));
    }
}
