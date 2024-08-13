package Java_1.Assignment6;

import java.util.Random;

/**
 * The PlayingCardFactory class is responsible for generating random playing cards.
 *
 * @Author Greg Dawe
 */
public class PlayingCardFactory {


    /**
     * Generates a random playing card with a random value and suit.
     *
     * @return A string representation of the randomly generated playing card.
     */
    public static String generateRandomCard() {


        Random random = new Random();
        PlayingCard.Value randomValue = PlayingCard.Value.values()[random.nextInt(13)];

        PlayingCard.Suit randomSuit = PlayingCard.Suit.values()[random.nextInt(3)];
        PlayingCard randomPlayingCard = new PlayingCard(randomValue, randomSuit);
        return randomPlayingCard.toString();
    }

    /**
     * Generates a random playing card with a specified suit and a random value.
     *
     * @param suit The suit of the randomly generated playing card.
     * @return A string representation of the randomly generated playing card.
     */
    public static String generateRandomCardFromSuit(PlayingCard.Suit suit) {

        Random random = new Random();
        PlayingCard.Value randomValue = PlayingCard.Value.values()[random.nextInt(13)];

        PlayingCard randomPlayingCard = new PlayingCard(randomValue, suit);
        return randomPlayingCard.toString();
    }
}
