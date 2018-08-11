package org.minions.devfund.katerinaanzoleaga.battleship;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class OceanTest {
    private Ocean theOcean;

    @Before
    public void setUp() {
        theOcean = new Ocean();
    }

    @Test
    public void testConstructor() {
        for (Ship[] row : theOcean.getShips()) {
            for (Ship elem : row) {
                assertEquals(".", elem.toString());
            }
        }
    }



}