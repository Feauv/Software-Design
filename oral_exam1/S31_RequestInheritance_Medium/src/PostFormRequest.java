import java.util.UUID;

/**
 * PostFormRequest extends from {@link PostRequest} in the case of a form
 *
 * @author Nick Grove
 */
public class PostFormRequest extends PostRequest{

    /**
     * Form variable
     */
    private Form form;
    /**
     * Count of PostFormRequest objects
     */
    private static int requestCount;

    /**
     * Initializes PostFormRequest and initializes its super {@link PostRequest}. Adds to
     * {@link PostFormRequest#requestCount}
     *
     * @param randUUID  Random UUID
     * @param randIP    Random IP
     * @param randForm  Random Form
     */
    public PostFormRequest(UUID randUUID, String randIP, Form randForm) {

        super(randUUID,randIP);

        this.form = randForm;

        requestCount++;

    }

    /**
     * @return Strings of all instance variables plus {@link PostRequest#instanceVariables()}
     */
    public String instanceVariables() {

        return super.instanceVariables() + String.valueOf(this.getForm().fieldsToString());

    }

    /**
     * @return {@link PostFormRequest#form}
     */
    public Form getForm() {
        return form;
    }

    /**
     * @return {@link PostFormRequest#requestCount}
     */
    public static int count() {
        return requestCount;
    }

}
