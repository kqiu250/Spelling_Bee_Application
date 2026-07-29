import java.io. *;
import java.util. *;


public class Dictionary_Storage{

    public static Scanner scanner;
    public static String word;
    public static String definition;

    public static void setRandomWord(int level){
        try{
            String file = "resource/Current_Learning_Dictionary_Storage/level_" 
              + calculateLevel(level) + ".txt";

            File dictionary = new File(file);

            scanner = new Scanner(dictionary);
            Random random = new Random();
            int randomSpace = random.nextInt(getDictionaryWordLength()) + 1;

            int i = 0;
            while(scanner.hasNextLine() && i < randomSpace){
                String line = scanner.nextLine();

                if(line.isBlank()){
                    i++;
                }
            }

            String wordLine = scanner.nextLine();
            word = wordLine.substring(6, wordLine.length());
            String definitionLine = scanner.nextLine();
            definition = definitionLine.substring(10, definitionLine.length());

            scanner.close();
        }
        catch (FileNotFoundException e) {
        e.printStackTrace();
        }

    }
    public static String getWord(){
        return word;
    }

    public static String getDefinition(){
        return definition;
    }

    private static int getDictionaryWordLength(){
        String firstLine = scanner.nextLine();
        return Integer.parseInt(firstLine.substring(11 , firstLine.length()));
    }

    private static String calculateLevel(int level){

        // [3-4 Letter]
        if(level >= 3 && level <= 4) return "1";
        // [5 Letter]
        else if (level == 5) return "2";
        // [6 Letter]
        else if(level == 6) return "3";
        // [7 Letter]
        else if(level == 7) return "4";
        // [8 Letter]
        else if(level == 8) return "5";
        // [9 Letter]
        else if(level == 9) return "6";
        // [10 Letter]
        else if(level == 10) return "7";
        
        return "7";
    }



}
