package org.minions.devfund.reinaldo.codewars;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by reinaldo on 08-07-18.
 */
public class AccumulTest {

    /**
     * Method for verifies the assert equal.
     * @param actual result.
     * @param expected result.
     */
    private static void testing(final String actual, final String expected) {
        assertEquals(expected, actual);
    }

    /**
     * Test for verify the Accumul.
     */
    @Test
    public void test() {

        testing(Accumul.accum("Zpg"), "Z-Pp-Ggg");
        testing(Accumul.accum("NyffsGeyylB"),
                "N-Yy-Fff-Ffff-Sssss-Gggggg-Eeeeeee-Yyyyyyyy-Yyyyyyyyy-Llllllllll-Bbbbbbbbbbb");
        testing(Accumul.accum("MjtkuBovqrU"),
                "M-Jj-Ttt-Kkkk-Uuuuu-Bbbbbb-Ooooooo-Vvvvvvvv-Qqqqqqqqq-Rrrrrrrrrr-Uuuuuuuuuuu");
        testing(Accumul.accum("EvidjUnokmM"),
                "E-Vv-Iii-Dddd-Jjjjj-Uuuuuu-Nnnnnnn-Oooooooo-Kkkkkkkkk-Mmmmmmmmmm-Mmmmmmmmmmm");
        testing(Accumul.accum("HbideVbxncC"),
                "H-Bb-Iii-Dddd-Eeeee-Vvvvvv-Bbbbbbb-Xxxxxxxx-Nnnnnnnnn-Cccccccccc-Ccccccccccc");
    }
}
