package org.minions.devfund.noemiguzman.battleship;

public class Ocean {
    private int SIZE_OCEAN = 20;
    private int NRO_SHIPS = 13;
    private Ship[][] ships = new Ship[SIZE_OCEAN][SIZE_OCEAN];
    private int shotsFired;
    private int hitCount;
    private int shipsSunk;

    /*
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

    /*
     * Place all randomly on the (initially empty) ocean.
     * Place larger ships before smaller ones, or you may end up with no legal place to put a large ship.
     */
    public void placeAllShipsRandomly() {
        Ship[] ships =  newShips();
        int i=0;
        for (Ship ship : ships) {
            System.out.print("put");
            ship.putRandom(this);
        }
    }
    private Ship[] newShips(){
        Ship[] ships = new Ship[NRO_SHIPS];
        ships[0] = new BattleShip();
        ships[1] = new BattleCruiser();
        ships[4] = new Destroyer();
        ships[5] = new Submarine();
        for (int i = 2; i < 4; i++) {
            ships[i] = new Cruiser();
            ships[i + 4] = new LightCruiser();
            ships[i + 6] = new Destroyer();
            ships[i + 8] = new Submarine();
        }

        ships[12] = new Submarine();

        return ships;
    }
    /*
     * Returns true if the given location contains a ship, false if it does not.
     */
    public boolean isOccupied(int row, int column) {

        return !ships[row][column].getShipType().equals("empty");
    }

    /*
     * Returns true if the given location contains a real ship, still afloat, (not an EmptySea), false if it does not.
     * In addition, this method updates the number of shots that have been fired, and the number of hits.
     * Note: If a location contains a real ship, shootAt should return true every time the user shoots at that same location.
     * Once a ship has been sunk, additional shots at its location should return false.
     */
    public boolean shootAt(int row, int column) {
        this.shotsFired++;
        if (isOccupied(row, column)) {
            if (ships[row][column].shootAt(row, column)) {
                if (ships[row][column].isSunk()) {
                    System.out.println("You just sunk a " + ships[row][column].getShipType());
                    shipsSunk++;
                }
                hitCount++;
                return true;
            }
            return false;
        }
        return false;
    }

    /*
     * Prints the ocean. To aid the user, row numbers should be displayed along the left edge of the array, and column numbers should be displayed along the top.
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

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        for (int i = 0; i < 20; i++) {
            sb.append(String.format("%3d", i));
        }
        sb.append("\n");

        for (int i = 0; i < 20; i++) {
            sb.append(String.format("%2d ", i));
            for (int j = 0; j < 20; j++) {
//				sb.append(ships[i][j].toString());

                if (!ships[i][j].wasShootAt(i, j)) { // never been fired
                    sb.append(".");
                } else {
                    sb.append(ships[i][j].toString());
//					if (!isOccupied(i, j)) { // fired, but nothing there
//						sb.append("-");
//					} else {
//						sb.append(ships[i][j].toString());
//					}
                }



                sb.append("  ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    /*
     * Returns the 20x20 array of ships.
     * The methods in the Ship class that take an Ocean parameter really need to be able to look at the contents of this array;
     * the placeShipAt method even needs to modify it.
     */
    public Ship[][] getShipArray() {
        return ships;
    }

    public void setShips(Ship[][] ships) {
        this.ships = ships;
    }

    /*
     * Returns the number of shots fired (in this game).
     */
    public int getShotsFired() {
        return shotsFired;
    }

    /*
     * Returns the number of hits recorded (in this game). All hits are counted, not just the first time a given square is hit.
     */
    public int getHitCount() {
        return hitCount;
    }

    /*
     * Returns the number of ships sunk (in this game).
     */
    public int getShipsSunk() {
        return shipsSunk;
    }

    /*
     * Returns true if all ships have been sunk, otherwise false.
     */
    public boolean isGameOver() {
        return shipsSunk == 13;
    }
}
