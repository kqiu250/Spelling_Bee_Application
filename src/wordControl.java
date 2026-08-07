public class wordControl{
    String word;
    String definition;
    int hint;

    public wordControl(String word, String definition){
        this.word = word;
        this.definition = definition; 
        this.hint = 0;

    }

    public String getWord(){
        return this.word;
    } 

    // get definition
    public String getDefinition() {
        return this.definition;
    }

    // get sround

    public char getLettterHint(){
        if(this.hint < 0 || this.hint >= word.length()){ return '!';}
        hint++;
        return word.charAt(hint - 1);
    }

    public boolean isCorrectWord( String userGuess){
        // edge case: if the user input is empty or null, return false
        if (userGuess == null || userGuess.isEmpty()) {
            return false;
        }
        
        userGuess = userGuess.trim();

        // test user input (character input) and check if the input is correct
        if (userGuess.equals(word)) {
            return true;
        }

        return false;
    } 
}