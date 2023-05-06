package WID_Classes;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;

public class TournamentTest {
    
    @Test
    public void testGetName() {
        Tournament t = new Tournament("Tennis Championship");
        assertEquals("Tennis Championship", t.getName());
    }
    
    @Test
    public void testAddEvent() {
        Tournament t = new Tournament("Tennis Championship");
        IndividualEvent e1 = new IndividualEvent("Men's Singles");
        IndividualEvent e2 = new IndividualEvent("Women's Singles");
        t.addEvent(e1);
        t.addEvent(e2);
        List<Event> events = t.getEvents();
        assertEquals(2, events.size());
        assertEquals("Men's Singles", events.get(0).getName());
        assertEquals("Women's Singles", events.get(1).getName());
    }
    
    @Test
    public void testPlayedIn() {
        Tournament t = new Tournament("Tennis Championship");
        IndividualEvent e1 = new IndividualEvent("Men's Singles");
        Participant p1 = new Participant("Roger Federer");
        Participant p2 = new Participant("Rafael Nadal");
        e1.addScore(p1, 6);
        t.addEvent(e1);
        assertTrue(t.playedIn(p1));
        assertFalse(t.playedIn(p2));
    }
    
    @Test
    public void testGetWinners() {
        Tournament t = new Tournament("Tennis Championship");
        IndividualEvent e1 = new IndividualEvent("Men's Singles");
        IndividualEvent e2 = new IndividualEvent("Women's Singles");
        Participant p1 = new Participant("Roger Federer");
        Participant p2 = new Participant("Rafael Nadal");
        Participant p3 = new Participant("Serena Williams");
        Participant p4 = new Participant("Maria Sharapova");
        e1.addScore(p1, 6);
        e1.addScore(p2, 4);
        e2.addScore(p3, 6);
        e2.addScore(p4, 6);
        t.addEvent(e1);
        t.addEvent(e2);
        List<Participant> winners = t.getWinners();
        assertEquals(2, winners.size());
        assertEquals(p3, winners.get(0));
        assertEquals(p4, winners.get(1));
    }
    
    @Test
    public void testGetScores() {
        Tournament t = new Tournament("Tennis Championship");
        IndividualEvent e1 = new IndividualEvent("Men's Singles");
        IndividualEvent e2 = new IndividualEvent("Women's Singles");
        Participant p1 = new Participant("Roger Federer");
        Participant p2 = new Participant("Rafael Nadal");
        Participant p3 = new Participant("Serena Williams");
        Participant p4 = new Participant("Maria Sharapova");
        e1.addScore(p1, 6);
        e1.addScore(p2, 4);
        e2.addScore(p3, 6);
        e2.addScore(p4, 6);
        t.addEvent(e1);
        t.addEvent(e2);
        Map<Participant, Integer> scores = t.getScores();
        assertEquals(3, scores.size());
        assertEquals((Integer)6, scores.get(p1));
        assertEquals((Integer)6, scores.get(p3));
        assertEquals((Integer)6, scores.get(p4));
    }

}

