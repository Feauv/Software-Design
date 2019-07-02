import java.util.*;
import java.lang.String;

/**
 * Vigenere is a class that is used for Vigenere Cipher Encryption and Decryption. The way this type of encryption works is
 * by using the letters of a message you enter and a keyword.
 *
 * Example: If you enter the message "apple" and your keyword is "lemon" the first letter in the encrypted message
 * will be "l". Apple's first letter is easy for an example because what the encryption is doing is using the index of
 * the letters. So the first letter for "apple" is "a" and the first letter for "lemon" is "l", therefore the index for
 * "a" is 0 and the is index for "l" is 11. We then add these indexes together to get 11, and that is why the first
 * letter of the encrypted message is "l".
 *
 * This is why having the {@link Vigenere#vigenereGrid} is vital because we can use it for all possible letter
 * combinations.
 *
 * @author Nick Grove
 */
public class Vigenere {

    /**
     * The vigenerGrid instance variable is based of the "Vigenere Table". The "Vigenere Table" is used for Vigenere
     * Cipher Encryption and Decryption.
     */
    private Map<Character,Map<Character,Character>> vigenereGrid;


    /**
     * Default Constructor
     */
    Vigenere() { initGrid(); }

    /**
     * Initializes the "Vigenere Table" or {@link Vigenere#vigenereGrid}. This method first goes about
     * initializing the alphabet and then using that alphabet to put every possible letter combination into the {@link Vigenere#vigenereGrid}
     */
    private void initGrid() {

        Character[] alpha = new Character[26];
        for(int i = 0; i < alpha.length; i++)
            alpha[i] = (char)(65 + i);

        this.vigenereGrid = new HashMap<>();
        int cipherLetterIndex;

        for (int i = 0; i < alpha.length; i++) {
            for (int j = 0; j < alpha.length; j++) {

                cipherLetterIndex = i+j;
                if (cipherLetterIndex > 25)
                    cipherLetterIndex = cipherLetterIndex - 26;

                this.vigenereGrid.computeIfAbsent(alpha[i], k -> new HashMap<>());
                this.vigenereGrid.get(alpha[i]).put(alpha[j], alpha[cipherLetterIndex]);

            }

        }

    }

    /**
     * Returns the keyword put in a form that matches the message, so we can use the keyword for encryption/decryption.
     * Whenever we need to encrypt/decrypt using the "Vigenere Table"({@link Vigenere#vigenereGrid}), the keyword needs
     * to match the message.
     *
     * Example: If our message is "Hello World" and our keyword is "Java", using this method our keyword becomes
     * "JavaJ avaJa" to which is the same size and spacing as our message.
     *
     * @param k     Represents the keyword for encryption/decryption
     * @param m     Represents the message before encryption/decryption
     * @return      The keyword repeated to the correct size of the message and spaced to match the message
     */
    public char[] matchKeywordSizeToMessage(String k, String m) {

        char[] keywordSizeAdjusted = new char[m.length()];
        int count = 0;

        for(int i = 0; i < m.length(); i++) {

            if (m.charAt(i) == ' ') {

                keywordSizeAdjusted[i] = ' ';

            } else {

                keywordSizeAdjusted[i] = k.charAt(count);
                count++;

            }

            if (count >= k.length())
                count = 0;

        }

        return keywordSizeAdjusted;

    }

    /**
     * Returns an inputted String as a char array.
     *
     * @param s     Input String
     * @return      The input String as a char array
     */
    private char[] toCharArray(String s) {

        char[] charArray = new char[s.length()];
        s.getChars(0, s.length(), charArray, 0);
        return charArray;

    }


    /**
     * Returns a String that is the input message encrypted. To achieve this the method make a new char array and sets it
     * to the same size as the decrypted message. It then loops, and using the decrypted message and keyword along with
     * the {@link Vigenere#vigenereGrid} to assign the encrypted message its letters. Inside the loop spaces must be
     * accounted for as well.
     *
     * @param dM    Represents a decrypted message
     * @param k     Represents a keyword
     * @return      Vigenere Cipher Encryption of the decrypted message using the keyword and the {@link Vigenere#vigenereGrid}
     *
     */
    public String encrypt(String dM, String k) {

        dM = dM.toUpperCase();
        k = k.toUpperCase();

        char[] decryptedMessage = toCharArray(dM);
        char[] keyword = matchKeywordSizeToMessage(k, dM);

        char[] encryptedMessage = new char[decryptedMessage.length];

        for (int i = 0; i < decryptedMessage.length; i++) {

            if (decryptedMessage[i] == ' ') {
                encryptedMessage[i] = ' ';
                i++;
            }

            encryptedMessage[i] = this.vigenereGrid.get(decryptedMessage[i]).get(keyword[i]);

        }

        return String.valueOf(encryptedMessage);

    }

    /**
     * Returns a String that is the input message decrypted. Vigenere Dencryption is achieved by looping through the
     * {@link Vigenere#vigenereGrid} to find the keyword letter, and then indexing to where the encrypted message's
     * letter is. From doing this you have the map entry where the decrypted message letter is the key, therefore from
     * here the method gets the key of the entry.
     *
     * @param eM    Represents a encrypted message
     * @param k     Represents a keyword
     * @return      Vigenere Cipher Dencryption of the encrypted message using the keyword and the {@link Vigenere#vigenereGrid}
     */
    public String decrypt(String eM, String k) {

        eM = eM.toUpperCase();
        k = k.toUpperCase();

        char[] encryptedMessage = toCharArray(eM);
        char[] keyword = matchKeywordSizeToMessage(k, eM);

        char[] decryptedMessage = new char[encryptedMessage.length];

        for (int i = 0; i < encryptedMessage.length; i++) {

            if (encryptedMessage[i] == ' ') {
                decryptedMessage[i] = ' ';
                i++;
            }


            for (Map.Entry<Character, Character> entry : this.vigenereGrid.get(keyword[i]).entrySet())
                if (entry.getValue().equals(encryptedMessage[i]))
                    decryptedMessage[i] = entry.getKey();

        }

        return String.valueOf(decryptedMessage);

    }

    /**
     * The main method of the class, the constantly loops to ask for a keyword and message. Once the keyword and message
     * are entered in it encrypts the message and then decrypts back. This prints the encrypted message while also
     * showing that the encryption and decryption work correctly.
     *
     * @param args
     */
    public static void main(String args[]){

        Vigenere v = new Vigenere();
        Scanner input = new Scanner(System.in);
        String message, keyword;
        boolean loop = true;

        while (loop) {

            System.out.println("Encrypting/Decrypting Keyword: ");
            keyword = input.nextLine();

            System.out.println("Encrypting/Decrypting Message: ");
            message = input.nextLine();

            System.out.println("Encrypted: " + v.encrypt(message, keyword));
            message = v.encrypt(message,keyword);

            System.out.println("Decrypted: " + v.decrypt(message, keyword));
            System.out.println("\n");
            message = v.decrypt(message,keyword);

        }



    }



}
