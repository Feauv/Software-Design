import java.util.ArrayList;
import java.util.List;

/**
 * The GapFinder class is a Filter that sends all of the sequences of bases separated. The Filter's job is to add bases
 * (A, T, C, or G) to the sequence, cut off the sequence if a gap is found (N), and ignore all other characters.
 */
public class GapFinder implements Runnable {

    /**
     * The {@link BlockingBuffer} output is sent to
     */
    private final BlockingBuffer outputBuffer;
    /**
     * The input from {@link OpenReadingFrameFilter}
     */
    private final List<Character> bases;

    GapFinder( BlockingBuffer outputBuffer, String bases) {

        this.outputBuffer = outputBuffer;
        this.bases = toCharacterList(bases);

    }

    @Override
    public void run() {

        List<Character> sequence = new ArrayList<>();
        List<Character> divider = new ArrayList<>();
        divider.add('0');

        try {

            for (Character base : bases) {

                if (base == 'N') {
                    if (sequence.size() > 0) {
//                    System.out.println(sequence);

                        Thread.sleep(1500);
                        outputBuffer.blockingPut(sequence);
                        outputBuffer.blockingPut(divider);
                        sequence.clear();


                    } else {
                        System.out.println("No sequence yet");
                    }
                } else if (base == 'A' || base == 'C'|| base == 'G' || base == 'T') {
                    sequence.add(base);
                }

            }

            Thread.sleep(100);
            outputBuffer.blockingPut(sequence);
            outputBuffer.blockingPut(divider);

        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }

    }

    /**
     * Converts the user inputted String into a Character list
     * @param bases DNA String
     * @return Bases in a Character list
     */
    List<Character> toCharacterList(String bases) {

        List<Character> returnList = new ArrayList<>();

        for (char base : bases.toCharArray()) {

            returnList.add(base);

        }

        return returnList;

    }

}
