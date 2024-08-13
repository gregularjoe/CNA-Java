package Java_2.Project;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * The {@code Server} class represents a server that listens for client connections
 * and handles them using a thread pool.
 */
public class Server {

    /**
     * The main method to start the server.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Server server = new Server();
        server.Start(3000);
    }

    /**
     * Starts the server on the specified port number.
     *
     * @param portNumber the port number to start the server on
     */
    public void Start(int portNumber) {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);

            while (true) {
                try {
                    Socket clientSocket = serverSocket.accept();
                    executorService.submit(new ServiceRequest(clientSocket));
                } catch (IOException ioe) {
                    System.out.println("Error accepting connection");
                    ioe.printStackTrace();
                }
            }
        } catch (IOException e) {
            System.out.println("Error starting Server on " + portNumber);
            e.printStackTrace();
        }
    }
}
