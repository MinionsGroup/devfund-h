package org.minions.devfund.richard.square;

/**
 * Class.
 */
public class SquareFill extends SquareActions {

    /**
     * {@inheritDoc}
     */
    @Override
    public void action(final Squarelotron mySquare) {
        mySquare.getSquarelotron()[this.gRow()][this.gCol()] = this.getValue();
    }
}
