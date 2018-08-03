package org.minions.devfund.richard.battleship;

import java.util.Random;

/**
 * Interface.
 */
public class Strategy {

    private static int row;
    private static int column;
    private static boolean horizontal;
    private static Ocean ocean;
    private static Ship ship;

    /**
     *
     */
    void action() {
    }

    /**
     * @param myStrategy Strategy
     * @param myOcean    Ocean.
     */
    static void action(Strategy myStrategy, Ocean myOcean) {
        ocean = myOcean;
        for (int i = 0; i < myOcean.getOceanLength(); i++) {
            for (int j = 0; j < myOcean.getOceanLength(); j++) {
                row = i;
                column = j;
                myStrategy.action();
            }
        }
    }

    static void setShip(Strategy myStrategy, Ocean myOcean, Ship myShip) {
        ocean = myOcean;
        ship = myShip;
        for (int i = 0; i < ship.getNumber(); i++) {
            while (!isCompleted()) {
                Random random = new Random();
                row = random.nextInt(getOcean().getShips().length);
                column = random.nextInt(getOcean().getShips().length);
                horizontal = random.nextBoolean();
                if (isEmpty()) {
                    myStrategy.action();
                }
            }
        }
    }

    private static boolean isCompleted() {
        if (ship.getNumber() == 0) {
            return true;
        }
        return false;
    }

    /**
     * @return boolean.
     */
    private static boolean isEmpty() {
        return (ocean.getShips()[row][column] instanceof EmptySea);
    }

    /**
     * @return row.
     */
    static int getColumn() {
        return column;
    }

    /**
     * @return row.
     */
    static int getRow() {
        return row;
    }

    /**
     * @return ocean.
     */
    static Ocean getOcean() {
        return ocean;
    }

    /**
     * @return ship.
     */
    public static Ship getShip() {
        return ship;
    }

    /**
     * 
     * @return
     */
    public static boolean getHorizontal(){
        return horizontal;
    }

}
