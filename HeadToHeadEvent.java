package WID_Classes;



public class HeadToHeadEvent extends Event {

	public HeadToHeadEvent(String name) {
        super(name);
    }

    public void addScore(Participant p1, Participant p2, int score1, int score2) {
        super.addScore(p1, score1);
        super.addScore(p2, score2);
    }

    public int getScore(Participant p1, Participant p2) {
        int score1 = super.getScore(p1);
        int score2 = super.getScore(p2);
        if (score1 >= 0 && score2 >= 0) {
            return score1 + score2;
        } else {
            return -1;
        }
    }
}



