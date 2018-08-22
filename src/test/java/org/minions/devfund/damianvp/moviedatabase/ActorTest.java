package org.minions.devfund.damianvp.moviedatabase;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Test Class for Actor.
 */
public class ActorTest {
    private Actor actor1;
    private Actor actor2;
    private Movie movie1;
    private Movie movie2;
    private Movie movie3;
    private Movie movie4;
    private String actorMacchio = "Ralph Macchio";
    private String actorFreeman = "Morgan Freeman";
    private String karateMovie = "Karate Kid";
    private String gloryMovie = "Glory";
    private String sevenMovie = "Seven";
    private String theShawshankRedemtionMovie = "The Shawshank Redemption";

    /**
     * Method to initialize each test.
     */
    @Before
    public void setUpActorTest() {

        actor1 = new Actor(actorMacchio);
        actor2 = new Actor(actorFreeman);
    }
    /**
     * method to test Actor constructor.
     */
    @Test
    public void testActorConstructor() {
        final ArrayList<Movie> emptyMovieList = new ArrayList<>();
        assertEquals(actorMacchio, actor1.getName());
        assertEquals(emptyMovieList, actor1.getMovies());
        assertEquals(actorFreeman, actor2.getName());
        assertEquals(emptyMovieList, actor1.getMovies());
    }
    /**
     * Method to test add movie method.
     */
    @Test
    public void testAddMovie() {
        movie1 = new Movie(karateMovie);
        movie2 = new Movie(gloryMovie);
        movie3 = new Movie(sevenMovie);
        movie4 = new Movie(theShawshankRedemtionMovie);
        final List<Movie> expectedList1 = Arrays.asList(movie1, movie2);
        final List<Movie> expectedList2 = Arrays.asList(movie2, movie3, movie4);
        actor1.addMovie(movie1);
        actor1.addMovie(movie2);
        actor2.addMovie(movie2);
        actor2.addMovie(movie3);
        actor2.addMovie(movie4);
        assertEquals(expectedList1, actor1.getMovies());
        assertEquals(expectedList2, actor2.getMovies());
    }



    /**
     * Method to test add movie already existent.
     */
    @Test
    public void testAddMovieAlreadyExist() {

        movie1 = new Movie(karateMovie);
        movie2 = new Movie(gloryMovie);
        movie3 = new Movie(sevenMovie);
        movie4 = new Movie(theShawshankRedemtionMovie);
        final List<Movie> expectedList1 = Arrays.asList(movie1, movie2);
        final List<Movie> expectedList2 = Arrays.asList(movie2, movie3, movie4);
        actor1.addMovie(movie1);
        actor1.addMovie(movie1);
        actor1.addMovie(movie2);
        actor2.addMovie(movie2);
        actor2.addMovie(movie3);
        actor2.addMovie(movie3);
        actor2.addMovie(movie4);
        assertEquals(expectedList1, actor1.getMovies());
        assertEquals(expectedList2, actor2.getMovies());
    }

    /**
     * Method to test set name method of Actor class.
     */
    @Test
    public void testSetName() {
        final String newName = "Ralph Macchio Test";
        actor1.setName(newName);
        assertEquals(newName, actor1.getName());
    }

    /**
     * Method to test getName method of Actor class.
     */
    @Test
    public void testGetName() {
        assertEquals(actorMacchio, actor1.getName());
        assertEquals(actorFreeman, actor2.getName());
    }

}
