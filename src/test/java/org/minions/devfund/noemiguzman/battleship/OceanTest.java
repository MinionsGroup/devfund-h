package org.minions.devfund.noemiguzman.battleship;


import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Class to test Ocean class.
 */

public class OceanTest {
    /**
     * method to test constructor.
     */
    @Test
    public void testConstructor() {
        final int sizeOcean = 20;
        Ocean ocean = new Ocean();
        assertEquals(0, ocean.getHitCount());
        assertEquals(0, ocean.getShipsSunk());
        assertEquals(0, ocean.getShotsFired());
        for (int i = 0; i < sizeOcean; i++) {
            for (int j = 0; j < sizeOcean; j++) {
                assertEquals("empty", ocean.getShipArray()[i][j].getShipType());
            }
        }

    }

    /**
     * test place all ship.
     */
    @Test
    public void testPlaceAllShipsRandomly() {
        final int sizeOcean = 20;
        final int expectedShipCount = 61;
        Ocean ocean = new Ocean();
        ocean.placeAllShipsRandomly();
        assertEquals(0, ocean.getHitCount());
        assertEquals(0, ocean.getShipsSunk());
        assertEquals(0, ocean.getShotsFired());
        int shipCount = 0;
        for (int i = 0; i < sizeOcean; i++) {
            for (int j = 0; j < sizeOcean; j++) {
                if (!ocean.getShipArray()[i][j].getShipType().equals("empty")) {
                    shipCount++;
                }

            }
        }
        // 8 + 7 + 2*6 + 2*5 + 3*4 + 4*3 = 61
        assertEquals(expectedShipCount, shipCount);
    }

    /**
     * method totest isoccupied.
     */
    @Test
    public void testIsOccupied1() {
        final int sizeOcean = 20;
        Ocean ocean = new Ocean();
        for (int i = 0; i < sizeOcean; i++) {
            for (int j = 0; j < sizeOcean; j++) {
                assertFalse(ocean.isOccupied(i, j));
            }
        }
    }

    /**
     * test is occupied.
     */
    @Test
    public void testIsOccupiedWithShip() {
        final int size8 = 8;
        Ocean ocean = new Ocean();
        BattleShip ship = new BattleShip();
        ship.placeShipAt(0, 0, true, ocean);
        for (int j = 0; j < size8; j++) {
            assertTrue(ocean.isOccupied(0, j));
        }
        assertFalse(ocean.isOccupied(0, size8));
    }

    /**
     * test shootat.
     */
    @Test
    public void testShootAt1() {
        Ocean ocean = new Ocean();
        BattleShip ship = new BattleShip();
        final int expectedShot = 3;
        ship.placeShipAt(0, 0, true, ocean);
        ocean.shootAt(0, 0);
        ocean.shootAt(0, 0);
        ocean.shootAt(1, 0);
        assertEquals(2, ocean.getHitCount());
        assertEquals(0, ocean.getShipsSunk());
        assertEquals(expectedShot, ocean.getShotsFired());
    }

    /**
     * test shoot at with ships.
     */
    @Test
    public void testShootAtWithShip() {
        Ocean ocean = new Ocean();
        BattleShip ship = new BattleShip();
        final int place8 = 8;
        final int expectedShots = 10;
        ship.placeShipAt(0, 0, true, ocean);
        for (int j = 0; j < place8; j++) {
            ocean.shootAt(0, j);
        }
        ocean.shootAt(0, 1);
        ocean.shootAt(0, 2);

        assertEquals(place8, ocean.getHitCount());
        assertEquals(1, ocean.getShipsSunk());
        assertEquals(expectedShots, ocean.getShotsFired());

    }

    /**
     * test to string.
     */
    @Test
    public void testToString() {
        final int sizeOcean = 20;
        final int place8 = 8;
        Ocean ocean = new Ocean();
        BattleShip ship = new BattleShip();
        ship.placeShipAt(0, 0, true, ocean);
        for (int j = 0; j < place8; j++) {
            ocean.shootAt(0, j);
        }

        assertEquals(place8, ocean.getHitCount());
        assertEquals(1, ocean.getShipsSunk());
        assertEquals(place8, ocean.getShotsFired());

        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        for (int i = 0; i < sizeOcean; i++) {
            sb.append(String.format("%3d", i));
        }
        sb.append("\n");

        for (int i = 0; i < sizeOcean; i++) {
            sb.append(String.format("%2d ", i));
            for (int j = 0; j < sizeOcean; j++) {
                if (i == 0 && j < place8) {
                    sb.append("x  ");
                } else {
                    sb.append(".  ");
                }
            }
            sb.append("\n");
        }

        assertEquals(sb.toString(), ocean.toString());

    }

    /**
     * test to string.
     */
    @Test
    public void testToString2() {
        final int sizeOcean = 20;
        final int place7 = 7;
        Ocean ocean = new Ocean();
        BattleShip ship = new BattleShip();
        ship.placeShipAt(0, 0, true, ocean);
        for (int j = 0; j < place7; j++) {
            ocean.shootAt(0, j);
        }

        assertEquals(place7, ocean.getHitCount());
        assertEquals(0, ocean.getShipsSunk());
        assertEquals(place7, ocean.getShotsFired());

        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        for (int i = 0; i < sizeOcean; i++) {
            sb.append(String.format("%3d", i));
        }
        sb.append("\n");

        for (int i = 0; i < sizeOcean; i++) {
            sb.append(String.format("%2d ", i));
            for (int j = 0; j < sizeOcean; j++) {
                if (i == 0 && j < place7) {
                    sb.append("S  ");
                } else {
                    sb.append(".  ");
                }
            }
            sb.append("\n");
        }

        assertEquals(sb.toString(), ocean.toString());
    }
    /**
     * test to string.
     */
    @Test
    public void testIsGameOver() {
        final int place8 = 8;
        Ocean ocean = new Ocean();
        BattleShip ship = new BattleShip();
        ship.placeShipAt(0, 0, true, ocean);
        for (int j = 0; j < place8; j++) {
            ocean.shootAt(0, j);
        }

        assertEquals(place8, ocean.getHitCount());
        assertEquals(1, ocean.getShipsSunk());
        assertEquals(place8, ocean.getShotsFired());
        assertFalse(ocean.isGameOver());
    }
    /**
     * test shoot at with ships vertical.
     */
    @Test
    public void testShootAtWithShipVertical() {
        Ocean ocean = new Ocean();
        BattleShip ship = new BattleShip();
        final int place8 = 8;
        final int expectedShots = 10;
        ship.placeShipAt(0, 0, false, ocean);
        for (int j = 0; j < place8; j++) {
            ocean.shootAt(0, j);
        }
        ocean.shootAt(0, 1);
        ocean.shootAt(0, 2);

        assertEquals(1, ocean.getHitCount());
        assertEquals(0, ocean.getShipsSunk());
        assertEquals(expectedShots, ocean.getShotsFired());

    }
    /**
     * test to string vertical.
     */
    @Test
    public void testToStringVertical() {
        final int sizeOcean = 20;
        final int place8 = 8;
        Ocean ocean = new Ocean();
        BattleShip ship = new BattleShip();
        ship.placeShipAt(0, 0, false, ocean);
        for (int j = 0; j < place8; j++) {
            ocean.shootAt(0, j);
        }

        assertEquals(1, ocean.getHitCount());
        assertEquals(0, ocean.getShipsSunk());
        assertEquals(place8, ocean.getShotsFired());

        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        for (int i = 0; i < sizeOcean; i++) {
            sb.append(String.format("%3d", i));
        }
        sb.append("\n");

        for (int i = 0; i < sizeOcean; i++) {
            sb.append(String.format("%2d ", i));
            for (int j = 0; j < sizeOcean; j++) {
                if (i == 0 && j < 1) {
                    sb.append("S  ");
                } else {
                    sb.append(".  ");
                }
            }
            sb.append("\n");
        }

        assertEquals(sb.toString(), ocean.toString());

    }
}
