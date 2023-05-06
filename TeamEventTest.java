package WID_Classes;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TeamEventTest {

    @Test
    public void testAddScore() {
        TeamEvent event = new TeamEvent("Soccer");

        List<Participant> team = new ArrayList<>();
        team.add(new Participant("John"));
        team.add(new Participant("Jane"));
        team.add(new Participant("Bob"));

        event.addScore(team, 2,0);
        event.addScore(team, 3,1);
        event.addScore(team, 1,2);

        assertEquals(6, event.getScore(team));
    }

    @Test
    public void testGetScore() {
        TeamEvent event = new TeamEvent("Basketball");

        List<Participant> team = new ArrayList<>();
        team.add(new Participant("Alice"));
        team.add(new Participant("David"));
        team.add(new Participant("Emily"));

        event.addScore(team, 3,0);
        event.addScore(team, 2,1);
        event.addScore(team, 0,2);

        assertEquals(5, event.getScore(team));
    }

    @Test
    public void testInvalidScore() {
        TeamEvent event = new TeamEvent("Volleyball");

        List<Participant> team = new ArrayList<>();
        team.add(new Participant("Tom"));
        team.add(new Participant("Sarah"));
        team.add(new Participant("Mike"));

        event.addScore(team, 0,0);
        event.addScore(team, -1,1);
        event.addScore(team, 0,2);

        assertEquals(-1, event.getScore(team));
    }
}
