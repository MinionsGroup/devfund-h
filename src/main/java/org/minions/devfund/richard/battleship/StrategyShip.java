package org.minions.devfund.richard.battleship;


public class StrategyShip extends Strategy {

    /**
     * Constructor.
     */
    StrategyShip() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    void action() {
        getOcean().getShips()[getRow()][getColumn()] = getShip();
        getShip().setBowRow(getRow());
        getShip().setBowColumn(getColumn());
        getShip().setHorizontal(getHorizontal());
        getShip().setNumber(getShip().getNumber() - 1);
    }
}
