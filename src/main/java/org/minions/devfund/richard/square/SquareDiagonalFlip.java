package org.minions.devfund.richard.square;

/**
 * Class.
 */
public class SquareDiagonalFlip extends SquareActions {
    /**
     * {@inheritDoc}
     */
    @Override
    protected void action(final Squarelotron mySquare) {
        if (isInRing(mySquare.getRing())) {
            mySquare.getSquarelotron()[this.gRow()][this.gCol()] = mySquare.getSquareCopy()[this.gCol()][this.gRow()];
        }
    }
}
