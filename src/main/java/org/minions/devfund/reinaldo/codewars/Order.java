package org.minions.devfund.reinaldo.codewars;

import java.util.AbstractMap;
import java.util.Arrays;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.joining;

/**
 * Created by reinaldo on 08-07-18.
 */
public final class Order {

    /**
     *This is the constructor of the Order.
     */
    private Order() { }

    /**
     * Implements is for the order the word.
     * @param words word as parameter.
     * @return String order.
     */
    public static String order(final String words) {
        return Arrays.stream(words.split(" "))
                .map(word -> new AbstractMap.SimpleEntry<>(word, word.replaceAll("\\D+", "")))
                .sorted(comparing(AbstractMap.SimpleEntry::getValue))
                .map(AbstractMap.SimpleEntry::getKey)
                .collect(joining(" "));
    }
}
