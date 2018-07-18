package org.minions.devfund.richard.square;

/**
 * Class.
 */
public class SquareUpsideDownFlip extends SquareActions {
    /**
     * {@inheritDoc}
     */
    @Override
    protected void action(final Squarelotron mySquare) {
        if (isInRing(mySquare.getRing())) {
            mySquare.getSquarelotron()[this.gRow()][this.gCol()] =
                    mySquare.getSquareCopy()[this.getSquareSize() - this.gRow() - 1][this.gCol()];
        }
    }
}
