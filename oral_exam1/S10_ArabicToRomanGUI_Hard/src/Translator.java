import java.util.ArrayList;
import java.util.List;

/**
 * Translator is a class that deals with the logic of converting from Arabic to Roman Numerals and vice versa. Translator
 * is able to detect if it is Arabic or Roman and also validate Roman Numerals. (Arabic to Roman conversion assumes that
 * Arabic integer is between 1-3999)
 *
 * @author Nick Grove
 */
public class Translator {

    /**
     * List of all possible numerals
     */
    private final List<Character> numerals;
    /**
     * List of all possible numbers
     */
    private final List<Character> numeric;

    /**
     * Initializes the numeral and number lists
     */
    Translator() {

        this.numerals = initNumerals();
        this.numeric = initNumeric();

    }

    /**
     * Uses ASCII code to retrieve all the possible Roman numerals
     *
     * @return All possible numerals as a list
     */
    private List<Character> initNumerals() {

        List<Character> a = new ArrayList<>();

        a.add(new Character(((char)(67))));
        a.add(new Character(((char)(73))));
        a.add(new Character(((char)(76))));
        a.add(new Character(((char)(77))));
        a.add(new Character(((char)(86))));
        a.add(new Character(((char)(88))));

        return a;

    }

    /**
     * Uses ASCII code to retrieve all the possible Arabic numbers;
     *
     * @return All possible numbers as a list
     */
    private List<Character> initNumeric() {

        List<Character> n = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            n.add(new Character(((char) (48 + i))));
        }

        return n;

    }

    /**
     * Detects the language of what was entered on the {@link Window} side of things. Takes a char array and iterates
     * through that array. Whatever the first language that is found is, that is the precedent set for the rest of the
     * array. As we iterate through the loop we keep checking to that original language we detect. If the language
     * stays the same throughout the array then we have a valid input. If we catch difference the language is marked as
     * "Invalid".
     *
     * @param typedChars    Char array of the input text area from {@link Window}
     * @return              String of the detected language from the char array
     */
    public String detectLanguage(char typedChars[]) {

        String curLang = "";
        String newLang;

        for (char num : typedChars) {

            if (numerals.contains(num)) {

                newLang = "Roman";

                if (curLang == "") {
                    curLang = "Roman";
                } else if (newLang == curLang) {
                    curLang = "Roman";
                } else {
                    return "Invalid";
                }

            } else if (numeric.contains(num)) {

                newLang = "Arabic";

                if (curLang == "") {
                    curLang = "Arabic";
                } else if (newLang == curLang) {
                    curLang = "Arabic";
                } else {
                    return "Invalid";
                }

            } else {

                return "Invalid";
            }

        }

        return curLang;

    }

    /**
     * Gets an int from {@link Window#inputArea} and translates it a Roman numerals. Use of
     * {@link Translator#numericChars(int)} to get the highest number that the integer is greater than or equal to, as
     * a char. Use of {@link Translator#numericInt(int)} to do the same thing but to get an integer. If statement checks
     * if the input number equals what is returned from {@link Translator#numericInt(int)}. If the recusive call does not
     * happen and the numerals variable is return. If not there is a recursive call plus the current numerals. A
     * recursive call works great here but can keep getting the highest number available from the input integer and then
     * when it equals the highest number, you can just return back all the Strings that were accumulate, and then a
     * Roman numeral is return.
     *
     * @param number    Arabic integer
     * @return          Roman numerals
     */
   public String toRoman(int number) {

        String numerals =  numericChars(number);
        int highestNumeralBelowInt = numericInt(number);

        if (number == highestNumeralBelowInt)
            return numerals;

        return numerals + toRoman(number-highestNumeralBelowInt);

    }

    /**
     * Gets a char array from {@link Window#inputArea} and translates to an Arabic integer. The method first starts with
     * the call of {@link Translator#numeralValidation(char[])} to validate the Roman numerals. If invalid it returns that,
     * but if it is valid the method continues. A for loop iterates through the array and there is an if else that
     * constantly checks for numerals that something like a 4, 9, 40, etc. The reason this check is done is because
     * many Roman numeral pairs have a numeral that is a number above them paired with a number that subtracts the
     * difference, such as 4 is IV. Once the Arabic integer is accumulated it is made a String and returned.
     *
     * @param typedChars    Roman numerals
     * @return              Arabic integer
     */
    public String toArabic(char typedChars[]) {

        if (!(numeralValidation(typedChars))) {
            return "Not a valid Roman Numeral";
        }

        int arabicInt = 0;

        for (int i = 0; i < typedChars.length; i++) {

            int symbol1 = numeralValue(typedChars[i]);

            if (i+1 < typedChars.length) {

                int symbol2 = numeralValue(typedChars[i+1]);

                if (symbol1 >= symbol2) {
                    arabicInt += symbol1;
                } else {
                    arabicInt += symbol2 - symbol1;
                    i++;
                }

            } else {

                arabicInt += symbol1;
                i++;
                
            }

        }

        return Integer.toString(arabicInt);

    }

    /**
     * Called by {@link Translator#toRoman(int)} to get the highest numeral that the int is greater than or equal to.
     *
     * @param num   Arabic integer
     * @return      Highest numeral that num is greater than or equal to
     */
    private String numericChars(int num) {

        if (num >= 1000) {
            return "M";
        } else if (num >= 900) {
            return "CM";
        } else if (num >= 500) {
            return "D";
        } else if (num >= 400) {
            return "CD";
        } else if (num >= 100) {
            return "C";
        } else if (num >= 90) {
            return "XC";
        } else if (num >= 50) {
            return "L";
        } else if (num >= 40) {
            return "XL";
        } else if (num >= 10) {
            return "X";
        } else if (num >= 9) {
            return "IX";
        } else if (num >= 5) {
            return "V";
        } else if (num >= 4) {
            return "IV";
        } else if (num >= 1) {
            return "I";
        } else {
            return "";
        }

    }

    /**
     * Called by {@link Translator#toRoman(int)} to get the highest number that the int is greater than or equal to.
     *
     * @param num   Arabic integer
     * @return      Highest number that num is greater than or equal to
     */
    private int numericInt(int num) {

        if (num >= 1000) {
            return 1000;
        } else if (num >= 900) {
            return 900;
        } else if (num >= 500) {
            return 500;
        } else if (num >= 400) {
            return 400;
        } else if (num >= 100) {
            return 100;
        } else if (num >= 90) {
            return 90;
        } else if (num >= 50) {
            return 50;
        } else if (num >= 40) {
            return 40;
        } else if (num >= 10) {
            return 10;
        } else if (num >= 9) {
            return 9;
        } else if (num >= 5) {
            return 5;
        } else if (num >= 4) {
            return 4;
        } else if (num >= 1) {
            return 1;
        } else {
            return 0;
        }

    }

    /**
     * Called by {@link Translator#toArabic(char[])} to validate numerals. Two basic rules of Roman numerals are
     * in use here: 1 - V, L, and D can each only happen once; 2 - I, X, C, and M can only happens 3 times (in a row).
     * A switch statement inside a for loop with few count variables is used to achieve this outcome.
     *
     * @param numerals  Char array of numerals
     * @return          Boolean if it is valid or not
     */
    private boolean numeralValidation(char numerals[]) {

        int VCount = 0, LCount = 0, DCount = 0;
        int IThruMCount = 0;
        char lastChar = ' ';

        for (char numeral : numerals) {

            switch (numeral) {

                case 'V':
                    VCount++;
                    if (VCount > 1) {
                        return false;
                    }
                    break;
                case 'L':
                    LCount++;
                    if (LCount > 1) {
                        return false;
                    }
                    break;
                case 'D':
                    DCount++;
                    if (DCount > 1) {
                        return false;
                    }
                    break;
                case 'I':
                    if (numeral == lastChar) {
                        IThruMCount++;

                        if (IThruMCount > 3) {
                            return false;
                        }
                    } else {
                        IThruMCount = 0;
                        IThruMCount++;
                        lastChar = numeral;
                    }
                    break;
                case 'X':
                    if (numeral == lastChar) {
                        IThruMCount++;

                        if (IThruMCount > 3) {
                            return false;
                        }
                    } else {
                        IThruMCount = 0;
                        IThruMCount++;
                        lastChar = numeral;
                    }
                    break;
                case 'C':
                    if (numeral == lastChar) {
                        IThruMCount++;

                        if (IThruMCount > 3) {
                            return false;
                        }
                    } else {
                        IThruMCount = 0;
                        IThruMCount++;
                        lastChar = numeral;
                    }
                    break;
                case 'M':
                    if (numeral == lastChar) {
                        IThruMCount++;

                        if (IThruMCount > 3) {
                            return false;
                        }
                    } else {
                        IThruMCount = 0;
                        IThruMCount++;
                        lastChar = numeral;
                    }
                    break;

            }

        }

        return true;

    }

    /**
     * Called by {@link Translator#toArabic(char[])} to get the numerical value of a numeral.
     *
     * @param numeral   Roman numeral
     * @return          Int value of the numeral
     */
    private int numeralValue(char numeral) {

        switch (numeral) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return -1;
        }

    }

}
