package org.minions.devfund.benjamin;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * class to test movie class.
 */
public class MovieTest {
    private static final String MOVIE_NAME = "Batman Forever";
    /**
     * Test set/get name function.
     */
    @Test
    public void testSetName() {
        Movie movie = new Movie();
        movie.setName(MOVIE_NAME);
        assertEquals(MOVIE_NAME, movie.getName());
    }

    /**
     * Test add actors function.
     */
    @Test
    public void testAddActors() {
        Movie movie = new Movie();
        movie.setName(MOVIE_NAME);
        movie.addActors(new String[]{"Crhistian Bale", "Morgan Freeman"});
        assertEquals(2, movie.getSize());
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
