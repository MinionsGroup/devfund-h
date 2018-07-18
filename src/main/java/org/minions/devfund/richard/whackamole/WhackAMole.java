package org.minions.devfund.richard.whackamole;

/**
 * Class.
 */
public class WhackAMole {

    private int attemptsLeft;
    private char[][] moleGrid;
    private MatrixFill myMatrixFill;
    private int row;
    private int col;


    private StringBuilder myStringBuilder;

    /**
     * @param numAttempts   This variable is the number attempts.
     * @param gridDimension This variable is grid dimension..
     */
    WhackAMole(final int numAttempts, final int gridDimension) {
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
    boolean place(int row, int col) {
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
    String printGrid() {
        return iterateArray(new MatrixPrint());
    }

    /**
     * @return This returns string.
     */
    String printGridToUser() {
        return iterateArray(new MatrixPrintToUser());
    }

    /**
     * @param myMatrixActions This variable is the Interface.
     * @return This returns string.
     */
    private String iterateArray(final MatrixActions myMatrixActions) {
        myStringBuilder = new StringBuilder();
        for (int myRow = 0; myRow < moleGrid.length; myRow++) {
            for (int myColumn = 0; myColumn < moleGrid.length; myColumn++) {
                this.row = myRow;
                this.col = myColumn;
                myMatrixActions.action(this);
            }
        }
        return myStringBuilder.toString();
    }

    /**
     * @return This returns the attempts left.
     */
    int getAttemptsLeft() {
        return this.attemptsLeft;
    }

    /**
     * @return This returns the moles left.
     */
    int getMolesLeft() {
        return myMatrixFill.getMolesLeft();
    }

    /**
     * @return This returns the score.
     */
    int getScore() {
        return myMatrixFill.getScore();
    }

    /**
     * @return row.
     */
    int getRow() {
        return row;
    }

    /**
     * @return column;
     */
    int getCol() {
        return col;
    }

    /**
     * @return StringBuilder.
     */
    StringBuilder getMyStringBuilder() {
        return myStringBuilder;
    }

    /**
     * @return getMoleGrid.
     */
    char[][] getMoleGrid() {
        return moleGrid;
    }

}
