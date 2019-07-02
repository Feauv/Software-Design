import javax.swing.JFrame;

public class GameDriver {

    /**
     * The driver for the game. It initializes a new {@link GameFrame} object, and sets its close operation and to be
     * visible.
     *
     * @param args
     */
    public static void main(String[] args) {

        GameFrame gameFrame = new GameFrame();

        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setVisible(true);

    }

}
