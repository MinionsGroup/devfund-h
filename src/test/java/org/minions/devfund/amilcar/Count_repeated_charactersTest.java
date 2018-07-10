package org.minions.devfund.amilcar;

import org.junit.Assert;
import org.junit.Test;


public class Count_repeated_charactersTest {
    /**
     *
     */
    @Test
    public void testCountRepeatedCharacters(){
        Assert.assertEquals(4, Count_repeated_characters.charCount("fizzbuzz",'z'));
        Assert.assertEquals(4, Count_repeated_characters.charCount("FIZZBUZZ", 'z'));
        Assert.assertEquals(8, Count_repeated_characters.charCount("fizzbuzz FIZZBUZZ", 'z'));
        Assert.assertNotEquals(2, Count_repeated_characters.charCount("fizzbuzz FIZZBUZZ", 'z'));
    }
}