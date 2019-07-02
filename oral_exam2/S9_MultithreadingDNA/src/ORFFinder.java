import java.util.ArrayList;
import java.util.List;

/**
 * This class is the final Filter and it finds the Open Reading Frames, the ORFs are found by waiting until a stop
 * codon and if the sequence made before that codon is over 21 than it is an ORF.
 */
public class ORFFinder implements Runnable {

    /**
     * Input Buffer
     */
    private final BlockingBuffer inputBuffer;
    /**
     * Specified size the sesquences need to be
     */
    private final int specifiedSize;
    /**
     * Interruption boolean
     */
    private boolean interruption = false;

    ORFFinder(BlockingBuffer inputBuffer, int specifiedSize) {

        this.inputBuffer = inputBuffer;
        this.specifiedSize = specifiedSize;

    }

    @Override
    public void run() {

        List<Character> sequence = new ArrayList<>();

        while (!interruption) {

            try {

                Thread.sleep(1500);
                List<Character> geneticSequence = inputBuffer.blockingGet();

                if (geneticSequence.contains('0')) {
//                    System.out.println(sequence);
                    sequence.clear();
                }
                else {

                    for (Character oneLetterCode : geneticSequence) {

                        if (oneLetterCode == '*' && sequence.size() >= specifiedSize) {
                            sequence.add(oneLetterCode);
                            System.out.println(sequence);
                            sequence.clear();

                        }

                        sequence.add(oneLetterCode);

                    }

                }

            } catch (InterruptedException e) {
                System.out.println("ORF Finder Interrupted");
                interruption = true;
            }

        }

    }
}
