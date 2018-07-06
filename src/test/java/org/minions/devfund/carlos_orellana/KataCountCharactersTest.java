package org.minions.devfund.carlos_orellana;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * The goal is test the count characters methods.
 *
 * @author Carlos Orellana.
 * @since 07/06/2018.
 */
public class KataCountCharactersTest {

    private KataCountCharacters kataCountCharacters;
    private static final int NUMBER_TWO = 2;
    private static final int NUMBER_THIRTY_THREE = 33;

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
        int numberCharacters = this.kataCountCharacters.countCharacteres("elephant", 'e');
        Assert.assertEquals(NUMBER_TWO, numberCharacters);
    }

    /**
     * Runs test case countCharacteresParagraphSentence.
     */
    @Test
    public void countCharacteresParagraphSentence() {
        String paragraph = "Set of features, qualities or circumstances that indicate the nature of a thing or the way "
                + "of thinking and acting of a person or a community, and by which it is distinguished from others.";
        int numberCharacters = this.kataCountCharacters.countCharacteres(paragraph, ' ');
        Assert.assertEquals(NUMBER_THIRTY_THREE, numberCharacters);
    }
}
