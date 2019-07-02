import java.util.ArrayList;
import java.util.List;

/**
 * This class acts as the collector for any info the user needs to know once the edit distance and edit operations are
 * figured. When the number of edits and what the edits are printed to the console, that is because of this class
 */
public class Feedback {

    /**
     * The string that the Editor starts
     */
    private final String baseString;
    /**
     * The string that the Editor ends with
     */
    private final String convertedString;
    /**
     * The list of edits that need to be made
     */
    private List<String> edits = new ArrayList<>();
    /**
     * The number of edits that need to be made
     */
    private int distance;

    /**
     * Initializes the two string from the {@link Editor} class
     * @param str1 The baseString
     * @param str2 The convertedString
     */
    Feedback(String str1, String str2) {

        baseString = str1;
        convertedString = str2;
        distance = 0;

    }

    /**
     * Once the calculation for the edit distance is finished this method is called to set the distance for the
     * Feedback class
     * @param distance The edit distance
     */
    public void setDistance(int distance) {
        this.distance = distance;
    }

    /**
     * When the edit is a removal
     * @param removeCharacter The letter that must be removed
     */
    public void remove(Character removeCharacter) {

        edits.add(0, "Remove \'" + Character.toString(removeCharacter) + "\' from str1");

    }

    /**
     * When the edit is a replacement
     * @param replaceCharacter The letter that is being replaced
     * @param withThisCharacter The new letter that will be put in
     */
    public void replace(Character replaceCharacter, Character withThisCharacter) {

        edits.add("Replace \'" + Character.toString(replaceCharacter) + "\' from str1 with \'" + Character.toString(withThisCharacter) + "\'");

    }

    /**
     * When the edit is an addition
     * @param addCharacter The letter that must be added
     */
    public void add(Character addCharacter) {

        edits.add("Add \'" + Character.toString(addCharacter) + "\' to str1");

    }

    /**
     * When all information is collected for the edit distance the Editor calls this so all of the Feedback can be made
     * into a string (and be printable)
     * @return All the elements of the class as a string
     */
    public String toString() {

        String string = "";

        string += "str1: " + baseString + "\n";
        string += "str2: " + convertedString + "\n";

        string += "edit distance: " + Integer.toString(distance) + " -->\n";

        for (String e : edits) {

            string += "\t" + e + "\n";

        }

        return string;

    }

}
