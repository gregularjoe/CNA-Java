package Java_2.Project;

import java.util.ArrayList;

/**
 * The {@code Hand} class represents a hand of playing cards.
 * It provides methods to manage the cards in the hand.
 */
public class Hand {

    /**
     * The current hand of playing cards.
     */
    private ArrayList<PlayingCard> currentHand = new ArrayList<>();

    /**
     * Constructs an empty hand.
     */
    public Hand() {
        this.currentHand = new ArrayList<>();
    }

    /**
     * Constructs a hand with the specified cards.
     *
     * @param hand the initial cards in the hand
     */
    public Hand(ArrayList<PlayingCard> hand) {
        currentHand = new ArrayList<>(hand);
    }

    /**
     * Returns the current hand of playing cards.
     *
     * @return the current hand of playing cards
     */
    public ArrayList<PlayingCard> getHand() {
        return this.currentHand;
    }

    /**
     * Sets the current hand of playing cards.
     *
     * @param currentHand the new hand of playing cards
     */
    public void setHand(ArrayList<PlayingCard> currentHand) {
        this.currentHand = currentHand;
    }

    /**
     * Adds a card to the current hand.
     *
     * @param playingCard the card to be added
     */
    public void addCard(PlayingCard playingCard) {
        this.currentHand.add(playingCard);
    }

    /**
     * Returns the number of cards in the current hand.
     *
     * @return the number of cards in the current hand
     */
    public int getSize() {
        return currentHand.size();
    }

    /**
     * Returns a string representation of the current hand.
     *
     * @return a string representation of the current hand
     */
    public String printHand() {
        StringBuilder handString = new StringBuilder();
        for (PlayingCard card : this.currentHand) {
            handString.append("|").append(card.toString()).append("|");
        }
        return handString.toString().trim();
    }
}
