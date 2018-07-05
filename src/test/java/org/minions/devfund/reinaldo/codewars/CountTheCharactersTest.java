package org.minions.devfund.reinaldo.codewars;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by reinaldo on 05-07-18.
 */
public class CountTheCharactersTest {

    public static final int EXPECTEDRESULT = 4;

    /**
     * Replace examples and use TDD development by writing your own tests.
     */
    @Test
    public void testSomething() {
        assertEquals(EXPECTEDRESULT, CountTheCharacters.charCount("fizzbuzz", 'z'));
        assertEquals(EXPECTEDRESULT, CountTheCharacters.charCount("FIZZBUZZ", 'z'));
    }
}
