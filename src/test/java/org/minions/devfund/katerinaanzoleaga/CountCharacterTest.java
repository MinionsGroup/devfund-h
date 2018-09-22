package org.minions.devfund.katerinaanzoleaga;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test class definition.
 */
public class CountCharacterTest {

    /**
     * Verifies if charCount returns expected value for a certain strings.
     */
    @Test
    public void testCharCount() {
        CountCharacter charCount = new CountCharacter();
        int actualResult = charCount.charCount("fzi", 'z');
        assertEquals(1, actualResult);
        actualResult = charCount.charCount("fziz", 'z');
        assertEquals(2, actualResult);
        actualResult = charCount.charCount("", 'a');
        assertEquals(0, actualResult);
    }
}
