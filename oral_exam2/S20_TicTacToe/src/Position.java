/**
 * The Position class is convenient class to have for the pairing of coordinates on the board.
 */
public class Position {

    /**
     * Vertical coordinate
     */
    private final Integer vertical;
    /**
     * Horizontal coordinate
     */
    private final Integer horizontal;

    /**
     * Only constructor for a Position is inputting a vertical and horizontal coordinate.
     * @param vertical Inputted vertical coordinate
     * @param horizontal Inputted horizontal coordinate
     */
    public Position(Integer vertical, Integer horizontal) {
        this.vertical = vertical;
        this.horizontal = horizontal;
    }

    /**
     * @return Vertical coordinate
     */
    public Integer getVertical() { return vertical; }

    /**
     * @return Horizontal coordinate
     */
    public Integer getHorizontal() { return horizontal; }

}
