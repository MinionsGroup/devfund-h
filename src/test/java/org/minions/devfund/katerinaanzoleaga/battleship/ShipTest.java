package org.minions.devfund.katerinaanzoleaga.battleship;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ShipTest {
    private static final Ship aBattleShip = new BattleShip();
    private static Ocean theOcean = new Ocean();
    private Integer row, column;
    private Boolean horizontal, expectedResult;

    public ShipTest(Integer row, Integer column, Boolean horizontal,Boolean expectedResult) {
        this.row = row;
        this.column = column;
        this.horizontal = horizontal;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection positions() {
        return Arrays.asList(new Object[][] {
                { 0, 0, false, true },
                { 0, 19, false, true },
                { 19,19, false, false },
                { -1, 22, true, false },
                { 19, 0, true, true }
        });
    }

    @Test
    public void testOkToPlaceShipAt() {
        Ship aBattleShip = new BattleShip();
        assertEquals(expectedResult, aBattleShip.okToPlaceShipAt(row, column, horizontal, theOcean));
    }

    @Test
    public void placeShipAt() {
        ;
    }
}