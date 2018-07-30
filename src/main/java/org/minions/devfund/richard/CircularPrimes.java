package org.minions.devfund.richard;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Class.
 */
public class CircularPrimes {


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
     * @return List.
     */
    List<Integer> getCircularPrimesList() {
        return circularPrimesList;
    }
}
