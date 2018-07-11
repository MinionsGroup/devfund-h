package org.minions.devfund.amilcar;

import org.junit.Assert;
import org.junit.Test;

/**
 * Class about the count repeated character test.
 */
public class CountRepeatedCharactersTest {
    /**
     * Unit test method to valida the expected amount of characters.
     */
    @Test
    public void testCountRepeatedCharacters() {
        Assert.assertEquals(CountRepeatedCharacters.FOUR, CountRepeatedCharacters.charCount("fizzbuzz", 'z'));
        Assert.assertEquals(CountRepeatedCharacters.FOUR, CountRepeatedCharacters.charCount("FIZZBUZZ", 'z'));
        Assert.assertEquals(CountRepeatedCharacters.EIGHT, CountRepeatedCharacters.charCount("fizzbuzz FIZZBUZZ", 'z'));
        Assert.assertNotEquals(CountRepeatedCharacters.TWO, CountRepeatedCharacters.charCount("fizzbuzz FIZZBUZZ", 'z'));
    }
}
