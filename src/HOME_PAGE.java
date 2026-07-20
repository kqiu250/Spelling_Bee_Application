import java.util.Scanner;

public class HOME_PAGE {
    public static void main(String[] args) {
        System.out.println("");
        centerText("Welcome to the Spelling Bee Game!", 27);
        while(true){
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
                    "       |  VOCABULARY                                                        |\n" +
                    "       +--------------------------------------+-----------------------------+\n" +
                    "       |  Current Word Count                  |           TEST              |\n" +
                    "       |                                      |                             |\n" +
                    "       |              0 Words                 |     Unlock at 10 Words      |\n" +
                    "       +--------------------------------------+-----------------------------+\n" +     
                    "       |                         [ EXIT GAME ]                              |\n" +
                    "       +====================================================================+"
            );

            centerText("Please select an option:", 7);
            centerText("1. Start Game", 7);
            centerText("2. Test Mode", 7);
            centerText("3. Exit", 7);

            // Strictly enforce user input to be between 1 and 3
            Scanner scanner = new Scanner(System.in);
            int choice = 0;
            while (choice < 1 || choice > 3) {
                System.out.print("       Enter your choice (1-3): ");
                System.out.flush(); // Ensure the prompt is displayed before reading input
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    centerText("Invalid input. Please enter a number between 1 and 3.", 7);
                }
            }
            
            clearConsole();
            switch (choice) {
                case 1:
                    verticalCenter(6);
                    centerText("Starting the game...", 32);
                    pauseTime(1000);
                    break;
                case 2:
                    verticalCenter(6);
                    centerText("Entering Test Mode...", 32);
                    pauseTime(1000);
                    break;
                case 3:
                    verticalCenter(6);
                    centerText("Exiting the application. Goodbye!", 32);
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            clearConsole();
        }
    }

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void pauseTime(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            System.out.println("Waiting interrupted");
        }
    }

    public static void centerText(String text, int padding) {
        System.out.println(" ".repeat(padding) + text);
    }

    public static void verticalCenter(int padding) {
        System.out.println("\n".repeat(padding));
    }
}
