import java.util.UUID;

/**
 * PostEncryptionFormRequest extends from {@link PostFormRequest} and has an encryption scheme
 *
 * @author Nick Grove
 */
public class PostEncryptedFormRequest extends PostFormRequest {

    /**
     * Encryption scheme
     */
    private String scheme;
    /**
     * Count of PostEncryptionFormRequest objects
     */
    private static int requestCount;

    /**
     * Initializes PostEncryptionFormRequest and initializes its super {@link PostFormRequest}. Adds to
     * {@link PostEncryptedFormRequest#requestCount}
     *
     * @param randUUID              Random UUID
     * @param randIP                Random IP
     * @param randForm              Random Form
     * @param randEncryptionScheme  Random Scheme
     */
    public PostEncryptedFormRequest(UUID randUUID, String randIP, Form randForm, String randEncryptionScheme) {

        super(randUUID,randIP,randForm);

        this.scheme = randEncryptionScheme;

        requestCount++;

    }

    /**
     * @return Strings of all instance variables plus {@link PostFormRequest#instanceVariables()}
     */
    public String instanceVariables() {

        return super.instanceVariables() + "\nThis Form was Encrypted Using: " + String.valueOf(this.scheme);

    }

    /**
     * @return {@link PostEncryptedFormRequest#requestCount}
     */
    public static int count() {
        return requestCount;
    }

}
