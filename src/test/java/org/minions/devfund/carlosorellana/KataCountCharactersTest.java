package org.minions.devfund.carlosorellana;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * The goal is test the count characters methods.
 *
 * @author Carlos Orellana.
 * @since 07/06/2018.
 */
public class KataCountCharactersTest {

    private KataCountCharacters kataCountCharacters;

    /**
     * Set ups method.
     */
    @Before
    public void setUp() {
        this.kataCountCharacters = new KataCountCharacters();
    }

    /**
     * Runs test case countCharacteresElephantSentence.
     */
    @Test
    public void countCharacteresElephantSentence() {
        final int expectedResult = 2;
        int numberCharacters = this.kataCountCharacters.countCharacteres("elephant", 'e');
        assertEquals(expectedResult, numberCharacters);
    }

    /**
     * Runs test case countCharacteresParagraphSentence.
     */
    @Test
    public void countCharacteresParagraphSentence() {
        final int expectedResult = 36;
        String paragraph = "Set of features, qualities or circumstances that indicate the nature of a thing or the way "
                + "of thinking and acting of a person or a community, and by which it is distinguished from others.";
        int numberCharacters = this.kataCountCharacters.countCharacteres(paragraph, ' ');
        assertEquals(expectedResult, numberCharacters);
    }

    /**
     * Runs test case countCharacteresMayusSentence.
     */
    @Test
    public void countCharacteresSentence() {
        final int expectedResult = 4;
        int numberCharacters = this.kataCountCharacters.countCharacteres("fizzbuzz", 'Z');
        assertEquals(expectedResult, numberCharacters);
    }
}
