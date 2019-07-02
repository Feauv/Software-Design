import java.util.Arrays;

import static java.lang.Math.*;

/**
 * MachineLearning is a class that contains methods for Machine Learning calculations. Much like the class java.lang.Math,
 * there are no instance variables and all the methods are static. Therefore the MachineLearning class is not meant to
 * have a class. It is meant to type MachineLearing and then dot(.) whatever method you want to use.
 *
 * @author Nick Grove
 */
public class MachineLearning {

    /**
     * Returns the Cosine Similarity between two vectors. Cosine Similarity is the cosine of the angle between two vectors.
     * The calculation is done by calculating the Dot Product between the two vectors and dividing that by the
     * multiplication of the two vectors' Magnitudes.
     *
     * @param A     Represents vector A in a Cosine Similarity calculation
     * @param B     Represents vector B in a Cosine Similarity calculation
     * @return      Cosine of the angle between vector A(float array A) and vector B(float array B)
     */
    static float cosineSimilarity(float [] A, float [] B){

        // Size Check
        try {
            int ASumforMag = 0, BSumforMag = 0, dotProduct = 0;
            double magA, magB;

            // Iterate through the values of both lists
            for (int i = 0; i < A.length; i++) {

                // Add to dot product
                dotProduct += A[i] * B[i];

                // Square number and add to a sum for magnitude calculation
                ASumforMag += pow(A[i], 2);
                BSumforMag += pow(B[i], 2);

            }

            // Calculate magnitude for each
            magA = pow(ASumforMag, .5);
            magB = pow(BSumforMag, .5);

            // Divide by Zero Check
            if (magA == 0 || magB == 0)
                return 0;

            // Return final calculation
            return dotProduct / (float) (magA * magB);

        } catch (ArrayIndexOutOfBoundsException e) {
            return 0;
        }

    }

    /**
     * Returns the Euclidean Distance between two vectors. If we were to take vector A and
     * vector B and line them up so they were the legs of a right triangle, the Euclidean Distance would be the
     * hypotenuse. The calculation is done by first taking the x, y, and z components (x and y for a plane) of vector
     * B minus the corresponding components in vector A (eg. (xB - xA)), and then secondly taking those components and
     * do a magnitude calculation on them.
     *
     * @param A     Represents vector A in a Euclidean Distance calculation
     * @param B     Represents vector B in a Euclidean Distance calculation
     * @return      The length of segment that would connect vector A(float array A) and vector B(float array B)
     */
    static double euclideanDistance(float [] A, float [] B){

        // Size Check
        try {

            double euclidSum = 0;

            // Iterate through each value and calculate to add to each sum
            for (int i = 0; i < A.length; i++)
                euclidSum += pow((A[i] - B[i]), 2);

            // Return square root calculation of our sum
            return pow(euclidSum, .5);

        } catch (ArrayIndexOutOfBoundsException e) {
            return 0;
        }

    }

    /**
     * Returns the Hamming Distance between two binary codes. Hamming Distance is the number of indexes that two binary
     * codes differ by.
     *
     * Example: A = 1010, B = 1001 - The Hamming Distance between the two codes is 2 because the codes differ at index 2 (A = 1, B = 0) and index 3
     * (A = 0, B = 1)
     *
     * @param A     Represents binary code A
     * @param B     Represents binary code B
     * @return      How many indexes where the two codes differ
     */
    // Hamming Distance Method
    static int hammingDistance(String A, String B){

        // Size Check
        if(A.length() != B.length())
            return 0;

        int hD = 0;

        // Iterate though the String and check for any positions that are not equal
        for (int i = 0; i < A.length(); i++)
            if (A.charAt(i) != B.charAt(i))
                hD++;

        return hD;

    }

}
