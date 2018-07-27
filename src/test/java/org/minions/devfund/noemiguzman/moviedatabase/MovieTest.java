package org.minions.devfund.noemiguzman.moviedatabase;

import java.util.ArrayList;

/**
 * class to test movie.
 */

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *  Class to test Movie.
 */

public class MovieTest {
    private Actor actor1;
    private Actor actor2;
    private Movie movie1;
    private Movie movie2;
    private ArrayList<Movie> movieList1;
    private ArrayList<Movie> movieList2;
    private ArrayList<Actor> actorList;

    /**
     * Setup movie1 and movie2.
     */
    @Before
    public void setUp() {
        movie1 = new Movie("Batman");
        movie2 = new Movie("Super man");

        movieList1 = new ArrayList<>();
        movieList1.add(movie1);
        movieList2 = new ArrayList<>();
        movieList2.add(movie2);

        actorList = new ArrayList<>();

        actor1 = new Actor("actor1", movieList1);
        actor2 = new Actor("actor2", movieList2);

        movie1.addActor(actor1);
        movie2.addActor(actor2);
    }

    /**
     * Method to test movie constructor.
     */
    @Test
    public void testConstructor() {
        assertEquals("Batman", movie1.getName());
        assertEquals(actor1, movie1.getActors().get(0));
    }

    /**
     *  Method to test add movie actor.
     */
    @Test
    public void testAddMovieActor() {
        movie2.addActor(actor1);

        actorList.add(actor2);
        actorList.add(actor1);
        assertEquals(actorList, movie2.getActors());

        movie2.addActor(actor2);
        assertEquals(actorList, movie2.getActors());
    }

}

