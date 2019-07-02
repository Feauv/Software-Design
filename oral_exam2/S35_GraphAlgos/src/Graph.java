import java.util.*;

/**
 * Graph is the representation of all of the inputted words. The class contains various information such as an adjacency
 * list, what vertices have the most edges, and what vertices have edges. Graph can show the words relationships to each
 * other.
 */
public class Graph {

    /**
     * Map for the Adjacency List. When I did research on adjacency lists they are most commonly arrays, but a map is
     * better especially for the data size
     */
    private Map<String,List<String>> adjacencyList;
    /**
     * A Pair with the list of what vertices have the most edges and how many edges that is
     */
    private Pair<List<String>,Integer> mostEdges;
    /**
     * The List of all the words from words.dat
     */
    private List<String> data;
    /**
     * A List of all words that have edges
     */
    private List<String> haveEdges;
    /**
     * A running sum for the numbers of connections that are made
     */
    private int runningSum;
    /**
     * Number of words
     */
    private final int dataSize = 5757;

    /**
     * The Graph constructor initializes all instance variables, and it is inputted the words
     * @param data words.dat input
     */
    Graph(List<String> data) {

        this.data = data;
        adjacencyList = new HashMap<>();
        haveEdges = new ArrayList<>();
        mostEdges = new Pair<>(data, 0);
        runningSum = 0;

    }

    /**
     * This method's job is to construct the adjacency list from our data. A lot of iterations are made to make any
     * relationship between two words is accounted for in the list. The other instance variables such as mostEdges,
     * haveEdges, and runninngSum are updated throughout this method.
     */
    public void adjacencyListConstruction() {

        Iterator<String> dataIterator = data.iterator();

        while (dataIterator.hasNext()) {

            String currentData = dataIterator.next();

            adjacencyList.put(currentData, new ArrayList<>());
            Iterator<String> currentDataIterator = data.iterator();

            while (currentDataIterator.hasNext()) {

                String comparison = currentDataIterator.next();

                if (EditorLogic.editDistanceCheck(EditorLogic.toCharacterArray(currentData).iterator(), EditorLogic.toCharacterArray(comparison).iterator()) && (currentData != comparison)) {

                    adjacencyList.get(currentData).add(comparison);
                    runningSum++;

                    if (adjacencyList.get(currentData).size() > mostEdges.getRight()) {

                        mostEdges.setLeft(new ArrayList<>());
                        mostEdges.getLeft().add(currentData);

                        mostEdges.setRight(adjacencyList.get(currentData).size());

                    } else if (adjacencyList.get(currentData).size() == mostEdges.getRight()) {

                        mostEdges.getLeft().add(currentData);

                    }



                    if (!haveEdges.contains(currentData)) { haveEdges.add(currentData); }

                }

            }

        }

        System.out.println(mapToString() + "\n");
        System.out.println(dataInfoToString());

    }

    /**
     * Converts the adjacency list to a String for easy printing.
     * @return String of the adjacency list
     */
    private String mapToString() {

        String string = "";

        for (String vertex : data) {

            string += vertex + " : " + adjacencyList.get(vertex) + "\n";

        }

        return string;

    }

    /**
     * Converts all of the other info recorded by the class into a String
     * @return All other info into a String
     */
    private String dataInfoToString() {

        String string = "";

        string += "Average Number of Connections : " + Double.toString((double)runningSum/dataSize) + "\n";
        string += "Vertices That Have Edges : " + Integer.toString(haveEdges.size()) + "\n";
        string += "Vertices That Have The Most Edges : " + mostEdges.getLeft() + " with " + Integer.toString(mostEdges.getRight()) + "\n";

        return string;

    }

}
