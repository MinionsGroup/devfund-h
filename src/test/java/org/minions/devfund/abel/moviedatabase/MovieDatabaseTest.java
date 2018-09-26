package org.minions.devfund.abel.moviedatabase;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Class for Movie Database Unit Tests.
 */
public class MovieDatabaseTest {

    private MovieDatabase movieDatabase;

    /**
     * SetUp method.
     */
    @Before
    public void setUp() {
        movieDatabase = new MovieDatabase();
    }

    /**
     * Test AddMovie.
     */
    @Test
    public void testAddMovieNewMovieAndActors() {
        final String expectedMovie = "The Godfather";
        final String firstActor = "Al Pacino";
        final String secondActor = "Marlon Brando";
        final int expectedMoviesSize = 1;
        final int expectedActorsSize = 2;

        movieDatabase.addMovie(expectedMovie, new String[]{firstActor, secondActor});
        final int actualMoviesSize = movieDatabase.getMovieList().size();
        final String actualMovie = movieDatabase.getMovieList().get(0).getName();
        final int actualActorsSize = movieDatabase.getActorList().size();

        assertEquals(expectedMoviesSize, actualMoviesSize);
        assertEquals(expectedMovie, actualMovie);
        assertEquals(expectedActorsSize, actualActorsSize);
    }

    /**
     * Test AddMovie.
     */
    @Test
    public void testAddMovieAlreadyAdded() {
        final String expectedMovie = "Gladiator";
        final String firstActor = "Russell Crowe";
        final String secondActor = "Joaquin Phoenix";
        final int expectedMoviesSize = 1;
        final int expectedActorsSize = 2;

        movieDatabase.addMovie(expectedMovie, new String[]{firstActor, secondActor});
        movieDatabase.addMovie(expectedMovie, new String[]{firstActor, secondActor});
        final int actualMoviesSize = movieDatabase.getMovieList().size();
        final String actualMovie = movieDatabase.getMovieList().get(0).getName();
        final int actualActorsSize = movieDatabase.getActorList().size();

        assertEquals(expectedMoviesSize, actualMoviesSize);
        assertEquals(expectedMovie, actualMovie);
        assertEquals(expectedActorsSize, actualActorsSize);
    }

    /**
     * Test AddMovie.
     */
    @Test
    public void testAddMovieNewActors() {
        final String expectedMovie = "The Dark Knight";
        final String secondMovie = "The Dark Knight Rises";
        final String firstActor = "Christian Bale";
        final String secondActor = "Heath Ledger";
        final String thirdActor = "Aaron Eckhart";
        final int expectedMoviesSize = 2;
        final int expectedActorsSize = 3;

        movieDatabase.addMovie(expectedMovie, new String[]{firstActor, secondActor});
        movieDatabase.addMovie(secondMovie, new String[]{firstActor, secondActor, thirdActor});
        final int actualMoviesSize = movieDatabase.getMovieList().size();
        final String actualMovie = movieDatabase.getMovieList().get(0).getName();
        final int actualActorsSize = movieDatabase.getActorList().size();

        assertEquals(expectedMoviesSize, actualMoviesSize);
        assertEquals(expectedMovie, actualMovie);
        assertEquals(expectedActorsSize, actualActorsSize);
    }

    /**
     * Test AddRating.
     */
    @Test
    public void testAddRatingNewMovie() {
        final String newMovie = "Forrest Gump";
        final String firstActor = "Tom Hanks";
        final String secondActor = "Rebecca Williams";
        final double expectedRating = 10.0;

        movieDatabase.addMovie(newMovie, new String[]{firstActor, secondActor});
        movieDatabase.addRating(newMovie, expectedRating);
        final double actualRating = movieDatabase.getMovieList().get(0).getRating();

        assertEquals(expectedRating, actualRating, 0.0);
    }

    /**
     * Test UpdateRating.
     */
    @Test
    public void testUpdateRatingToExistingMovie() {
        final String newMovie = "The Matrix";
        final String firstActor = "Keanu Reeves";
        final String secondActor = "Laurence Fishburne";
        final double initialRating = 10.0;
        final double expectedRating = 15.0;

        movieDatabase.addMovie(newMovie, new String[]{firstActor, secondActor});
        movieDatabase.addRating(newMovie, initialRating);
        movieDatabase.updateRating(newMovie, expectedRating);
        final double actualRating = movieDatabase.getMovieList().get(0).getRating();

        assertEquals(expectedRating, actualRating, 0.0);
    }

    /**
     * Test GetBestActor.
     */
    @Test
    public void testGetBestActor() {
        final String firstMovie = "The Lord of the Rings: The Fellowship of the Ring";
        final String secondMovie = "The Lord of the Rings: The Return of the King";
        final String expectedBestActor = "Orlando Bloom";
        final String secondActor = "Sean Astin";
        final double firstMovieRating = 10.0;
        final double secondMovieRating = 15.0;

        movieDatabase.addMovie(firstMovie, new String[]{expectedBestActor, secondActor});
        movieDatabase.addMovie(secondMovie, new String[]{expectedBestActor});
        movieDatabase.addRating(firstMovie, firstMovieRating);
        movieDatabase.addRating(secondMovie, secondMovieRating);
        final String actualBestActor = movieDatabase.getBestActor();

        assertEquals(expectedBestActor, actualBestActor);
    }

    /**
     * Test GetBestMovie.
     */
    @Test
    public void testGetBestMovie() {
        final String firstMovie = "Back to the Future";
        final String expectedBestMovie = "Back to the Future Part II";
        final String firstActor = "Michael J. Fox";
        final String secondActor = "Christopher Lloyd";
        final double firstMovieRating = 10.0;
        final double secondMovieRating = 15.0;

        movieDatabase.addMovie(firstMovie, new String[]{firstActor, secondActor});
        movieDatabase.addMovie(expectedBestMovie, new String[]{firstActor});
        movieDatabase.addRating(firstMovie, firstMovieRating);
        movieDatabase.addRating(expectedBestMovie, secondMovieRating);
        final String actualBestMovie = movieDatabase.getBestMovie();

        assertEquals(expectedBestMovie, actualBestMovie);
    }
}
