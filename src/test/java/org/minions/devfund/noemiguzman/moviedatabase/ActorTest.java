package org.minions.devfund.noemiguzman.moviedatabase;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * class to test actor.
 */
public class ActorTest {
    private Actor actor1;
    private Movie movie2;
    private ArrayList<Movie> movieList1;

    /**
     * Set movie 1 and movie2.
     */
    @Before
    public void setUpActors() {
        Movie movie1 = new Movie("Batman");
        movie2 = new Movie("Batman and Robin");

        movieList1 = new ArrayList<>();
        movieList1.add(movie1);

        actor1 = new Actor("Christian Bale", movieList1);
    }

    /**
     * method to test actor constructor.
     */
    @Test
    public void testActorConstructor() {
        assertEquals("Christian Bale", actor1.getName());
        assertEquals(movieList1, actor1.getMovies());
    }

    /**
     * Method to test add movie.
     */
    @Test
    public void testAddMovie() {
        actor1.addMovie(movie2);
        movieList1.add(movie2);
        assertEquals(movieList1, actor1.getMovies());
    }
    /**
     * Method to test get name actor.
     */
    @Test
    public void testGetName() {
        String expectecName = "Christian Bale";
        assertEquals(expectecName, actor1.getName());
    }
}
