import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The {@link Player} class for all human players, therefore players who physically type in input.
 */
public class HumanPlayer extends Player {

    /**
     * The symbol for this player
     */
    Character symbol;

    /**
     * The default constructor for a HumanPlayer, only takes in the symbol that the player will be using throughout the
     * game
     * @param symbol The symbol that will be played with
     */
    HumanPlayer(Character symbol) {

        this.symbol = symbol;

    }

    /**
     * This method is courtesy of the {@link Player} class and for a HumanPlayer it is used for the input of a move
     * @return The {@link Position} of the new move to be made
     */
    @Override
    public Position makeMove() {

        boolean inputBool = false;
        Integer vertical = 0, horizontal = 0;

        while (!inputBool) {

            System.out.println("What is your move?");
            System.out.println("Coordinates (type a row, a space, and then a the column): ");
            try {
                Scanner input = new Scanner(System.in);
                vertical = input.nextInt();
                horizontal = input.nextInt();
                inputBool = true;
            } catch (InputMismatchException e) {
                System.out.println("\nPlease enter integers");
            }

        }

        return new Position(vertical-1,horizontal-1);

    }

    /**
     * Getter for the player's symbol
     * @return The object's symbol
     */
    @Override
    public Character getSymbol() {
        return symbol;
    }

}
