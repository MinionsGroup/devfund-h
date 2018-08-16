package org.minions.devfund.katerinaanzoleaga.battleship;

import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
//import org.junit.experimental.categories.Category;
import junitparams.JUnitParamsRunner;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class ShipTest {
    private static final Ship aBattleShip = new BattleShip();
    private static final Ship aBattleCrusie = new BattleCruiser();
    private static Ocean theOcean = new Ocean();

    @Test
    @Parameters ( {
            "0, 8, true, false",
            "0, 0, false, false",
            "1, 5, false, false ",
            "19,8, true, true",
            "-1, 22, true, false",
            "19, 18, true, false"
    })
    public void testOkToPlaceShipAt(int row, int column, boolean horizontal, boolean expectedResult) {
        aBattleShip.placeShipAt(0, 0, true, theOcean);
        assertEquals(expectedResult, aBattleShip.okToPlaceShipAt(row, column, horizontal, theOcean));
    }

    @Test
    public void placeShipAt() {
        ;
    }

    @Test
    public void testShootAt() {
        aBattleCrusie.placeShipAt(1,1,true, theOcean);
        aBattleCrusie.shootAt(1,1);
        assertTrue(aBattleCrusie.getHit()[0]);
        assertTrue (aBattleCrusie.shootAt(1, 2));
        assertTrue (aBattleCrusie.shootAt(1, 3));
        assertTrue (aBattleCrusie.shootAt(1, 4));
        assertTrue (aBattleCrusie.shootAt(1, 5));
        assertTrue (aBattleCrusie.shootAt(1, 6));
        assertTrue (aBattleCrusie.shootAt(1, 7));
        assertTrue(aBattleCrusie.isSunk());
        assertFalse(aBattleCrusie.shootAt(1, 8));
        assertFalse(aBattleCrusie.shootAt(2, 6));

    }

    @Test
    public void isSunk() {

    }
}