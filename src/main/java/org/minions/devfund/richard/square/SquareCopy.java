package org.minions.devfund.richard.square;

/**
 * Class.
 */
public class SquareCopy extends SquareActions {
    /**
     * {@inheritDoc}
     */
    @Override
    protected void action(final Squarelotron mySquare) {
        mySquare.getSquareCopy()[this.gRow()][this.gCol()] = mySquare.getSquarelotron()[this.gRow()][this.gCol()];
    }
}
