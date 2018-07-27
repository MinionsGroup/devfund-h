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
    private String actorBale = "Christian Bale";
    private String actoreAffleck = "Ben Affleck";

    /**
     * Set movie 1 and movie2.
     */
    @Before
    public void setUpActors() {
        Movie movie1 = new Movie("Batman");
        movie2 = new Movie("Batman and Robin");

        movieList1 = new ArrayList<>();
        movieList1.add(movie1);

        actor1 = new Actor(actorBale, movieList1);
    }

    /**
     * method to test actor constructor.
     */
    @Test
    public void testActorConstructor() {
        assertEquals(actorBale, actor1.getName());
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
        assertEquals(actorBale, actor1.getName());
    }
    /**
     * Method to test set name actor.
     */
    @Test
    public void testSetName() {
        actor1.setName(actoreAffleck);
        assertEquals(actoreAffleck, actor1.getName());
    }
    /**
     * Method to test add movie.
     */
    @Test
    public void testAddMovieTwoTime() {
        actor1.addMovie(movie2);
        actor1.addMovie(movie2);
        assertEquals(movieList1, actor1.getMovies());
    }
}
