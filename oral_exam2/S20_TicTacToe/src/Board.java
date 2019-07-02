/**
 * The Board is the visual representation of the {@link Game}. The class has an instance variable called spaces which
 * is a 2 dimensional array of Space objects and is the physical representation of the Board. The "spaces" of the Board
 * is updated as gameplay continues. The Board class also has its own logic that is carried out by its methods. The
 * Board is able to validate moves, determine if the board is still playable, update itself when moves are made, and
 * convert the spaces array into a String.
 */
public class Board {

    /**
     * The representation of the board
     */
    public Space[][] spaces;

    /**
     * Constructor for the Board, primary purpose is to initialize the spaces array
     */
    Board() {

        spaces = new Space[3][3];

        for (int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {

                spaces[i][j] = new BlankSpace(i,j);

            }
        }

    }

    /**
     * Iterates through the spaces and checks if any of them are a BlankSpace
     * @return Boolean if the board is still playable (has any BlankSpaces)
     */
    public boolean stillPlayable() {

        for(Space[] row : spaces) {
            for(Space space : row) {

                if(space.getClass().getName() == "BlankSpace") {

                    return true;

                }

            }
        }

        return false;

    }

    /**
     * Validating if a move can be made where the {@link Player} is choosing to move
     * @param move The inputted move that needs to be validated
     * @return If the move is valid
     */
    public boolean validate(PlayedSpace move) {

        try {

            if (spaces[move.getPosition().getVertical()][move.getPosition().getHorizontal()].getClass().getName() == "BlankSpace")
                return true;
            else return false;

        } catch (ArrayIndexOutOfBoundsException e) {

            return false;

        }

    }

    /**
     * A method that is used to place the move onto the board
     * @param move The inputted move that will be placed
     */
    public void updateBoard(PlayedSpace move) {

        spaces[move.getPosition().getVertical()][move.getPosition().getHorizontal()] = move;

    }

    /**
     * Converts {@link Board#spaces} into a string to be displayed to the console
     */
    public String boardToString() {

        String string = "";

        for(int i = 0; i < 3; i++) {
            string += " " + Character.toString(spaces[i][0].getSymbol()) + " | "
                    + Character.toString(spaces[i][1].getSymbol()) + " | "
                    + Character.toString(spaces[i][2].getSymbol()) + " \n";

            if (i < 2) {

                string += "---|---|---\n";

            }

        }

        return string;

    }

}
