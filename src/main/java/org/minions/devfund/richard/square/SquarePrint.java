package org.minions.devfund.richard.square;


/**
 * Class.
 */
public class SquarePrint extends SquareActions {

    /**
     * {@inheritDoc}
     */
    @Override
    protected void action(final Square mySquare) {
        this.getMyStreamBuilder().append(mySquare.getMatrix()[this.gRow()][this.gCol()]).append(" ");
    }
}
