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
                { 0, 8, true, false },
                { 0, 0, false, false },
                { 1, 5, false, false },
                { 19,8, true, true },
                { -1, 22, true, false },
                { 19, 18, true, false }
        });
    }

    @Test
    public void testOkToPlaceShipAt() {
        aBattleShip.placeShipAt(0, 0, true, theOcean);
        assertEquals(expectedResult, aBattleShip.okToPlaceShipAt(row, column, horizontal, theOcean));
    }

    @Test
    public void placeShipAt() {
        ;
    }
}