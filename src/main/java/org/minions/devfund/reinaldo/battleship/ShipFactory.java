package org.minions.devfund.reinaldo.battleship;

/**
 * This is the ship Fatory class.
 */
public class ShipFactory implements IShipFactory {
    @Override
    public Ship getShip(final ShipTypeEnum shipType) {
        switch (shipType) {
            case BATTLESHIP:
                return new BattleShip();
            case BATTLE_CRUISER:
                return new BattleCruiser();
            case CRUISER:
                return new Cruiser();
            case LIGHT_CRUISER:
                return new LightCruiser();
            case DESTROYER:
                return new Destroyer();
            case SUBMARINE:
                return new Submarine();
            default:
                return new EmptySea();
        }
    }
}
