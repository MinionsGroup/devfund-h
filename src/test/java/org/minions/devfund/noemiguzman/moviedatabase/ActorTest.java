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
    private Movie movie1;
    private Movie movie2;
    private ArrayList<Movie> movieList1;
    private ArrayList<Movie> movieList2;

    /**
     * Set movie 1 and movie2.
     */
    @Before
    public void setUpActors() {
        movie1 = new Movie("movie1");
        movie2 = new Movie("movie2");

        movieList1 = new ArrayList<>();
        movieList1.add(movie1);
        movieList2 = new ArrayList<>();
        movieList2.add(movie2);

        actor1 = new Actor("actor1", movieList1);
    }

    /**
     * method to test actor constructor.
     */
    @Test
    public void testActorConstructor() {
        assertEquals("actor1", actor1.getName());
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
}
