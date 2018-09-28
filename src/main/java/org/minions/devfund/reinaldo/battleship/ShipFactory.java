package org.minions.devfund.reinaldo.battleship;

/**
 * This is the ship Fatory class.
 */
public class ShipFactory implements IShipFactory {
    @Override
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
