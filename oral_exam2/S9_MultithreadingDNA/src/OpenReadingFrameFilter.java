import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * An Open Reading Frame Filter is what the entire program is, but for the class with the same name it just acts as a
 * controller. This class has only a main method and it initializes and executes everything for the program.
 */
public class OpenReadingFrameFilter {

    /**
     * The main method takes in user input and uses it to sent the ORF Filter in motion. This method initializes all of
     * the {@link BlockingBuffer} objects that are between Filters and executes all of the Filters as Threads.
     * @param args
     * @throws InterruptedException
     */
    public static void main(String args[]) throws InterruptedException {

        Scanner input = new Scanner(System.in);

        ExecutorService executorService = Executors.newCachedThreadPool();

        BlockingBuffer gapToComplementor = new BlockingBuffer(1, "Gap Finder", "Reverse Complementor");
        BlockingBuffer complementorToBuilder = new BlockingBuffer(1, "Reverse Complementor", "Frame Builder");
        BlockingBuffer builderToTranslator = new BlockingBuffer(1, "Frame Builder", "Translator");
        BlockingBuffer translatorToFinder = new BlockingBuffer(1, "Translator", "ORF Finder");

        System.out.println("Enter a sequence of bases: ");
        String dna = input.next().toUpperCase();

        executorService.execute(new GapFinder(gapToComplementor, dna));
        executorService.execute(new ReverseComplementor(gapToComplementor,complementorToBuilder));
        executorService.execute(new FrameBuilder(complementorToBuilder,builderToTranslator));
        executorService.execute(new Translator(builderToTranslator,translatorToFinder));
        executorService.execute(new ORFFinder(translatorToFinder, 21));

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);

    }

}
