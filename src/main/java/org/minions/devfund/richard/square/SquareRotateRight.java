package org.minions.devfund.richard.square;

/**
 * Class.
 */
public class SquareRotateRight extends SquareActions {
    /**
     * {@inheritDoc}
     */
    @Override
    protected void action(final Squarelotron mySquare) {
        int trueValue = mySquare.getSquareCopy()[squareSize - myColumn - 1][myRow];
        int falseValue = mySquare.getSquareCopy()[myColumn][squareSize - myRow - 1];
        mySquare.getSquare()[myRow][myColumn] = (mySquare.getNumberOfTurns() > 0) ? trueValue : falseValue;
    }
}
