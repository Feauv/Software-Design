import java.util.UUID;

/**
 * GetFileRequest extends from {@link GetRequest} in the case of a file request
 *
 * @author Nick Grove
 */
public class GetFileRequest extends GetRequest{

    /**
     * File variable
     */
    private File file;
    /**
     * The count of GetFileRequest objects made
     */
    private static int requestCount;

    /**
     * Initializes the a GetFileRequest and its super {@link GetRequest}. Adds to {@link GetFileRequest#requestCount}.
     *
     * @param randUUID Random UUID
     * @param randFile Random File
     */
    public GetFileRequest(UUID randUUID, File randFile) {

        super(randUUID, randFile.getPath());

        this.file = randFile;

        requestCount++;

    }

    /**
     * @return Strings of all instance variables plus {@link GetRequest#instanceVariables()}
     */
    public String instanceVariables() {

        return super.instanceVariables() + "\nFile Path: " + String.valueOf(this.getFile().getPath()) + "\n" +
                "File Type: " + String.valueOf(this.getFile().getType());

    }

    /**
     * @return {@link GetFileRequest#file}
     */
    public File getFile() {
        return file;
    }

    /**
     * @return {@link GetFileRequest#requestCount}
     */
    public static int count() {
        return requestCount;
    }

}
