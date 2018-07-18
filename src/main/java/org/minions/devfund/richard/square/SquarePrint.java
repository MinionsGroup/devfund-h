package org.minions.devfund.richard.square;


/**
 * Class.
 */
public class SquarePrint extends SquareActions {

    /**
     * {@inheritDoc}
     */
    @Override
    protected void action(final Squarelotron mySquare) {
        myStreamBuilder.append(mySquare.getSquare()[myRow][myColumn]).append(" ");
    }
}
