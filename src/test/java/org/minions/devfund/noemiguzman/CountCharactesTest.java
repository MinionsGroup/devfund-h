package org.minions.devfund.noemiguzman;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
/**
 *  Tests CountCharacters class.
 */
public class CountCharactesTest {
    /**
     *  tests from Code wars.
     */
    @Test
    public void countChar() {
        final int expected = 4;
        CountCharacters countCharacter = new CountCharacters();
        assertEquals(expected, countCharacter.countChar("fizzbuzz", 'z'));
        assertEquals(expected, countCharacter.countChar("FIZZBUZZ", 'z'));
        assertEquals(expected, countCharacter.countChar("aFIaZaZBUAZZ", 'a'));
    }
}
