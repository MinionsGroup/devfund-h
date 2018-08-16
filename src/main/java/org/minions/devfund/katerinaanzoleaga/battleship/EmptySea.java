package org.minions.devfund.katerinaanzoleaga.battleship;

import java.util.Arrays;

public class EmptySea extends Ship {
    public EmptySea() {
        this.setLength(1);
        this.fillHitArray();
}

    /**
     * Initializes HitArray with false values.
     */
    private void fillHitArray() {
        boolean[] ahit = new boolean[HITLENGTH];
        ahit[0] = false;
        this.setHit(ahit);
    }


    /**
     * Shoot at an empty position leads to a false return but also we need to mark that the position was fired upon.
     * @param row
     * @param column
     * @return
     */
    @Override
    boolean shootAt(int row, int column) {
        boolean[] ahit;
        ahit = this.getHit();
        ahit[0] = true;
        this.setHit(ahit);
        return false;
    }

    @Override
    boolean isSunk() {
        return false;
    }

    @Override
    public String toString() {
        return ".";
    }

    @Override
    String getShipType() {
        return "empty";
    }

}
