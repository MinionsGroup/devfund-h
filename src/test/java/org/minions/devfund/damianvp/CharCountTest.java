package org.minions.devfund.damianvp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests CountCharacters class.
 */
public class CharCountTest {
    /**
     * tests from Code wars.
     */
    @Test
    public void charCount() {
        final int expectedEight = 8;
        final int expectedFour = 4;

        CharCount charCounter = new CharCount();
        assertEquals(expectedEight, charCounter.characterCounter("fizzbuzz FIZZBUZZ", 'z'));
        assertEquals(expectedEight, charCounter.characterCounter("fizzbuzz FIZZBUZZ", 'Z'));
        assertEquals(expectedFour, charCounter.characterCounter("FIZZBUZZ", 'z'));
        assertEquals(0, charCounter.characterCounter("TEdff fdjfj 223", '1'));
        assertEquals(expectedFour, charCounter.characterCounter("TE00df0f f0djfj 223", '0'));
        assertEquals(0, charCounter.characterCounter("RRuyt 111000AAdda", (char) 0));
    }
}
