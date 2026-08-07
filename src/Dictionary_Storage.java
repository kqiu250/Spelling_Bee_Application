import java.io. *;
import java.util. *;


public class Dictionary_Storage{

    public static Scanner scanner;
    public static String word;
    public static String definition;

    public static void setRandomWord(int wordLength){
        // based on the word length point to the file that contains the words that on the same level
        String file = "resource/Current_Learning_Dictionary_Storage/level_" 
        + calculateLevel(wordLength) + ".txt";

        try{
            File dictionary = new File(file);

            scanner = new Scanner(dictionary);
            Random random = new Random();

            // get the total number of words in the dictionary on first line and
            // generate a random number to select a word from the dictionary
            int randomSpace = random.nextInt(getDictionaryWordLength()) + 1;

            // skip the first line and reach the space above the word that is randomly selected
            int i = 0;
            while(scanner.hasNextLine() && i < randomSpace){
                String line = scanner.nextLine();

                if(line.isBlank()){
                    i++;
                }
            }
            
            // get the word and definition from the dictionary
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

    private static void removeWord(String word){    
        // NOTE: remove the word from the dictionary to avoid repetition

        // TODO: learn PrintWriter and finish this method to remove the word from the dictionary file

        // based on the word length point to the file that contains the words that on the same level
        String file = "resource/Current_Learning_Dictionary_Storage/level_" 
          + calculateLevel(word.length()) + ".txt";

        try {
            File dictionary = new File(file);
            // find the index(space) of the word to remove from the dictionary
            scanner.close();

            PrintWriter writer = new PrintWriter(dictionary);
            // the space above the word put a "x" to mark the word to be removed
            writer.close();
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

    private static String calculateLevel(int wordLength){

        // [3-4 Letter]
        if(wordLength >= 3 && wordLength <= 4) return "1";
        // [5 Letter]
        else if (wordLength == 5) return "2";
        // [6 Letter]
        else if(wordLength == 6) return "3";
        // [7 Letter]
        else if(wordLength == 7) return "4";
        // [8 Letter]
        else if(wordLength == 8) return "5";
        // [9 Letter]
        else if(wordLength == 9) return "6";
        // [10 Letter]
        else if(wordLength  == 10) return "7";
        
        return "7";
    }



}
