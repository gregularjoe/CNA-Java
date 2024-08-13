package Java_2.Project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * The {@code ServiceRequest} class handles client requests in a separate thread.
 * It implements the {@code Runnable} interface to allow concurrent processing.
 */
class ServiceRequest implements Runnable {

    /**
     * The client socket.
     */
    private final Socket socket;

    /**
     * Constructs a new {@code ServiceRequest} with the specified client socket.
     *
     * @param connection the client socket
     */
    public ServiceRequest(Socket connection) {
        this.socket = connection;
    }

    /**
     * The main logic for handling client requests.
     * It reads input from the client, processes the request, and sends a response.
     */
    public void run() {
        try (PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()))) {
            Game game = new Game();
            game.gameStart();

            JSONRequestData jsonResponse = new JSONRequestData();
            jsonResponse.addLine(game.printTitle());
            jsonResponse.addLine(game.printHideDealerInfo());
            jsonResponse.addLine(game.printPlayerInfo());
            out.println(JSONHandler.createObject(jsonResponse));

            String inputLine;
            boolean waitingForBet = false;

            while ((inputLine = in.readLine()) != null) {
                JSONRequestData jsonRequest = JSONHandler.parseObject(inputLine);
                assert jsonRequest != null;
                if (game.getCardDeck().getSize() > 4) {
                    game.setCardDeck(new CardDeck());
                    game.getCardDeck().deckShuffler();
                }

                if (waitingForBet) {
                    handleBetInput(game, jsonRequest, jsonResponse);
                    waitingForBet = false;
                    jsonResponse.addLine(game.printHideDealerInfo());
                    jsonResponse.addLine(game.printPlayerInfo());
                    jsonResponse.addLine(Game.printCommands());
                } else {
                    waitingForBet = handleRequest(game, jsonRequest, jsonResponse);
                    if (!waitingForBet) {
                        jsonResponse.addLine(game.printHideDealerInfo());
                        jsonResponse.addLine(game.printPlayerInfo());
                        jsonResponse.addLine(Game.printCommands());
                    }
                }

                out.println(JSONHandler.createObject(jsonResponse));
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to write to client");
            System.out.println(e.getMessage());
        }
    }

    /**
     * Handles the client's request based on the input command.
     *
     * @param game the game instance
     * @param request the client's request data
     * @param jsonResponse the response data to be sent to the client
     * @return {@code true} if waiting for additional input, {@code false} otherwise
     */
    private boolean handleRequest(Game game, JSONRequestData request, JSONRequestData jsonResponse) {
        switch (request.getData().get(0).toUpperCase()) {
            case "B" -> {
                jsonResponse.addLine("Set Bet: ");
                return true;
            }
            case "H" -> {
                game.getPlayer().getCurrentHand().addCard(game.getCardDeck().drawCard());
                game.getPlayer().getScore().calculateScore(game.getPlayer().getCurrentHand());
                if (game.getPlayer().getScore().getScore() > 21) {
                    jsonResponse.addLine("\n*** HIT ***\n");
                    jsonResponse.addLine(game.printShowDealerInfo());
                    jsonResponse.addLine(game.printPlayerInfo());
                    jsonResponse.addLine("\n*** BUST ***\n");
                    jsonResponse.addLine("\n*** Dealer Wins Round! ***\n");

                    game.reset();
                } else {
                    jsonResponse.addLine("\n*** HIT ***\n");
                }
            }
            case "S" -> {
                jsonResponse.addLine("***STAY***");
                jsonResponse.addLine(game.printShowDealerInfo());
                jsonResponse.addLine(game.printPlayerInfo());
                boolean dealersTurn = true;
                while (dealersTurn) {
                    game.getDealer().getScore().calculateScore(game.getDealer().getCurrentHand());

                    if (game.getDealer().getScore().getScore() > 21) {
                        jsonResponse.addLine("DEALER BUSTS");
                        jsonResponse.addLine("***YOU WINN***");

                        jsonResponse.addLine("----------New Round----------");

                        game.getPlayer().setCurrentHand(game.getCardDeck().drawHand());
                        game.getDealer().setCurrentHand(game.getCardDeck().drawHand());
                        game.getPlayer().setMoney(game.getPlayer().getMoney() + game.getPlayer().getBet());

                        dealersTurn = false;
                    } else if (game.getDealer().getScore().getScore() > game.getPlayer().getScore().getScore()) {
                        jsonResponse.addLine("*** DEALER WINS ***");
                        jsonResponse.addLine("----------New Round----------");

                        game.getPlayer().setCurrentHand(game.getCardDeck().drawHand());
                        game.getDealer().setCurrentHand(game.getCardDeck().drawHand());
                        game.getPlayer().setMoney(game.getPlayer().getMoney() - game.getPlayer().getBet());

                        dealersTurn = false;
                    } else {
                        game.getDealer().getCurrentHand().addCard(game.getCardDeck().drawCard());
                        jsonResponse.addLine("--- Dealer Draws Card ----");
                        jsonResponse.addLine(game.printShowDealerInfo());
                        jsonResponse.addLine(game.printPlayerInfo());
                    }
                }
            }
            default -> jsonResponse.addLine("Invalid Option");
        }
        if (game.getPlayer().getMoney() < 1) {
            jsonResponse.addLine(game.getPlayer().mysteriousStranger());
        }
        return false; // Indicate that we are not waiting for any additional input
    }

    /**
     * Handles the client's bet input.
     *
     * @param game the game instance
     * @param request the client's request data
     * @param jsonResponse the response data to be sent to the client
     */
    private void handleBetInput(Game game, JSONRequestData request, JSONRequestData jsonResponse) {
        try {
            int bet = Integer.parseInt(request.getData().get(0));
            if (bet <= game.getPlayer().getMoney()) {
                game.getPlayer().setBet(bet);
                jsonResponse.addLine("Bet set to: " + bet);
            } else {
                jsonResponse.addLine("Insufficient Funds...");
            }
        } catch (NumberFormatException e) {
            jsonResponse.addLine("Invalid input. Please enter a valid integer.");
        }
    }
}
