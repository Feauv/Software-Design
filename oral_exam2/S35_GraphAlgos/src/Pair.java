/**
 * The Pair class gives us the ability to pair two objects together
 * @param <L> Left object
 * @param <R> Right object
 */
public class Pair<L,R> {

    /**
     * Left object of the Pair
     */
    private L left;
    /**
     * Right object of the Pair
     */
    private R right;

    /**
     * Pair can only be constructed one way and that is with a left object and right object
     * @param left Inputted left
     * @param right Inputted right
     */
    public Pair(L left, R right) {
        this.left = left;
        this.right = right;
    }

    /**
     * Left getter
     * @return left
     */
    public L getLeft() {
        return left;
    }

    /**
     * Left setter
     * @param left
     */
    public void setLeft(L left) {
        this.left = left;
    }

    /**
     * Right getter
     * @return right
     */
    public R getRight() {
        return right;
    }

    /**
     * Right setter
     * @param right
     */
    public void setRight(R right) {
        this.right = right;
    }
}
