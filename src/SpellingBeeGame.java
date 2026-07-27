import java.util.*;

public class SpellingBeeGame {

    // Number of words to next level
    final public static int LEVEL_1 = 25;  // [3-4 Letter]
    final public static int LEVEL_2 = 50;  // [3-5 Letter]
    final public static int LEVEL_3 = 75;  // [3-6 Letter]
    final public static int LEVEL_4 = 100; // [3-7 Letter]
    final public static int LEVEL_5 = 150; // [3-8 Letter]
    final public static int LEVEL_6 = 200; // [3-9 Letter]
    final public static int LEVEL_7 = 250; // [3-10 Letter]

    public static void startGame(Scanner scanner) {

        // Calculate level that fit with player current skill
        // Random rand = new Random();
        // int currWordKnown = CurreantWordCount_Storage.getWordLength();
        // calculateDifficultyLevel(currWordKnown, rand);

        // randomly select a word from the dictionary by player level
        // word word new word(Dictionary_Storage.getRandomWord(level));

        // word.getSround();
        // System.out.println("Definition: " + word.getDefinition());
        
        word word = new word("counter"); // test word

        System.out.println("YOUR WORD IS: __________\n");
        System.out.println("Definition: " + word.getDefinition() + "\n\n\n");

        while (true) {
            System.out.print("Please enter your guess: ");
            String userGuess = ((String) scanner.next()).toLowerCase(); 
            if (word.isCorrectWord(userGuess)) {
                System.out.println("Correct! Well done.");
                break; // exit loop
            }
            System.out.println("Incorrect, try again.");
        }

        // add to current word to known work
        // CurreantWordCount_Storage.addWord(word);

        // remove the word from the dictionary to avoid repetition
        // Dictionary_Storage.removeWord(word);

    }

    public static int calculateDifficultyLevel(int length, Random random){
        int level;

        if (length <= LEVEL_1) level = random.nextInt(2) + 3;
        else if (length <= LEVEL_2) level = random.nextInt(3) + 3;
        else if (length <= LEVEL_3) level = random.nextInt(4) + 3;
        else if (length <= LEVEL_4) level = random.nextInt(5) + 3; 
        else if (length <= LEVEL_5) level = random.nextInt(6) + 3; 
        else if (length <= LEVEL_6) level = random.nextInt(7) + 3; 
        else if (length <= LEVEL_7) level = random.nextInt(8) + 3; 
        else level = random.nextInt(8) + 3; 

        return level;

    }
}