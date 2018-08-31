package org.minions.devfund.richard.square;

/**
 * Class.
 */
public class SquareRotateRight extends SquareActions {
    /**
     * {@inheritDoc}
     */
    @Override
    protected void action(final Square mySquare) {
        int tValue = mySquare.getMatrixCopy()[this.getSquareSize() - this.gCol() - 1][this.gRow()];
        int fValue = mySquare.getMatrixCopy()[this.gCol()][this.getSquareSize() - this.gRow() - 1];
        mySquare.getMatrix()[this.gRow()][this.gCol()] = mySquare.getNumberOfTurns() > 0 ? tValue : fValue;
    }
}
