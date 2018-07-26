package org.minions.devfund.noemiguzman.moviedatabase;

import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MovieTest {
    private Actor actor1;
    private Actor actor2;
    private Movie movie1;
    private Movie movie2;
    private ArrayList<Movie> movieList1;
    private ArrayList<Movie> movieList2;
    private ArrayList<Actor> actorList;

    @Before
    public void setUp() {
        movie1 = new Movie("movie1");
        movie2 = new Movie("movie2");

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

    @Test
    public void testConstructor() {
        assertEquals("movie1", movie1.getName());
        assertEquals(actor1, movie1.getActors().get(0));
    }

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

