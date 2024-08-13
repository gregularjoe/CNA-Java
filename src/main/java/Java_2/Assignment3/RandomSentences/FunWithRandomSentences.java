package Java_2.Assignment3.RandomSentences;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FunWithRandomSentences {
    public static void main(String[] args) throws FileNotFoundException {

        SentenceFactory sentenceFactory = new SentenceFactory();
        PrintWriter printWriter = new PrintWriter("Twenty-Sentences.txt");

        for (int i = 0; i < 20; i++) {
            printWriter.println(sentenceFactory.generateSentence());
        }
        printWriter.close();
    }
}
