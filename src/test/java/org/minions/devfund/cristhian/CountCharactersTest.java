package org.minions.devfund.cristhian;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * CountCharactersTest class.
 */
public class CountCharactersTest {
    /**
     * Testing class.
     */
    @Test
    public void testSomething() {
        final int expected = 4;
        assertEquals(expected, CountCharacters.charCount("fizzbuzz", 'z'));
        assertEquals(expected, CountCharacters.charCount("FIZZBUZZ", 'z'));
    }
}
