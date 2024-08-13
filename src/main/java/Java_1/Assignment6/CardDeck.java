package Java_1.Assignment6;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;

/**
 * The CardDeck class represents a deck of playing cards.
 *
 * @Author Greg Dawe
 */
public class CardDeck {

    private final ArrayList<PlayingCard> deck;

    /**
     * Constructs a card deck of 52 cards.
     */
    public CardDeck() {
        this.deck = new ArrayList<>();

        for (PlayingCard.Suit suit : PlayingCard.Suit.values()) {

            for (PlayingCard.Value s : PlayingCard.Value.values()) {
                this.deck.add(new PlayingCard(s, suit));
            }
        }
    }

    /**
     * Shuffles the deck of playing cards.
     */
    public void deckShuffler() {
        Collections.shuffle(this.deck);
    }

    /**
     * Gets the size of the deck arraylist.
     *
     * @return The number of cards in the deck.
     */
    public int getSize() {
        return this.deck.size();
    }

    /**
     * Prints the contents of the deck arraylist.
     */
    public void printDeck(PrintStream printStream) {

        for (PlayingCard c : this.deck) {

            printStream.printf("|%s|", c);

        }
    }

    /**
     * Prints the first card in the deck arraylist.
     * Removes that card from the deck arraylist.
     */
    public void drawCard(PrintStream printStream) {
        printStream.printf("|%s|", this.deck.get(0));
        this.deck.remove(0);
    }

    /**
     * Prints the first  5 cards in the deck arraylist.
     * Removes first 5 cards from the deck arraylist.
     */
    public void drawHand(PrintStream printStream) {
        for (int i = 0; i < 5; i++) {
            printStream.printf("|%s|", this.deck.get(0));
            this.deck.remove(0);
        }
    }
}
