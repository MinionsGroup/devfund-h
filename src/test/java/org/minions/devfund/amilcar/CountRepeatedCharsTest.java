package org.minions.devfund.amilcar;

import org.junit.Assert;
import org.junit.Test;

/**
 * Class about the count repeated character test.
 */
public class CountRepeatedCharsTest {
    /**
     * Unit test method to valida the expected amount of characters.
     */
    @Test
    public void testCountRepeatedCharacters() {
        Assert.assertEquals(CountRepeatedChars.FOUR, CountRepeatedChars.charCount("fizzbuzz", 'z'));
        Assert.assertEquals(CountRepeatedChars.FOUR, CountRepeatedChars.charCount("FIZZBUZZ", 'z'));
        Assert.assertEquals(CountRepeatedChars.EIGHT, CountRepeatedChars.charCount("fizzbuzz FIZZBUZZ", 'z'));
        Assert.assertNotEquals(CountRepeatedChars.TWO, CountRepeatedChars.charCount("fizzbuzz FIZZBUZZ", 'z'));
    }
}
