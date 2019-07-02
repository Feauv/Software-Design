/**
 * @author Nick Grove
 */
public class File {

    /**
     * File path
     */
    private String path;
    /**
     * File type
     */
    private String type;

    /**
     * Assign params to {@link File#path} and {@link File#type}
     *
     * @param randFilePath Random file path
     * @param randFileType Random file type
     */
    public File(String randFilePath, String randFileType) {

        this.path = randFilePath;
        this.type = randFileType;

    }

    /**
     * @return {@link File#path}
     */
    public String getPath() {
        return path;
    }

    /**
     * @return {@link File#type}
     */
    public String getType() {
        return type;
    }

}
