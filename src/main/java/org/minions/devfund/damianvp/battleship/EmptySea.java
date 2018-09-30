package org.minions.devfund.damianvp.battleship;

import java.util.Arrays;

/**
 * EmptySea class.
 */
public class EmptySea extends Ship {

    /**
     * EmptySea class constructor.
     */
    EmptySea() {
        this.setLength(1);
        this.setHit(new boolean[1]);
        Arrays.fill(this.getHit(), false);
    }

    /**
     * Method to shot at in a specific place.
     * @param row int value of specific coordinate.
     * @param column int value of specific coordinate.
     * @return boolean, false.
     */
    @Override
    boolean shootAt(int row, int column) {
        this.getHit()[0] = true;
        return false;
    }

    /**
     * Override method to verify if is sunk.
     * @return
     */
    @Override
    boolean isSunk() {
        return false;
    }

    /**
     * Override method toString.
     * @return "-", ".".
     */
    @Override
    public String toString() {
        return this.getHit()[0] ? "-" : ".";
    }

    /**
     * Override method to get the type of the ship.
     * @return String type, type of ship.
     */
    @Override
    String getShipType() {
        return "empty";
    }

}
