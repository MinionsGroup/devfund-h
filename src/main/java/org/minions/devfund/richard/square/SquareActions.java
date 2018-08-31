package org.minions.devfund.richard.square;

/**
 * Abstract class.
 */
public abstract class SquareActions {

    private static final int MAX_ROTATIONS = 4;
    private static int myRow;
    private static int myColumn;
    private static int value;
    private static int squareSize;
    private static StringBuilder myStreamBuilder;

    /**
     * @param mySquare Square.
     */
    protected abstract void action(Square mySquare);

    /**
     * @param mySquareActions mySquareActions.
     * @param mySquare        mySquare.
     * @return mySquareActions.
     */
    static SquareActions action(final SquareActions mySquareActions, final Square mySquare) {
        value = 0;
        squareSize = mySquare.getMatrix().length;
        myStreamBuilder = new StringBuilder();
        for (int row = 0; row < squareSize; row++) {
            for (int column = 0; column < squareSize; column++) {
                myRow = row;
                myColumn = column;
                value++;
                mySquareActions.action(mySquare);
            }
        }
        return mySquareActions;
    }

    /**
     * @param mySquare Square.
     */
    static void rotateRight(final Square mySquare) {
        for (int ind = 0; ind < Math.abs(mySquare.getNumberOfTurns()) % MAX_ROTATIONS; ind++) {
            SquareActions.action(new SquareCopy(), mySquare);
            SquareActions.action(new SquareRotateRight(), mySquare);
        }
    }

    /**
     * @param ring int.
     * @return boolean.
     */
    boolean isInRing(int ring) {
        int min = ring - 1;
        int max = squareSize - ring;
        boolean inRow = myRow == min || myRow == max;
        boolean inCol = myColumn == min || myColumn == max;
        boolean rowInRange = min <= myRow && myRow <= max;
        boolean colInRange = min <= myColumn && myColumn <= max;
        return inRow && colInRange || inCol && rowInRange;
    }

    /**
     * @return String.
     */
    String getPrint() {
        return myStreamBuilder.toString();
    }

    /**
     * @return row.
     */
    int gRow() {
        return myRow;
    }

    /**
     * @return Column.
     */
    int gCol() {
        return myColumn;
    }

    /**
     * @return value.
     */
    int getValue() {
        return value;
    }

    /**
     * @return Square size.
     */
    int getSquareSize() {
        return squareSize;
    }

    /**
     * @return StreamBuilder.
     */
    StringBuilder getMyStreamBuilder() {
        return myStreamBuilder;
    }
}
