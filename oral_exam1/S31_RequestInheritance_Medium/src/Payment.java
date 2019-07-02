/**
 * Payment is a class that has all the normal aspects of payment: sender, amount, and receiver
 *
 * @author Nick Grove
 */
public class Payment {

    /**
     * Sender Name
     */
    private String name;
    /**
     * Payment Amount
     */
    private int nextInt;
    /**
     * Receiver Name
     */
    private String name1;

    /**
     * Initializes a payment
     *
     * @param randName      Random Name
     * @param nextInt       Random Amount
     * @param randName1     Random Name
     */
    public Payment(String randName, int nextInt, String randName1) {

        this.name = randName;
        this.nextInt = nextInt;
        this.name1 = randName1;

    }

    /**
     * @return {@link Payment#name}
     */
    public String getName() {
        return name;
    }

    /**
     * @return {@link Payment#nextInt}
     */
    public int getNextInt() {
        return nextInt;
    }

    /**
     * @return {@link Payment#name1}
     */
    public String getName1() {
        return name1;
    }
}
