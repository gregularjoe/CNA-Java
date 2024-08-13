package Java_2.Project;

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
     * Prints the first card in the deck arraylist.
     * Removes that card from the deck arraylist.
     */
    public PlayingCard drawCard() {
        PlayingCard currentCard = this.deck.get(0);
        this.deck.remove(0);
        return currentCard;
    }

    /**
     * Prints the first  5 cards in the deck arraylist.
     * Removes first 5 cards from the deck arraylist.
     */
    public Hand drawHand() {
        ArrayList<PlayingCard> newHand = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            newHand.add(this.drawCard());
        }
        return new Hand(newHand);
    }
}
