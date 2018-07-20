package org.minions.devfund.carlosorellana;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * The goal is test the Squarelotron methods.
 *
 * @author Carlos Orellana.
 * @since 07/17/2018.
 */
public class SquarelotronTest {

    /**
     * Validates Matriz.
     */
    @Test
    public void countCharactersElephantSentence() {
        final int size = 5;
        final int ringNumber = 2;
        Squarelotron squarelotron = new Squarelotron(size);
        System.out.println(squarelotron.toString());
        Squarelotron one = squarelotron.upsideDownFlip(ringNumber);
        System.out.println(one.toString());
        Squarelotron two = squarelotron.mainDiagonarlFlip(ringNumber);
        System.out.println(two.toString());
    }

    /**
     * Validates Matriz size.
     */
    @Test
    public void validatesMatrixSize() {
        final int size = 6;
        Squarelotron squarelotron = new Squarelotron(size);
        int[] actualArraySize = squarelotron.buildArray();
        assertTrue((size * size) == actualArraySize.length);
    }
}
