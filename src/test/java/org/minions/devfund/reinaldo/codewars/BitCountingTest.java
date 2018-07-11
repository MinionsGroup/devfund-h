package org.minions.devfund.reinaldo.codewars;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by reinaldo on 08-07-18.
 */
public class BitCountingTest {

    /**
     * This is the testGame.
     */
    @Test
    public void testGame() {
        final int expected1 = 5;
        final int expected2 = 1;
        final int expected3 = 3;
        final int expected4 = 2;
        final int expected5 = 2;

        final int result1 = 1234;
        final int result2 = 4;
        final int result3 = 7;
        final int result4 = 9;
        final int result5 = 10;

        assertEquals(expected1, BitCounting.countBits(result1));
        assertEquals(expected2, BitCounting.countBits(result2));
        assertEquals(expected3, BitCounting.countBits(result3));
        assertEquals(expected4, BitCounting.countBits(result4));
        assertEquals(expected5, BitCounting.countBits(result5));
    }

}
