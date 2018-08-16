package org.minions.devfund.katerinaanzoleaga.battleship;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Ocean test class.
 */
public class OceanTest {
    private Ocean theOcean;
    private LightCruiser lightCruiser = new LightCruiser();

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
     *
     */
    @Test
    public void testPlaceAllShipRandomly() {
        theOcean.placeAllShipRandomly();

    }

    @Test
    public void testPrint() {
        lightCruiser.placeShipAt(2, 2, false, theOcean);
        theOcean.shootAt(2, 2);
        theOcean.shootAt(4, 2);
        theOcean.shootAt(3, 2);
        theOcean.shootAt(5, 2);
        theOcean.shootAt(6, 2);
        theOcean.shootAt(3, 7);
        theOcean.print();

    }
}