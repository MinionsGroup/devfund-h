package org.minions.devfund.noemiguzman.moviedatabase;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 *  Class to test movie database.
 */
public class MovieDatabaseTest {
    private MovieDatabase moviedb1;
    private MovieDatabase moviedb2;
    private Movie movie1;
    /**
     * Method to setup movie1 and movie2.
     */

    @Before
    public void setUpMovieDatabases() {
        String actorScarlett = "Scarlett Johansson";
        String movieSkin = "Under the skin";
        moviedb1 = new MovieDatabase();
        moviedb2 = new MovieDatabase();

        movie1 = new Movie(movieSkin);

        List<Movie> movieList1 = new ArrayList<>();
        movieList1.add(movie1);

        Actor actor1 = new Actor(actorScarlett, movieList1);
        movie1.addActor(actor1);

    }

    /**
     *  Method to test constructor movie database.
     */
    @Test
    public void testConstructor() {
        List<Movie> movieList = new ArrayList<>();
        List<Actor> actorList = new ArrayList<>();
        assertEquals(movieList, moviedb1.getMovieList());
        assertEquals(actorList, moviedb2.getActorList());
    }

    /**
     *  Method to test add movie.
     */
    @Test
    public void testAddMovieTwoTime() {
        String actorBruce = "Bruce Willis";
        String actorJackson = "Samuel L. Jackson";
        String movieGlassS = "Glass Suspenso";
        List<Movie> movieList = new ArrayList<>();
        MovieDatabase moviedb3 = new MovieDatabase();
        String[] actors1 = new String[] {actorBruce, actorJackson};
        moviedb3.addMovie(movieGlassS, actors1);
        moviedb3.addMovie(movieGlassS, actors1);
        movieList.add(movie1);
        List<Movie> actualMovies = moviedb3.getMovieList();
        assertEquals(movieList.toString(), actualMovies.toString());
    }
    /**
     *  Method to test add movie.
     */
    @Test
    public void testAddMovie() {
        String actorNeve = "Neve Campbell";
        String actorCox = "Courtney Cox";
        String movieScream = "Scream";
        List<Movie> movieList = new ArrayList<>();
        MovieDatabase moviedb3 = new MovieDatabase();
        String[] actors1 = new String[] {actorCox, actorNeve};
        moviedb3.addMovie(movieScream, actors1);
        movieList.add(movie1);
        List<Movie> actualMovies = moviedb3.getMovieList();
        assertEquals(movieList.toString(), actualMovies.toString());
    }

    /**
     *  Method to test add rating.
     */
    @Test
    public void testAddRating() {
        String actorJesse = "Jesse Eisenberg";
        String actorAffleck = "Ben Affleck";
        String movieBatman = "The Batman";
        final Double expectedRating = 7.8;
        String[] actors = new String[] {actorAffleck, actorJesse};
        moviedb2.addMovie(movieBatman, actors);
        moviedb2.addRating(movieBatman, expectedRating);
        assertEquals(expectedRating, moviedb2.getMovieList().get(0).getRating(), 0);
    }

    /**
     *  Method to test update rating.
     */
    @Test
    public void testUpdateRating() {
        String actorSykes = "Eric Sykes";
        String actorKidman = "Nicole Kidman";
        String movieOther = "The Others";
        String[] actors = new String[] {actorKidman, actorSykes};
        final Double expected1 =  25.10;
        final Double expectedFinal = 32.10;
        moviedb2.addMovie(movieOther, actors);
        moviedb2.addRating(movieOther, expected1);
        moviedb2.updateRating(movieOther, expectedFinal);
        assertEquals(expectedFinal, moviedb2.getMovieList().get(0).getRating(), 0);
    }

    /**
     * Method to test get best actor.
     */
    @Test
    public void testGetBestActor() {
        String actorWest = "Adam West";
        String actorBale = "Christian Bale";
        String actorAffleck = "Ben Affleck";
        String movieGlass = "Glass";
        String movieBatman = "Batman";
        String movieIt = "It";
        String[] actors1 = new String[] {actorAffleck, actorWest};
        String expectedBestActor = actorAffleck;
        final Double expectedRating1 = 5.5;
        moviedb1.addMovie(movieGlass, actors1);
        moviedb1.addRating(movieGlass, expectedRating1);

        String[] actors2 = new String[] {actorWest, actorAffleck, actorBale};
        final Double expectedRating2 = 6.5;
        moviedb1.addMovie(movieBatman, actors2);
        moviedb1.addRating(movieBatman, expectedRating2);

        String[] actors3 = new String[] {actorWest, actorBale};
        final Double expectedRating3 = 7.5;
        moviedb1.addMovie(movieIt, actors3);
        moviedb1.addRating(movieIt, expectedRating3);

        assertEquals(expectedBestActor, moviedb1.getBestActor());
    }

    /**
     * Method to test get best movie.
     */
    @Test
    public void testGetBestMovie() {
        String actorBale = "Christian Bale";
        String actorWest = "Adam West";
        String actorAffleck = "Ben Affleck";
        String movieBatman = "Batman";
        String movieGlass = "Glass";
        String movieIt = "It";
        String[] actors1 = new String[] {actorAffleck, actorWest};
        final Double expectedRating1 = 15.5;
        moviedb1.addMovie(movieGlass, actors1);
        moviedb1.addRating(movieGlass, expectedRating1);

        String[] actors2 = new String[] {actorWest, actorAffleck, actorBale};
        final Double expectedRating2 = 16.5;
        moviedb1.addMovie(movieBatman, actors2);
        moviedb1.addRating(movieBatman, expectedRating2);

        String[] actors3 = new String[] {actorWest, actorBale};
        final Double expectedRating3 = 17.5;
        moviedb1.addMovie(movieIt, actors3);
        moviedb1.addRating(movieIt, expectedRating3);
        assertEquals(movieIt, moviedb1.getBestMovie());
    }
}
