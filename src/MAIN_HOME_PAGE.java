// home page of the spelling bee game
// This class displays the home page of the spelling bee game and handles user input for navigation.

import java.util.Scanner;


public class MAIN_HOME_PAGE {
    public static void main(String[] args) {

        System.out.println("");
        format.horizontalText("Welcome to the Spelling Bee Game!", 27);

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

            format.horizontalText("Please select an option:", 7);
            format.horizontalText("1. Start Game", 7);
            format.horizontalText("2. Test Mode", 7);
            format.horizontalText("3. Exit", 7);
            
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
                    format.horizontalText("Invalid input. Please enter a number between 1 and 3.", 7);
                }
            }

            // switch case to handle user choice
            format.clearConsole();
            switch (choice) {
                case 1:
                    format.waitIntro("Starting the game...", 32, 6, 825);
                    format.clearConsole();
                    do{
                        SpellingBeeGame.startGame(scanner);
                        format.clearConsole();
                    }while(ifContinue(scanner));
                
                    format.waitIntro("Exiting the game. Goodbye!", 32, 6, 825);
                    break;
                case 2:
                    format.waitIntro("Entering test mode...", 32, 6, 825);
                    break;
                case 3:
                    format.waitIntro("Exiting the game. Goodbye!", 32, 6, 825);
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            format.clearConsole();
        }
    }

    public static boolean ifContinue(Scanner scanner){
        System.out.print("Do you want to continue? (y/n): ");
        String input = " ";
        while(input != "y" || input != "n"){
            input = scanner.nextLine().trim().toLowerCase();
            if(input.equals("y")){
                return true;
            }
            if(input.equals("n")){
                return false;
            }
        }
        return false;
    }
}
