package Java_2.Assignment2.Phishing;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PhishingDetector {

    public static void main(String[] args) {

        /*
         * Hashmap where for each key the value is an int array, the first represents the
         * assigned score, and the second represents the count of how many times the word appears.
         */
    HashMap<String, Integer[]> susWords = new HashMap<>();
        susWords.put("urgent", new Integer[] {2, 0});
        susWords.put("lottery",new Integer[]{2, 0});
        susWords.put("prize", new Integer[]{3, 0});
        susWords.put("prince", new Integer[]{4, 0});
        susWords.put("win", new Integer[]{3, 0});
        susWords.put("winner", new Integer[]{4, 0});
        susWords.put("free", new Integer[]{1, 0});
        susWords.put("bank", new Integer[]{4, 0});
        susWords.put("account", new Integer[]{4, 0});
        susWords.put("direct", new Integer[] {1, 0});
        susWords.put("deposit", new Integer[]{4, 0});
        susWords.put("congratulations", new Integer[]{2, 0});
        susWords.put("password", new Integer[]{4, 0});
        susWords.put("claim", new Integer[]{3, 0});
        susWords.put("limited", new Integer[]{1, 0});
        susWords.put("exclusive", new Integer[]{3, 0});
        susWords.put("refund", new Integer[]{3, 0});
        susWords.put("bonus", new Integer[]{2, 0});
        susWords.put("access", new Integer[]{3, 0});
        susWords.put("click", new Integer[]{4, 0});
        susWords.put("activate", new Integer[]{4, 0});
        susWords.put("dear", new Integer[]{4, 0});
        susWords.put("deal", new Integer[]{2, 0});
        susWords.put("payment", new Integer[]{2, 0});
        susWords.put("cash", new Integer[]{4, 0});
        susWords.put("money", new Integer[]{4, 0});
        susWords.put("identity", new Integer[]{3, 0});
        susWords.put("confirm", new Integer[]{1, 0});
        susWords.put("information", new Integer[]{1, 0});
        susWords.put("code", new Integer[]{1, 0});

        String fileName = "src/main/java/Assignment2/Phishing/PhishingEmailExample2.txt";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("\\W+");
                for (String word : words) {
                    word = word.toLowerCase();
                    if (susWords.containsKey(word)) {
                        Integer[] susWordValues = susWords.get(word);
                        susWordValues[0] += susWordValues[0];
                        susWordValues[1] += 1;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }

        int susTallyTotal = 0;
        for (Map.Entry<String, Integer[]> entry : susWords.entrySet()) {
            String susWord = entry.getKey();
            int susCount = entry.getValue()[1];
            int susScore = entry.getValue()[0];
            if (susCount == 0) {
                System.out.println("Suspicious word: " + susWord + " | Sus Count: " + susCount + " | Sus Score: " + "0");
            }else {
                susTallyTotal += susScore;
                System.out.println("Suspicious word: " + susWord + " | Sus Count: " + susCount + " | Sus Score: " + susScore);
            }
        }
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Total Tallied Score of Suspicious Words: " + susTallyTotal);
    }

}
