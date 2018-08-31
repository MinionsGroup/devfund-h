package org.minions.devfund.richard;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Class.
 */
public class CircularPrimes {

    private static final int TEEN = 10;
    private ArrayList<Integer> circularPrimesList;
    private int range;

    /**
     * @param range Range.
     */
    CircularPrimes(final int range) {
        this.circularPrimesList = new ArrayList<>();
        this.range = range;
    }

    /**
     * @param number number.
     * @return boolean.
     */
    private boolean isCircularPrime(final int number) {
        StringBuilder myStringBuilder = new StringBuilder();
        myStringBuilder.append(number).reverse();
        return isPrime(number) && isPrime(Integer.parseInt(myStringBuilder.toString()));
    }

    /**
     * @param number number.
     * @return boolean.
     */
    private boolean isCircularPrimeWithoutString(final int number) {
        return isPrime(number) && isPrime(this.reverseNumber(number));
    }


    /**
     * @param number number.
     * @return int.
     */
    int reverseNumber(final int number) {
        int numberOfDigits = this.getNumberOfDigits(number);
        if (numberOfDigits <= 1) {
            return number;
        }
        int reverse = 0;
        int[] arrayNumbers = this.getArrayOfNumbers(number);
        int ind = numberOfDigits - 1;
        int decimal = (int) Math.pow(TEEN, ind);
        while (ind >= 0) {
            reverse += arrayNumbers[ind] * decimal;
            decimal /= TEEN;
            ind--;
        }
        return reverse;
    }

    /**
     * @param number number.
     * @return Array of Numbers.
     */
    int[] getArrayOfNumbers(final int number) {
        int numberOfDigits = getNumberOfDigits(number);
        int temp = number;
        int module;
        int[] arrayNumbers = new int[numberOfDigits];
        for (int i = numberOfDigits - 1; i >= 0; i--) {
            module = temp % TEEN;
            arrayNumbers[i] = module;
            temp /= TEEN;
        }
        return arrayNumbers;
    }

    /**
     * @param number number.
     * @return int.
     */
    int getNumberOfDigits(final int number) {
        if (number >= TEEN) {
            return getNumberOfDigits(number / TEEN) + 1;
        } else {
            return 1;
        }
    }

    /**
     * @param number number.
     * @return boolean.
     */
    private boolean isPrime(final int number) {
        return IntStream.rangeClosed(2, number / 2).noneMatch(i -> number % i == 0);
    }

    /**
     * Fill to List.
     */
    void fillListToCircularPrimes() {
        for (int i = 1; i <= range; i++) {
            if (isCircularPrime(i)) {
                circularPrimesList.add(i);
            }
        }
    }

    /**
     * Fill to List.
     */
    void fillListToCircularPrimesWithoutStrings() {
        for (int i = 1; i <= range; i++) {
            if (isCircularPrimeWithoutString(i)) {
                circularPrimesList.add(i);
            }
        }
    }

    /**
     * @return List.
     */
    List<Integer> getCircularPrimesList() {
        return circularPrimesList;
    }
}
