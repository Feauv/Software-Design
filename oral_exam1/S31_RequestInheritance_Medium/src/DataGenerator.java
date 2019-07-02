import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

/**
 * DataGenerator is a class that randomly generates data for {@link Server}
 */
public class DataGenerator {

    /**
     * Random variable.
     */
    private Random rand;
    /**
     * Array of names for our data.
     */
    private String[] names;
    /**
     * Array of encryption schemes for our data.
     */
    private String[] encryption;
    /**
     * Array of video titles for our data.
     */
    private String[] videoTitles;
    /**
     * Array of file paths for our data.
     */
    private String[] filePaths;
    /**
     * Array of file types for our data.
     */
    private String[] fileTypes;
    /**
     * Array of colors for our data.
     */
    private String[] colors;

    /**
     * Initializes our Random object and all arrays.
     */
    DataGenerator() {
        // initialize with example data
        this.rand = new Random();
        this.names = new String[]{"Tom", "Guadalupe", "Tina", "Markus", "Michael", "Diego", "Mr. Patel", "Alex"};
        this.encryption = new String[]{"Vigenere", "One Time Pad", "RSA", "Diffie-Hellman"};
        this.videoTitles = new String[]{"Top 10 Cutest Cat Videos", "ONE Simple Trick to Pass SWD", "Java 101", "Pythonistas Pythoning with Pythons", "P == NP?!?!?!"};
        this.filePaths = new String[]{"/Users/abpwrs/puppies", "/Users/tomc/backstroke", "/Users/swd_student/question", "/Users/cie_student/question", "/Users/student/stress"};
        this.fileTypes = new String[]{"txt", "csv", "pptx", "pdf", "hs", "gif", "png", "h5"};
        this.colors = new String[]{"red", "orange", "yellow", "green", "blue", "indigo", "violet", "egg shell"};
    }

    /**
     * @return A random name from {@link DataGenerator#names}
     */
    private String getRandName() {
        return this.names[this.rand.nextInt(this.names.length)];
    }

    /**
     * @return A random color from {@link DataGenerator#colors}
     */
    private String getRandColor() {
        return this.colors[this.rand.nextInt(this.colors.length)];
    }

    /**
     * @return A random video title from {@link DataGenerator#videoTitles}
     */
    private String getRandVideoTitle() {
        return this.videoTitles[this.rand.nextInt(this.videoTitles.length)];
    }

    /**
     * @return A random file type from {@link DataGenerator#fileTypes}
     */
    private String getRandFileType() {
        return this.fileTypes[this.rand.nextInt(this.fileTypes.length)];
    }

    /**
     * @return A random file path from {@link DataGenerator#filePaths}
     */
    private String getRandFilePath() {
        return this.filePaths[this.rand.nextInt(this.filePaths.length)];
    }

    /**
     * @return A random URL
     */
    public String getRandURL() {
        return "localhost:" + (((this.rand.nextInt(9) + 1) * 1000) + this.rand.nextInt(999));
    }

    /**
     * @return A random payment
     */
    public Payment getRandPayment() {
        return new Payment(this.getRandName(), this.rand.nextInt(10000), this.getRandName());
    }

    /**
     * @return A random UUID
     */
    public UUID getRandUUID() {
        return UUID.randomUUID();
    }

    /**
     * @return A random encryption scheme
     */
    public String getRandEncryptionScheme() {
        return this.encryption[this.rand.nextInt(this.encryption.length)];
    }

    /**
     * @return A random video
     */
    public Video getRandVideo() {
        return new Video(this.getRandURL(), this.getRandVideoTitle(), this.getRandName());
    }

    /**
     * @return A random file
     */
    public File getRandFile() {
        return new File(this.getRandFilePath(), this.getRandFileType());
    }

    /**
     * @return A random form
     */
    public Form getRandForm() {
        HashMap<String, String> fields = new HashMap<>();
        fields.put("Favorite color", this.getRandColor());
        fields.put("Favorite encryption scheme", this.getRandEncryptionScheme());
        fields.put("Name", this.getRandName());
        return new Form(fields);
    }

    /**
     * @return A random IP
     */
    public String getRandIP() {
        return rand.nextInt(256) + "." + rand.nextInt(256) + "." + rand.nextInt(256) + "." + rand.nextInt(256);
    }

}
