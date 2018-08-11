package org.minions.devfund.katerinaanzoleaga.battleship;
import java.util.Arrays;

/**
 * BattleShip class definition.
 * Extends Ship with a length of 8
 */
public class BattleShip extends Ship {

    /**
     * BattleShip constructor.
     */
    public BattleShip() {
        this.setLength(HITLENGTH);
        this.fillHitArray();

    }

    /**
     * Initializes hit array with false values.
     */
    private void fillHitArray() {
        boolean[] aHit = new boolean[HITLENGTH];
        Arrays.fill(aHit, false);
        this.setHit(aHit);
    }

    /**
     * Ship type getter.
     * @return the name of this class.
     */
    @Override
    String getShipType() {
        return "battleship";
    }
}
