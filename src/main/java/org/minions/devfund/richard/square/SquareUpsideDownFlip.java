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
            mySquare.getSquare()[myRow][myColumn] = mySquare.getSquareCopy()[squareSize - myRow - 1][myColumn];
        }
    }
}
