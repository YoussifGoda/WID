package WID_Classes;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class IndividualEventTest {

    @Test
    public void testAddScore() {
        IndividualEvent event = new IndividualEvent("Running");
        Participant p1 = new Participant("Alice");
        Participant p2 = new Participant("Bob");
        event.addScore(p1, 10);
        event.addScore(p2, 20);
        assertEquals(event.getScore(p1), 10);
        assertEquals(event.getScore(p2), 20);
    }

    @Test
    public void testGetScore() {
        IndividualEvent event = new IndividualEvent("Running");
        Participant p1 = new Participant("Alice");
        Participant p2 = new Participant("Bob");
        event.addScore(p1, 10);
        event.addScore(p2, 20);
        assertEquals(event.getScore(p1), 10);
        assertEquals(event.getScore(p2), 20);
    }

    @Test
    public void testGetWinners() {
        IndividualEvent event = new IndividualEvent("Running");
        Participant p1 = new Participant("Alice");
        Participant p2 = new Participant("Bob");
        Participant p3 = new Participant("Charlie");
        event.addScore(p1, 10);
        event.addScore(p2, 20);
        event.addScore(p3, 15);
        List<Participant> winners = event.getWinners();
        
        assertEquals(winners.size(), 1);
        assertEquals(winners.get(0), p2);
    }

}
