package org.minions.devfund.carlosorellana;

import org.junit.Test;

/**
 * The goal is test the Squarelotron methods.
 *
 * @author Carlos Orellana.
 * @since 07/17/2018.
 */
public class SquarelotronTest {

    /**
     * Runs test case countCharacteresElephantSentence.
     */
    @Test
    public void countCharacteresElephantSentence() {
        final int size = 4;
        Squarelotron squarelotron = new Squarelotron(size);
        System.out.println(squarelotron.toString());
        squarelotron.buildArray();
        Squarelotron one = squarelotron.upsideDownFlip(2);
        System.out.println(one.toString());
    }
}
