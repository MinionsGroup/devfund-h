package org.minions.devfund.richard.whackamole;

/**
 * Class.
 */
public class MatrixFill implements MatrixActions {
    private static final int ZERO = 0;
    private static final char EMPTY_PLACE = '*';
    private static final char MOLE = 'M';
    private static final char MOLE_WHACKED = 'W';
    private int molesLeft;
    private int score;

    /**
     * {@inheritDoc}
     */
    @Override
    public void action(final char[][] moleGrid, final int row, final int column, final StringBuilder myStreamBuilder) {
        moleGrid[row][column] = EMPTY_PLACE;
    }

    /**
     * @param moleGrid This variable is the array.
     * @param row      This variable is the row.
     * @param col      This variable is the column.
     * @return This returns the boolean.
     */
    public boolean setMole(final char[][] moleGrid, final int row, final int col) {
        boolean valueReturned = this.isValidPosition(moleGrid, row, col, EMPTY_PLACE);
        if (valueReturned) {
            moleGrid[row][col] = MOLE;
            this.molesLeft++;
        }
        return valueReturned;
    }

    /**
     * @param moleGrid This variable is the array.
     * @param row      This variable is the row.
     * @param col      This variable is the column.
     */
    public void setWhack(final char[][] moleGrid, final int row, final int col) {
        if (isValidPosition(moleGrid, row, col, MOLE)) {
            this.molesLeft--;
            this.score++;
            moleGrid[row][col] = MOLE_WHACKED;
        }
    }

    /**
     * @param moleGrid      This variable is the array.
     * @param row           This variable is the row.
     * @param col           This variable is the column.
     * @param positionValue This variable is the value position.
     * @return This returns the boolean.
     */
    private boolean isValidPosition(final char[][] moleGrid, final int row, final int col, final char positionValue) {
        boolean checkRow = ZERO <= row && row < moleGrid.length;
        boolean checkCol = ZERO <= col && col < moleGrid.length;
        return checkRow && checkCol && positionValue == moleGrid[row][col];
    }

    /**
     * @return This returns the moles left.
     */
    public int getMolesLeft() {
        return this.molesLeft;
    }

    /**
     * @return This returns the score.
     */
    public int getScore() {
        return this.score;
    }
}
