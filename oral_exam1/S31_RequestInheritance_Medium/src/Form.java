import java.util.HashMap;
import java.util.Map;

/**
 * Form is a class that is a form of randomly generated data
 *
 * @author Nick Grove
 */
public class Form {

    /**
     * The HashMap that is the "form"
     */
    private HashMap<String,String> fields;

    /**
     * Initializes {@link Form#fields}
     *
     * @param fields HashMap of random fields
     */
    public Form(HashMap<String, String> fields) {

        this.fields = fields;

    }

    /**
     * Called by the instanceVariables method to get the fields as a String.
     *
     * @return The {@link Form#fields} into a String
     */
    public String fieldsToString() {

        String fieldsAsString = "";

        for (Map.Entry<String,String> field : this.fields.entrySet()) {

            fieldsAsString = fieldsAsString + "\nLabel: " + field.getKey() + "\nValue: " + field.getValue();

        }

        return fieldsAsString;

    }


    /**
     * @return {@link Form#fields}
     */
    public HashMap<String, String> getFields() {
        return fields;
    }

}
