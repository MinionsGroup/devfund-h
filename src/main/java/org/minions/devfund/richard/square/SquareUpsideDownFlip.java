package org.minions.devfund.richard.square;

/**
 * Class.
 */
public class SquareUpsideDownFlip extends SquareActions {
    /**
     * {@inheritDoc}
     */
    @Override
    protected void action(final Square mySquare) {
        if (isInRing(mySquare.getRing())) {
            mySquare.getMatrix()[this.gRow()][this.gCol()] =
                    mySquare.getMatrixCopy()[this.getSquareSize() - this.gRow() - 1][this.gCol()];
        }
    }
}
