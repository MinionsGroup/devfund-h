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
        mySquare.getSquareCopy()[myRow][myColumn] = mySquare.getSquare()[myRow][myColumn];
    }
}
