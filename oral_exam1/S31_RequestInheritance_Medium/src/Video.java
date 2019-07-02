/**
 * @author Nick Grove
 */
public class Video {

    /**
     * URL variable
     */
    private String url;
    /**
     * Title variable
     */
    private String title;
    /**
     * Name variable
     */
    private String name;

    /**
     * Initializes a Video object
     *
     * @param randURL           Random URL
     * @param randVideoTitle    Random Title
     * @param randName          Random Name
     */
    public Video(String randURL, String randVideoTitle, String randName) {

        this.url = randURL;
        this.title = randVideoTitle;
        this.name = randName;

    }

    /**
     * @return {@link Video#url}
     */
    public String getUrl() {
        return url;
    }

    /**
     * @return {@link Video#title}
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return {@link Video#name}
     */
    public String getName() {
        return name;
    }
}
