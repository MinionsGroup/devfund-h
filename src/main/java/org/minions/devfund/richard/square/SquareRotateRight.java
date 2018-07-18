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
        int tValue = mySquare.getSquareCopy()[this.getSquareSize() - this.gCol() - 1][this.gRow()];
        int fValue = mySquare.getSquareCopy()[this.gCol()][this.getSquareSize() - this.gRow() - 1];
        mySquare.getSquarelotron()[this.gRow()][this.gCol()] = mySquare.getNumberOfTurns() > 0 ? tValue : fValue;
    }
}
