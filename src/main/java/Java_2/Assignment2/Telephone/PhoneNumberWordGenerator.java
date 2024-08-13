package Java_2.Assignment2.Telephone;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class PhoneNumberWordGenerator {
    private static final HashMap<Character, String> phoneNumberLetters = new HashMap<>();

    static {

        phoneNumberLetters.put('2',"abc");
        phoneNumberLetters.put('3',"def");
        phoneNumberLetters.put('4',"ghi");
        phoneNumberLetters.put('5',"jkl");
        phoneNumberLetters.put('6',"mno");
        phoneNumberLetters.put('7',"prs");
        phoneNumberLetters.put('8',"tuv");
        phoneNumberLetters.put('9',"wxy");
}


    String letterHolder = "";
    List<String> possibleWordList = new ArrayList<>();
    public void generatePossibleWords(String phoneNumber) {
        if (this.letterHolder.length() == phoneNumber.length()) {
            possibleWordList.add(letterHolder);
            return;
        }

        String letters = phoneNumberLetters.get(phoneNumber.charAt(letterHolder.length()));

        for (char letter : letters.toCharArray()) {
            letterHolder += letter;
            generatePossibleWords(phoneNumber);
            letterHolder = letterHolder.substring(0, letterHolder.length() - 1);

        }
    }
    public List<String> getPossibleWords() {
        return possibleWordList;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a phone number with no space, omit numbers with 0 and/or 1: eg'*******'");
        String userNumber = scanner.nextLine();

        PrintWriter printWriter = new PrintWriter("src/main/java/Assignment2/Telephone/output.txt");
        PhoneNumberWordGenerator phoneNumberWordGenerator = new PhoneNumberWordGenerator();
        phoneNumberWordGenerator.generatePossibleWords(userNumber);

        List<String> possibleWordList = phoneNumberWordGenerator.getPossibleWords();
        for (String possibleWord : possibleWordList) {
            printWriter.println(possibleWord);
            System.out.println(possibleWord);
        }
        printWriter.close();
    }
}
