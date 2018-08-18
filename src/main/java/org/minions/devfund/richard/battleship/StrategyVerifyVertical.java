package org.minions.devfund.richard.battleship;

/**
 * Class.
 */
public class StrategyVerifyVertical implements StrategyShip {

    /**
     * {@inheritDoc}
     */
    @Override
    public void action(Ship ship, Ocean ocean, int ind) {
        ShipHelper.setOccupied(ocean.isOccupied(ind, ship.getBowColumn()));
        ShipHelper.verifyBorder(ocean, ind, ship.getBowColumn());
    }
}
