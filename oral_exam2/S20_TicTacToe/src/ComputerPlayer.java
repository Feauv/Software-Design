import java.util.Random;

/**
 * A class that is a player that does not take user input. It automatically generates moves.
 */
public class ComputerPlayer extends Player {

    /**
     * The symbol that the Player has
     */
    private Character symbol;
    /**
     * Random generator for making moves
     */
    private Random generator = new Random();

    /**
     * Default constructor
     * @param symbol The inputted symbol that the player will use throughout the game
     */
    ComputerPlayer(Character symbol) {

        this.symbol = symbol;

    }

    /**
     * Method for the player to make a move. This is the ComputerPlayer class so the move is randomly generated.
     * @return {@link Position} the computer wants to move to
     */
    @Override
    public Position makeMove() {
        Integer vertical = generator.nextInt(3);
        Integer horizontal = generator.nextInt(3);
        return new Position(vertical,horizontal);
    }

    /**
     * Check out {@link Player}
     * @return The player's symbol
     */
    @Override
    public Character getSymbol() {
        return symbol;
    }

}
