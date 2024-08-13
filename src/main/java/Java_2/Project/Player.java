package Java_2.Project;

/**
 * The {@code Player} class represents a player in the game.
 * It provides methods to manage the player's hand, money, bet, and score.
 */
public class Player {

    /**
     * The current hand of the player.
     */
    private Hand currentHand;

    /**
     * The amount of money the player has.
     */
    private int money;

    /**
     * The current bet of the player.
     */
    private int bet;

    /**
     * The score of the player.
     */
    private Score score;

    /**
     * Constructs a new {@code Player} with default values.
     * The player starts with a new hand, a score of 0, $100, and a bet of $10.
     */
    public Player() {
        this.currentHand = new Hand();
        this.score = new Score();
        this.money = 100;
        this.bet = 10;
    }

    /**
     * Returns the current hand of the player.
     *
     * @return the current hand of the player
     */
    public Hand getCurrentHand() {
        return currentHand;
    }

    /**
     * Sets the current hand of the player.
     *
     * @param currentHand the new hand of the player
     */
    public void setCurrentHand(Hand currentHand) {
        this.currentHand = currentHand;
    }

    /**
     * Returns the amount of money the player has.
     *
     * @return the amount of money the player has
     */
    public int getMoney() {
        return money;
    }

    /**
     * Sets the amount of money the player has.
     * If the amount is less than 0, it is set to 0.
     *
     * @param money the new amount of money the player has
     */
    public void setMoney(int money) {
        this.money = money;
        if (this.money < 0) {
            this.money = 0;
        }
    }

    /**
     * Returns the current bet of the player.
     *
     * @return the current bet of the player
     */
    public int getBet() {
        return bet;
    }

    /**
     * Sets the current bet of the player.
     *
     * @param bet the new bet of the player
     */
    public void setBet(int bet) {
        this.bet = bet;
    }

    /**
     * Returns the score of the player.
     *
     * @return the score of the player
     */
    public Score getScore() {
        return this.score;
    }

    /**
     * Sets the score of the player.
     *
     * @param score the new score of the player
     */
    public void setScore(Score score) {
        this.score = score;
    }

    /**
     * Simulates an encounter with a mysterious stranger who gives the player $100.
     *
     * @return a string describing the encounter
     */
    public String mysteriousStranger() {
        setMoney(100);

        return """

                ?????????????????????????????????????????????????????????????????????????????????????????????
                ?..A mysterious stranger takes your hand and in it they place $100 dollars in loose change..?
                ?????????????????????????????????????????????????????????????????????????????????????????????
                """;
    }
}
