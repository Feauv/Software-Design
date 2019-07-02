import java.util.ArrayList;
import java.util.List;

/**
 * The Translator filter takes the frames from the {@link FrameBuilder} and translates them into a {@link Codon}.
 * The output from the Translator will end up with the {@link ORFFinder}.
 */
public class Translator implements Runnable {

    /**
     * Input Buffer
     */
    private final BlockingBuffer inputBuffer;
    /**
     * Output Buffer
     */
    private final BlockingBuffer outputBuffer;
    /**
     * Interruption boolean
     */
    private boolean interruption = false;

    Translator(BlockingBuffer inputBuffer, BlockingBuffer outputBuffer) {

        this.inputBuffer = inputBuffer;
        this.outputBuffer = outputBuffer;

    }

    @Override
    public void run() {

        while (!interruption) {

            try {

                Thread.sleep(1500);
                List<Character> frame = inputBuffer.blockingGet();
                List<Character> geneticSequence = new ArrayList<>();

                if (frame.size() == 3) {

                    String string = "";

                    for (Character base : frame) {

                        string += Character.toString(base);

                    }

                    Codon codon = Codon.getCodon(string);
                    geneticSequence.add(codon.getOneLetterCode());
                    outputBuffer.blockingPut(geneticSequence);

                } else if (frame.size() == 1){
                    Thread.sleep(500);
                    //outputBuffer.blockingPut(geneticSequence);
                    outputBuffer.blockingPut(frame);

                }

            } catch (InterruptedException e) {
                System.out.println("Translator Interrupted");
                interruption = true;
            }


        }

    }
}
