package org.minions.devfund.richard.whackamole;

/**
 * Class.
 */
public class WhackAMole {

    private int attemptsLeft;
    private char[][] moleGrid;
    private MatrixFill myMatrixFill;

    /**
     * @param numAttempts   This variable is the number attempts.
     * @param gridDimension This variable is grid dimension..
     */
    public WhackAMole(final int numAttempts, final int gridDimension) {
        this.moleGrid = new char[gridDimension][gridDimension];
        this.attemptsLeft = numAttempts;
        myMatrixFill = new MatrixFill();
        this.iterateArray(myMatrixFill);
    }

    /**
     * @param row This variable is the row.
     * @param col This variable is the column.
     * @return This returns the boolean.
     */
    public boolean place(int row, int col) {
        return myMatrixFill.setMole(moleGrid, row, col);
    }

    /**
     * @param row This variable is the row.
     * @param col This variable is the column.
     */
    void whack(final int row, final int col) {
        this.attemptsLeft--;
        myMatrixFill.setWhack(moleGrid, row, col);
    }

    /**
     * @return This returns string.
     */
    public String printGrid() {
        return iterateArray(new MatrixPrint());
    }

    /**
     * @return This returns string.
     */
    public String printGridToUser() {
        return iterateArray(new MatrixPrintToUser());
    }

    /**
     * @param myMatrixActions This variable is the Interface.
     * @return This returns string.
     */
    private String iterateArray(final MatrixActions myMatrixActions) {
        StringBuilder myStringBuilder = new StringBuilder();
        for (int row = 0; row < moleGrid.length; row++) {
            for (int column = 0; column < moleGrid.length; column++) {
                myMatrixActions.action(moleGrid, row, column, myStringBuilder);
            }
        }
        return myStringBuilder.toString();
    }

    /**
     * @return This returns the attempts left.
     */
    public int getAttemptsLeft() {
        return this.attemptsLeft;
    }

    /**
     * @return This returns the moles left.
     */
    public int getMolesLeft() {
        return myMatrixFill.getMolesLeft();
    }

    /**
     * @return This returns the score.
     */
    public int getScore() {
        return myMatrixFill.getScore();
    }
}
