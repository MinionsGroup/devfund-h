package org.minions.devfund.danielmontecinos;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests CountCharacters class.
 */
public class CountCharactersTest {

    private CountCharacters countCharacters;

    /**
     * Creates a new CountCharacters object.
     */
    @Before
    public void setUp() {
        countCharacters = new CountCharacters();
    }

    /**
     * Checks if method returns expected value for a certain string.
     */
    @Test
    public void testCharCountStringOne() {
        final int actualResult = countCharacters.charCount("fizzbuzz", 'z');
        final int expectedResult = 4;

        assertEquals(expectedResult, actualResult);
    }

    /**
     * Checks if method returns expected value using another string.
     */
    @Test
    public void testCharCountStringTwo() {
        final int actualResult = countCharacters.charCount("Fancy fifth fly aloof", 'f');
        final int expectedResult = 5;

        assertEquals(expectedResult, actualResult);
    }
}
