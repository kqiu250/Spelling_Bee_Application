// home page of the spelling bee game
// This class displays the home page of the spelling bee game and handles user input for navigation.

import java.util.Scanner;

public class HOME_PAGE {
    public static void main(String[] args) {

        System.out.println("");
        horizontalText("Welcome to the Spelling Bee Game!", 27);

        // Main loop to display the home page and handle user input
        while (true) {
            System.out.println(
                            "       +====================================================================+\n" +
                            "       |                         S P E L L I N G  B E E                     |\n" +
                            "       +====================================================================+\n" +
                            "       |                                                                    |\n" +
                            "       |  HOME                                              SETTINGS        |\n" +
                            "       |                                                                    |\n" +
                            "       |                                                                    |\n" +
                            "       |                                                                    |\n" +
                            "       |                         [ START GAME ]                             |\n" +
                            "       |                                                                    |\n" +
                            "       |                                                                    |\n" +
                            "       |                                                                    |\n" +
                            "       |                                                                    |\n" +
                            "       |                                                                    |\n" +
                            "       |                                                                    |\n" +
                            "       |                                                                    |\n" +
                            "       |                                                                    |\n" +
                            "       |  VOCABULARY                                                        |\n" +
                            "       +--------------------------------------+-----------------------------+\n" +
                            "       |  Current Word Count                  |           TEST              |\n" +
                            "       |              0 Words                 |     Unlock at 10 Words      |\n" +
                            "       |                                      |                             |\n" +
                            "       +--------------------------------------+-----------------------------+\n" +
                            "       |                         [ EXIT GAME ]                              |\n" +
                            "       +====================================================================+");

            horizontalText("Please select an option:", 7);
            horizontalText("1. Start Game", 7);
            horizontalText("2. Test Mode", 7);
            horizontalText("3. Exit", 7);
            
            // scanner user choice input
            // Strictly enforce user input to be between 1 and 3
            Scanner scanner = new Scanner(System.in);
            int choice = 0;
            while (choice < 1 || choice > 3) {  
                System.out.print("       Enter your choice (1-3): ");
                System.out.flush(); // Ensure the prompt is displayed before reading input
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    horizontalText("Invalid input. Please enter a number between 1 and 3.", 7);
                }
            }

            // switch case to handle user choice
            clearConsole();
            switch (choice) {
                case 1:
                    waitIntro("Starting the game...");
                    spellingBeeGame();

                    break;
                case 2:
                    waitIntro("Entering test mode...");
                    break;
                case 3:
                    waitIntro("Exiting the game. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            clearConsole();
        }
    }

    
    // Method to clear the console screen
    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Method to pause the program for a specified number of milliseconds
    public static void pauseTime(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            System.out.println("Waiting interrupted");
        }
    }

    // Method to control horizontal spacing by padding
    public static void horizontalText(String text, int padding) {
        System.out.println(" ".repeat(padding) + text);
    }

    // Method to control vertical spacing by padding
    public static void verticalCenter(int padding) {
        System.out.println("\n".repeat(padding));
    }

    //
    public static void waitIntro(String text){
         verticalCenter(6);
         horizontalText(text, 32);
         pauseTime(1000);
    }

    public static boolean ifContinue(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to continue? (y/n): ");
        String input = scanner.nextLine().trim().toLowerCase();
        return input.equals("y");
    }
}
