package org.minions.devfund.noemiguzman.moviedatabase;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;


import static junit.framework.TestCase.assertTrue;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 *  Class to test movie database.
 */
public class MovieDatabaseTest {
    private MovieDatabase moviedb1;
    private MovieDatabase moviedb2;
    private MovieDatabase moviedb3;

    private Movie movie1 = new Movie("Glass");
    private Movie movie2 = new Movie("Batman");
    private Movie movie3 = new Movie("It");
    private ArrayList<Movie> movieList1;
    private ArrayList<Movie> movieList2;
    private ArrayList<Movie> movieList3;

    private Actor actor1;
    private Actor actor2;
    private Actor actor3;

    private ArrayList<Movie> movieList;
    private ArrayList<Actor> actorList;

    /**
     * Method to setup movie1 and movie2.
     */

    @Before
    public void setUpMovieDatabases() {
        moviedb1 = new MovieDatabase();
        moviedb2 = new MovieDatabase();
        moviedb3 = new MovieDatabase();



        movieList1 = new ArrayList<>();
        movieList1.add(movie1);
        movieList2 = new ArrayList<>();
        movieList2.add(movie2);
        movieList3 = new ArrayList<>();
        movieList3.add(movie3);

        actor1 = new Actor("Ben Affleck", movieList1);
        actor2 = new Actor("Adam West", movieList2);
        actor3 = new Actor("Christian Bale", movieList3);

        movie1.addActor(actor1);
        movie2.addActor(actor2);
        movie3.addActor(actor3);

        movieList = new ArrayList<>();
        actorList = new ArrayList<>();
    }

    /**
     *  Method to test constructor movie database.
     */
    @Test
    public void testConstructor() {
        assertEquals(movieList, moviedb1.getMovieList());
        assertEquals(actorList, moviedb2.getActorList());
    }

    /**
     *  Method to test add movie.
     */
    @Test
    public void testAddMovie() {

        String[] actors1 = new String[] {"Ben Affleck", "Adam West"};
        moviedb3.addMovie("Glass", actors1);

        movieList.add(movie1);

        assertTrue(movieList.equals(moviedb3.getMovieList()));
    }
    /**
     *  Method to test add movie two time.
     */
    @Test
    public void testAddMovieTwoTime() {

        String[] actors1 = new String[] {"Ben Affleck", "Adam West"};
        moviedb3.addMovie("Glass", actors1);
        moviedb3.addMovie("Glass", actors1);
        movieList.add(movie1);

        assertTrue(movieList.equals(moviedb3.getMovieList()));
    }
    /**
     *  Method to test add movie.
     */
    @Test
    public void testAddMovieWithActor() {
        movieList.add(movie2);

        String[] actors2;
        actors2 = new String[] {"Ben Affleck", "Adam West", "Christian Bale"};

        String[] newActors2 = actors2.clone();
        assertArrayEquals(newActors2, actors2);
        assertFalse(newActors2 == actors2);
        moviedb3.addMovie("Batman", newActors2);
        assertTrue(movieList.equals(moviedb3.getMovieList()));
    }
    /**
     *  Method to test add rating.
     */
    @Test
    public void testAddRating() {
        final Double expectedRating = 7.8;
        String[] actors = new String[] {"Ben Affleck", "Adam West"};
        moviedb2.addMovie("Batman", actors);
        moviedb2.addRating("Batman", expectedRating);
        assertEquals(expectedRating, moviedb2.getMovieList().get(0).getRating(), 0);
    }

    /**
     *  Method to test update rating.
     */
    @Test
    public void testUpdateRating() {
        String[] actors = new String[] {"Ben Affleck", "Adam West"};
        final Double expected1 =  25.10;
        final Double expectedFinal = 32.10;
        moviedb2.addMovie("Batman", actors);
        moviedb2.addRating("Batman", expected1);
        moviedb2.updateRating("Batman", expectedFinal);
        assertEquals(expectedFinal, moviedb2.getMovieList().get(0).getRating(), 0);
    }

    /**
     * Method to test get best actor.
     */
    @Test
    public void testGetBestActor() {

        String[] actors1 = new String[] {"Ben Affleck", "Adam West"};
        String expectedBestActor = "Adam West";
        final Double expectedRating1 = 5.5;
        moviedb1.addMovie("Glass", actors1);
        moviedb1.addRating("Glass", expectedRating1);

        String[] actors2;
        actors2 = new String[] {"Adam West", "Ben Affleck", "Christian Bale"};
        final Double expectedRating2 = 6.5;
        moviedb1.addMovie("Batman", actors2);
        moviedb1.addRating("Batman", expectedRating2);

        String[] actors3;
        actors3 = new String[] {"Adam West", "Christian Bale"};
        final Double expectedRating3 = 7.5;
        moviedb1.addMovie("It", actors3);
        moviedb1.addRating("It", expectedRating3);

        // actor1 movies
        movie1.addActor(actor2);
        movie2.addActor(actor1);
        movie2.addActor(actor3);
        movie3.addActor(actor2);

        movieList1.add(movie2);

        // actor2 movies
        movieList2.add(movie1);
        movieList2.add(movie3);

        // actor3 movies
        movieList3.add(movie2);

        // Test movie ratings
        movie1.setRating(expectedRating1);
        movie2.setRating(expectedRating2);
        movie3.setRating(expectedRating3);
        System.out.println(moviedb1.getBestActor());
        assertTrue(expectedBestActor.equals(moviedb1.getBestActor()));
        assertTrue("It".equals(moviedb1.getBestMovie()));
    }

    /**
     * Method to test get best movie.
     */
    @Test
    public void testGetBestMovie() {
        String[] actors1;
        actors1 = new String[] {"Ben Affleck", "Adam West"};
        final Double expectedRating1 = 15.5;
        moviedb1.addMovie("Glass", actors1);
        moviedb1.addRating("Glass", expectedRating1);

        String[] actors2;
        actors2 = new String[] {"Adam West", "Ben Affleck", "Christian Bale"};
        final Double expectedRating2 = 16.5;
        moviedb1.addMovie("Batman", actors2);
        moviedb1.addRating("Batman", expectedRating2);

        String[] actors3;
        actors3 = new String[] {"Adam West", "Christian Bale"};
        final Double expectedRating3 = 17.5;
        moviedb1.addMovie("It", actors3);
        moviedb1.addRating("It", expectedRating3);

        // actor1 movies
        movie1.addActor(actor2);
        movie2.addActor(actor1);
        movie2.addActor(actor3);
        movie3.addActor(actor2);

        movieList1.add(movie2);

        // actor2 movies
        movieList2.add(movie1);
        movieList2.add(movie3);

        // actor3 movies
        movieList3.add(movie2);

        // Test movie ratings
        movie1.setRating(expectedRating1);
        movie2.setRating(expectedRating2);
        movie3.setRating(expectedRating3);


        assertTrue("It".equals(moviedb1.getBestMovie()));
    }


}
