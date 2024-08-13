package Java_2.Assignment4;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//6.15 (Copying and Reversing LinkedLists) Write a program that
//        creates a LinkedList object of 10 characters, then creates a second
//        LinkedList object containing a copy of the first list, but in reverse
//        order.


public class ReverseLinkedList {
    public static void main(String[] args) {

        String[] names = {"Rita", "Angela", "Robert", "Jimmy", "Violet", "David", "Juliet", "Romeo", "Diana", "Charles"};

        List<String> namesList = new LinkedList<>(Arrays.asList(names));
        System.out.println("List of Names: ");
        System.out.println(namesList);
        System.out.println("--------------------------------------------------");

        LinkedList<Object> reversedNamesList = new LinkedList<>();
        for (int i = 9; i >= 0 ; i--) {
            reversedNamesList.add(namesList.get(i));
        }
        System.out.println("Reversed List of Names:");
        System.out.println(reversedNamesList);

    }
}
