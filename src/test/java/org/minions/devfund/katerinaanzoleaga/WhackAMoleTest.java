package org.minions.devfund.katerinaanzoleaga;
/**
 * WhackAMole game tests.
 */

//import static org.junit.Assert.assertEquals;

//import com.sun.org.apache.xpath.internal.operations.Equals;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * The test cases.
 */
public class WhackAMoleTest {
    private static final int NUM_ATEMPTS = 10;
    private static final int GRID_DIMENSION = 4;
    private static final int OUT_OF_RANGE = 20;

    private WhackAMole whackAMole = new WhackAMole(NUM_ATEMPTS, GRID_DIMENSION);


    /**
     * Verifies if the constructor returns the expected values.
     */
    @Test
    public void whackAMoleConstructor() {
        assertEquals(NUM_ATEMPTS, whackAMole.getAttemptsLeft());
        char[][] otherGrid = new char[][]{
                {'*', '*', '*', '*'},
                {'*', '*', '*', '*'},
                {'*', '*', '*', '*'},
                {'*', '*', '*', '*'}};
        WhackAMole otherWhackAMole = new WhackAMole(NUM_ATEMPTS, GRID_DIMENSION);
        otherWhackAMole.setMoleGrid(otherGrid);
        assertTrue(whackAMole.equals(otherWhackAMole));
    }

    /**
     * Verifies if it is possible to place a mole in a valid possiton.
     */
    @Test
    public void placeWherePossible() {
        char[][] otherGrid = new char[][]{
                {'*', '*', '*', '*'},
                {'*', '*', 'M', '*'},
                {'*', '*', '*', '*'},
                {'*', '*', '*', '*'}};
        WhackAMole otherWhackAMole = new WhackAMole(NUM_ATEMPTS, GRID_DIMENSION);
        otherWhackAMole.setMoleGrid(otherGrid);
        assertTrue(whackAMole.place(1, 2));
        assertTrue(whackAMole.equals(otherWhackAMole));
    }

    /**
     * Verifies if it is NOT possible to place a mole in a NOT valid possiton.
     */
    @Test
    public void placeWhereNotPossible() {
        char[][] otherGrid = new char[][]{
                {'*', '*', '*', '*'},
                {'*', '*', '*', '*'},
                {'*', '*', '*', '*'},
                {'*', '*', '*', '*'}};
        WhackAMole otherWhackAMole = new WhackAMole(NUM_ATEMPTS, GRID_DIMENSION);
        otherWhackAMole.setMoleGrid(otherGrid);
        assertFalse(whackAMole.place(1, OUT_OF_RANGE));
        assertTrue(whackAMole.equals(otherWhackAMole));
    }

    /**
     * Verifies the effect of placing a Mole in a valid position.
     */
    @Test
    public void whackWerePosible() {
        char[][] otherGrid = new char[][]{
                {'*', '*', '*', '*'},
                {'*', '*', '*', '*'},
                {'*', '*', 'W', '*'},
                {'*', '*', '*', '*'}};
        WhackAMole otherWhackAMole = new WhackAMole(NUM_ATEMPTS, GRID_DIMENSION);
        otherWhackAMole.setMoleGrid(otherGrid);
        whackAMole.place(2, 2);
        whackAMole.whack(2, 2);
        assertEquals(NUM_ATEMPTS - 1, whackAMole.getAttemptsLeft());
        assertEquals(0, whackAMole.getMolesLeft());
        assertTrue(whackAMole.equals(otherWhackAMole));
    }

    /**
     * Verifies the effect of TRYING TO place a Mole in a NOT valid position.
     */

    @Test
    public void whackWereNotPosible() {
        char[][] otherGrid = new char[][]{
                {'*', '*', '*', '*'},
                {'*', '*', '*', '*'},
                {'*', '*', 'M', '*'},
                {'*', '*', '*', '*'}};
        WhackAMole otherWhackAMole = new WhackAMole(NUM_ATEMPTS, GRID_DIMENSION);
        otherWhackAMole.setMoleGrid(otherGrid);
        whackAMole.place(2, 2);
        whackAMole.whack(OUT_OF_RANGE, 2);
        assertEquals(NUM_ATEMPTS - 1, whackAMole.getAttemptsLeft());
        assertEquals(1, whackAMole.getMolesLeft());
        assertTrue(whackAMole.equals(otherWhackAMole));
    }

/*
    @Test
    public void printGridToUser() {
    }

    @Test
    public void printGrid() {
    }

    @Test
    public void placeNMoles() {
    }
*/
}
