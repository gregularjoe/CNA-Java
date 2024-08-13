package Java_2.Project;

public class Dealer {
    private Hand currentHand;
    private Score score;

    /**
     * Constructs a Dealer with an empty hand and a new score.
     */
    public Dealer() {
        this.currentHand = new Hand();
        this.score = new Score();
    }

    /**
     * Gets the current hand of the dealer.
     *
     * @return The current hand of the dealer.
     */
    public Hand getCurrentHand() {
        return this.currentHand;
    }

    /**
     * Sets the current hand of the dealer.
     *
     * @param currentHand The new hand to set for the dealer.
     */
    public void setCurrentHand(Hand currentHand) {
        this.currentHand = currentHand;
    }

    /**
     * Gets the score of the dealer.
     *
     * @return The score of the dealer.
     */
    public Score getScore() {
        return this.score;
    }

    /**
     * Sets the score of the dealer.
     *
     * @param score The new score to set for the dealer.
     */
    public void setScore(Score score) {
        this.score = score;
    }
}
