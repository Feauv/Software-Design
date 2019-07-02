import java.util.UUID;

/**
 * PostEncryptionPaymentRequest extends from {@link PostPaymentRequest} and has an encryption scheme
 *
 * @author Nick Grove
 */
public class PostEncryptedPaymentRequest extends PostPaymentRequest{

    /**
     * Encryption scheme
     */
    private String scheme;
    /**
     * Count of PostEncryptionPaymentRequest objects
     */
    private static int requestCount;

    /**
     * Initializes PostEncryptionPaymentRequest and initializes its super {@link PostPaymentRequest}. Adds to
     * {@link PostEncryptedPaymentRequest#requestCount}
     *
     * @param randUUID              Random UUID
     * @param randIP                Random IP
     * @param randPayment           Random Payment
     * @param randEncryptionScheme  Random Scheme
     */
    public PostEncryptedPaymentRequest(UUID randUUID, String randIP, Payment randPayment, String randEncryptionScheme) {

        super(randUUID,randIP,randPayment);

        this.scheme = randEncryptionScheme;

        requestCount++;

    }


    /**
     * @return Strings of all instance variables plus {@link PostPaymentRequest#instanceVariables()}
     */
    public String instanceVariables() {

        return super.instanceVariables() + "\nThis Payment was Encrypted Using: " + String.valueOf(this.scheme);

    }

    /**
     * @return {@link PostEncryptedPaymentRequest#requestCount}
     */
    public static int count() {
        return requestCount;
    }

}
