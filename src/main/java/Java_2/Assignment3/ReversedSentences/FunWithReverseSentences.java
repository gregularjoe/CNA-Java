package Java_2.Assignment3.ReversedSentences;

import java.util.Scanner;
import java.util.StringTokenizer;

public class FunWithReverseSentences {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StringBuilder reversedSentence = new StringBuilder();

        System.out.println("Enter a sentence and I will reverse it for you!");
        String userSentence = scanner.nextLine();

        String[] tokens = userSentence.split(" ");

        for (int i = tokens.length - 1; i > -1; i--) {
            reversedSentence.append(tokens[i]);
            reversedSentence.append(" ");
        }
        System.out.println(reversedSentence);
    }
}