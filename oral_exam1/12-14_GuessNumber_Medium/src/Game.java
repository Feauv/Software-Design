import java.util.Random;
import java.lang.Math;

/**
 * Game is a class that is utilized by {@link GameFrame} for all of the game logic of the number guessing game. Game
 * actively keeps track of how close the user is to guessing the number, if the user is getting closer to the number,
 * text that needs to be displayed to the user, and of if the user wins.
 *
 * @author Nick Grove
 */
public class Game {

    /**
     * The random number that the user is trying to guess.
     */
    private int randNum;
    /**
     * How far the user's last guess is from {@link Game#randNum}.
     */
    private int difference;
    /**
     * Boolean for if the user has won.
     */
    private boolean winBool;
    /**
     * Boolean for if the user is hot or cold with their guess.
     */
    private boolean tempBool;
    /**
     * A message that needs to be displayed to the user.
     */
    private String statement;

    /**
     * Default Constructor
     */
    Game() {

        Random rand = new Random();

        this.randNum = rand.nextInt(1000) + 1;
        this.difference = 1000;

    }

    /**
     * An access point for {@link GameFrame} to send its input and get information out. The handler was created so
     * {@link GameFrame} can use it without having to call all of Game's logic methods. The method takes in the user's
     * input and sends it out to the private methods.
     *
     * @param input     The user input int that is received from the {@link GameFrame}
     */
    public void userIntHandler(int input) {

        this.tempBool = changeDifference(input);
        this.statement = highLowOrWin(input);
        this.winBool = winCheck(input);

    }


    /**
     * Returns a boolean that will be assigned to {@link Game#tempBool}. The method takes in the input and absolute
     * values its difference between it and {@link Game#randNum}. Uses an if and else to check if the input is "hot"
     * or "cold" compared to the user's last guess. Assigns {@link Game#difference} to the new number if it is "hot".
     *
     * @param input     The user input int
     * @return          A boolean saying if the user has gotten closer with their guess
     */
    private boolean changeDifference(int input) {

        int newDifference = Math.abs((randNum-input));

        if (newDifference < this.difference) {
            this.difference = newDifference;
            return true;
        } else {
            return false;
        }

    }

    /**
     * Returns a String that is assigned to {@link Game#statement} and will then be displayed on the user interface.
     * The method uses if statements to determine if the user's guess is "Too High", "Too Low", or "Correct".
     *
     * @param input     The user input int
     * @return          A String that is the statement that must be relayed to the user
     */
    private String highLowOrWin(int input) {

        if (input > this.randNum) {
            return "Too High";
        } else if (input < this.randNum) {
            return "Too Low";
        } else if (input == this.randNum) {
            return "Correct! You Win!";
        }

        return "";

    }

    /**
     * Returns a boolean that will be assigned to {@link Game#winBool}. Uses an if and else to check if the user's guess
     * equals {@link Game#randNum}.
     *
     * @param input     The user input int
     * @return          A boolean saying if the user has won
     */
    private boolean winCheck(int input) {

        if (input == this.randNum) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * @return {@link Game#statement}
     */
    public String getStatement() { return this.statement; }

    /**
     * @return {@link Game#tempBool}
     */
    public boolean getTempBool() { return this.tempBool; }

    /**
     * @return {@link Game#winBool}
     */
    public boolean getWinBool() { return this.winBool; }

}
