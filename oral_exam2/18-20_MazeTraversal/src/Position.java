/**
 * A class that makes pairing coordinates easier
 */
public class Position {

    /**
     * Vertical coordinate
     */
    public Integer vertical;
    /**
     * Horizontal coordinate
     */
    public Integer horizontal;

    /**
     * The constructor for a position, sets the coordinates
     * @param vertical
     * @param horizontal
     */
    public Position(Integer vertical, Integer horizontal) {
        this.vertical = vertical;
        this.horizontal = horizontal;
    }

    /**
     * This method is called when a position needs to be changed
     * @param move The move is inputted as the change that is being made to the current position object
     * @return
     */
    public Position positionChange(Position move) {

        Integer vertical = this.vertical + move.vertical;
        Integer horizontal = this.horizontal + move.horizontal;

        return new Position(vertical,horizontal);

    }

    /**
     * @return String of the position
     */
    public String toString() {

        return "Current Position: " + Integer.toString(this.vertical) + " " + Integer.toString(this.horizontal);

    }

}
