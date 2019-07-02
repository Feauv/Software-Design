/**
 * An abstract class for players. The {@link HumanPlayer} and {@link ComputerPlayer} classes extend player to have
 * the base methods for what a player needs.
 */
public abstract class Player {

    /**
     * This is where a move is made by a player
     * @return {@link Position} of the move that a player wants to make
     */
    abstract Position makeMove();

    /**
     * Used by the {@link Game} class to get a player's symbol
     * @return The symbol of the player
     */
    abstract Character getSymbol();


}
