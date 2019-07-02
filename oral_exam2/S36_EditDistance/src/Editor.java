/**
 * The Editor class is where all of the edit distance calculations and operations are done. In this class an edit distance
 * algorithm is implemented and communication is made to the {@link Feedback} class to print the important messages to
 * the console
 */
public class Editor {

    /**
     * The {@link Feedback} object of the class
     */
    private Feedback feedback;
    /**
     * The string that the Editor starts
     */
    private String baseString;
    /**
     * The string that the Editor ends with
     */
    private String convertedString;
    /**
     * The length of the baseString
     */
    private int baseLength;
    /**
     * The length of the convertedString
     */
    private int convertedLength;
    /**
     * The grid that the edit distance algorithm produces
     */
    private int[][] grid;

    /**
     * Initialization of all instance variables for the Editor is done inside this constructor
     */
    Editor(String str1, String str2) {

        feedback = new Feedback(str1, str2);

        baseString = str1;
        convertedString = str2;

        baseLength = baseString.length();
        convertedLength = convertedString.length();

        grid = new int[baseLength + 1][convertedLength + 1];

    }

    /**
     * The Editor has about 3 important methods that do various processes, this method is here so the driver class can
     * use just this method instead of call all 3 methods. The rest of the methods inside this class can be private
     * because of this method.
     */
    public void driverHandler() {

        editDistanceGrid();
        System.out.println("Edit Distance Grid:");
        System.out.println(gridToString());
        gridTraversal();

    }

    /**
     * Finding the edit distance can get very complicated with substrings and strings of different sizes, so to solve for
     * the edit distance we must construct a grid so we can visualize the relationship between the two strings. The grid
     * can be very easy to explain with an example. If constructed a grid with two strings that were the exact same such
     * as "bee" and "bee" the grid would be 4 by 4 and only 0's down the diagonal. When we have two different words we
     * can see change down the diagonal and change in the path from getting from corner to corner. The idea of the grid
     * between the two strings can be very hard to grasp so there is more explanation and visuals inside the Wiki and in
     * the JavaDoc documentation for {@link Editor#gridTraversal()}
     */
    private void editDistanceGrid() {

        for (int i = 0; i <= baseLength; i++) {
            grid[i][0] = i;
        }

        for (int j = 0; j <= convertedLength; j++) {
            grid[0][j] = j;
        }

        for (int i = 0; i < baseLength; i++) {

            char char1 = baseString.charAt(i);

            for (int j = 0; j < convertedLength; j++) {

                char char2 = convertedString.charAt(j);

                if (char1 == char2) {

                    grid[i + 1][j + 1] = grid[i][j];

                } else {

                    int diagonal = grid[i][j] + 1;
                    int horizontal = grid[i][j + 1] + 1;
                    int vertical = grid[i + 1][j] + 1;

                    int minDistance;

                    if (diagonal > horizontal) { minDistance = horizontal; } else { minDistance = diagonal;}

                    if (!(vertical > minDistance)) { minDistance = vertical; }

                    grid[i + 1][j + 1] = minDistance;

                }
            }
        }

        feedback.setDistance(grid[baseLength][convertedLength]);

    }

    /**
     * This method takes our grid and makes a string for printing to the console. Once the user understands how the
     * algorithm and grid works showing the grid for their input will be very helpful.
     * @return The grid we constructed as a string
     */
    private String gridToString() {

        String string = "    ";

        for(int i = 0; i < convertedString.length(); i++) {
            string += Character.toString(convertedString.charAt(i)) + " ";
        }

        string += "\n";

        for(int i = 0; i < grid.length; i++) {

            if (i > 0) {
                string += Character.toString(baseString.charAt(i-1)) + " ";
            } else {
                string += "  ";
            }

            for(int j = 0; j < grid[0].length; j++) {

                string += Integer.toString(grid[i][j]) + " ";

            }

            string += "\n";

        }

        return string;

    }

    /**
     * This method traverses the grid from the bottom right corner up to its origin. The traversal of the grid is
     * necessary because we know the number for the edit distance calculation, but we do not know what each "edit" is,
     * such as replacing, adding, or removing a letter. The way traversing the grid works is when you start from the
     * bottom corner if the number to left of your current position is less then your current number then that means the
     * edit was an addition of a letter. If the number above your current position is less than your current number then
     * that means the edit was a removal of a letter. If the number up and left from your current position is less, that
     * means there was a replacement. Finally if none of those were passed than that means there was no edit, and you
     * move your current position up and left.
     */
    private void gridTraversal() {

        int row = baseLength;
        int column = convertedLength;

        while(row + column != 0) {

            if (grid[row][column-1] < grid[row][column]) {
                feedback.add(convertedString.charAt(column-1));
                column--;
            } else if (grid[row-1][column] < grid[row][column]) {
                feedback.remove(baseString.charAt(row-1));
                row--;
            } else if (grid[row-1][column-1] < grid[row][column]) {
                feedback.replace(baseString.charAt(row-1), convertedString.charAt(column-1));
                row--;column--;
            } else {
                row--;column--;
            }

        }

        System.out.println(feedback.toString());

    }

}
