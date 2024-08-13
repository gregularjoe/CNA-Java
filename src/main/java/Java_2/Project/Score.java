package Java_2.Project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * The {@code Score} class represents the score calculation for a hand of playing cards.
 * It provides methods to calculate and retrieve the score.
 */
public class Score {

    /**
     * The list of face cards (Jack, Queen, King).
     */
    private final ArrayList<String> faceCards = new ArrayList<>(Arrays.asList("J", "Q", "K"));

    /**
     * The list of number cards (2 to 10).
     */
    private final ArrayList<String> numberCards = new ArrayList<>(Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10"));

    /**
     * The current score.
     */
    private int score;

    /**
     * Calculates the score for the given hand of playing cards.
     *
     * @param hand the hand of playing cards
     */
    public void calculateScore(Hand hand) {
        int updatingScore = 0;
        boolean hasAce = false;

        for (int i = 0; i < hand.getSize(); i++) {
            PlayingCard currentCard = hand.getHand().get(i);

            if (faceCards.contains(currentCard.getValue().val)) {
                updatingScore += 10;
            } else if (numberCards.contains(currentCard.getValue().val)) {
                updatingScore += Integer.parseInt(currentCard.getValue().val);
            }

            if (Objects.equals(currentCard.getValue().val, "A")) {
                updatingScore += 11;
                hasAce = true;
            }
        }
        if (updatingScore > 21 && hasAce) {
            updatingScore -= 10;
        }

        setScore(updatingScore);
    }

    /**
     * Returns the current score.
     *
     * @return the current score
     */
    public int getScore() {
        return this.score;
    }

    /**
     * Sets the current score.
     *
     * @param calculatedScore the new score to be set
     */
    private void setScore(int calculatedScore) {
        this.score = calculatedScore;
    }
}
