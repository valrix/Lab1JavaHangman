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

        // Create a Random object to choose a random word from the list
        Random randomWordIndex = new Random();

        // Assign the random word by choosing a random index from the word bank list
        String randomWord = wordBank.get(randomWordIndex.nextInt(wordBank.size()));

        // Create an ArrayList that will hold each letter of the random word as it's own index
        ArrayList<String> randomWordSplitArrayList = new ArrayList<>();

        // Add each letter of the random word to the ArrayList by using the Collections class
        Collections.addAll(randomWordSplitArrayList, randomWord.split(""));

        // Create a separate ArrayList that will hold the blank representations of each letter in the word
        ArrayList<String> hiddenWordArrayList = new ArrayList<>();

        // Populate the hiddenWordArrayList with the same amount of blanks as the length of the random word
        for (int i = 0; i < randomWord.length(); i++) {
            hiddenWordArrayList.add("_ ");
        }

        // Loop through the list and display the blanks to the user as the start of the game
        for (String blank : hiddenWordArrayList) {
            System.out.print(blank + " ");
        }
    }
}
