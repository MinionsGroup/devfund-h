package org.minions.devfund.richard.battleship;

/**
 * Class.
 */
public class StrategySetShipVertical implements StrategyShip {

    /**
     * {@inheritDoc}.
     */
    @Override
    public void action(final Ship ship, final Ocean ocean, final int ind) {
        ocean.getShipArray()[ind][ship.getBowColumn()] = ship;
    }
}
