package org.minions.devfund.carlosorellana;

/**
 * The goal is execute the Squarelotron methods.
 *
 * @author Carlos Orellana.
 * @since 07/17/2018.
 */
public class Squarelotron {

    private int[][] squarelotron;
    private int size;

    /**
     * Constructor Sqarelotron.
     *
     * @param n - Size of squarelotron array.
     */
    public Squarelotron(final int n) {
        this.size = n;
        this.squarelotron = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                squarelotron[i][j] = i * size + j + 1;
            }
        }
    }

    /**
     * Constructor Squarelotron.
     *
     *  @param array - New Squarelotron array
     */
    public Squarelotron(int[] array){
        this.size = (int) Math.sqrt(array.length);
        this.squarelotron = new int[size][size];
        int indexArray = 0;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                squarelotron[i][j] = array[indexArray];
                indexArray++;
            }
        }
    }

    public int[] buildArray() {
        int[] newArray = new int[this.size * this.size];

        for(int x = 0; x < this.size; x++) {

            for (int y = 0; y < this.size; y++) {
                newArray[x * this.size + y] = squarelotron[x][y];
//                System.out.println(squarelotron[x][y]);
//                System.out.println('|');
//                System.out.println(newArray[x * this.size + y]);
//                System.out.println('-');
            }
        }


        return newArray;
    }

    public Squarelotron upsideDownFlip(int ring) {

        int[] arrayToChange = buildArray();
        int[] squarelotronArray = new int[this.size * this.size];

        for(int x = 0; x < this.size; x++) {
            for(int y = 0; y < this.size; y++){

                if(x == ring - 1 || x == this.size - ring || y == ring - 1 || y == this.size - ring){
                    int indexSquarelotron = x * this.size + y;
                    int indexArrayToChange = (this.size - x - 1) * this.size + y;
                    squarelotronArray[indexSquarelotron] = arrayToChange[indexArrayToChange];
                }//0 * 5 + 0 = 0 // (5 - 0 - 1) = 4 *
                 else {
                    int a = x * size + y;
                    int b = x * size + y;
                    squarelotronArray[a] = arrayToChange[b];
                }

            }
        }
        return new Squarelotron(squarelotronArray);
    }
    /**
     * hola.
     * @return Sting.
     */
    @Override
    public String toString() {
        StringBuffer sqString = new StringBuffer();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sqString.append(squarelotron[i][j] + "\t");
            }

            sqString.append("\n");
        }
        return sqString.toString();
    }
}
