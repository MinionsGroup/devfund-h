package org.minions.devfund.damianvp.battleship;

public class EmptySea extends Ship{

    EmptySea() {
        this.setLength(1);
    }


    @Override
    boolean shootAt(int row, int column) {
        return false;
//        return super.shootAt(row, column);
    }

    @Override
    boolean isSunk() {
        return false;
//        return super.isSunk();
    }

    @Override
    public String toString() {
        return "E";
//        return super.toString();
    }

    @Override
    String getShipType() {
        return "empty";
    }

}
