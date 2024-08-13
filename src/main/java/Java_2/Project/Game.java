package Java_2.Project;

public class Game {

    private Player player;
    private Dealer dealer;
    private CardDeck cardDeck;


    /**
     * Starts the game by initializing the card deck, shuffling it, and dealing hands to the player and dealer.
     */
    public void gameStart() {
        CardDeck cardDeck = new CardDeck();
        cardDeck.deckShuffler();
        setCardDeck(cardDeck);
        cardDeck.deckShuffler();

        Player player = new Player();
        setPlayer(player);
        player.setCurrentHand(cardDeck.drawHand());

        Dealer dealer = new Dealer();
        setDealer(dealer);
        dealer.setCurrentHand(cardDeck.drawHand());
    }

    /**
     * Sets the player for the game.
     *
     * @param player The player to set.
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * Gets the player of the game.
     *
     * @return The player of the game.
     */
    public Player getPlayer() {
        return this.player;
    }

    /**
     * Sets the dealer for the game.
     *
     * @param dealer The dealer to set.
     */
    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    /**
     * Gets the dealer of the game.
     *
     * @return The dealer of the game.
     */
    public Dealer getDealer() {
        return this.dealer;
    }

    /**
     * Gets the card deck of the game.
     *
     * @return The card deck of the game.
     */
    public CardDeck getCardDeck() {
        return this.cardDeck;
    }

    /**
     * Sets the card deck for the game.
     *
     * @param cardDeck The card deck to set.
     */
    public void setCardDeck(CardDeck cardDeck) {
        this.cardDeck = cardDeck;
    }

    /**
     * Resets the game by deducting the player's bet from their money and dealing new hands to the player and dealer.
     */
    public void reset() {
        this.player.setMoney(this.player.getMoney() - this.player.getBet());
        this.player.setCurrentHand(this.cardDeck.drawHand());
        this.dealer.setCurrentHand(this.cardDeck.drawHand());
    }

    /**
     * Prints the title of the game.
     *
     * @return The title of the game.
     */
    public String printTitle() {
        return "\n----------------------------------------------------\nWelcome to Big Al's BlackJack Table.";
    }

    /**
     * Prints the available commands for the game.
     *
     * @return The available commands for the game.
     */
    public static String printCommands() {
        return """
                    
                    Enter B to Set Bet. (Auto bet every round is $10)
                    Enter H to Hit. (Take another card)
                    Enter S to Stay. (Keep their current hand)

                    What would you like to do?:\s""";
    }

    /**
     * Prints the player's information, including their hand, score, and money.
     *
     * @return The player's information.
     */
    public String printPlayerInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("--Your Hand--\n");
        sb.append(this.player.getCurrentHand().printHand()).append("\n");
        sb.append("-------------------------\n");
        this.player.getScore().calculateScore(this.player.getCurrentHand());
        sb.append(String.format("Your Score: %d Your Money: $%d\n", this.player.getScore().getScore(), this.player.getMoney()));
        sb.append("--------------------------------\n");
        return sb.toString();
    }

    /**
     * Prints the dealer's information, including their hand and score.
     *
     * @return The dealer's information.
     */
    public String printShowDealerInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n--Dealer Hand--\n");
        sb.append(this.dealer.getCurrentHand().printHand()).append("\n");
        sb.append("-------------------------\n");
        this.dealer.getScore().calculateScore(this.dealer.getCurrentHand());
        sb.append(String.format("Dealer Score: %d\n", this.dealer.getScore().getScore()));
        sb.append("--------------------------------\n");
        return sb.toString();
    }

    /**
     * Prints the dealer's information, hiding one of the dealer's cards.
     *
     * @return The dealer's information with one card hidden.
     */
    public String printHideDealerInfo() {
        return "-----------------------------------------------------------------" +
                "\n--Dealer's Hand--" + "\n" + "|" +
                dealer.getCurrentHand().getHand().get(0) + "|" +
                "|??|";
    }
}
