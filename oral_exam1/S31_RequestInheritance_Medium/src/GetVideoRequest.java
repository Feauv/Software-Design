import java.util.UUID;

/**
 * GetFileRequest extends from {@link GetRequest} in the case of a video request
 *
 * @author Nick Grove
 */
public class GetVideoRequest extends GetRequest{

    /**
     * Video variable
     */
    private Video video;
    /**
     * The count of GetVideoRequest objects made
     */
    private static int requestCount;

    /**
     * Initializes the a GetVideoRequest and its super {@link GetRequest}. Adds to {@link GetVideoRequest#requestCount}.
     *
     * @param randUUID Random UUID
     * @param randVideo Random Video
     */
    public GetVideoRequest(UUID randUUID, Video randVideo) {

        super(randUUID,randVideo.getUrl());

        this.video = randVideo;

        requestCount++;

    }

    /**
     * @return Strings of all instance variables plus {@link GetRequest#instanceVariables()}
     */
    public String instanceVariables() {

        return super.instanceVariables() + "\nVideo URL: " + String.valueOf(this.video.getUrl()) + "\n" + "Video Title: " +
                String.valueOf(this.getVideo().getTitle()) + "\n" + "By: " + String.valueOf(this.getVideo().getName());

    }
    /**
     * @return {@link GetVideoRequest#video}
     */
    public Video getVideo() {
        return video;
    }
    /**
     * @return {@link GetVideoRequest#requestCount}
     */
    public static int count() {
        return requestCount;
    }

}
