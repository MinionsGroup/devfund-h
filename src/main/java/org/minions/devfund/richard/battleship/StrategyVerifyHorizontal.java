package org.minions.devfund.richard.battleship;

/**
 * Class.
 */
public class StrategyVerifyHorizontal implements StrategyShip {

    /**
     * {@inheritDoc}.
     */
    @Override
    public void action(final Ship ship, final Ocean ocean, final int ind) {
        ShipHelper.setValidPosition(!ocean.isOccupied(ship.getBowRow(), ind));
        ShipHelper.verifyBorder(ocean, ship.getBowRow(), ind);
    }
}
