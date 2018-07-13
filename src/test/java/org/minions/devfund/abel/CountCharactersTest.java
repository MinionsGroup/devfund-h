package org.minions.devfund.abel;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit Tests for CountCharacters.
 */
public class CountCharactersTest {

    /**
     * Sample test provided by CodeWars.
     */
    @Test
    public void testSomething() {
        final int expected = 4;

        assertEquals(expected, CountCharacters.charCount("fizzbuzz", 'z'));
        assertEquals(expected, CountCharacters.charCount("FIZZBUZZ", 'z'));
    }
}
