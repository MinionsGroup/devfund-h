package org.minions.devfund.richard;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Test Class.
 */
public class CircularPrimesTest {

    /**
     * Test.
     */
    @Test
    public void testFillListToCircularPrimes() {
        final int num = 100;
        final List<Integer> expectedResult = Arrays.asList(1, 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, 97);
        CircularPrimes prime = new CircularPrimes(num);
        prime.fillListToCircularPrimes();
        assertEquals(expectedResult, prime.getCircularPrimesList());
    }

    /**
     * Test.
     */
    @Test
    public void testFillListToCircularPrimesWithoutStrings() {
        final int num = 100;
        final List<Integer> expectedResult = Arrays.asList(1, 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, 97);
        CircularPrimes prime = new CircularPrimes(num);
        prime.fillListToCircularPrimesWithoutStrings();
        assertEquals(expectedResult, prime.getCircularPrimesList());
    }

    /**
     * Test.
     */
    @Test
    public void testGetLengthNumber() {
        final int one = 1;
        final int two = 2;
        final int three = 3;
        final int four = 4;
        final int teen = 10;
        final int ninetyNine = 99;
        final int hundred = 100;
        final int hundredOne = 101;
        final int oneThousand = 1000;
        CircularPrimes prime = new CircularPrimes(hundred);
        assertEquals(one, prime.getNumberOfDigits(one));
        assertEquals(two, prime.getNumberOfDigits(teen));
        assertEquals(two, prime.getNumberOfDigits(ninetyNine));
        assertEquals(three, prime.getNumberOfDigits(hundred));
        assertEquals(three, prime.getNumberOfDigits(hundredOne));
        assertEquals(four, prime.getNumberOfDigits(oneThousand));
    }

    /**
     * Test.
     */
    @Test
    public void testGetArrayOfNumbers() {
        final int hundred = 100;
        CircularPrimes prime = new CircularPrimes(hundred);
        final int teen = 10;
        final int[] arrayTeen = {1, 0};
        assertArrayEquals(arrayTeen, prime.getArrayOfNumbers(teen));
        final int eightyNine = 89;
        final int[] arrayEightyNine = {8, 9};
        assertArrayEquals(arrayEightyNine, prime.getArrayOfNumbers(eightyNine));
        final int hundredOne = 101;
        final int[] arrayHundredOne = {1, 0, 1};
        assertArrayEquals(arrayHundredOne, prime.getArrayOfNumbers(hundredOne));
        final int oneThousand = 1000;
        final int[] arrayOneThousand = {1, 0, 0, 0};
        assertArrayEquals(arrayOneThousand, prime.getArrayOfNumbers(oneThousand));

    }


    /**
     * Test.
     */
    @Test
    public void testReverseNumber() {
        final int one = 1;
        CircularPrimes prime = new CircularPrimes(one);
        assertEquals(one, prime.reverseNumber(one));
        final int two = 2;
        assertEquals(two, prime.reverseNumber(two));
        final int teen = 10;
        assertEquals(one, prime.reverseNumber(teen));
        final int eightyNine = 89;
        final int ninetyEight = 98;
        assertEquals(ninetyEight, prime.reverseNumber(eightyNine));
        final int hundred = 100;
        assertEquals(one, prime.reverseNumber(hundred));
        final int hundredOne = 101;
        assertEquals(hundredOne, prime.reverseNumber(hundredOne));
        final int oneThousand = 1000;
        assertEquals(one, prime.reverseNumber(oneThousand));
        final int num = 1324;
        final int expected = 4231;
        assertEquals(expected, prime.reverseNumber(num));

    }

}
