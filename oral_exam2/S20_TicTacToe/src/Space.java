/**
 * An abstract class for a space, or position on a Tic Tac Toe board. The {@link Board} utilizes Spaces a lot.
 */
public abstract class Space {

    /**
     * @return The {@link Position} of the Space
     */
    abstract Position getPosition();

    /**
     * @return The symbol of the Space
     */
    abstract Character getSymbol();

}
