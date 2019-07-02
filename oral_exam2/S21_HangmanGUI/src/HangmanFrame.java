import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * This class deals with mostly just the UI elements of the program. The many components of the interface for the user
 * are initialized and updated in this class as the game goes on.
 */
public class HangmanFrame extends JFrame {

    /**
     * Located in the center of the frame, used for directions
     */
    private JLabel centerLabel;
    /**
     * The JLabel that shows hangman aspect of the interface, with underlines for letters that have not been guessed
     */
    private JLabel hangmanLabel;
    /**
     * Info that the user must know, usually related to last thing they entered
     */
    private JLabel statement;
    /**
     * Where the word to be guessed is inputted and where letters are inputted
     */
    private JTextField inputField;
    /**
     * The JLabel showing the incorrect letters that have already been guessed
     */
    private JLabel incorrect;
    /**
     * The JLabel showing the number of wrong guesses the player has until the game is over
     */
    private JLabel guesses;
    /**
     * The UI's {@link HangmanGame} object
     */
    private HangmanGame game;
    /**
     * Boolean indicator that tells whether or not the game has started
     */
    private boolean gameStart;

    /**
     * The Frame and all of the UI components are intialized and set in place in the HangmanFrame's constructor.
     */
    HangmanFrame() {

        super("Hangman");
        setLayout(null);

        centerLabel = new JLabel("Enter a word to be guessed below");
        hangmanLabel = new JLabel("");
        statement = new JLabel("");
        incorrect = new JLabel("");
        guesses = new JLabel("");

        inputField = new JTextField();

        gameStart = false;

        setSize(400,280);

        centerLabel.setHorizontalAlignment(JLabel.CENTER);
        hangmanLabel.setHorizontalAlignment(JLabel.CENTER);
        statement.setHorizontalAlignment(JLabel.CENTER);
        incorrect.setHorizontalAlignment(JLabel.LEFT);
        guesses.setHorizontalAlignment(JLabel.LEFT);

        setupView(centerLabel, 400, 30, 0, 80);
        setupView(hangmanLabel, 400, 30, 0, 110);
        setupView(statement, 200, 30, 100, 190);
        setupView(incorrect, 250, 20, 5, 0);
        setupView(guesses, 100, 20, 5, 20);
        setupView(inputField, 200, 30, 100, 160);

        this.inputField.addKeyListener(new KeyListener() {

            /**
             * Triggered when a key is typed
             *
             * @param e     KeyEvent from user
             */
            @Override
            public void keyTyped(KeyEvent e) {

            }

            /**
             * Triggered when a key is pressed
             *
             * @param e     KeyEvent from user
             */
            @Override
            public void keyPressed(KeyEvent e) {

            }

            /**
             * Triggered when a key is released. In this method it tracks the KeyEvent and checks if it is an enter.
             *
             * @param e     KeyEvent from user
             */
            @Override
            public void keyReleased(KeyEvent e) {

                char enter = '\n';
                if (enter == e.getKeyChar()) {
                    if(!gameStart) {

                        game = new HangmanGame(inputField.getText());
                        gameStart = true;
                        UIInit();

                    } else {

                        if(inputField.getText().length() > 1) {

                            statement.setText("Enter just one letter for input");
                            inputField.setText("");

                        } else if(game.getIncorrect().contains(inputField.getText().charAt(0)) || String.valueOf(game.getOutputWord()).indexOf(inputField.getText()) > -1) {

                            statement.setText("Letter has already been played");
                            inputField.setText("");

                        } else {

                            if(game.guess(inputField.getText().charAt(0))) {
                                statement.setText(inputField.getText() + " was correct");
                            } else {
                                statement.setText(inputField.getText() + " was incorrect");
                            }

                            UISet();

                        }

                        if(!(String.valueOf(game.getOutputWord()).indexOf("_") > -1) && !(game.getUntilDeath() < 0)) {
                            statement.setText("Winner!");
                        } else if (game.getUntilDeath() < 0) {
                            statement.setText("Game Over");
                        }

                    }
                }

            }

        });

    }

    /**
     * What all the UI components are set to when a game begins
     */
    private void UIInit() {

        inputField.setText("");
        hangmanLabel.setText(String.valueOf(game.getOutputWord()));
        centerLabel.setText("Guess the word");
        incorrect.setText("incorrect: " + game.getIncorrect().toString());
        guesses.setText("guesses left: " + Integer.toString(game.getUntilDeath()));

    }

    /**
     * What all the UI components are reset to after the user guesses a letter
     */
    private void UISet() {

        inputField.setText("");
        hangmanLabel.setText(String.valueOf(game.getOutputWord()));
        incorrect.setText("incorrect: " + game.getIncorrect().toString());
        guesses.setText("guesses left: " + Integer.toString(game.getUntilDeath()));

    }

    /**
     * Overloaded method that sets a JLabel onto the JFrame
     *
     * @param view  JLabel
     * @param w     Width of the label
     * @param h     Height of the label
     * @param x     X-Coordinate of the label
     * @param y     Y-Coordinate of the label
     */
    private void setupView(JLabel view, int w, int h, int x, int y) {

        view.setSize(w,h);
        view.setLocation(x,y);

        add(view);

    }

    /**
     * Overloaded method that sets a JTextField onto the JFrame
     *
     * @param view  JTextField
     * @param w     Width of the field
     * @param h     Height of the field
     * @param x     X-Coordinate of the field
     * @param y     Y-Coordinate of the field
     */
    private void setupView(JTextField view, int w, int h, int x, int y) {

        view.setSize(w,h);
        view.setLocation(x,y);

        add(view);

    }

}
