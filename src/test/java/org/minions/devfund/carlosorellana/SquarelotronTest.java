package org.minions.devfund.carlosorellana;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

/**
 * The goal is test the Squarelotron methods.
 *
 * @author Carlos Orellana.
 * @since 07/17/2018.
 */
public class SquarelotronTest {


    /**
     * Verifies if the new Squarelotron matrix has the expected size.
     */
    @Test
    public void testSquarelotronMatrixEqualsToSize() {
        final int size = 5;
        Squarelotron squarelotron = new Squarelotron(size);
        assertTrue(squarelotron.getSquarelotron().length == size);
    }

    /**
     * Verifies if Squarelotron has the number of rings expected.
     */
    @Test
    public void testSquarelotronSize5Contains3Rings() {
        final int size = 5;
        final int numberOfRings = 3;
        Squarelotron squarelotron = new Squarelotron(size);
        assertTrue(squarelotron.getMaxRings() == numberOfRings);
    }

    /**
     * Verify that UpsideDowFlip method return the expected result when select the Ring 1.
     */
    @Test
    public void TestUpsideDownFlipMethodRingOne() {
        final int [][] expectedMatrix = {
                {21,22,23,24,25},
                {16,7,8,9,20},
                {11,12,13,14,15},
                {6,17,18,19,10},
                {1,2,3,4,5}
        };

        final int size = 5;
        final int ring = 1;
        Squarelotron squarelotron = new Squarelotron(size);
        Squarelotron squarelotron1 = squarelotron.upsideDownFlip(ring);
        System.out.println(squarelotron1.toString());
        assertArrayEquals(expectedMatrix, squarelotron1.getSquarelotron());
    }

    /**
     * Verify that UpsideDowFlip method return the expected result when select the Ring 2.
     */
    @Test
    public void TestUpsideDownFlipMethodRinTwo() {
        final int [][] expectedMatrix = {
                {1,2,3,4,5},
                {6,17,18,19,10},
                {11,12,13,14,15},
                {16,7,8,9,20},
                {21,22,23,24,25}
        };

        final int size = 5;
        final int ring = 2;
        Squarelotron squarelotron = new Squarelotron(size);
        Squarelotron squarelotron1 = squarelotron.upsideDownFlip(ring);
        System.out.println(squarelotron1.toString());
        assertArrayEquals(expectedMatrix, squarelotron1.getSquarelotron());
    }

    /**
     * Verify that MainDiagonalFlip method return the expected result when select the Ring 1.
     */
    @Test
    public void TestMainDiagonalFlipMethodRingOne() {
        final int [][] expectedMatrix = {
                {1,6,11,16,21},
                {2,7,8,9,22},
                {3,12,13,14,23},
                {4,17,18,19,24},
                {5,10,15,20,25}
        };

        final int size = 5;
        final int ring = 1;
        Squarelotron squarelotron = new Squarelotron(size);
        Squarelotron squarelotron1 = squarelotron.mainDiagonalFlip(ring);
        System.out.println(squarelotron1.toString());
        assertArrayEquals(expectedMatrix, squarelotron1.getSquarelotron());
    }

    /**
     * Verify that rotateRight method return the expected result when select the Ring 1.
     */
    @Test
    public void TestMainDiagonalFlipMethodRinTwo() {
        final int [][] expectedMatrix = {
                {1,2,3,4,5},
                {6,7,12,17,10},
                {11,8,13,18,15},
                {16,9,14,19,20},
                {21,22,23,24,25}
        };
        final int size = 5;
        final int ring = 2;
        Squarelotron squarelotron = new Squarelotron(size);
        Squarelotron squarelotron1 = squarelotron.mainDiagonalFlip(ring);
        System.out.println(squarelotron1.toString());
        assertArrayEquals(expectedMatrix, squarelotron1.getSquarelotron());
    }

    /**
     * Verify that MainDiagonalFlip method return the expected result when select the Ring 1.
     */
    @Test
    public void TestRotateRightMethodRingOneRotate90Grades() {
        final int size = 5;
        final int turn = 1;
        final int [][] expectedMatrix = {
                {21,16,11,6,1},
                {22,17,12,7,2},
                {23,18,13,8,3},
                {24,19,14,9,4},
                {25,20,15,10,5}
        };

        Squarelotron squarelotron = new Squarelotron(size);
        squarelotron.rotateRight(turn);
        System.out.println(squarelotron.toString());
        assertArrayEquals(expectedMatrix, squarelotron.getSquarelotron());
    }

    /**
     * Verify that rotateRight method return the expected result when select the Ring 2.
     */
    @Test
    public void TestRotateRightMethodRinOneRotate270Grades() {
        final int size = 5;
        final int turn = 3;
        final int [][] expectedMatrix = {
                {21,16,11,6,1},
                {22,17,12,7,2},
                {23,18,13,8,3},
                {24,19,14,9,4},
                {25,20,15,10,5}
        };

        Squarelotron squarelotron = new Squarelotron(size);
        squarelotron.rotateRight(turn);
        System.out.println(squarelotron.toString());
        assertArrayEquals(expectedMatrix, squarelotron.getSquarelotron());
    }
}
