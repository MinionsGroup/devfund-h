package org.minions.devfund.damianvp.battleship;

import java.util.Arrays;
import java.util.Random;

public class Ocean {
    private Ship[][] ships = new Ship[20][20];



    private int shotsFired;
    private int hitCount;
    private int shipsSunk;

    Ocean() {
        for (Ship[] row: this.ships) {
            Arrays.fill(row, new EmptySea());
        }
        this.shotsFired = 0;
        this.hitCount = 0;
        this.shipsSunk = 0;
    }
    //one 8-square Battleship, one 7-square Battlecruiser, two 6-square Cruisers, two 5-square Light Cruisers, three 4-square Destroyers and four 3-square Submarines
    void placeAllShipsRandomly() {
//        Random random = new Random();
//        BattleShip battleShip = new BattleShip();
//        battleShip.setHorizontal(random.nextBoolean());
        Random random = new Random();
//		random.setSeed(10);
        Ship[] ships = new Ship[13];
        for (int i = 0; i < 13; i++) {
            if (i == 0) {
                ships[i] = new BattleShip();
            } else if (i == 1) {
                ships[i] = new BattleCruiser();
            } else if (i < 4) {
                ships[i] = new Cruiser();
            } else if (i < 6) {
                ships[i] = new LightCruiser();
            } else if (i < 9) {
                ships[i] = new Destroyer();
            } else if (i < 13) {
                ships[i] = new Submarine();
            }
        }
        int i=1;

        for (Ship ship : ships) {
            while (true) {
                int row = random.nextInt(20);
                int column = random.nextInt(20);
                boolean horizontal = random.nextBoolean();
//				System.out.println(ship.getShipType() + " "+ row + " " + column + " horizontal? " + horizontal + " ok? "+ ship.okToPlaceShipAt(row, column, horizontal, this));
                if (ship.okToPlaceShipAt(row, column, horizontal, this)) {

                    ship.placeShipAt(row, column, horizontal, this);
                    System.out.println("placed ship:---" + i);
                    i++;
                    break;
                }
            }
        }

        System.out.println("print game board///////");

        for (int ii = 0; ii < 20; ii++) {
            for (int j = 0; j < 20; j++) {
                System.out.println(this.getShipArray()[ii][j].getShipType());
//                if (!this.getShipArray()[ii][j].getShipType().equals("empty")) {
//                    shipCount++;
//                }

            }
        }

//        System.out.println(Arrays.deepToString(getShipArray()));

    }

    boolean isOccupied(int row, int column) {
//        if (!this.ships[row][column].getShipType().equals("empty")) {
//            return false;
//        }
//        return true;
        return !ships[row][column].getShipType().equals("empty");
    }

    boolean shootAt(int row, int column) {
        this.shotsFired++;
        if (isOccupied(row, column)) {
            if (ships[row][column].shootAt(row, column)) {
                if (ships[row][column].isSunk()) {
                    shipsSunk++;
                }
                hitCount++;
                System.out.println(hitCount);
                return true;
            }
            return false;
        } else {
            ships[row][column].shootAt(row, column);
        }
        return false;
    }

    public Ship[][] getShips() {
        return ships;
    }

    public int getShotsFired() {
        return shotsFired;
    }

    public int getHitCount() {
        return hitCount;
    }

    public int getShipsSunk() {
        return shipsSunk;
    }

    boolean isGameOver() {
        return false;
    }

    Ship[][] getShipArray() {
        return ships;
    }


//    void print() {
//
//    }

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









}
