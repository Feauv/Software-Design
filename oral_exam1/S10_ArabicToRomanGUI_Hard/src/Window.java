import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Window extends from JFrame and sets up all of the user interface
 *
 * @author Nick Grove
 */
public class Window extends JFrame {

    /**
     * Input text area
     */
    private JTextArea inputArea;
    /**
     * Output text area
     */
    private JTextArea translatedArea;
    /**
     * Input title, shows detection
     */
    private JLabel inputTitle;
    /**
     * Output title, shows translation
     */
    private JLabel translatedTitle;
    /**
     * {@link Translator} object
     */
    private final Translator translator = new Translator();

    /**
     * Window constructor initializes and sets up all components within the user interface. It uses super to set up the
     * frame and it sets its size and layout. Uses the overloaded method setupViews to set all components. Sets up
     * text alignment for labels. Finally add a KeyListener for {@link Window#inputArea}.
     */
    Window() {

        super("Arabic to Roman");
        setLayout(null);

        this.inputArea = new JTextArea("");
        this.translatedArea = new JTextArea("");
        this.translatedArea.setEnabled(false);
        this.inputTitle = new JLabel("Ready To Detect");
        this.translatedTitle = new JLabel("");

        setSize(1000, 300);

        setupView(this.inputArea, 300, 100, 100, 100);
        setupView(this.translatedArea, 300, 100, 600, 100);
        setupView(this.inputTitle, 300, 50, 100, 50);
        setupView(this.translatedTitle, 300, 50, 600, 50);

        this.inputTitle.setHorizontalAlignment(JLabel.CENTER);
        this.inputTitle.setVerticalAlignment(JLabel.BOTTOM);

        this.translatedTitle.setHorizontalAlignment(JLabel.CENTER);
        this.translatedTitle.setVerticalAlignment(JLabel.BOTTOM);

        inputArea.addKeyListener(new KeyListener() {

            /**
             * Triggered when a key is typed
             *
             * @param e     KeyEvent
             */
            @Override
            public void keyTyped(KeyEvent e) {

            }

            /**
             * Triggered when a key is pressed
             *
             * @param e     KeyEvent
             */
            @Override
            public void keyPressed(KeyEvent e) {


            }

            /**
             * Triggered when a key is released. As soon as a key is released this method sends the text of
             * {@link Window#inputArea} to {@link Translator#detectLanguage(char[])}. The language returned from that
             * method goes through a switch statement to translate the input. The methods {@link Translator#toRoman(int)}
             * and {@link Translator#toArabic(char[])} are called based on what the translation needs to be.
             *
             * @param e     KeyEvent
             */
            @Override
            public void keyReleased(KeyEvent e) {

                String lang = translator.detectLanguage(inputArea.getText().toCharArray());
                inputTitle.setText("Detected: " + lang);

                if (inputArea.getText().equals("")) {

                    inputTitle.setText("Ready To Detect");
                    translatedArea.setText("");
                }

                switch (lang) {
                    case "Arabic":
                        translatedTitle.setText("Translated to Roman");
                        translatedArea.setText(translator.toRoman(Integer.parseInt(new String(inputArea.getText().toCharArray()))));
                        break;
                    case "Roman":
                        translatedTitle.setText("Translated to Arabic");
                        translatedArea.setText(translator.toArabic(inputArea.getText().toCharArray()));
                        break;
                    default:
                        translatedTitle.setText("Unable to Translate");
                        break;
                }

            }

        });

    }

    /**
     * Overloaded function that sets up a JTextArea inside the JFrame
     *
     * @param view  JTextArea
     * @param w     Width of the area
     * @param h     Height of the area
     * @param x     X-Coordinate of the area
     * @param y     Y-Coordinate of the area
     */
    private void setupView(JTextArea view, int w, int h, int x, int y) {

        view.setSize(w,h);
        view.setLocation(x,y);

        add(view);

    }

    /**
     * Overloaded function that sets up a JLabel inside the JFrame
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

}
