package org.minions.devfund.noemiguzman.battleship;

/**
 * Ocean class.
 */
public class Ocean {
    private static final int SIZE_OCEAN = 20;
    private static final int NRO_SHIPS = 13;
    private Ship[][] ships = new Ship[SIZE_OCEAN][SIZE_OCEAN];
    private int shotsFired;
    private int hitCount;
    private int shipsSunk;

    /**
     * Creates an empty ocean (fills the ships array with a bunch of EmptySea instances).
     * Also initializes any game variables, such as how many shots have been fired.
     */
    public Ocean() {
        shotsFired = 0;
        hitCount = 0;
        shipsSunk = 0;
        for (int i = 0; i < SIZE_OCEAN; i++) {
            for (int j = 0; j < SIZE_OCEAN; j++) {
                EmptySea emptySea = new EmptySea();
                emptySea.placeShipAt(i, j, true, this);
            }
        }
    }

    /**
     * Place all randomly on the (initially empty) ocean.
     * Place larger ships before smaller ones, or you may end up with no legal place to put a large ship.
     */
    public void placeAllShipsRandomly() {
        Ship[] ships =  newShips();
        for (Ship ship : ships) {
            ship.putRandom(this);
        }
    }

    /**
     * new ships method.
     * @return ship list
     */
    private Ship[] newShips() {
        Ship[] ships = new Ship[NRO_SHIPS];
        for (int i = 0; i < NRO_SHIPS; i++) {
            ships[i] = selectShip(i);
        }
        return ships;
    }

    /**
     * get a ship.
     * @param i int
     * @return Ship object
     */
    private Ship selectShip(int i) {

        final int iLC = 4;
        final int iDES = 7;

        Ship ship1;
        switch (i) {
            case 0:  ship1  = new BattleShip();
                break;
            case 1:  ship1  = new BattleCruiser();
                break;
            case 2: case iLC - 1: ship1 = new Cruiser();
                break;
            case iLC: case iLC + 1:  ship1 = new LightCruiser();
                break;
            case iDES - 1: case iDES: case iDES + 1: ship1 = new Destroyer();
                break;

            default: ship1 = new Submarine();
                break;
        }
        return ship1;
    }
    /**
     * Returns true if the given location contains a ship, false if it does not.
     * @param row number
     * @param column number
     * @return true if it is occupied.
     */
    public boolean isOccupied(int row, int column) {

        return !ships[row][column].getShipType().equals("empty");
    }

    /**
     * Returns true if the given location contains a real ship, still afloat, (not an EmptySea), false if it does not.
     * In addition, this method updates the number of shots that have been fired, and the number of hits.
     * If a location contains a real ship, shootAt should return true every time the user shoots at that same location.
     * Once a ship has been sunk, additional shots at its location should return false.
     * @param row number
     * @param column number
     * @return true
     */
    public boolean shootAt(int row, int column) {
        this.shotsFired++;
        if (isOccupied(row, column)) {
            if (ships[row][column].shootAt(row, column)) {
                if (ships[row][column].isSunk()) {
                    shipsSunk++;
                }
                hitCount++;
                return true;
            }
            return false;
        }
        return false;
    }

    /**
     * Prints the ocean. To aid the user, row numbers should be displayed along the left edge of the array.
     * and column numbers should be displayed along the top.
     * Numbers should be 00 to 19, not 1 to 20.
     * The top left corner square should be 0, 0.
     * Use ’S’ to indicate a location that you have fired upon and hit a (real) ship,
     * ’-’ to indicate a location that you have fired upon and found nothing there,
     * ’x’ to indicate a location containing a sunken ship,
     * and ’.’ (a period) to indicate a location that you have never fired upon.
     */
    public void print() {
        System.out.println(toString());
    }

    /**
     * method to return string the game.
     * @return string
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        for (int i = 0; i < SIZE_OCEAN; i++) {
            sb.append(String.format("%3d", i));
        }
        sb.append("\n");

        for (int i = 0; i < SIZE_OCEAN; i++) {
            sb.append(String.format("%2d ", i));
            for (int j = 0; j < SIZE_OCEAN; j++) {
                if (!ships[i][j].wasShootAt(i, j)) {
                    sb.append(".");
                } else {
                    sb.append(ships[i][j].toString());
                }
                sb.append("  ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * Returns the 20x20 array of ships.
     * Take an Ocean parameter really need to be able to look at the contents of this array;
     * the placeShipAt method even needs to modify it.
     * @return Ships
     */
    public Ship[][] getShipArray() {
        return ships.clone();
    }

    /**
     * Returns the number of shots fired (in this game).
     * @return in shots
     */
    public int getShotsFired() {
        return shotsFired;
    }


    /**
     * Returns the number of hits recorded (in this game).
     * All hits are counted, not just the first time a given square is hit.
     * @return hits
     */
    public int getHitCount() {
        return hitCount;
    }


    /**
     * Returns the number of ships sunk (in this game).
     * @return in sunk
     */
    public int getShipsSunk() {
        return shipsSunk;
    }

    /**
     * Returns true if all ships have been sunk, otherwise false.
     * @return true if shipssumk
     */
    public boolean isGameOver() {
        return shipsSunk == NRO_SHIPS;
    }
}
