package org.minions.devfund.benjamin;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * It is in charge to define CountCharacters class unit tests.
 */
public class CountCharactersTest {

    /**
     * Asserts character count method with basic inputs.
     */
    @Test
    public void testCountCharacters() {
        final int expected = 4;
        assertEquals(expected, CountCharacters.charCount("fizzbuzz", 'z'));
        assertEquals(expected, CountCharacters.charCount("FIZZBUZZ", 'z'));
    }
}
