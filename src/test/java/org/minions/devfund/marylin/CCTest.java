package org.minions.devfund.marylin;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Class to run unit test against CC.java class.
 */
public class CCTest {

    /**
     * Method to count all the lower case characters.
     */
    @Test
    public void testLowerCaseCharacters() {
        CC cc = new CC();
        final int expectedResult = 4;
        assertEquals(expectedResult, cc.charCount("fizzbuzz", 'z'));

    }

    /**
     * Method to count the upper case characters.
     */
    @Test
    public void testUpperCaseCharacters() {
        CC cc = new CC();
        final int expectedResult = 4;
        assertEquals(expectedResult, cc.charCount("FIZZBUZZ", 'z'));
    }

    /**
     * Method to to count the lower and upper case characters.
     */
    @Test
    public void testLowerAndUpperCaseCharacters() {
        CC cc = new CC();
        final int expectedResult = 5;
        assertEquals(expectedResult, cc.charCount("fizZbuzZz", 'z'));
    }
}
