package org.minions.devfund;

import org.junit.Test;
import static org.junit.Assert.*;

public class Count_repeated_charactersTest {
    /**
     *
     */
    @Test
    public void testCountRepeatedCharacters(){
        assertEquals(4, Count_repeated_characters.charCount("fizzbuzz",'z'));
        assertEquals(4, Count_repeated_characters.charCount("FIZZBUZZ", 'z'));
        assertEquals(8, Count_repeated_characters.charCount("fizzbuzz FIZZBUZZ", 'z'));
    }
}