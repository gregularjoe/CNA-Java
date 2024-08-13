package Java_2.Assignment5.MessingAbout;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        // Step 1: Create an instance of MessingRunnable
        MessingRunnable messingRunnable = new MessingRunnable("Fruit");

        // Step 2: Create an ExecutorService
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // Step 3: Submit the MessingRunnable instance to the ExecutorService
        executorService.execute(messingRunnable);

        // Step 4: Shutdown the ExecutorService
        executorService.shutdown();
    }
}
