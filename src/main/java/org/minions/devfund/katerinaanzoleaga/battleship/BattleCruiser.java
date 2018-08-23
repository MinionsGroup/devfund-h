package org.minions.devfund.katerinaanzoleaga.battleship;

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
        this.setHit(new boolean[LENGTH]);
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
