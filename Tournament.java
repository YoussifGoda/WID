package WID_Classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tournament {

    private String name;
    private List<Event> events;
    
    public Tournament(String name) {
        this.name = name;
        this.events = new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }
    
    public void addEvent(Event event) {
        events.add(event);
    }
    
    public List<Event> getEvents() {
        return events;
    }
    
    public boolean playedIn(Participant p) {
        for (Event event : events) {
            if (event.playedIn(p)) {
                return true;
            }
        }
        return false;
    }
    
    public List<Participant> getWinners() {
        List<Participant> winners = new ArrayList<>();
        int highestScore = Integer.MIN_VALUE;
        for (Event event : events) {
            int eventScore = event.getScores();
            if (eventScore > highestScore) {
                highestScore = eventScore;
                winners.clear();
                winners.addAll(event.getWinners());
            } else if (eventScore == highestScore) {
                winners.addAll(event.getWinners());
            }
        }
        return winners;
    }
    
    public Map<Participant, Integer> getScores() {
        Map<Participant, Integer> scores = new HashMap<>();
        for (Event event : events) {
            for (Participant participant : event.getWinners()) {
                int score = scores.getOrDefault(participant, 0);
                score += event.getScore(participant);
                scores.put(participant, score);
            }
        }
        return scores;
    }
}
