package org.minions.devfund.royrodriguez.movie;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tests for movie database.
 */
public class MovieDatabaseTest {

    private static final int FIRST_MOVIE = 0;
    private static final double PARAMETER_FOR_DOUBLE = 0;
    private static final String THE_PIANIST2 = "The Pianist2";
    private static final String ALPHA_2 = "Alpha2";
    private static final String ALPHA_MOVIE_2 = "AlphaMovie2";
    private static final String ALPHA_MOVIE = "AlphaMovie";
    private static final String ALPHA = "Alpha";

    /**
     * Get best actor in the collection.
     */
    @Test
    public void testGetBestActor() {
        final MovieDatabase movieDatabase = new MovieDatabase();

        final String movie1 = "Monster1";
        final String[] movie1WithActors = {"Denzel Washington2"};
        final int movie1WithRating = 20;

        final String movie2 = "The Pianist";
        final String[] movie2WithActors = new String[]{"Adrien Brody", "Chris Pine"};
        final int movie2WithRating = 5;

        final String expectedBestActor = "Denzel Washington2";
        movieDatabase.addMovie(movie1, movie1WithActors);
        movieDatabase.addMovie(movie2, movie2WithActors);
        movieDatabase.updateRating(movie1, movie1WithRating);
        movieDatabase.updateRating(movie2, movie2WithRating);
        assertEquals(expectedBestActor, movieDatabase.getBestActor());
    }

    /**
     * Get best movie in the collection.
     */
    @Test
    public void testGetBestMovie() {
        final MovieDatabase movieDatabase = new MovieDatabase();

        final String movie1 = "Monster2";
        final String[] movie1WithActors = {"Denzel Washington", "Charlize Theron"};
        final int movie1WithRating = 20;

        final String movie2 = "The Pianist";
        final String[] movie2WithActors = new String[]{"Adrien Brody", "Chris Pine"};
        final int movie2WithRating = 5;

        final String expectedBestMovie = "Monster2";

        movieDatabase.addMovie(movie1, movie1WithActors);
        movieDatabase.addMovie(movie2, movie2WithActors);
        movieDatabase.updateRating(movie1, movie1WithRating);
        movieDatabase.updateRating(movie2, movie2WithRating);
        assertEquals(expectedBestMovie, movieDatabase.getBestMovie());
    }

    /**
     * Add new movie and actor in the collection.
     */
    @Test
    public void testAddMovieActorExist() {
        final MovieDatabase movieDatabase = new MovieDatabase();
        final String movieOld = THE_PIANIST2;
        final String[] actors = {"Anne Hathaway", "Matthew McConaughey"};

        final String movieNew = THE_PIANIST2;
        final String[] actorsNew = {"Anne Hathaway"};

        final int expectedMovieListSize = 1;
        final int expectedActorsListSize = 2;
        movieDatabase.addMovie(movieOld, actors);
        movieDatabase.addMovie(movieNew, actorsNew);

        assertEquals(expectedMovieListSize, movieDatabase.getMovieList().size());
        assertEquals(expectedActorsListSize, movieDatabase.getActorList().size());
    }

    /**
     * Add the same movie in the collection.
     */
    @Test
    public void testAddMovieAlreadyExist() {
        final MovieDatabase movieDatabase = new MovieDatabase();
        final String movie = THE_PIANIST2;
        final String[] actors = {"Anne Hathaway2", "Matthew McConaughey2"};

        final int expectedMovieListSize = 1;
        final int expectedActorsListSize = 2;

        movieDatabase.addMovie(movie, actors);
        movieDatabase.addMovie(movie, actors);

        assertEquals(expectedMovieListSize, movieDatabase.getMovieList().size());
        assertEquals(expectedActorsListSize, movieDatabase.getActorList().size());
    }

    /**
     * Updated the movie rating.
     */
    @Test
    public void testUpdateRating() {
        final MovieDatabase movieDatabase = new MovieDatabase();
        final String movie = THE_PIANIST2;
        final String[] actors = {"Anne Hathaway3", "Matthew McConaughey3"};
        final int newRating = 10;
        final int updateRating = 20;

        movieDatabase.addMovie(movie, actors);
        movieDatabase.addRating(movie, newRating);
        movieDatabase.addRating(movie, updateRating);
        assertEquals(updateRating, movieDatabase.getMovieList().stream()
                .findFirst().get().getRating(), PARAMETER_FOR_DOUBLE);
    }

    /**
     * Add the movie rating.
     */
    @Test
    public void testAddRating() {
        final MovieDatabase movieDatabase = new MovieDatabase();
        final String movie = THE_PIANIST2;
        final String[] actors = {"Anne Hathaway4", "Matthew McConaughey4"};
        final int newRating = 10;

        movieDatabase.addMovie(movie, actors);
        movieDatabase.addRating(movie, newRating);
        assertEquals(newRating, movieDatabase.getMovieList().get(FIRST_MOVIE).getRating(), PARAMETER_FOR_DOUBLE);
    }

    /**
     * Test empty actors and movies lists.
     */
    @Test
    public void testForMovieAndActorAreEmpty() {
        final MovieDatabase movieDatabase = new MovieDatabase();
        assertTrue(movieDatabase.getMovieList().isEmpty());
        assertTrue(movieDatabase.getActorList().isEmpty());
    }

    /**
     * Test setMovieList.
     */
    @Test
    public void testSetMovieList() {
        final MovieDatabase movieDatabase = new MovieDatabase();
        final ArrayList<Movie> movies = new ArrayList<>();
        final Movie movie = new Movie();
        movie.setName(ALPHA);
        movies.add(movie);
        movieDatabase.setMovieList(movies);
        assertEquals(movie.getName(), movieDatabase.getMovieList().get(0).getName());
    }

    /**
     * Test setActorList.
     */
    @Test
    public void testSetActorList() {
        final MovieDatabase movieDatabase = new MovieDatabase();
        final ArrayList<Actor> actors = new ArrayList<>();
        final Actor actor = new Actor();
        actor.setName(ALPHA);
        actors.add(actor);
        movieDatabase.setActorList(actors);
        assertEquals(actor.getName(), movieDatabase.getActorList().get(0).getName());
    }

    /**
     * Test getBestMovie.
     */
    @Test
    public void testBestMovie() {
        final MovieDatabase movieDatabase = new MovieDatabase();
        final ArrayList<Movie> movies = new ArrayList<>();
        final ArrayList<Actor> actors = new ArrayList<>();
        final Actor actor = new Actor();
        actor.setName(ALPHA);
        actors.add(actor);
        Movie movie = new Movie();
        movie.setName(ALPHA_MOVIE);
        final double rating = 10.0;
        movie.setRating(rating);
        movie.setActors(actors);

        final ArrayList<Actor> actors2 = new ArrayList<>();
        final Actor actorTwo = new Actor();
        actorTwo.setName(ALPHA_2);
        actors2.add(actorTwo);
        Movie movie2 = new Movie();
        movie2.setName(ALPHA_MOVIE_2);
        final double rating2 = 20.0;
        movie2.setRating(rating2);
        movie2.setActors(actors2);

        movies.add(movie);
        movies.add(movie2);

        movieDatabase.setMovieList(movies);

        assertEquals(ALPHA_MOVIE_2, movieDatabase.getBestMovie());
    }

    /**
     * Test getBestMovie.
     */
    @Test
    public void testBestMovieTwo() {
        final MovieDatabase movieDatabase = new MovieDatabase();
        final ArrayList<Movie> movies = new ArrayList<>();
        final ArrayList<Actor> actors = new ArrayList<>();
        final Actor actor = new Actor();
        actor.setName(ALPHA);
        actors.add(actor);
        Movie movie = new Movie();
        movie.setName(ALPHA_MOVIE);
        final double rating = 10.0;
        movie.setRating(rating);
        movie.setActors(actors);

        final ArrayList<Actor> actors2 = new ArrayList<>();
        final Actor actorTwo = new Actor();
        actorTwo.setName("Alpha2");
        actors2.add(actorTwo);
        Movie movie2 = new Movie();
        movie2.setName("AlphaMovie2");
        final double rating2 = 10.0;
        movie2.setRating(rating2);
        movie2.setActors(actors2);

        movies.add(movie);
        movies.add(movie2);

        movieDatabase.setMovieList(movies);

        assertEquals(ALPHA_MOVIE, movieDatabase.getBestMovie());
    }

    /**
     * Test getBestActor.
     */
    @Test
    public void testBestMovieActor() {
        final MovieDatabase movieDatabase = new MovieDatabase();
        final ArrayList<Movie> movies = new ArrayList<>();
        final ArrayList<Actor> actors = new ArrayList<>();
        final Actor actor = new Actor();
        actor.setName(ALPHA);
        actors.add(actor);
        Movie movie = new Movie();
        movie.setName(ALPHA_MOVIE);
        final double rating = 30.0;
        movie.setRating(rating);
        movie.setActors(actors);

        final ArrayList<Actor> actors2 = new ArrayList<>();
        final ArrayList<Movie> movies2 = new ArrayList<>();
        final Actor actorTwo = new Actor();
        actorTwo.setName(ALPHA_2);
        actors2.add(actorTwo);
        Movie movie2 = new Movie();
        movie2.setName(ALPHA_MOVIE_2);
        final double rating2 = 20.0;
        movie2.setRating(rating2);
        movie2.setActors(actors2);

        movies.add(movie);

        movies2.add(movie2);
        actors.add(actorTwo);
        actor.setMovies(movies);
        actorTwo.setMovies(movies2);
        movieDatabase.setActorList(actors);

        movieDatabase.setMovieList(movies);
        assertEquals(ALPHA, movieDatabase.getBestActor());
    }

    /**
     * Test getBestActor two.
     */
    @Test
    public void testBestMovieActorTwo() {
        final MovieDatabase movieDatabase = new MovieDatabase();
        final ArrayList<Movie> movies = new ArrayList<>();
        final ArrayList<Actor> actors = new ArrayList<>();
        final Actor actor = new Actor();
        actor.setName(ALPHA);
        actors.add(actor);
        Movie movie = new Movie();
        movie.setName(ALPHA_MOVIE);
        final double rating = 10.0;
        movie.setRating(rating);
        movie.setActors(actors);

        final ArrayList<Actor> actors2 = new ArrayList<>();
        final ArrayList<Movie> movies2 = new ArrayList<>();
        final Actor actorTwo = new Actor();
        actorTwo.setName(ALPHA_2);
        actors2.add(actorTwo);
        Movie movie2 = new Movie();
        movie2.setName(ALPHA_MOVIE_2);
        final double rating2 = 20.0;
        movie2.setRating(rating2);
        movie2.setActors(actors2);

        movies.add(movie);

        movies2.add(movie2);
        actors.add(actorTwo);
        actor.setMovies(movies);
        actorTwo.setMovies(movies2);
        movieDatabase.setActorList(actors);

        movieDatabase.setMovieList(movies);
        assertEquals(ALPHA_2, movieDatabase.getBestActor());
    }
}
