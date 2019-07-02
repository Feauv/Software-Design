import java.util.UUID;

/**
 * GetRequest extends from {@link Request} in order to get a request
 *
 * @author Nick Grove
 */
public class GetRequest extends Request{

    /**
     * URL String
     */
    private String url;
    /**
     * Count of GetRequest objects
     */
    private static int requestCount;

    /**
     * Initializes a GetRequest and initializes its super {@link Request}. Adds to {@link GetRequest#requestCount}.
     *
     * @param randUUID Random UUID
     * @param randURL Random URL
     */
    public GetRequest(UUID randUUID, String randURL) {

        super(randUUID);

        this.url = randURL;

        requestCount++;

    }

    /**
     * @return {@link Request#instanceVariables()}
     */
    public String instanceVariables() {

        return super.instanceVariables();

    }

    /**
     * @return {@link GetRequest#url}
     */
    public String getUrl() {
        return url;
    }

    /**
     * @return {@link GetRequest#requestCount}
     */
    public static int count() {
        return requestCount;
    }

}
