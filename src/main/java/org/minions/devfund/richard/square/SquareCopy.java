package org.minions.devfund.richard.square;

/**
 * Class.
 */
public class SquareCopy extends SquareActions {
    /**
     * {@inheritDoc}
     */
    @Override
    protected void action(final Square mySquare) {
        mySquare.getMatrixCopy()[this.gRow()][this.gCol()] = mySquare.getMatrix()[this.gRow()][this.gCol()];
    }
}
