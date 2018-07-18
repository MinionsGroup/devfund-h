package org.minions.devfund.richard.square;

/**
 *
 */
public class Squarelotron {

    private int[][] squarelotron;
    private int[][] squareCopy;
    private int ring;
    private int numberOfTurns;

    /**
     * @param n size.
     */
    public Squarelotron(int n) {
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
        SquareActions.action(new SquareCopy(), this);
        SquareActions.action(new SquareUpsideDownFlip(), this);
        return this;
    }

    /**
     * @param ring ring.
     * @return Square.
     */
    public Squarelotron mainDiagonalFlip(int ring) {
        this.ring = ring;
        SquareActions.action(new SquareCopy(), this);
        SquareActions.action(new SquareDiagonalFlip(), this);
        return this;
    }

    /**
     * @param numberOfTurns number of turns.
     * @return square.
     */
    public Squarelotron rotateRight(int numberOfTurns) {
        this.numberOfTurns = numberOfTurns;
        SquareActions.rotateRight(this);
        return this;
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
