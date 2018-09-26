package org.minions.devfund.benjamin;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * class to tes movie class.
 */
public class MovieTest {
    /**
     * Test set name function.
     */
    @Test
    public void testSetName() {
        Movie movie = new Movie();
        String movieName = "BATMAN";
        movie.setName(movieName);
        assertEquals(movieName, movie.getName());
    }

    /**
     * Test add actors function.
     */
    @Test
    public void testAddActors() {
        Movie movie = new Movie();
        String movieName = "BATMAN";
        movie.setName(movieName);
        movie.addActors(new String[]{"Crhistian Bale", "Morgan Freeman"});
        assertEquals(2, movie.getSize());
    }

    /**
     * Test get movie name function.
     */
    @Test
    public void testGetName() {
        Movie movie = new Movie();
        String movieName = "BATMAN";
        movie.setName(movieName);
        assertEquals(movieName, movie.getName());
    }

    /**
     * Test set rating function.
     */
    @Test
    public void testSetRating() {
        Movie movie = new Movie();
        final double ten = 10;
        movie.setRating(ten);
        assertEquals(ten, movie.getRating(), 0.0);
    }
}
