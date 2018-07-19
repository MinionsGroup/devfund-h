package org.minions.devfund.richard.square;

/**
 * Class.
 */
public class Square {

    private int[][] matrix;
    private int[][] matrixCopy;
    private int ring;
    private int numberOfTurns;
    private int size;
    private Square myNewSquare;

    /**
     * @param n size.
     */
    public Square(int n) {
        this.size = n;
        this.matrix = new int[size][size];
        this.matrixCopy = new int[size][size];
        SquareActions.action(new SquareFill(), this);
    }

    /**
     * @param ring ring.
     * @return Square.
     */
    public Square upsideDownFlip(int ring) {
        this.myNewSquare = new Square(this.size);
        this.myNewSquare.ring = ring;
        SquareActions.action(new SquareUpdate(), this);
        SquareActions.action(new SquareCopy(), myNewSquare);
        SquareActions.action(new SquareUpsideDownFlip(), myNewSquare);
        return myNewSquare;
    }

    /**
     * @param ring ring.
     * @return Square.
     */
    public Square mainDiagonalFlip(int ring) {
        this.myNewSquare = new Square(this.size);
        this.myNewSquare.ring = ring;
        SquareActions.action(new SquareUpdate(), this);
        SquareActions.action(new SquareCopy(), myNewSquare);
        SquareActions.action(new SquareDiagonalFlip(), myNewSquare);
        return myNewSquare;
    }

    /**
     * @param numberOfTurns number of turns.
     * @return square.
     */
    public Square rotateRight(int numberOfTurns) {
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
    public int[][] getMatrix() {
        return matrix.clone();
    }

    /**
     * @return cloned square.
     */
    int[][] getMatrixCopy() {
        return matrixCopy;
    }

    /**
     * @return Number of turns.
     */
    int getNumberOfTurns() {
        return numberOfTurns;
    }

    /**
     * @return Square.
     */
    public Square getNewSquare() {
        return myNewSquare;
    }
}
