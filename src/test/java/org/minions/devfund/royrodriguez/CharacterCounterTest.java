package org.minions.devfund.royrodriguez;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests for https://www.codewars.com/kata/count-the-characters/ .
 */
public class CharacterCounterTest {

    /**
     * Basic code wars test.
     */
    @Test
    public void testSomething() {
        final int expected = 4;
        CharacterCounter characterCounter = new CharacterCounter();
        assertEquals(expected, characterCounter.charCount("fizzbuzz", 'z'));
        assertEquals(expected, characterCounter.charCount("FIZZBUZZ", 'z'));
    }
}
