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
<<<<<<< HEAD
    public void testCountRepeatedChars() {
=======
    public void testCountRepeatedCharacters() {
>>>>>>> e0c6fc1035d9b96c4b1f29869d4d3acd596949bd
        Assert.assertEquals(CountRepeatedChars.FOUR, CountRepeatedChars.charCount("fizzbuzz", 'z'));
        Assert.assertEquals(CountRepeatedChars.FOUR, CountRepeatedChars.charCount("FIZZBUZZ", 'z'));
        Assert.assertEquals(CountRepeatedChars.EIGHT, CountRepeatedChars.charCount("fizzbuzz FIZZBUZZ", 'z'));
        Assert.assertNotEquals(CountRepeatedChars.TWO, CountRepeatedChars.charCount("fizzbuzz FIZZBUZZ", 'z'));
    }
}
