package WID_Classes;

import java.util.ArrayList;
import java.util.List;

public class EventDemo {

    public static void main(String[] args) {

        // Create participants
        Participant p1 = new Participant("Alice");
        Participant p2 = new Participant("Bob");
        Participant p3 = new Participant("Charlie");
        Participant p4 = new Participant("David");
        Participant p5 = new Participant("Eve");

        // Create tournament
        Tournament tournament = new Tournament("My Tournament");

        // Create individual event
        IndividualEvent individualEvent = new IndividualEvent("Individual Event");
        individualEvent.addScore(p1, 10);
        individualEvent.addScore(p2, 20);
        individualEvent.addScore(p3, 30);
        individualEvent.addScore(p4, 40);
        individualEvent.addScore(p5, 50);
        tournament.addEvent(individualEvent);

        // Create head-to-head event
        HeadToHeadEvent headToHeadEvent = new HeadToHeadEvent("Head-to-Head Event");
        headToHeadEvent.addScore(p1, p2, 20, 10);
        headToHeadEvent.addScore(p1, p3, 30, 20);
        headToHeadEvent.addScore(p2, p4, 15, 25);
        headToHeadEvent.addScore(p3, p4, 35, 30);
        headToHeadEvent.addScore(p4, p5, 40, 45);
        tournament.addEvent(headToHeadEvent);

        // Create team event
        TeamEvent teamEvent = new TeamEvent("Team Event");
        List<Participant> team1 = new ArrayList<>();
        team1.add(p1);
        team1.add(p2);
        team1.add(p3);
        teamEvent.addScore(team1, 20,0);
        teamEvent.addScore(team1, 30,1);
        teamEvent.addScore(team1, 50,2);
        List<Participant> team2 = new ArrayList<>();
        team2.add(p3);
        team2.add(p4);
        team2.add(p5);
        teamEvent.addScore(team1, 20,0);
        teamEvent.addScore(team1, 40,1);
        teamEvent.addScore(team1, 50,2);
        tournament.addEvent(teamEvent);

        // Print winners of tournament
        System.out.println("Winners of " + tournament.getName() + ":");
        List<Participant> winners = tournament.getWinners();
        if (winners.isEmpty()) {
            System.out.println("No winners");
        } else {
            for (Participant winner : winners) {
                System.out.println(winner.getName());
            }
        }
    }
}

