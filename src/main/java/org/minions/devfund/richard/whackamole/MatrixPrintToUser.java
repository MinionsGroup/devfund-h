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
    public void action(final WhackAMole myW) {
        final char[][] moleGrid = myW.getMoleGrid();
        final int row = myW.getRow();
        final int col = myW.getCol();
        myW.getMyStringBuilder().append(moleGrid[row][col] == MOLE ? EMPTY_PLACE : moleGrid[row][col]).append(" ");
    }
}
