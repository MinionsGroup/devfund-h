package org.minions.devfund.richard.square;

/**
 * Abstract class.
 */
public abstract class SquareActions {

    static int myRow;
    static int myColumn;
    static int value;
    static int squareSize;
    static StringBuilder myStreamBuilder;

    /**
     * @param mySquareActions mySquareActions.
     * @param mySquarelotron  mySquarelotron.
     * @return mySquareActions.
     */
    static SquareActions action(final SquareActions mySquareActions, final Squarelotron mySquarelotron) {
        value = 0;
        squareSize = mySquarelotron.getSquare().length;
        myStreamBuilder = new StringBuilder();
        for (int row = 0; row < squareSize; row++) {
            for (int column = 0; column < squareSize; column++) {
                myRow = row;
                myColumn = column;
                value++;
                mySquareActions.action(mySquarelotron);
            }
        }
        return mySquareActions;
    }

    /**
     * @param mySquare Square.
     */
    public static void rotateRight(final Squarelotron mySquare) {
        for (int ind = 0; ind < Math.abs(mySquare.getNumberOfTurns()); ind++) {
            SquareActions.action(new SquareCopy(), mySquare);
            SquareActions.action(new SquareRotateRight(), mySquare);
        }
    }

    /**
     * @param mySquare Square.
     */
    protected abstract void action(Squarelotron mySquare);

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
    public String getPrint() {
        return myStreamBuilder.toString();
    }
}
