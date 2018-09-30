package org.minions.devfund.benjamin;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
/**
 * Class to test MovieDatabase class.
 */
public class MovieDatabaseTest {
    private static final String ACTOR_UNO = "Crhistian Bale";
    private static final String ACTOR_DOS = "Morgan Freeman";
    private static final String NEW_MOVIE = "Batman Forever";
    private static final String NEW_MOVIE_TWO = "NewMovie2";
    private MovieDatabase movieDatabase;

    /**
     * .
     */
    @Before
    public void setUp() {
        movieDatabase = new MovieDatabase();
    }

    /**
     * Test Add a new movie and actors.
     */
    @Test
    public void testAddMovieNewMovieAndActors() {
        movieDatabase.addMovie(NEW_MOVIE, new String[]{ACTOR_UNO, ACTOR_DOS});
        assertEquals(1, movieDatabase.getMovieList().size());
        assertEquals(NEW_MOVIE, movieDatabase.getMovieList().get(0).getName());
        assertEquals(2, movieDatabase.getActorList().size());
    }

    /**
     * Test add movie that already exist.
     */
    @Test
    public void testAddMovieAlreadyExist() {
        movieDatabase.addMovie(NEW_MOVIE, new String[]{ACTOR_UNO, ACTOR_DOS});
        movieDatabase.addMovie(NEW_MOVIE, new String[]{ACTOR_UNO, ACTOR_DOS});
        assertEquals(1, movieDatabase.getMovieList().size());
        assertEquals(NEW_MOVIE, movieDatabase.getMovieList().get(0).getName());
        assertEquals(2, movieDatabase.getActorList().size());
    }

    /**
     * Test add rating.
     */
    @Test
    public void testAddRatingNewMovie() {
        movieDatabase.addMovie(NEW_MOVIE, new String[]{ACTOR_UNO, ACTOR_DOS});
        final double ten = 10.0;
        movieDatabase.addRating(NEW_MOVIE, ten);
        assertEquals(ten, movieDatabase.getMovieList().get(0).getRating(), 0.0);
    }

    /**
     * Test update rating.
     */
    @Test
    public void testUpdateRating() {
        movieDatabase.addMovie(NEW_MOVIE, new String[]{ACTOR_UNO, ACTOR_DOS});
        final double ten = 10.0;
        final double fifteen = 15.0;
        movieDatabase.addRating(NEW_MOVIE, ten);
        movieDatabase.updateRating(NEW_MOVIE, fifteen);
        assertEquals(fifteen, movieDatabase.getMovieList().get(0).getRating(), 0.0);
    }

    /**
     * Test get best actor.
     */
    @Test
    public void testGetBestActor() {
        movieDatabase.addMovie(NEW_MOVIE, new String[]{ACTOR_UNO, ACTOR_DOS});
        movieDatabase.addMovie(NEW_MOVIE_TWO, new String[]{ACTOR_UNO});
        final double ten = 10.0;
        final double fifteen = 15.0;
        movieDatabase.addRating(NEW_MOVIE, ten);
        movieDatabase.addRating(NEW_MOVIE_TWO, fifteen);
        assertEquals(ACTOR_UNO, movieDatabase.getBestActor());
    }

    /**
     * Test get best movie.
     */
    @Test
    public void testGetBestMovie() {
        movieDatabase.addMovie(NEW_MOVIE, new String[]{ACTOR_UNO, ACTOR_DOS});
        movieDatabase.addMovie(NEW_MOVIE_TWO, new String[]{ACTOR_UNO});
        final double ten = 10.0;
        final double fifteen = 15.0;
        movieDatabase.addRating(NEW_MOVIE, ten);
        movieDatabase.addRating(NEW_MOVIE_TWO, fifteen);
        assertEquals(NEW_MOVIE_TWO, movieDatabase.getBestMovie());
    }

    /**
     * Test AddMovie.
     */
    @Test
    public void testAddMovieNewActors() {
        final String expectedMovie = "NewMovie";
        final String firstActor = "Actor1";
        final String secondActor = "Actor2";
        final String thirdActor = "Actor3";
        final int expectedMoviesSize = 2;
        final int expectedActorsSize = 3;
        movieDatabase.addMovie(expectedMovie, new String[]{firstActor, secondActor});
        movieDatabase.addMovie(NEW_MOVIE_TWO, new String[]{firstActor, secondActor, thirdActor});
        final int actualMoviesSize = movieDatabase.getMovieList().size();
        final String actualMovie = movieDatabase.getMovieList().get(0).getName();
        final int actualActorsSize = movieDatabase.getActorList().size();
        assertEquals(expectedMoviesSize, actualMoviesSize);
        assertEquals(expectedMovie, actualMovie);
        assertEquals(expectedActorsSize, actualActorsSize);
    }
}
