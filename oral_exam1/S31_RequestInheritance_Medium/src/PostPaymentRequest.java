import java.util.UUID;

/**
 * PostPaymentRequest extends from {@link PostRequest} in the case of a payment
 *
 * @author Nick Grove
 */
public class PostPaymentRequest extends PostRequest{

    /**
     * Payment variable
     */
    private Payment payment;
    /**
     * Count of PostPaymentRequest objects
     */
    private static int requestCount;

    /**
     * Initializes PostPaymentRequest and initializes its super {@link PostRequest}. Adds to
     * {@link PostPaymentRequest#requestCount}
     *
     * @param randUUID      Random UUID
     * @param randIP        Random IP
     * @param randPayment   Random Payment
     */
    public PostPaymentRequest(UUID randUUID, String randIP, Payment randPayment) {

        super(randUUID,randIP);

        this.payment = randPayment;

        requestCount++;

    }

    /**
     * @return Strings of all instance variables plus {@link PostRequest#instanceVariables()}
     */
    public String instanceVariables() {

        return super.instanceVariables() + "\nPayment Sender: " + String.valueOf(this.getPayment().getName()) + "\n" +
                "Payment Ammount: " + String.valueOf(this.getPayment().getNextInt() + "\n" + "Payment Receiver: " +
                String.valueOf(this.getPayment().getName1()));

    }

    /**
     * @return {@link PostPaymentRequest#payment}
     */
    public Payment getPayment() {
        return payment;
    }

    /**
     * @return {@link PostPaymentRequest#requestCount}
     */
    public static int count() {
        return requestCount;
    }

}
