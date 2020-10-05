import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Display welcome message
        System.out.println("Hello, welcome to text-based Hangman!");

        // Create Scanner object for the users input on the command line
        Scanner userInput = new Scanner(System.in);

        // Create an ArrayList and populate it with a list of words
        ArrayList<String> wordBank = new ArrayList<>();
        wordBank.add("apple");
        wordBank.add("orange");
        wordBank.add("mango");
        wordBank.add("watermelon");
        wordBank.add("pineapple");
        wordBank.add("cantaloupe");
    }
}
