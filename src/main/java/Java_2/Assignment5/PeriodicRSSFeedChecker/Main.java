package Java_2.Assignment5.PeriodicRSSFeedChecker;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * The Main class is the entry point of the RSS Feed Checker application.
 * It prompts the user to input URLs for RSS feeds, schedules periodic checks
 * for these feeds, and prints the latest posts to the console.
 */
public class Main {
    /**
     * The main method of the application. It prompts the user for RSS feed URLs,
     * schedules periodic checks for these feeds using a ScheduledExecutorService,
     * and handles thread interruptions gracefully.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter RSS feed URLs (type 'done' to finish):");

        // gets feedURL from user via scanner, adds it do the feedsURLs ArrayList
        List<String> feedURLs = new ArrayList<>();
        do {
            String userInput = input.nextLine();
            if (userInput.equalsIgnoreCase("done")) {
                break;
            }
            feedURLs.add(userInput);
        } while (true);

        /*
         * Loop through the list of feed URLs, create an RSSFeedChecker for each URL,
         * and schedule the checker to run at a fixed delay of 16000 milliseconds.
         * The start of each checker is staggered by a delay of 4000 milliseconds.
         */
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
        for (String url : feedURLs) {
            RSSFeedChecker checker = new RSSFeedChecker(url);
            executorService.scheduleWithFixedDelay(checker, 0, 10000, TimeUnit.MILLISECONDS);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("Thread error");
            }
        }
    }
}
