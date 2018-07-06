package org.minions.devfund.JoseEguivar;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * My second javadoc.
 */

public class CountCharactersTest {
    /**
     * CountCharacters test.
     */
    @Test
    public void testSomething() {
        final int out = 4;
        assertEquals(out, CountCharacters.charCount("fizzbuzz", 'z'));
        assertEquals(out, CountCharacters.charCount("FIZZBUZZ", 'z'));
    }
}

