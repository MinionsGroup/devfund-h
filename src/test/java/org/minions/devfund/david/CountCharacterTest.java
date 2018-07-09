package org.minions.devfund.david;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Class test Count Character methods.
 */
public class CountCharacterTest {

    /**
     * Code wars tests.
     */
    @Test
    public void countChar() {
        final int expected = 4;
        CountCharacter countCharacter = new CountCharacter();
        assertEquals(expected, countCharacter.countChar("fizzbuzz", 'z'));
        assertEquals(expected, countCharacter.countChar("FIZZBUZZ", 'z'));
    }
}
