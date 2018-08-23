package org.minions.devfund.katerinaanzoleaga.battleship;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertFalse;

/**
 * Ocean test class.
 */
public class OceanTest {
    private Ocean theOcean;
    private BattleShip battleShip = new BattleShip();
    private BattleCruiser battleCruiser = new BattleCruiser();
    private Cruiser cruiser = new Cruiser();
    private LightCruiser lightCruiser = new LightCruiser();
    private Destroyer destroyer = new Destroyer();
    private Submarine submarine = new Submarine();
    private EmptySea emptySea = new EmptySea();

    /**
     * Setup a new ocean for each test.
     */
    @Before
    public void setUp() {
        theOcean = new Ocean();
    }

    /**
     * Verify if the constructor creates the ship with empty ships.
     */
    @Test
    public void testConstructor() {
        for (Ship[] row : theOcean.getShipArray()) {
            for (Ship elem : row) {
                assertEquals(".", elem.toString());
                assertSame(elem.getShipType(),  "empty");
            }
        }
    }



    /**
     * Test to verify if lightCrusier shots until sunk.
     */
    @Test
    public void testLightCruiserShotAt() {
        final int lightCruiserThree = 3;
        final int lightCruiserFour = 4;
        final int lightCruiserFive = 5;
        final int lightCruiserSix = 6;
        final int lightCruiserSeven = 7;
        final int lightCruiserNinth = 9;

        lightCruiser.placeShipAt(2, 2, false, theOcean);
        theOcean.shootAt(0, 0);
        theOcean.shootAt(2, 2);
        theOcean.shootAt(lightCruiserFour, 2);
        theOcean.shootAt(lightCruiserThree, 2);
        theOcean.shootAt(lightCruiserFive, 2);
        theOcean.shootAt(lightCruiserSix, 2);
        theOcean.shootAt(lightCruiserThree, lightCruiserSeven);
        theOcean.shootAt(lightCruiserNinth, lightCruiserNinth + 1);
        theOcean.shootAt(lightCruiserNinth, lightCruiserNinth);
        assertTrue(lightCruiser.isSunk());
    }

    /**
     * Shooting to osean on the positions of a cruiser until sunk.
     */
    @Test
    public void testCruiserShotAt() {
        final int cruiserThree = 3;
        final int cruiserFour = 4;
        final int cruiserFive = 5;

        cruiser.placeShipAt(0, theOcean.getShipArray().length - 1, false, theOcean);
        assertTrue(theOcean.shootAt(0, theOcean.getShipArray().length - 1));
        assertTrue(theOcean.shootAt(1, theOcean.getShipArray().length - 1));
        assertTrue(theOcean.shootAt(2, theOcean.getShipArray().length - 1));
        assertTrue(theOcean.shootAt(cruiserThree, theOcean.getShipArray().length - 1));
        assertTrue(theOcean.shootAt(cruiserFour, theOcean.getShipArray().length - 1));
        assertTrue(theOcean.shootAt(cruiserFive, theOcean.getShipArray().length - 1));
        assertFalse(theOcean.shootAt(cruiserFive + 2, theOcean.getShipArray().length - 1));
        assertFalse(theOcean.shootAt(1, 0));
        assertFalse(theOcean.shootAt(cruiserFive + cruiserThree, 0));
        assertTrue(cruiser.isSunk());
    }


}
