package org.minions.devfund.damianvp;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Test clas for Squarelotron.
 */
public class SquarelotronTest {
    /**
     * test of squarelotron constructor.
     */
    @Test
    public void testSquarelotronConstructorSize() {
        final int two = 2;
        final int three = 3;
        final int four = 4;
        Squarelotron se = new Squarelotron(two);
        assertEquals(two, se.getSize());
        assertEquals(1, se.getSquarelotron()[0][0]);
        assertEquals(two, se.getSquarelotron()[0][1]);
        assertEquals(three, se.getSquarelotron()[1][0]);
        assertEquals(four, se.getSquarelotron()[1][1]);
    }

    /**
     * squarelotron constructor test size 5.
     */
    @Test
    public void testSquarelotronConstructorSize2() {
        final int zero = 0;
        final int three = 3;
        final int four = 4;
        final int five = 5;
        final int twentyOne = 21;
        final int nineTeen = 19;
        Squarelotron se = new Squarelotron(five);
        assertEquals(five, se.getSize());
        assertEquals(twentyOne, se.getSquarelotron()[four][zero]);
        assertEquals(nineTeen, se.getSquarelotron()[three][three]);
    }

    /**
     * test rotate rigth 1 turn.testMainDiagonalFlipNewObject.
     */
    @Test
    public void testRotateRight1() {
        final int two = 2;
        final int three = 3;
        final int four = 4;
        Squarelotron se = new Squarelotron(two);
        se.rotateRight(1);
        assertEquals(three, se.getSquarelotron()[0][0]);
        assertEquals(1, se.getSquarelotron()[0][1]);
        assertEquals(four, se.getSquarelotron()[1][0]);
        assertEquals(two, se.getSquarelotron()[1][1]);
    }

    /**
     * test rotate rigth 2 turn.
     */
    @Test
    public void testRotateRight2() {
        final int three = 3;
        final int four = 4;
        Squarelotron se = new Squarelotron(2);
        se.rotateRight(2);
        assertEquals(four, se.getSquarelotron()[0][0]);
        assertEquals(three, se.getSquarelotron()[0][1]);
        assertEquals(2, se.getSquarelotron()[1][0]);
        assertEquals(1, se.getSquarelotron()[1][1]);
    }

    /**
     * test rotate rigth 3 turn.
     */
    @Test
    public void testRotateRight3() {
        final int three = 3;
        final int four = 4;
        Squarelotron se = new Squarelotron(2);
        se.rotateRight(three);
        assertEquals(2, se.getSquarelotron()[0][0]);
        assertEquals(four, se.getSquarelotron()[0][1]);
        assertEquals(1, se.getSquarelotron()[1][0]);
        assertEquals(three, se.getSquarelotron()[1][1]);
    }

    /**
     * test rotate rigth 4 turn.
     */
    @Test
    public void testRotateRight4() {
        final int three = 3;
        final int four = 4;
        final int five = 5;
        final int six = 6;
        final int nine = 9;
        Squarelotron se = new Squarelotron(three);
        se.rotateRight(four);
        assertEquals(three, se.getSquarelotron()[0][2]);
        assertEquals(six, se.getSquarelotron()[1][2]);
        assertEquals(nine, se.getSquarelotron()[2][2]);
        assertEquals(2, se.getSquarelotron()[0][1]);
        assertEquals(five, se.getSquarelotron()[1][1]);
    }

    /**
     * test rotate rigth 5 turn.
     */
    @Test
    public void testRotateRight5() {
        final int three = 3;
        final int four = 4;
        final int five = 5;
        final int nine = 9;
        final int thirteen = 13;
        final int sevenTeen = 17;
        Squarelotron se = new Squarelotron(five);
        se.rotateRight(five);
        assertEquals(sevenTeen, se.getSquarelotron()[1][1]);
        assertEquals(thirteen, se.getSquarelotron()[2][2]);
        assertEquals(nine, se.getSquarelotron()[three][three]);
        assertEquals(five, se.getSquarelotron()[four][four]);
    }

    /**
     * test rotate rigth 6 turn.
     */
    @Test
    public void testRotateRight6() {
        final int three = 3;
        final int six = 6;
        final int fifteen = 15;
        final int sixteen = 16;
        final int twentyOne = 21;
        final int twentyTwo = 22;
        Squarelotron se = new Squarelotron(six);
        se.rotateRight(six);
        assertEquals(twentyTwo, se.getSquarelotron()[2][2]);
        assertEquals(twentyOne, se.getSquarelotron()[2][three]);
        assertEquals(sixteen, se.getSquarelotron()[three][2]);
        assertEquals(fifteen, se.getSquarelotron()[three][three]);
    }

    /**
     * test of diagonal flip. original squarelotron not should change.
     */
    @Test
    public void testMainDiagonalFlipNewObject() {
        final int four = 4;
        final int five = 5;
        final int seven = 7;
        final int fifteen = 15;
        final int twentyOne = 21;
        final int twentyThree = 23;
        final int twentyFive = 25;
        Squarelotron se = new Squarelotron(five);
        Squarelotron se2 = se.mainDiagonalFlip(1);
        assertEquals(1, se.getSquarelotron()[0][0]);
        assertEquals(seven, se.getSquarelotron()[1][1]);
        assertEquals(five, se.getSquarelotron()[0][four]);
        assertEquals(twentyThree, se.getSquarelotron()[four][2]);
        assertEquals(twentyFive, se.getSquarelotron()[four][four]);
        assertEquals(fifteen, se.getSquarelotron()[2][four]);
        assertEquals(1, se2.getSquarelotron()[0][0]);
        assertEquals(seven, se2.getSquarelotron()[1][1]);
        assertEquals(twentyOne, se2.getSquarelotron()[0][four]);
        assertEquals(fifteen, se2.getSquarelotron()[four][2]);
        assertEquals(twentyFive, se2.getSquarelotron()[four][four]);
        assertEquals(twentyThree, se2.getSquarelotron()[2][four]);
    }

    /**
     * test main diagonal flip, dimension 5 and ring 1.
     */
    @Test
    public void testMainDiagonalFlipDimension5Ring1() {
        final int four = 4;
        final int five = 5;
        final int seven = 7;
        final int fifteen = 15;
        final int twentyOne = 21;
        final int twentyThree = 23;
        final int twentyFive = 25;
        Squarelotron se = new Squarelotron(five);
        se = se.mainDiagonalFlip(1);
        assertEquals(1, se.getSquarelotron()[0][0]);
        assertEquals(seven, se.getSquarelotron()[1][1]);
        assertEquals(twentyOne, se.getSquarelotron()[0][four]);
        assertEquals(fifteen, se.getSquarelotron()[four][2]);
        assertEquals(twentyFive, se.getSquarelotron()[four][four]);
        assertEquals(twentyThree, se.getSquarelotron()[2][four]);
    }

    /**
     * test main diagonal flip, dimension 5 and ring 2.
     */
    @Test
    public void testMainDiagonalFlipDimension5Ring2() {
        final int three = 3;
        final int five = 5;
        final int seven = 7;
        final int eight = 8;
        final int twelve = 12;
        final int thirteen = 13;
        final int fourteen = 14;
        Squarelotron se = new Squarelotron(five);
        se = se.mainDiagonalFlip(2);
        assertEquals(1, se.getSquarelotron()[0][0]);
        assertEquals(seven, se.getSquarelotron()[1][1]);
        assertEquals(thirteen, se.getSquarelotron()[2][2]);
        assertEquals(twelve, se.getSquarelotron()[1][2]);
        assertEquals(eight, se.getSquarelotron()[2][1]);
        assertEquals(fourteen, se.getSquarelotron()[three][2]);
    }

    /**
     * test main diagonal flip, dimension 5 and ring 3.
     */
    @Test
    public void testMainDiagonalFlipDimension5Ring3() {
        final int three = 3;
        final int four = 4;
        final int five = 5;
        final int seven = 7;
        final int thirteen = 13;
        final int eighteen = 18;
        final int nineteen = 19;
        final int twentyFive = 25;
        Squarelotron se = new Squarelotron(five);
        se = se.mainDiagonalFlip(three);
        assertEquals(1, se.getSquarelotron()[0][0]);
        assertEquals(seven, se.getSquarelotron()[1][1]);
        assertEquals(thirteen, se.getSquarelotron()[2][2]);
        assertEquals(nineteen, se.getSquarelotron()[three][three]);
        assertEquals(twentyFive, se.getSquarelotron()[four][four]);
        assertEquals(eighteen, se.getSquarelotron()[three][2]);
    }

    /**
     * test upside down flip, dimension 4 and ring 1.
     */
    @Test
    public void testUpsideDownFlipDimension1() {
        final int three = 3;
        final int four = 4;
        final int six = 6;
        final int eight = 8;
        final int nine = 9;
        final int thirteen = 13;
        final int fifteen = 15;
        Squarelotron se = new Squarelotron(four);
        se = se.upsideDownFlip(1);
        assertEquals(thirteen, se.getSquarelotron()[0][0]);
        assertEquals(fifteen, se.getSquarelotron()[0][2]);
        assertEquals(nine, se.getSquarelotron()[1][0]);
        assertEquals(six, se.getSquarelotron()[1][1]);
        assertEquals(eight, se.getSquarelotron()[2][three]);
        assertEquals(four, se.getSquarelotron()[three][three]);
    }

    /**
     * test upside down flip, dimension 4 and ring 2.
     */
    @Test
    public void testUpsideDownFlipDimension2() {
        final int three = 3;
        final int four = 4;
        final int six = 6;
        final int seven = 7;
        final int eleven = 11;
        final int thirteen = 13;
        final int fifteen = 15;
        Squarelotron se = new Squarelotron(four);
        se = se.upsideDownFlip(2);
        assertEquals(thirteen, se.getSquarelotron()[three][0]);
        assertEquals(fifteen, se.getSquarelotron()[three][2]);
        assertEquals(six, se.getSquarelotron()[2][1]);
        assertEquals(seven, se.getSquarelotron()[2][2]);
        assertEquals(eleven, se.getSquarelotron()[1][2]);
    }

    /**
     * test upside down flip, dimension 4 and ring 3.
     */
    @Test
    public void testUpsideDownFlipDimension3() {
        final int three = 3;
        final int four = 4;
        final int seven = 7;
        final int teen = 10;
        final int eleven = 11;
        final int thirteen = 13;
        final int fourteen = 14;
        final int fifteen = 15;
        Squarelotron se = new Squarelotron(four);
        se = se.upsideDownFlip(three);
        assertEquals(thirteen, se.getSquarelotron()[three][0]);
        assertEquals(fifteen, se.getSquarelotron()[three][2]);
        assertEquals(eleven, se.getSquarelotron()[2][2]);
        assertEquals(teen, se.getSquarelotron()[2][1]);
        assertEquals(fourteen, se.getSquarelotron()[three][1]);
        assertEquals(seven, se.getSquarelotron()[1][2]);
    }
}
