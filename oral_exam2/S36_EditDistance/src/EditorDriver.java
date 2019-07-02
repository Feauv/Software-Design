import java.util.Scanner;

/**
 * This class just acts as a controller for the {@link Editor} class. It takes input from the user and implements that
 * input so the Editor can use it.
 */
public class EditorDriver {

    /**
     * Everything done inside this class is done inside the main method. User input, initializing an Editor object, and
     * calling the Editor to handle the input.
     * @param args
     */
    public static void main(String args[]) {

        Scanner input = new Scanner(System.in);

        System.out.println("Your base string: ");
        String str1 = input.nextLine();
        System.out.println("Your string that you are converting to: ");
        String str2 = input.nextLine();
        System.out.println("\n");

        Editor editor = new Editor(str1, str2);
        editor.driverHandler();

    }

}
