package org.minions.devfund.richard.square;

/**
 * Class.
 */
public class SquareFill extends SquareActions {

    /**
     * {@inheritDoc}
     */
    @Override
    public void action(final Square mySquare) {
        mySquare.getMatrix()[this.gRow()][this.gCol()] = this.getValue();
    }
}
