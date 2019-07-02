import java.util.*;

/**
 * The ReverseComplementor reverses the sequence from {@link GapFinder} and switches all of the sequence to its
 * complements. After this it outputs the sequence to eventually go to the {@link FrameBuilder}
 */
public class ReverseComplementor implements Runnable {

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

    ReverseComplementor(BlockingBuffer inputBuffer, BlockingBuffer outputBuffer) {

        this.inputBuffer = inputBuffer;
        this.outputBuffer = outputBuffer;

    }

    @Override
    public void run() {

        while (!interruption) {

            try {

                Thread.sleep(1500);
                List<Character> bases = inputBuffer.blockingGet();
                Collections.reverse(bases);
                List<Character> sequence = new ArrayList<>();

                if (bases.size() == 1) { outputBuffer.blockingPut(bases); }
                else {

                    for (Character base : bases) {

                        switch (base) {

                            case 'A':
                                sequence.add('T');
                                break;
                            case 'T':
                                sequence.add('A');
                                break;
                            case 'C':
                                sequence.add('G');
                                break;
                            case 'G':
                                sequence.add('C');
                                break;

                        }

                    }

                    outputBuffer.blockingPut(sequence);

                }

            } catch (InterruptedException e) {
                System.out.println("Reverse Complementor Interrupted");
                interruption = true;
            }

        }

    }
}
