package org.minions.devfund.katerinaanzoleaga;

public class WhackAMole {
    int score = 0;
    int molesLeft;
    int attemptsLeft;
    char[][] moleGrid;

    //WhackaMole constructor requires, the maximum number of attempts and array dimension
    WhackAMole(int numAttempts, int gridDimension) {
        if (numAttempts < 0 || gridDimension < 0) {
            throw new NegativeArraySizeException();
        }

        this.attemptsLeft = numAttempts;
        this.moleGrid = new char[gridDimension][gridDimension];
        this.molesLeft = 0;
    }

    /* Places a mole in the row and column indicated, return false if it is not possible wither because there is a mole there already
     * or when the row and column are invalid for the dimensions of the grid
     * Also increases the number of moles left in the grid.
     */
    boolean place(int x, int y) {
        if (x < 0 || y < 0) {
            return false;
        }
        int max_index = this.moleGrid.length - 1;
        if (x <= max_index && y <= max_index && moleGrid[x][y] !='M') {
            this.moleGrid[x][y]='M';
            this.molesLeft = this.molesLeft + 1;
            return true;
        }
        else
            return false;
    }

    /**
     * Whacks a position indicated by the row and column parameter. If the position is out of the grid it will count as a failure.
     * If there is a mole in the position, then the score will increase
     */

    void whack(int x, int y) {
        if (x < 0 || y < 0) {
            this.attemptsLeft = this.attemptsLeft - 1;
        }
        else {
            int max_index = this.moleGrid.length - 1;
            if (x <= max_index && y <= max_index && moleGrid[x][y] == 'M') {
                this.moleGrid[x][y] = 'W';
                this.molesLeft = this.molesLeft - 1;
                this.score = this.score + 1;
            }
            this.attemptsLeft = this.attemptsLeft - 1;
        }
    }


    void printGridToUser() {
        int max_index = this.moleGrid.length - 1;
        for (int i = 0; i <= max_index; i++){
            for (int j = 0; j <= max_index; j++) {
                if (this.moleGrid[i][j] == 'M' || this.moleGrid[i][j] == '\u0000'){
                    System.out.print("   *");
                }
                else
                    System.out.print("   " + this.moleGrid[i][j]);

            }
            System.out.println();
        }
    }


    void printGrid() {
        int max_index = this.moleGrid.length - 1;
        for (int i = 0; i <= max_index; i++){
            for (int j = 0; j <= max_index; j++) {
                if (this.moleGrid[i][j] == '\u0000'){
                    System.out.print("   *");
                }
                else
                    System.out.print("   " + this.moleGrid[i][j]);
            }
            System.out.println();
        }
    }


    // Places N moles in randomic positions
    void placeNMoles(int N) {
        int i = 1;
        while (i <= N){
            Random randomGenerator = new Random();
            int x = randomGenerator.nextInt(this.moleGrid.length);
            int y = randomGenerator.nextInt(this.moleGrid.length);
            if (this.place(x, y)) {
                i = i + 1;	    }
        }
    }


    public static void main(String args[]) {
        int dimension = 10;
        int totalMoles =10;
        int maxAttempts = 50;
        WhackAMole wackamole = new WhackAMole(maxAttempts, dimension);
        wackamole.placeNMoles(totalMoles);
        System.out.println("Welcome to WackAMole game. Enter -1 and -1 to exit");
        System.out.println();
        wackamole.printGridToUser();
        int r = 0;
        int c = 0;
        while (wackamole.attemptsLeft > 0 && wackamole.score < totalMoles) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter row number: ");
            System.out.println();
            r = scanner.nextInt();
            System.out.print("Enter column number: ");
            System.out.println();
            c = scanner.nextInt();
            if (r == -1 && c == -1) {
                System.out.println("Good bye! ");
                System.out.println();
                wackamole.printGrid();
                break;
            }
            wackamole.whack(r, c);
            wackamole.printGridToUser();
            System.out.println("Remaining attempts: " + wackamole.attemptsLeft);
            System.out.println("Remaining moles:  " + wackamole.molesLeft);
            System.out.println("Score:  " + wackamole.score);
            System.out.println();
        }
        if (wackamole.score == totalMoles) {
            System.out.println("You won! ");
        }
        if (wackamole.attemptsLeft == 0) {
            System.out.println("You lost! ");
            System.out.println();
            wackamole.printGrid();
        }

    }

}
