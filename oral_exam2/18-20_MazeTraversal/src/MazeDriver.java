/**
 * A class that is a driver for maze traversal. Maze traversing assumes that the farther left opening is the start
 * and the farther right opening is the end. Multiple paths and ends cannot be accounted for.
 */
public class MazeDriver {

    /**
     * The main method initializes a char array or maze, and then uses the {@link MazeLogic} class to do the
     * traversal
     * @param args
     */
    public static void main(String args[]) {

        char[][] simpleMaze =
                        {{'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                        {'#' , '.', '.', '.', '#', '.', '.', '.', '.', '.', '.', '#'},
                        {'.' , '.', '#', '.', '#', '.', '#', '#', '#', '#', '.', '.'},
                        {'#' , '.', '#', '.', '.', '.', '.', '.', '.', '#', '.', '#'},
                        {'#' , '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}};

        if (MazeLogic.mazeTraversal(simpleMaze, new Position(2,0))) {

            System.out.println("Maze was traversed");

        } else {

            System.out.println("Maze has no end");

        }

    }

}
