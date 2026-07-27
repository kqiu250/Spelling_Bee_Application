public class format {

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
    public static void waitIntro(String text, int x, int y, int time){
        clearConsole();
        verticalCenter(y);
        horizontalText(text, x);
        pauseTime(time);
    }
    
}