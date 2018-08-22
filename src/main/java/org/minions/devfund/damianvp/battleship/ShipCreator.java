package org.minions.devfund.damianvp.battleship;

/**
 * ShipCreator class.
 */
public class ShipCreator {
    /**
     * This method get the instance of specific class of ship.
     * @param shipType string type of ship.
     * @return specific ship instance.
     */
    public Ship getShip(final String shipType) {
        switch (shipType) {
            case "BattleShip":
                return new BattleShip();
            case "BattleCruiser":
                return new BattleCruiser();
            case "Cruiser":
                return new Cruiser();
            case "LightCruiser":
                return new LightCruiser();
            case "Destroyer":
                return new Destroyer();
            case "Submarine":
                return new Submarine();
            default:
                return new EmptySea();
        }
    }
}
