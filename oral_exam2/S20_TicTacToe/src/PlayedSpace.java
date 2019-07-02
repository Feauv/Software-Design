/**
 * A PlayedSpace is a space that a {@link Player} has played on. It implements the abstract class {@link Space}, and this class
 * is used by the {@link Board} for all played spaces.
 */
public class PlayedSpace extends Space {

    /**
     * Symbol for the Space that is either an 'X' or 'O'
     */
    private final Character symbol;
    /**
     * {@link Position} or coordinates of the Space on the board
     */
    private final Position position;

    /**
     * Constructor for a PlayedSpace
     * @param position coordinates
     * @param symbol symbol for the space
     */
    PlayedSpace(Position position, Character symbol) {

        this.position = position;
        this.symbol = symbol;

    }

    /**
     * Check out {@link Space#getPosition()}
     * @return position
     */
    @Override
    public Position getPosition() {
        return position;
    }

    /**
     * Check out {@link Space#getSymbol()}
     * @return symbol
     */
    @Override
    public Character getSymbol() {
        return symbol;
    }

}
