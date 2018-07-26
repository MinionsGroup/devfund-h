package org.minions.devfund.noemiguzman.moviedatabase;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class ActorTest {
    private Actor actor1;
    private Actor actor2;
    private Movie movie1;
    private Movie movie2;
    private ArrayList<Movie> movieList1;
    private ArrayList<Movie> movieList_2;

    @Before
    public void setUpActors() {
        movie1 = new Movie("movie1");
        movie2 = new Movie("movie2");

        movieList1 = new ArrayList<>();
        movieList1.add(movie1);
        movieList_2 = new ArrayList<>();
        movieList_2.add(movie2);

        actor1 = new Actor("actor1", movieList1);
        actor2 = new Actor("actor2", movieList_2);
    }

    @Test
    public void testActorConstructor() {
        assertEquals("actor1", actor1.getName());
        assertEquals(movieList1, actor1.getMovies());
    }

    @Test
    public void testAddMovie() {
        actor1.addMovie(movie2);
        movieList1.add(movie2);
        assertEquals(movieList1, actor1.getMovies());
    }
}
