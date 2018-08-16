package org.minions.devfund.katerinaanzoleaga.battleship;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Ocean test class.
 */
public class OceanTest {
    private Ocean theOcean;

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
}