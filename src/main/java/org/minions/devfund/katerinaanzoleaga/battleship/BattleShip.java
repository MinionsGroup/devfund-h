package org.minions.devfund.katerinaanzoleaga.battleship;

/**
 * BattleShip class definition.
 * Extends Ship with a length of 8
 */
public class BattleShip extends Ship {

    /**
     * BattleShip constructor.
     */
    public BattleShip() {
        this.setLength(HITLENGHT);
        this.setHit(new boolean[HITLENGHT]);
    }

    /**
     * Ship type getter.
     * @return the name of this class.
     */
    @Override
    public String getShipType() {
        return "battleship";
    }
}
