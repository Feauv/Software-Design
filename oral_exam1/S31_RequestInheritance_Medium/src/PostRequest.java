import java.util.UUID;

/**
 * PostRequest extends from {@link Request} in order to post a request
 *
 * @author Nick Grove
 */
public class PostRequest extends Request{

    /**
     * IP variable
     */
    private String ip;
    /**
     * Count of PostRequest objects
     */
    private static int requestCount;

    /**
     * Initializes PostRequest and initializes its super {@link Request}. Adds to {@link PostRequest#requestCount}
     *
     * @param randUUID  Random UUID
     * @param randIP    Random IP
     */
    public PostRequest(UUID randUUID, String randIP) {

        super(randUUID);

        this.ip = randIP;

        requestCount++;

    }

    /**
     * @return
     */
    public String instanceVariables() {

        return super.instanceVariables() + "\nIP: " + String.valueOf(this.ip);

    }

    /**
     * @return
     */
    public static int count() {
        return requestCount;
    }

}
