package org.minions.devfund.abel.battleship;

/**
 * Interface for Ship Factory.
 */
public interface IShipFactory {

    /**
     * Get Ship base on its Type.
     *
     * @param shipType String.
     * @return Ship.
     */
    Ship getShip(String shipType);
}
