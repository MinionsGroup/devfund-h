package org.minions.devfund.richard.whackamole;

/**
 * Class.
 */
public class MatrixPrint implements MatrixActions {
    /**
     *  {@inheritDoc}
     */
    @Override
    public void action(final char[][] moleGrid, final int row, final int column, final StringBuilder myStreamBuilder) {
        myStreamBuilder.append(moleGrid[row][column]).append(" ");
    }
}
