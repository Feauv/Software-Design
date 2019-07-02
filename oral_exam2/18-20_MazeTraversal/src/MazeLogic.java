/**
 * A class with only static methods and variables that is used for the logic of a maze
 */
public class MazeLogic {

    /**
     * An array of all possible movements (up, down, left, right)
     */
    private static final Position[] movements = {new Position(-1,0),
                                                new Position(1,0),
                                                new Position(0,-1),
                                                new Position(0,1)};

    /**
     * A recursive method that is used to traverse a maze. When the method is called the current space on the map is made
     * an 'x', this shows that we have been here. The maze is then printed and traversal starts. The way traversing
     * starts is that the {@link MazeLogic#movements} array is iterated through to check for possible positions to
     * move to. When a possible position is found the recursive call is made and then the process is done over and
     * over. Dead end paths that are found are marked by '0's.
     * @param maze The maze that is being traversed
     * @param position The current position
     * @return A boolean if there is an ending to the maze.
     */
    public static boolean mazeTraversal(char[][] maze, Position position) {

        maze[position.vertical][position.horizontal] = 'x';
        print(maze);
        System.out.println(position.toString() + "\n\n\n");

        if (position.vertical == maze.length-1 || position.horizontal == maze[0].length-1) {

            return true;

        } else {

            for (Position move : movements) {

                Position newPosition = position.positionChange(move);

                try {
                    if (maze[newPosition.vertical][newPosition.horizontal] == '.') {

                        if (mazeTraversal(maze, newPosition)) return true;
                        else maze[newPosition.vertical][newPosition.horizontal] = '0';

                    }
                } catch (ArrayIndexOutOfBoundsException e) {

                }


            }

        }

        return false;

    }

    /**
     * The method used for printing the maze to the console
     * @param maze
     */
    private static void print(char[][] maze) {

        String row = "";

        for (int i = 0; i < maze.length; i++) {

            for (int j = 0; j < maze[0].length; j++) {

                row += String.valueOf(maze[i][j]) + " ";

            }

            System.out.println(row);
            row = "";

        }

    }

}
