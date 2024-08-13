package Java_2.Project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * The {@code Client} class represents the client that connects to the server and interacts with the game.
 */
public class Client {

	/**
	 * The main method to start the client.
	 *
	 * @param args command-line arguments (not used)
	 */
	public static void main(String[] args) {
		Client client = new Client();
		client.run(3000);
	}

	/**
	 * Runs the client and connects to the server on the specified port number.
	 *
	 * @param portNumber the port number to connect to the server
	 */
	public void run(int portNumber) {
		String hostName = "localhost";

		try (
				Socket echoSocket = new Socket(hostName, portNumber);
				PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
				BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))
		) {
			String userInput;
			boolean waitingForBet = false;
			int roundCounter = 0;
			while (true) {
				String response = in.readLine();
				JSONRequestData jsonResponse = JSONHandler.parseObject(response);

				assert jsonResponse != null;
				for (String line : jsonResponse.getData()) {
					System.out.println(line);
					if (line.equals("Set Bet: ")) {
						waitingForBet = true;
					}
				}

				if (waitingForBet) {
					userInput = stdIn.readLine();
					JSONRequestData jsonRequestData = new JSONRequestData();
					jsonRequestData.addLine(userInput);
					out.println(JSONHandler.createObject(jsonRequestData));
					waitingForBet = false;
					roundCounter++;
				} else {
					System.out.print(roundCounter < 1 ? Game.printCommands() : "");
					userInput = stdIn.readLine();
					JSONRequestData jsonRequestData = new JSONRequestData();
					jsonRequestData.addLine(userInput);
					out.println(JSONHandler.createObject(jsonRequestData));
					roundCounter++;
				}
			}
		} catch (UnknownHostException e) {
			System.err.println("Unknown host " + hostName);
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Run Server to access " + hostName);
			System.exit(1);
		}
	}
}
