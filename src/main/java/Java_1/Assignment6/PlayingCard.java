package Java_1.Assignment6;

import java.io.PrintStream;

/**
 * The PlayingCard class represents a standard playing card with a value and a suit.
 *
 * @Author Greg Dawe
 */
public class PlayingCard {

    private final Value value;
    private final Suit suit;

    /**
     * Constructs a playing card with the given value and suit.
     *
     * @param value The value of the card (e.g., "A", "2", "3", ..., "K").
     * @param suit  The suit of the card (one of DIAMONDS, HEARTS, CLUBS, SPADES).
     */
    public PlayingCard(Value value, Suit suit) {

        this.value = value;
        this.suit = suit;
    }

    /**
     * Gets the suit of the playing card.
     *
     * @return The suit of the card.
     */
    public Suit getSuit() {
        return this.suit;
    }

    /**
     * Gets the value of the playing card.
     *
     * @return The value of the card.
     */
    public Value getValue() {
        return this.value;
    }

    /**
     * Prints an ASCII representation of the playing card to the specified PrintStream.
     *
     * @param playingCard The playing card to be printed.
     * @param printStream The PrintStream to which the ASCII representation is printed.
     * @return Always returns null.
     */
    public static String printAsciiCard(PlayingCard playingCard, PrintStream printStream) {

        printStream.print(" _________\n" +
                "| " + playingCard.value.val + "       |\n" +
                "|         |\n" +
                "|    " + playingCard.suit.unicode + "    |\n" +
                "|         |\n" +
                "|       " + playingCard.value.val + " |\n" +
                " ---------\n");
        return "";
    }

    /**
     * Enumerates the possible suits of a playing card.
     */
    public enum Suit {
        DIAMONDS("\u2666"),
        HEARTS("\u2665"),
        CLUBS("\u2663"),
        SPADES("\u2660");
        final String unicode;

        Suit(String unicode) {
            this.unicode = unicode;
        }
    }

    ;

    /**
     * Enumerates the possible values of a playing card.
     */
    public enum Value {
        ACE("A"),
        ONE("1"),
        TWO("2"),
        THREE("3"),
        FOUR("4"),
        FIVE("5"),
        SIX("6"),
        SEVEN("7"),
        EIGHT("8"),
        NINE("9"),
        TEN("10"),
        JACK("J"),
        QUEEN("Q"),
        KING("K");
        final String val;

        Value(String str) {
            this.val = str;
        }
    }

    ;

    /**
     * Returns a string representation of the playing card.
     *
     * @return The string representation of the playing card (value + suit).
     */
    @Override
    public String toString() {
        return value.val + " " + suit.unicode;
    }


}

















