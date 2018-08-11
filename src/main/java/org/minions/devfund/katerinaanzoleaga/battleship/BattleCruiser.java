package org.minions.devfund.katerinaanzoleaga.battleship;
import java.util.Arrays;

/**
 * BattleCruiser class definition.
 * This extends Ship, with a length equal to 7
 */
public class BattleCruiser extends Ship {

    private static final int LENGTH = 7;

    /**
     * Class constructor.
     */
    public BattleCruiser() {

        this.setLength(LENGTH);
        this.fillHitArray();
    }

    /**
     * Initializes HitArray with false values.
     */
    private void fillHitArray() {
        boolean[] aHit = new boolean[HITLENGTH];
        Arrays.fill(aHit, 0, LENGTH - 1, false);
        this.setHit(aHit);
    }

    /**
     * Ship type getter.
     * @return battlecursier
     */
    @Override
    String getShipType() {
        return "battlecruiser";
    }
}
