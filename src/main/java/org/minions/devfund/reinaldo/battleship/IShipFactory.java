package org.minions.devfund.reinaldo.battleship;

/**
 * This is the IShipFactory interface to ship factory.
 */
public interface IShipFactory {
    /**
     * The method get ship.
     * @param shipType ship.
     * @return ship ship.
     */
    Ship getShip(String shipType);
}
