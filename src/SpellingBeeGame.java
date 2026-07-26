import java.util.*;

public class SpellingBeeGame {

    final public static int LEVEL_1 = 25; // Number of words in level 1 (3-4 letters)
    final public static int LEVEL_2 = 50; // Number of words in level 2 (3-5 letters)
    final public static int LEVEL_3 = 75; // Number of words in level 3 (3-6 letters)
    final public static int LEVEL_4 = 100; // Number of words in level 4 (3-7 letters)
    final public static int LEVEL_5 = 150; // Number of words in level 5 (3-8 letters)
    final public static int LEVEL_6 = 200; // Number of words in level 6 (3-9 letters)
    final public static int LEVEL_7 = 250; // Number of words in level 7 (3-10 letters)

    public static void startGame(Scanner scanner) {

        // Calculate the length - level of difficulty based on the current word count
        // if (CurreantWordCount_Storage.length() <= LEVEL_1) length = random.nextInt(2)
        // + 3; // Random length between 3 and 4
        // else if (CurreantWordCount_Storage.length() <= LEVEL_2) length =
        // random.nextInt(3) + 3; // Random length between 3 and 5
        // else if (CurreantWordCount_Storage.length() <= LEVEL_3) length =
        // random.nextInt(4) + 3; // Random length between 3 and 6
        // else if (CurreantWordCount_Storage.length() <= LEVEL_4) length =
        // random.nextInt(5) + 3; // Random length between 3 and 7
        // else if (CurreantWordCount_Storage.length() <= LEVEL_5) length =
        // random.nextInt(6) + 3; // Random length between 3 and 8
        // else if (CurreantWordCount_Storage.length() <= LEVEL_6) length =
        // random.nextInt(7) + 3; // Random length between 3 and 9
        // else if (CurreantWordCount_Storage.length() <= LEVEL_7) length =
        // random.nextInt(8) + 3; // Random length between 3 and 10

        // randomly select a word from the dictionary by letter length
        // String word = Dictionary_Storage.getRandomWord(length);

        // sound method missing, need to implement sound method to pronounce the word
        // sound(word);

        // definition(word);

        // display the word to the user
        System.out.println("YOUR WORD IS: __________\n");
        String word = "counter"; // test word
        definition(word);
        System.out.println("\n\n\n");

        while (true) {
            System.out.print("Please enter your guess: ");
            String userGuess = ((String) scanner.next()).toLowerCase(); // Convert user input to String and lowercase
                                                                        // for comparison
            Boolean isCorrect = CheckUserInput(userGuess, word.toLowerCase()); // Convert word to lowercase for
                                                                               // comparison

            if (isCorrect) {
                System.out.println("Correct! Well done.");
                break; // Exit the loop if the guess is correct
            } else {
                System.out.println("Incorrect, try again.");
            }
        }

        // add to current word count
        // CurreantWordCount_Storage.addWord(word);

        // remove the word from the dictionary to avoid repetition
        // Dictionary_Storage.removeWord(word);

    }

    // definition
    public static void definition(String word) {
        // search in resource Dictionary_Storage input(Stirng word) and return the
        // definition
        // String definition = Dictionary_Storage.getDefinition(word);

        String definition = "a flat surface for transactions, a device or person that tallies numbers, or an opposing action."; // test
                                                                                                                                // definition
        System.out.println("Definition: " + definition);

    }

    // check user input
    public static Boolean CheckUserInput(String userGuess, String word) {
        // edge case: if the user input is empty or null, return false
        if (userGuess == null || userGuess.isEmpty()) {
            return false;
        }

        // edge case: if user uses sapces at the beginning or end of the input, trim the
        // spaces
        // best case time complexity: O(1) if there no spaces at the beginning or end
        // worst case time complexity: O(n) if there are spaces at the beginning or end
        // of the input
        userGuess = userGuess.trim();

        // test user input (character input) and check if the input is correct
        if (userGuess.equals(word)) {
            return true;
        }

        return false;
    }
}
