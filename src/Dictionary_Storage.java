import java.io. *;
import java.util. *;


public class Dictionary_Storage{

    private File dictionaryLevel;
    private int size;
    private String word;
    private String definition;

    // constructor to initialize the dictionary storage with a specific word length file
    public Dictionary_Storage(int wordLength){
        this.dictionaryLevel = getDictionaryLevel(wordLength);
        this.size = getSize();
        this.word = null;
        this.definition = null;
    }

    public void setRandomWord(){
        try {
            Scanner scanner = new Scanner(dictionaryLevel);
            Random random = new Random();

            // generate a random number to select a word from the dictionary
            int randomSpace = random.nextInt(getSize()) + 1;

            int i = 0;
            while(scanner.hasNextLine() && i < randomSpace){
                String line = scanner.nextLine();

                if(line.isBlank()){
                        i++;
                }
            }
                
            // get the word and definition from the dictionary
            String wordLine = scanner.nextLine();
            this.word = wordLine.substring(6, wordLine.length());
            String definitionLine = scanner.nextLine();
            this.definition = definitionLine.substring(12, definitionLine.length());

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void removeWord(String word){    
        // NOTE: remove the word from the dictionary to avoid repetition

        // TODO: learn PrintWriter and finish this method to remove the word from the dictionary file

        // based on the word length point to the file that contains the words that on the same level
        String file = "resource/Current_Dictionary_Storage/level_" 
          + calculateLevel(word.length()) + ".txt";

        try {
            File dictionary = new File(file);
            Scanner scanner = new Scanner(dictionary);
            // find the index(space) of the word to remove from the dictionary
            // and -1 form the first line numOfWords in the file 
            scanner.close();

            PrintWriter writer = new PrintWriter(dictionary);
            // the space above the word put a "x" to mark the word to be removed
            writer.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public String getWord(){
        if(word == null){
            return "No word found";
        }

        return word;
    }

    public String getDefinition(){
        if(definition == null){
            return "No definition found";
        }

        return definition;
    }

    public int getSize(){
        if(size != 0){
            return size;
        }
        SetSize();
        return size;
    }

    public File getDictionaryLevel(int wordLength){
        if(this.dictionaryLevel != null){
            return this.dictionaryLevel;
        }
        SetDictionaryLevel(wordLength);
        return this.dictionaryLevel;
    }

    private void SetSize(){

        try {
            Scanner scanner = new Scanner(dictionaryLevel);
            String firstLine = scanner.nextLine();
            scanner.close();
            this.size = Integer.parseInt(firstLine.substring(11 , firstLine.length()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void SetDictionaryLevel(int wordLength){
        // based on the word length point to the file that contains the words that on the same level
        String file = "resource/Current_Dictionary_Storage/level_" 
        + calculateLevel(wordLength) + ".txt";

        try{
            this.dictionaryLevel = new File(file);
            Scanner scanner = new Scanner(dictionaryLevel);
            scanner.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private String calculateLevel(int wordLength){

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