package org.minions.devfund.richard;

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
    public void testCodeWars() {
        final int expectedFour = 4;
        final int expectedFive = 5;

        assertEquals(expectedFour, CountCharacters.countChar("fizzbuzz", 'z'));
        assertEquals(expectedFive, CountCharacters.countChar("Fancy fifth fly aloof", 'f'));
    }
}
