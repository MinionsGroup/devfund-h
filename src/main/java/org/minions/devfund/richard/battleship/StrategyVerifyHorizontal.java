package org.minions.devfund.richard.battleship;

/**
 * Class.
 */
public class StrategyVerifyHorizontal implements StrategyShip {

    /**
     * {@inheritDoc}
     */
    @Override
    public void action(Ship ship, Ocean ocean, int ind) {
        ShipHelper.setOccupied(ocean.isOccupied(ship.getBowRow(), ind));
        ShipHelper.verifyBorder(ocean, ship.getBowRow(), ind);
    }
}
