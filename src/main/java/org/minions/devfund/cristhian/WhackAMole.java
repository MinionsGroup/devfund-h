package org.minions.devfund.cristhian;

/**
 * WhackAMole Game.
 */
public class WhackAMole {
    private int score;
    private int molesLeft;
    private int attemptsLeft;
    private char[][] moleGrid;

    /**
     * Constructor.
     *
     * @param numAttempts   test .
     * @param gridDimension test.
     */
    public WhackAMole(int numAttempts, int gridDimension) {

        attemptsLeft = numAttempts;

        moleGrid = new char[gridDimension][gridDimension];
        for (int i = 0; i < gridDimension; i++) {
            for (int j = 0; j < gridDimension; j++) {
                moleGrid[i][j] = '*';
            }
        }

    }

    /**
     * getScore.
     *
     * @return int.
     */
    public int getScore() {
        return score;
    }

    /**
     * getMolesLeft.
     *
     * @return int.
     */
    public int getMolesLeft() {
        return molesLeft;
    }

    /**
     * getAttempsLeft.
     *
     * @return int.
     */
    public int getAttemptsLeft() {
        return attemptsLeft;
    }

    /**
     * place method.
     *
     * @param x int
     * @param y int
     * @return bollean
     */
    public boolean place(int x, int y) {


        if (x < moleGrid.length && y < moleGrid.length && moleGrid[x][y] != 'M') {
            moleGrid[x][y] = 'M';
            molesLeft++;
            return true;
        }

        return false;
    }

    /**
     * whack method.
     *
     * @param x int
     * @param y int
     */
    public void whack(int x, int y) {

        attemptsLeft--;
        final int val1 = 9;
        if (x < val1 && y < val1) {
            if (moleGrid[x][y] == 'M') {
                moleGrid[x][y] = 'W';
                score++;
                molesLeft--;
                System.out.println("Good, you Hit!!");
            } else {
                System.out.println("Try Again.");
            }
        } else {
            System.out.printf("The x or y value cannot be greater than 9");

        }
    }

    /**
     * print GridToUser method.
     *
     * @return bollean
     */
    public String printGridToUser() {
        System.out.println("--WhackAMole Game--");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < moleGrid.length; i++) {
            for (int j = 0; j < moleGrid.length; j++) {
                if (moleGrid[i][j] == 'M') {
                    System.out.print('*');
                    stringBuilder.append("*");
                } else {
                    System.out.print(moleGrid[i][j]);
                    stringBuilder.append(moleGrid[i][j]);
                }
            }
            System.out.println();
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    /**
     * printGrid method test 1.
     *
     * @return bollean
     */
    public String printGrid() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < moleGrid.length; i++) {
            for (int j = 0; j < moleGrid.length; j++) {
                System.out.print(moleGrid[i][j]);
                stringBuilder.append(moleGrid[i][j]);
            }
            System.out.println();
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }


}
