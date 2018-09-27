package org.minions.devfund.richard.square;

/**
 * Class.
 */
public class SquareUpdate extends SquareActions {
    /**
     * @param mySquare Square.
     */
    @Override
    protected void action(final Square mySquare) {
        mySquare.getNewSquare().getMatrix()[this.gRow()][this.gCol()] = mySquare.getMatrix()[this.gRow()][this.gCol()];
    }
}
