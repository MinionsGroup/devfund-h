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
        this.getMyStreamBuilder().append(mySquare.getSquarelotron()[this.gRow()][this.gCol()]).append(" ");
    }
}
