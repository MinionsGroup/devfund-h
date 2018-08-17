package org.minions.devfund.katerinaanzoleaga.battleship;

/**
 * EmptySea class.
 */
public class EmptySea extends Ship {

    /**
     * EmptySea constructor.
     */
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

    /**
     * Returns true if sunk.
     * @return bool
     */
    @Override
    boolean isSunk() {
        return false;

    }

    /**
     * Retrns the proper character depending of if fired or not.
     * @return string.
     */
    @Override
    public String toString() {
        if (this.getHit()[0]) {
            return "-";
        } else {
            return ".";
        }
    }

    /**
     * Returns empty.
     * @return string
     */
    @Override
    String getShipType() {
        return "empty";
    }

}
