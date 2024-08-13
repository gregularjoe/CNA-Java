package Java_2.Assignment3.Redaction;

import java.io.*;

public class DSPOSE {
    public static void main(String[] args) throws FileNotFoundException {

        String fileName = "sampleInfo.txt.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split(" ");
                for (String word : words) {
//
                    if (word.matches("[0-9]{2}-[0-9][2]-[0-9]{4}.?")) {
                        word = "##-##-####";
                        System.out.println(word);
                    }
                    if (word.matches("[0-9]{2}-[0-9]{2}-[0-9]{2}.?")) {
                        word = "##-##-##.";
                        System.out.println(word);
                    }
                    if (word.matches("CODE[0-9]+.?")){
                        int codeCount = word.length() - 5;
                        word = "CODE";
                        for (int i = 0; i < codeCount; i++) {
                            word += "#";
                        }
                        word += ".";
                        System.out.println(word);
                    }
                    if (word.matches("[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{4}.?")) {
                        word = "####-####-####-####";
                        System.out.println(word);
                    }
                    if(word.matches("\\$[0-9]+(.[0-9]{2})?")) {
                        String[] splitWord = word.split("[.]");

                        // - 1 for the $
                        int leftSideCount = splitWord[0].length() - 1;
                        word = "$";
                        for (int i = 0; i < leftSideCount; i++) {
                            word += "#";
                        }
                        word += ".##";
                        System.out.println(word);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
    }
}
