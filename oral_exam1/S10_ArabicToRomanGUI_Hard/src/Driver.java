import javax.swing.*;

/**
 * Driver is class that uses a main method to run the {@link Window} class
 *
 * @author Nick Grove
 */
public class Driver {

    /**
     * Initializes a new {@link Window} and sets up its close operation and sets it to be visible.
     *
     * @param args
     */
    public static void main(String[] args) {

        Window window = new Window();

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

    }

}
