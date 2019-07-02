import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * MachineLearningTest is class that is used to test the MachineLearning class of static methods. MachineLearningTest can
 * show you the implementation and the calculations of MachineLearning
 *
 * @author Nick Grove
 *
 * @see MachineLearning
 * @see Test
 * @see junit.framework.TestCase
 */
public class MachineLearningTest {

    /**
     * Tests the cosineSimilarity method from MachineLearning(Tests are for each assertEquals call). Tests: test two
     * positive vectors, test a vector with negative numbers to a vector with positive numbers, test two arrays that are of
     * different length (returns 0), test two arrays with larger numbers, and test for a divide by zero error.
     *
     * {@link MachineLearning#cosineSimilarity(float[], float[])}
     * @see Test
     * @see junit.framework.TestCase
     */
    @Test
    public void testCosineSimilarity () {

        float testArrayA[] = {1,2,3}, testArrayB[] = {2,6,3};

        // Given Test
        assertEquals(0.8781441f, MachineLearning.cosineSimilarity(testArrayA,testArrayB));

        // Negative Numbers Test
        testArrayA = new float[] {-5,-2,-3};
        testArrayB = new float[] {5,9,2};
        assertEquals(-0.75789315f, MachineLearning.cosineSimilarity(testArrayA,testArrayB));

        // Different Array Size Test
        testArrayA = new float[] {0,1,2};
        testArrayB = new float[] {0,1};
        assertEquals(0.0f, MachineLearning.cosineSimilarity(testArrayA,testArrayB));

        // Larger Numbers Test
        testArrayA = new float[] {10, 43, 32};
        testArrayB = new float[] {55, 23, 0};
        assertEquals(0.47345906f, MachineLearning.cosineSimilarity(testArrayA,testArrayB));

        // Divide by Zero Test
        testArrayA = new float[] {0, 0, 0};
        testArrayB = new float[] {0, 0, 0};
        assertEquals(0.0f, MachineLearning.cosineSimilarity(testArrayA,testArrayB));

    }

    /**
     * Tests the euclideanDistance method from MachineLearning(Tests are for each assertEquals call). Tests: test two
     * positive vectors, test a vector with negative numbers to a vector with positive numbers, test two arrays that are
     * of different length (returns 0), test two arrays with larger numbers, and test with a vector that has no distance.
     *
     * {@link MachineLearning#euclideanDistance(float[], float[])}
     * @see Test
     * @see junit.framework.TestCase
     */
    @Test
    public void testEuclideanDistance () {

        float testArrayA[] = {1,2,3}, testArrayB[] = {2,6,3};

        // Given Test
        assertEquals(4.123105625617661, MachineLearning.euclideanDistance(testArrayA, testArrayB));

        // Negative Numbers Test
        testArrayA = new float[] {-5,-2,-3};
        testArrayB = new float[] {5,9,2};
        assertEquals(15.684387141358123, MachineLearning.euclideanDistance(testArrayA, testArrayB));

        // Different Array Size Test
        testArrayA = new float[] {0,1,2};
        testArrayB = new float[] {0,1};
        assertEquals(0.0, MachineLearning.euclideanDistance(testArrayA,testArrayB));

        // Larger Numbers Test
        testArrayA = new float[] {10, 43, 32};
        testArrayB = new float[] {55, 23, 0};
        assertEquals(58.728187440104094, MachineLearning.euclideanDistance(testArrayA,testArrayB));

        // From Origin Test
        testArrayA = new float[] {0, 0, 0};
        testArrayB = new float[] {0, 3, 5};
        assertEquals(5.830951894845301, MachineLearning.euclideanDistance(testArrayA,testArrayB));

    }

    /**
     * Tests the cosineSimilarity and euclideDistance methods from MachineLearning together to check that the methods do
     * not change the arrays (vectors).
     *
     * {@link MachineLearning#cosineSimilarity(float[], float[])}, {@link MachineLearning#euclideanDistance(float[], float[])}
     * @see Test
     * @see junit.framework.TestCase
     */
    @Test
    public void testCosAndEucTogether () {

        float testArrayA[] = {5,1,7}, testArrayB[] = {8,4,3};

        // Test to see if methods change the array's values
        assertEquals(0.79558706f, MachineLearning.cosineSimilarity(testArrayA,testArrayB));
        assertEquals(5.830951894845301, MachineLearning.euclideanDistance(testArrayA,testArrayB));

    }

    /**
     * Tests the hammingDistance method from MachineLearning(Tests are for each assertEquals call). Tests: test a normal
     * pair of codes, do another a test that is the same way, test two codes that are completely different, test two
     * codes that are the exact same, and test two codes that are different lengths (returns 0)
     *
     * {@link MachineLearning#hammingDistance(String, String)}
     * @see Test
     * @see junit.framework.TestCase
     */
    @Test
    public void testHammingDistance () {

        String testA = "0110101", testB = "1110010";

        // Given Test
        assertEquals(4,MachineLearning.hammingDistance(testA,testB));

        testA = "10101010";
        testB = "11010100";
        assertEquals(6, MachineLearning.hammingDistance(testA,testB));

        // Completely Different Test
        testA = "1111111111";
        testB = "0000000000";
        assertEquals(testA.length(), MachineLearning.hammingDistance(testA,testB));

        // Completely Same Test
        testA = "0000000000";
        assertEquals(0, MachineLearning.hammingDistance(testA,testB));

        // Different Size String Test
        testA = "1010";
        testB = "11010100";
        assertEquals(0, MachineLearning.hammingDistance(testA,testB));

    }

}