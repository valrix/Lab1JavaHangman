import WordBankClasses.AnimalsWordBank;
import WordBankClasses.FruitsWordBank;
import WordBankClasses.ProgrammingLanguagesWordBank;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Display welcome message
        System.out.println("Hello, welcome to text-based Hangman!");

        // Display topics message and allows the user to select from the topics listed
        System.out.println("What topic of words would you like to play with?\n" +
                           "(1): Fruits\n" +
                           "(2): Animals\n" +
                           "(3): Programming Languages");


        // Create Scanner object for the users input on the command line
        Scanner userInput = new Scanner(System.in);

        // Declare an ArrayList for the word bank
        ArrayList<String> wordBank = null;

        // Selects the topic based on what the user entered
        switch (userInput.next()) {
            // If the user enters 1
            case "1" -> {
                // Add the ArrayList from the FruitsWordBank class to the word bank ArrayList
                wordBank = new FruitsWordBank().fruitsWordBankArrayList();
                System.out.println("You have chosen the Fruit Word Bank.\nBegin Guessing!");
            }
            case "2" -> {
                // Add the ArrayList from the AnimalsWordBank class to the word bank ArrayList
                wordBank = new AnimalsWordBank().animalsWordBankArrayList();
                System.out.println("You have chosen the Animal Word Bank.\nBegin Guessing!");
            }
            case "3" -> {
                // Add the ArrayList from the ProgrammingLanguagesWordBank class to the word bank ArrayList
                wordBank = new ProgrammingLanguagesWordBank().programmingLanguagesWordBankArrayList();
                System.out.println("You have chosen the Programming Languages Word Bank.\nBegin Guessing!");
            }
            default -> {
                // If an invalid selection was entered then display error message and quit
                System.err.println("You did not choose a valid Word Bank.");
                System.exit(-1);
            }
        }

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

        // Display a new line for the user to write their input on
        System.out.println();

        // Create integer variable that holds the number of wrong guesses
        int numberOfWrongGuesses = 0;

        // Gameplay loop that only ends if you win or lose
        do {
            // Assign the users input to the variable guess
            String guess = userInput.next();
            // If the users guess exists in the randomWordSplitArrayList
            if (randomWordSplitArrayList.contains(guess)) {
                // Loop through the randomWordSplitArrayList and assign each index to i
                for (int i = 0; i < randomWordSplitArrayList.size(); i++) {
                    // If the guess exists in the randomWordSplitArray
                    if (guess.equals(randomWordSplitArrayList.get(i))) {
                        // Set the guess letter to the matching index of the hiddenWordArrayList
                        hiddenWordArrayList.set(i, guess);
                    }
                }
                // Display the hiddenWordSplitArray after each guess to show the user their progress
                for (String blank : hiddenWordArrayList) {
                    System.out.print(blank + " ");
                }
                // Display blank line for the user to write on
                System.out.println();
            } else {
                // Increase the number of wrong guesses
                numberOfWrongGuesses++;
                // Display wrong guess message
                System.out.println("Incorrect Guess, you have: " + numberOfWrongGuesses + "/6 wrong guesse(s).");
            }

            // Displays the lose message if the number of wrong guesses equals or is greater than 6
            if (numberOfWrongGuesses >= 6) {
                System.out.println("Oh no! You lose! The word was \"" + randomWord + "\".");
                userInput.close();
                break;
                // Displays the win message if the hiddenWordArrayList matches the randomWordArrayList
            } else if (hiddenWordArrayList.equals(randomWordSplitArrayList)) {
                System.out.println("Yay! You win!");
                userInput.close();
                break;
            }
        } while(numberOfWrongGuesses < 6 || hiddenWordArrayList.equals(randomWordSplitArrayList));
    }
}
