import java.util.UUID;

/**
 * @author Nick Grove
 */
public class Request{

    /**
     *
     */
    private UUID uuid;
    /**
     *
     */
    private static int requestCount;

    /**
     * @param randUUID
     */
    public Request(UUID randUUID) {

        this.uuid = randUUID;

        requestCount++;

    }

    /**
     * @return Strings of all instance variables, all subclasses converge on this method
     */
    public String instanceVariables() {

        return "UUID: " + String.valueOf(this.uuid);

    }

    /**
     * @return {@link Request#uuid}
     */
    public UUID getUuid() {
        return uuid;
    }

    /**
     * @return {@link Request#requestCount}
     */
    public static int count() {
        return requestCount;
    }
}
