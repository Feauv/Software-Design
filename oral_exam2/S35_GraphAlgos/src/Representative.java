import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

/**
 * The class that acts as the driver for the program. It reads the words.dat file and calls the {@link Graph} to be constructed
 */
public class Representative {

    /**
     * The main method reads in the file and calls for the adjacency method to be made
     * @param args
     */
    public static void main(String args[]) {

        try {


            String[] lines = Files.readAllLines(new File("/user/n/njgrove/git/njgrove_swd/oral_exam2/S35_GraphAlgos/resources/words.dat").toPath()).toArray(new String[0]);
            List<String> data = Arrays.asList(lines);

            Graph graph = new Graph(data);

            graph.adjacencyListConstruction();


        } catch (IOException e) {

            System.out.println("There was a problem reading the file" + e);

        }

    }

}
