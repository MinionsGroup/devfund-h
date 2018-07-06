package org.minions.devfund.Benjamin;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test class.
 */
public class CountCharactersTest {
    /**
     * Unit test.
     */
    @Test
    public void testSomething() {
        final int expected = 4;
        assertEquals(expected, CountCharacters.charCount("fizzbuzz", 'z'));
        assertEquals(expected, CountCharacters.charCount("FIZZBUZZ", 'z'));
    }
}
