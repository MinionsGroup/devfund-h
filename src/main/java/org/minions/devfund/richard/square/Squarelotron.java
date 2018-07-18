package org.minions.devfund.richard.square;

/**
 *
 */
public class Squarelotron {

    private int[][] squarelotron;
    private int[][] squareCopy;
    private int ring;
    private int numberOfTurns;
    private int size;
    private Squarelotron myNewSquare;

    /**
     * @param n size.
     */
    public Squarelotron(int n) {
        this.size = n;
        this.squarelotron = new int[n][n];
        this.squareCopy = new int[n][n];
        SquareActions.action(new SquareFill(), this);
    }

    /**
     * @param ring ring.
     * @return Square.
     */
    public Squarelotron upsideDownFlip(int ring) {
        this.ring = ring;
        myNewSquare = this;
        SquareActions.action(new SquareCopy(), myNewSquare);
        SquareActions.action(new SquareUpsideDownFlip(), myNewSquare);
        return myNewSquare;
    }

    /**
     * @param ring ring.
     * @return Square.
     */
    public Squarelotron mainDiagonalFlip(int ring) {
        this.ring = ring;
        myNewSquare = this;
        SquareActions.action(new SquareCopy(), myNewSquare);
        SquareActions.action(new SquareDiagonalFlip(), myNewSquare);
        return myNewSquare;
    }

    /**
     * @param numberOfTurns number of turns.
     * @return square.
     */
    public Squarelotron rotateRight(int numberOfTurns) {
        this.numberOfTurns = numberOfTurns;
        myNewSquare = this;
        SquareActions.rotateRight(myNewSquare);
        return myNewSquare;
    }

    /**
     * @return String.
     */
    public String print() {
        return SquareActions.action(new SquarePrint(), this).getPrint();
    }

    /**
     * @return int.
     */
    public int getRing() {
        return ring;
    }

    /**
     * @return original square.
     */
    public int[][] getSquare() {
        return squarelotron.clone();
    }

    /**
     * @return cloned square.
     */
    public int[][] getSquareCopy() {
        return squareCopy.clone();
    }

    /**
     * @return Number of turns.
     */
    public int getNumberOfTurns() {
        return numberOfTurns;
    }
}
