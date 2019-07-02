import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * The static class that is used for all editing purposes, such as finding if the edit distance between two words is one.
 */
public class EditorLogic {

    /**
     * Converts a String into a Character list so that an iterator can be made out of it.
     * @param string Inputted word
     * @return The word into a Character list
     */
    public static List<Character> toCharacterArray(String string) {

        char[] charArray = string.toCharArray();
        List<Character> characterList = new ArrayList<>();

        for(char c : charArray) {

            characterList.add(c);

        }

        return characterList;

    }

    /**
     * A check made to see if a word is an edge.
     * @param baseStringIterator The iterator for the vertex that is being examined
     * @param convertedStringIterator The iterator that is being checked to become an edge of the vertex
     * @return A boolean if it is an edge
     */
    public static boolean editDistanceCheck(Iterator<Character> baseStringIterator, Iterator<Character> convertedStringIterator) {

        int distance = 0;

        while(baseStringIterator.hasNext()) {

            if (baseStringIterator.next() != convertedStringIterator.next()) {

                distance++;

                if (distance > 1) return false;

            }

        }

        return true;

    }

}
