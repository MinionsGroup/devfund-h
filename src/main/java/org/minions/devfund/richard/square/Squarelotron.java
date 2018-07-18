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
        this.squarelotron = new int[size][size];
        this.squareCopy = new int[size][size];
        SquareActions.action(new SquareFill(), this);
    }

    /**
     * @param ring ring.
     * @return Square.
     */
    public Squarelotron upsideDownFlip(int ring) {
        this.myNewSquare = new Squarelotron(size);
        this.myNewSquare.ring = ring;
        SquareActions.action(new SquareCopy(), myNewSquare);
        SquareActions.action(new SquareUpsideDownFlip(), myNewSquare);
        return myNewSquare;
    }

    /**
     * @param ring ring.
     * @return Square.
     */
    public Squarelotron mainDiagonalFlip(int ring) {
        this.myNewSquare = new Squarelotron(size);
        this.myNewSquare.ring = ring;
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
    int getRing() {
        return ring;
    }

    /**
     * @return original square.
     */
    public int[][] getSquarelotron() {
        return squarelotron.clone();
    }

    /**
     * @return cloned square.
     */
    int[][] getSquareCopy() {
        return squareCopy;
    }

    /**
     * @return Number of turns.
     */
    int getNumberOfTurns() {
        return numberOfTurns;
    }
}
