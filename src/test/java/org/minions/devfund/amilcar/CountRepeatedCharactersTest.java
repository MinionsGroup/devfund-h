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
        Assert.assertEquals(ConstantNumbers.FOUR, CountRepeatedCharacters.charCount("fizzbuzz", 'z'));
        Assert.assertEquals(ConstantNumbers.FOUR, CountRepeatedCharacters.charCount("FIZZBUZZ", 'z'));
        Assert.assertEquals(ConstantNumbers.EIGHT, CountRepeatedCharacters.charCount("fizzbuzz FIZZBUZZ", 'z'));
        Assert.assertNotEquals(ConstantNumbers.TWO, CountRepeatedCharacters.charCount("fizzbuzz FIZZBUZZ", 'z'));
    }
}
