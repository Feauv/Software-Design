import javax.swing.*;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * GameFrame is a class that extends JFrame to make a user interface for the number guessing game. The {@link Game} class
 * is used by GameFrame for all of the games logic.
 *
 * @author Nick Grove
 */
public class GameFrame extends JFrame {

    /**
     * JLabel that displays info to the user
     */
    private JLabel statement;
    /**
     * JTextField that the user enters their guesses in
     */
    private JTextField textField;
    /**
     * {@link Game} instance variable
     */
    private Game game;

    /**
     * Sets up the entire user interface. The constructor uses super to set the frame and then it sets the layout for
     * the frame (which is set to null). After this all user interface items are initialized, which includes instance ]
     * variables and local variables as well. All JLabel align their text to the center. The initial background color and
     * frame size are set. Use of the overloaded method setupView is used with all UI components to set them in place.
     * The constructor initializes the {@link GameFrame#textField}'s KeyListener, which is used to wait for an
     * enter from the user.
     */
    GameFrame() {

        super("Guess the Number");
        setLayout(null);

        JLabel question = new JLabel("I have a number between 1 and 1000. Can you guess my number?");
        JLabel directions = new JLabel("Please enter your first guess:");
        this.statement = new JLabel("");
        this.textField = new JTextField();
        this.game = new Game();

        question.setHorizontalAlignment(JLabel.CENTER);
        directions.setHorizontalAlignment(JLabel.CENTER);
        this.statement.setHorizontalAlignment(JLabel.CENTER);

        getContentPane().setBackground(new Color(217,217,219));
        setSize(500, 300);

        setupView(question, 500, 30, 0, 70);
        setupView(directions, 500, 30, 0, 120);
        setupView(this.statement, 500, 30, 0, 180);
        setupView(this.textField, 300, 30, 100, 150);

        this.textField.addKeyListener(new KeyListener() {

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
                    dealWithEnter();
                }

            }

        });

    }

    /**
     * Deals with whatever needs to be done when enter is pressed from the user. The method uses a try and catch to check
     * if they entered an int. If no exception the method uses {@link Game#userIntHandler(int)} to send the game logic
     * into motion. After that the {@link Game#getWinBool()}, {@link Game#getTempBool()}, and {@link Game#getStatement()}
     * are used to change the user interface, the method {@link GameFrame#UISet(Color, String)} is used to do this. If there
     * is an exception thrown, {@link GameFrame#UISet(Color, String)} displays the default background color and displays an
     * error message.
     */
    private void dealWithEnter() {

        try {
            int userInt = Integer.valueOf(this.textField.getText());
            this.statement.setText("");

            this.game.userIntHandler(userInt);

            if(this.game.getWinBool()) {
                UISet(Color.GREEN, this.game.getStatement());
            } else if (this.game.getTempBool()) {
                UISet(Color.RED, this.game.getStatement());
            } else if (!(this.game.getTempBool())) {
                UISet(Color.BLUE, this.game.getStatement());
            }

        } catch (NumberFormatException e) {
            UISet(new Color(217,217,219),"Error: Enter an integer");
        }

    }

    /**
     * Sets the changes to the user interface. The method is used after every guess is entered, set the background, relay
     * a message to the user, and set the {@link GameFrame#textField} to blank.
     *
     * @param background    The color that will be set to the background
     * @param statement     The statement that must be shown to the user
     */
    private void UISet(Color background, String statement) {
        getContentPane().setBackground(background);
        this.statement.setText(statement);
        this.textField.setText("");
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
