package org.minions.devfund.richard.whackamole;

/**
 * Class.
 */
public class MatrixPrintToUser implements MatrixActions {

    private static final char EMPTY_PLACE = '*';
    private static final char MOLE = 'M';

    /**
     * {@inheritDoc}
     */
    @Override
    public void action(final char[][] moleGrid, final int row, final int column, final StringBuilder myStreamBuilder) {
        myStreamBuilder.append(moleGrid[row][column] == MOLE ? EMPTY_PLACE : moleGrid[row][column]).append(" ");
    }
}
