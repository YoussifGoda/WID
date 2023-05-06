package WID_Classes;

import java.util.List;

public class TeamEvent extends Event {
    public TeamEvent(String name) {
        super(name);
    }

    public void addScore(List<Participant> team, int score, int index) {
        //for (Participant p : team) {
            super.addScore(team.get(index), score);
    }

    public int getScore(List<Participant> team) {
        int sum = 0;
        boolean valid = true;
        for (Participant p : team) {
            int score = super.getScore(p);
            if (score >= 0) {
                sum += score;
            } else {
                valid = false;
                break;
            }
        }
        if (valid) {
            return sum;
        } else {
            return -1;
        }
    }
}
