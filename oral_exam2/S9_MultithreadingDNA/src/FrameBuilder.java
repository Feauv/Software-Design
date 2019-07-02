import java.util.ArrayList;
import java.util.List;

/**
 * The FrameBuilder class is a Filter that gets an input sequence from {@link ReverseComplementor} and outputs a frame
 * or subsequence of 3 bases to go to the {@link Translator}
 */
public class FrameBuilder implements Runnable {

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

    FrameBuilder(BlockingBuffer inputBuffer, BlockingBuffer outputBuffer) {

        this.inputBuffer = inputBuffer;
        this.outputBuffer = outputBuffer;

    }

    @Override
    public void run() {

        while (!interruption) {

            try {

                Thread.sleep(1500);
                List<Character> bases = inputBuffer.blockingGet();
                List<Character> subSequence = new ArrayList<>();

                if (bases.contains('0')) { outputBuffer.blockingPut(bases); }
                else {

                    for (Character base : bases) {

                        if (subSequence.size() == 3) {
                            Thread.sleep(500);
                            outputBuffer.blockingPut(subSequence);
                            subSequence.clear();
                        }

                        subSequence.add(base);
//                        System.out.println(subSequence);

                    }

                }


            } catch (InterruptedException e) {
                System.out.println("Frame Builder Interrupted");
                interruption = true;
            }


        }

    }
}
