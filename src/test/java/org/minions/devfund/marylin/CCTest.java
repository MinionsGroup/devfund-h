package org.minions.devfund.marylin;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Class to run unit test against CC.java class.
 */
public class CCTest {
    private CC cc;

    /**
     * Method to create an instance of CC class.
     */
    @Before
    public void setUp() {
        cc = new CC();
    }

    /**
     * Method to count all the lower case characters.
     */
    @Test
    public void testLowerCaseCharacters() {
        final int expectedResult = 4;
        assertEquals(expectedResult, cc.charCount("fizzbuzz", 'z'));

    }

    /**
     * Method to count the upper case characters.
     */
    @Test
    public void testUpperCaseCharacters() {
        final int expectedResult = 4;
        assertEquals(expectedResult, cc.charCount("FIZZBUZZ", 'z'));
    }

    /**
     * Method to to count the lower and upper case characters.
     */
    @Test
    public void testLowerAndUpperCaseCharacters() {
        final int expectedResult = 5;
        assertEquals(expectedResult, cc.charCount("fizZbuzZz", 'z'));
    }
}
