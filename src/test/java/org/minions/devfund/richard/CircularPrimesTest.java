package org.minions.devfund.richard;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Test Class.
 */
public class CircularPrimesTest {

    /**
     * Test.
     */
    @Test
    public void testCodeWars() {
        final int num = 100;
        final List<Integer> expectedResult = Arrays.asList(1, 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, 97);
        CircularPrimes prime = new CircularPrimes(num);
        prime.fillListToCircularPrimes();
        assertEquals(expectedResult, prime.getCircularPrimesList());
    }
}
