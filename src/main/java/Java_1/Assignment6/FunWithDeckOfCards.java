package Java_1.Assignment6;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * The Main class contains the main method to execute the Card App.
 * It provides a simple text-based interface for interacting with a deck of playing cards.
 *
 * @Author Greg Dawe
 */
public class FunWithDeckOfCards {
    public static void main(String[] args) {

        System.out.println("Welcome to My Card App!");
        //Playing Card Class
        PlayingCard playingCard = new PlayingCard(PlayingCard.Value.ACE, PlayingCard.Suit.SPADES);
        System.out.printf("Testing the toString override method: %s\n", playingCard.toString());

        //ASCII method
        System.out.println("Testing the printAciiCard method: ");
        PlayingCard.printAsciiCard(playingCard, new PrintStream(System.out));

        //Gets Random Card - PlayingCardFactory
        System.out.printf("\nTesting the generateRandomCard method: %s\n", PlayingCardFactory.generateRandomCard());
        System.out.printf("Testing the generateRandomCardFromSuit method: %s\n", PlayingCardFactory.generateRandomCardFromSuit(PlayingCard.Suit.SPADES));


        PrintStream printStream = new PrintStream(System.out);

        //CardDeck
        CardDeck cardDeck = new CardDeck();


        Scanner input = new Scanner(System.in);
        char c;
        do {
            System.out.print("""

                    Enter A to see the deck of cards.
                    Enter B to shuffle the deck.
                    Enter C to draw a card.
                    Enter D to draw a hand of five cards.
                    Enter E to see how many cards are left in the deck.
                    When you're ready to Quit Press Q.
                    What would you like to do?:\s""");
            c = Character.toUpperCase(input.next().charAt(0));

            if (c == 'A') {
                if (cardDeck.getSize() == 0) {
                    System.out.println("\nThere are no cards left :(");
                } else {
                    printStream.println("\n ");
                    cardDeck.printDeck(printStream);
                    printStream.println("\n ");
                }

            } else if (c == 'B') {
                cardDeck.deckShuffler();
                System.out.println("\nThe deck hath been thuffled!!\n");

            } else if (c == 'C') {
                if (cardDeck.getSize() == 0) {
                    System.out.println("\nThere are no cards left :(");

                } else {
                    printStream.println(" ");
                    cardDeck.drawCard(printStream);
                }

            } else if (c == 'D') {
                if (cardDeck.getSize() < 5) {
                    System.out.println("\nThere are less than five cards left :(");
                } else {
                    printStream.println("\n ");
                    cardDeck.drawHand(printStream);
                    printStream.println("\n ");
                }

            } else if (c == 'E') {
                System.out.printf("\nThere are %d cards left in the deck.\n", cardDeck.getSize());
            }
        } while (c != 'Q');
        System.out.println("Thanks for playing!");
    }
}