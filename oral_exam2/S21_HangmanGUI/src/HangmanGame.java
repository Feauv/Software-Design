import java.util.ArrayList;
import java.util.List;

/**
 * The class that contains the behavior of the Hangman game
 */
public class HangmanGame {

    /**
     * The word that the user has to guess
     */
    private String wordToGuess;
    /**
     * The changing output that is shown as the user guesses letters
     */
    private char[] outputWord;
    /**
     * How many wrong guesses until death
     */
    private int untilDeath;
    /**
     * List of incorrect Characters that have been guessed
     */
    private List<Character> incorrect = new ArrayList<>();

    /**
     * The HangmanGame constructor takes in just the word that will be guessed and everything else is initialized by the
     * class
     * @param wordToGuess User inputted word that is trying to be guessed
     */
    HangmanGame(String wordToGuess) {

        this.wordToGuess = wordToGuess;

        outputWord = new char[wordToGuess.length()*2];

        for(int i = 0; i < wordToGuess.length()*2; i+=2) {
            outputWord[i] = '_';
            outputWord[i+1] = ' ';
        }

        untilDeath = 6;

    }


    /**
     * @return Output line
     */
    public char[] getOutputWord() {
        return outputWord;
    }

    /**
     * @return Guesses until game over
     */
    public int getUntilDeath() {
        return untilDeath;
    }

    /**
     * @return Incorrect's list
     */
    public List<Character> getIncorrect() {
        return incorrect;
    }

    /**
     * The method called when the user guesses a letter. A check is made to see if the letter is in the word, based on
     * this all other instance variables are updated accordingly.
     * @param guess The guessed letter
     * @return A boolean telling whether the letter is in the word or not
     */
    public boolean guess(char guess) {

        boolean guessIsCorrect = false;

        for(int i = 0; i < wordToGuess.length(); i++) {

            if(guess == wordToGuess.charAt(i)) {
                outputWord[i*2] = guess;
                guessIsCorrect = true;
            }

        }

        if(!guessIsCorrect) {

            incorrect.add(guess);
            untilDeath--;

        }

        return guessIsCorrect;

    }

}
