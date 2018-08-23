package org.minions.devfund.katerinaanzoleaga.battleship;

import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
//import org.junit.experimental.categories.Category;
import junitparams.JUnitParamsRunner;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

/**
 * Ship test class.
 */
@RunWith(JUnitParamsRunner.class)
public class ShipTest {
    private BattleShip battleShip = new BattleShip();
    private BattleCruiser battleCruiser = new BattleCruiser();
    private Cruiser cruiser = new Cruiser();
    private LightCruiser lightCruiser = new LightCruiser();
    private Destroyer destroyer = new Destroyer();
    private Submarine submarine = new Submarine();
    private EmptySea emptySea = new EmptySea();

    private static Ocean theOcean = new Ocean();

    /**
     * Parametrized test to test PacingShips in some valid and not valid positions.
     * @param row int
     * @param column int
     * @param horizontal bool
     * @param expectedResult bool
     */
    @Test
    @Parameters({
            "0, 8, true, false",
            "0, 0, false, false",
            "1, 5, false, false ",
            "19,8, true, true",
            "-1, 22, true, false",
            "19, 18, true, false"
    })
    public void testOkToPlaceShipAt(int row, int column, boolean horizontal, boolean expectedResult) {
        battleShip.placeShipAt(0, 0, true, theOcean);
        assertEquals(expectedResult, battleShip.okToPlaceShipAt(row, column, horizontal, theOcean));
    }

    /**
     * Test shot at different positions of a battleCruiser.
     */
    @Test
    public void testShootAt() {
        final int row = 0;
        final int column = 0;
        final int columnBattleCruiserThree = 3;
        final int columnBattleCruiserFour = 4;
        final int columnBattleCruiserFive = 5;
        final int columnBattleCruiserSix = 6;
        final int columnBattleCruiserSeven = 7;

        battleCruiser.placeShipAt(1, 1, true, theOcean);
        battleCruiser.shootAt(1, 1);
        assertTrue(battleCruiser.getHit()[0]);
        assertTrue(battleCruiser.shootAt(1, 2));
        assertTrue(battleCruiser.shootAt(1, columnBattleCruiserThree));
        assertTrue(battleCruiser.shootAt(1, columnBattleCruiserFour));
        assertTrue(battleCruiser.shootAt(1, columnBattleCruiserFive));
        assertTrue(battleCruiser.shootAt(1, columnBattleCruiserSix));
        assertTrue(battleCruiser.shootAt(1, columnBattleCruiserSeven));
        assertTrue(battleCruiser.isSunk());
        assertFalse(battleCruiser.shootAt(1, columnBattleCruiserSeven + 1));
        assertFalse(battleCruiser.shootAt(2, columnBattleCruiserSix));
    }


    /**
     * Test several shots until sunk a destroyer.
     */
    @Test
    public void testisSunkDestroyer() {
        destroyer.placeShipAt(0, 1, true, theOcean);
        assertEquals(true, destroyer.shootAt(0, 1));
        assertEquals(false, destroyer.isSunk());
        assertEquals(false, destroyer.shootAt(1, 0));
        assertEquals(true, destroyer.shootAt(0, 2));
        assertEquals(false, destroyer.isSunk());
        assertEquals(false, destroyer.shootAt(0, destroyer.getLength() + 1));
        assertEquals(false, destroyer.isSunk());
        assertEquals(true, destroyer.shootAt(0, destroyer.getLength()));
        assertEquals(false, destroyer.isSunk());
        assertEquals(true, destroyer.shootAt(0, destroyer.getLength() - 1));
        assertEquals(true, destroyer.isSunk());

        theOcean.print();
    }

    /**
     * Test several shots until sunk a submarine.
     */
    @Test
    public void testSunkSubmarine() {
        final int row = 0;
        final int column = 0;
        final int columnSubmarineZero = 0;
        final int columnSubmarineOne = 1;
        final int columnSubmarineTwo = 2;
        final Ship ship = new Submarine();
        ship.placeShipAt(row, column, true, theOcean);
        ship.shootAt(row, columnSubmarineZero);
        ship.shootAt(row, columnSubmarineOne);
        ship.shootAt(row, columnSubmarineTwo);
        ship.shootAt(row, columnSubmarineZero);
        assertTrue(ship.isSunk());
    }

    @Test
    public void testSunkDestroyerH(){
        final Ship destroyer = new Destroyer();
        destroyer.placeShipAt(0, 0 , true, theOcean);
        for (int i = 0; i < destroyer.getLength(); ++i) {
            destroyer.shootAt(0, i);
            if (i != destroyer.getLength() - 1) {
                assertFalse(destroyer.isSunk());
            }
        }
        assertTrue(destroyer.isSunk());
    }

    @Test
    public void testSunkDestroyerV(){
        final Ship destroyer = new Destroyer();
        destroyer.placeShipAt(0, 0 , false, theOcean);
        for (int i = 0; i < destroyer.getLength(); ++i) {
            destroyer.shootAt(i, 0);
            if (i != destroyer.getLength() - 1) {
                assertFalse(destroyer.isSunk());
            }
        }
        assertTrue(destroyer.isSunk());
    }

    @Test
    public void testSunkLightCruiserH(){
        final Ship lightCruiser = new Destroyer();
        lightCruiser.placeShipAt(0, 0 , true, theOcean);
        for (int i = 0; i < lightCruiser.getLength(); ++i) {
            lightCruiser.shootAt(0, i);
            if (i != lightCruiser.getLength() - 1) {
                assertFalse(lightCruiser.isSunk());
            }
        }
        assertTrue(lightCruiser.isSunk());
    }
    @Test
    public void testSunkLightCruiserV(){
        final Ship lightCruiser = new LightCruiser();
        assertFalse(lightCruiser.isSunk());
        lightCruiser.placeShipAt(0, 0 , false, theOcean);
        for (int i = 0; i < lightCruiser.getLength(); ++i) {
            lightCruiser.shootAt(i, 0);
            if (i != lightCruiser.getLength() - 1) {
                assertFalse(lightCruiser.isSunk());
            }
        }
        assertTrue(lightCruiser.isSunk());
    }


    @Test
    public void testSunkCruiserH(){
        final Ship cruiser = new Cruiser();
        cruiser.placeShipAt(0, 0 , true, theOcean);
        for (int i = 0; i < cruiser.getLength(); ++i) {
            cruiser.shootAt(0, i);
            if (i != cruiser.getLength() - 1) {
                assertFalse(cruiser.isSunk());
            }
        }
        assertTrue(cruiser.isSunk());
    }
    @Test
    public void testSunkCruiserV( ){
        final Ship cruiser = new Cruiser();
        assertFalse(cruiser.isSunk());
        cruiser.placeShipAt(0, 0 , false, theOcean);
        for (int i = 0; i < cruiser.getLength(); ++i) {
            cruiser.shootAt(i, 0);
            if (i != cruiser.getLength() - 1) {
                assertFalse(cruiser.isSunk());
            }
        }
        assertTrue(cruiser.isSunk());
    }


    @Test
    public void testSunkBattleCruiserH() {
        final Ship battleCruiser = new BattleCruiser();
        battleCruiser.placeShipAt(0, 0 , true, theOcean);
        for (int i = 0; i < battleCruiser.getLength(); ++i) {
            battleCruiser.shootAt(0, i);
            if (i != battleCruiser.getLength() - 1) {
                assertFalse(battleCruiser.isSunk());
            }
        }
        assertTrue(battleCruiser.isSunk());
    }

    @Test
    public void testSunkBattleCruiserV() {
        final Ship battleCruiser = new BattleCruiser();
        assertFalse(battleCruiser.isSunk());
        battleCruiser.placeShipAt(0, 0 , false, theOcean);
        for (int i = 0; i < battleCruiser.getLength(); ++i) {
            battleCruiser.shootAt(i, 0);
            if (i != battleCruiser.getLength() - 1) {
                assertFalse(battleCruiser.isSunk());
            }
        }
        assertTrue(battleCruiser.isSunk());
    }

    @Test
    public void testSunkBattleShipH() {
        final Ship battleShip = new BattleShip();
        battleShip.placeShipAt(0, 0 , true, theOcean);
        for (int i = 0; i < battleShip.getLength(); ++i) {
            battleShip.shootAt(0, i);
            if (i != battleShip.getLength() - 1) {
                assertFalse(battleShip.isSunk());
            }
        }
        assertTrue(battleShip.isSunk());
    }

    @Test
    public void testSunkBattleShipCruiserV() {
        final Ship battleShip = new BattleShip();
        assertFalse(battleShip.isSunk());
        battleShip.placeShipAt(0, 0 , false, theOcean);
        for (int i = 0; i < battleShip.getLength(); ++i) {
            battleShip.shootAt(i, 0);
            if (i != battleShip.getLength() - 1) {
                assertFalse(battleShip.isSunk());
            }
        }
        assertTrue(battleShip.isSunk());
    }

}
