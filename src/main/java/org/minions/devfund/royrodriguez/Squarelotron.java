package org.minions.devfund.royrodriguez;

public class Squarelotron {
    public int[][] squarelotron;
    int size;

    public Squarelotron(int n) {
        this.size = n;
        this.squarelotron = new int[n][n];
        initialize();
    }

    public Squarelotron(int[][] matrix, int size) {
        this.size = size;
        this.squarelotron = matrix;
    }

    private void initialize() {
        int value = 1;
        for (int row = 0; row < squarelotron.length; row++) {
            for (int col = 0; col < squarelotron.length; col++) {
                squarelotron[row][col] = value;
                value++;
            }
        }
    }

    public boolean belongsToTheRing(int ring, int x, int y) {
        if (x < size + 1 && y < size + 1 && ring > 0) {
            if (!belongsToTheRing(ring - 1, x, y)) {
                if (((x == ring || y == ring))) {
                    return true;
                }
                if (x == ring + size - odd(ring)) return true;
                if (y == ring + size - odd(ring)) return true;
            }
        }
        return false;
    }

    public int odd(int n) {
        return 2 * n - 1;
    }

    public Squarelotron upsideDownFlip(int ring) {
        int[][] matrix = squarelotron;
        for (int row = 0; row < squarelotron.length / 2; row++) {
            for (int col = 0; col < squarelotron.length; col++) {
                if (belongsToTheRing(ring, row + 1, col + 1)) {
                    flip(row, col, matrix, matrix.length);
                }
            }
        }
        return new Squarelotron(squarelotron, size);
    }

    private void flip(int row, int col, int[][] matrix, int matrixSize) {
        int fRow = row + matrixSize - odd(row) - 2;
        int aux = matrix[row][col];
        matrix[row][col] = matrix[fRow][col];
        matrix[fRow][col] = aux;
    }

    public void printSquarelotron() {
        for (int row = 0; row < squarelotron.length; row++) {
            for (int col = 0; col < squarelotron.length; col++) {
                System.out.print(squarelotron[row][col] + "\t");
            }
            System.out.println();
        }
    }

    public Squarelotron mainDiagonalFlip(int ring) {
        int[][] matrix = squarelotron;
        int aux;
        for (int col = ring - 1; col <= matrix.length - ring; col++) {
            aux = matrix[ring - 1][col];
            matrix[ring - 1][col] = matrix[col][ring - 1];
            matrix[col][ring - 1] = aux;
        }
        int rowLimit = matrix.length % 2 == 1 ? matrix.length - ring : matrix.length;
        for (int row = ring; row < rowLimit; row++) {
            aux = matrix[row][matrix.length - ring];
            matrix[row][matrix.length - ring] = matrix[matrix.length - ring][row];
            matrix[matrix.length - ring][row] = aux;
        }
        return new Squarelotron(matrix, matrix.length);
    }

    public void rotateRight(int numberOfTurns) {
        int ring = maxRings(size);
        while (numberOfTurns > 0) {
            while (ring > 0) {
                squarelotron = upsideDownFlip(ring).squarelotron;
                ring--;
            }
            ring = maxRings(size);
            while (ring > 0) {
                squarelotron = mainDiagonalFlip(ring).squarelotron;
                ring--;
            }
            printSquarelotron();
            numberOfTurns--;
        }
    }

    private int maxRings(int size) {
        return size % 2 == 0 ? size / 2 : (size / 2) + 1;
    }
}
