import javax.swing.*;

/**
 * The driver class for the game
 */
public class HangmanDriver {

    /**
     * The driver for the game. It initializes a new {@link HangmanFrame} object, and sets its close operation and to be
     * visible.
     * @param args
     */
    public static void main(String[] args) {

        HangmanFrame gameFrame = new HangmanFrame();

        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setVisible(true);

    }

}
