/**
 * A BlankSpace is a space that nobody has played yet. It implements the abstract class {@link Space}, and this class
 * is used to initialize the {@link Board} with 9 spaces that have not been played on.
 */
public class BlankSpace extends Space {

    /**
     * The constant symbol for a BlankSpace
     */
    private final Character symbol = ' ';
    /**
     * The BlankSpace's position
     */
    private final Position position;

    /**
     * Constructor for a BlankSpace
     * @param vertical Vertical coordinate for Position
     * @param horizontal Horizontal coordinate for Position
     */
    BlankSpace(Integer vertical, Integer horizontal) {

        position = new Position(vertical,horizontal);

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
