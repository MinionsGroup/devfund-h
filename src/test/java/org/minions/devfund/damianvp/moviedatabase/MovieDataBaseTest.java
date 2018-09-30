package org.minions.devfund.damianvp.moviedatabase;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

/**
 *  Class to test movie database.
 */
public class MovieDataBaseTest {
    private MovieDatabase movieDatabase;
    private String actorMacchio = "Ralph Macchio";
    private String actorFreeman = "Morgan Freeman";
    private String actorBale = "Christian Bale";
    private String actorJolie = "Angelina Jolie";
    private String karateMovie = "Karate Kid";
    private String gloryMovie = "Glory";
    private String sevenMovie = "Seven";


    /**
     * Before.
     */
    @Before
    public void setUpMovieDataBaseTest() {
        movieDatabase = new MovieDatabase();
    }

    /**
     * Method to test the constructor.
     */
    @Test
    public void testMovieDataBaseConstructor() {
        final ArrayList<Movie> expectedMovieList = new ArrayList<>();
        final ArrayList<Actor> expectedActorList = new ArrayList<>();
        assertEquals(expectedMovieList, movieDatabase.getMovieList());
        assertEquals(expectedActorList, movieDatabase.getActorList());
    }

    /**
     * Method to test de addMovie method.
     */
    @Test
    public void testAddMovie() {
        final int expectMovieListSize = 3;
        final int expectActorListSize = 4;
        final int three = 3;
        final String[] actorList1 = {actorMacchio, actorFreeman};
        final String[] actorList2 = {actorMacchio, actorBale, actorJolie};
        final String[] actorList3 = {actorJolie, actorFreeman};

        movieDatabase.addMovie(karateMovie, actorList1);
        movieDatabase.addMovie(gloryMovie, actorList2);
        movieDatabase.addMovie(sevenMovie, actorList3);
        assertEquals(expectMovieListSize, movieDatabase.getMovieList().size());
        assertEquals(expectActorListSize, movieDatabase.getActorList().size());
        assertEquals(karateMovie, movieDatabase.getMovieList().get(0).getName());
        assertEquals(gloryMovie, movieDatabase.getMovieList().get(1).getName());
        assertEquals(sevenMovie, movieDatabase.getMovieList().get(2).getName());
        assertEquals(actorMacchio, movieDatabase.getActorList().get(0).getName());
        assertEquals(actorFreeman, movieDatabase.getActorList().get(1).getName());
        assertEquals(actorBale, movieDatabase.getActorList().get(2).getName());
        assertEquals(actorJolie, movieDatabase.getActorList().get(three).getName());
    }


    /**
     * Test addMovie already existent.
     */
    @Test
    public void testAddMovieAlreadyExist() {
        final int expectMovieListSize = 3;
        final int expectActorListSize = 4;
        final int three = 3;
        final String[] actorList1 = {actorMacchio, actorFreeman};
        final String[] actorList2 = {actorMacchio, actorBale, actorJolie};
        final String[] actorList3 = {actorJolie, actorFreeman};

        movieDatabase.addMovie(karateMovie, actorList1);
        movieDatabase.addMovie(gloryMovie, actorList2);
        movieDatabase.addMovie(karateMovie, actorList1);
        movieDatabase.addMovie(sevenMovie, actorList3);
        assertEquals(expectMovieListSize, movieDatabase.getMovieList().size());
        assertEquals(expectActorListSize, movieDatabase.getActorList().size());
        assertEquals(karateMovie, movieDatabase.getMovieList().get(0).getName());
        assertEquals(gloryMovie, movieDatabase.getMovieList().get(1).getName());
        assertEquals(sevenMovie, movieDatabase.getMovieList().get(2).getName());
        assertEquals(actorMacchio, movieDatabase.getActorList().get(0).getName());
        assertEquals(actorFreeman, movieDatabase.getActorList().get(1).getName());
        assertEquals(actorBale, movieDatabase.getActorList().get(2).getName());
        assertEquals(actorJolie, movieDatabase.getActorList().get(three).getName());
    }

    /**
     * Method to test getBestActor method.
     */
    @Test
    public void testGetBestActor() {
        final double rating1 = 70.0;
        final double rating2 = 65.0;
        final double rating3 = 90.5;
        final String[] actorList1 = {actorMacchio, actorFreeman};
        final String[] actorList2 = {actorMacchio, actorBale, actorJolie};
        final String[] actorList3 = {actorJolie, actorFreeman};

        movieDatabase.addMovie(karateMovie, actorList1);
        movieDatabase.addMovie(gloryMovie, actorList2);
        movieDatabase.addMovie(sevenMovie, actorList3);
        movieDatabase.addRating(karateMovie, rating1);
        movieDatabase.addRating(gloryMovie, rating2);
        movieDatabase.addRating(sevenMovie, rating3);

        assertEquals(actorFreeman, movieDatabase.getBestActor());

    }
    /**
     * Method to test detBestMovie method..
     */
    @Test
    public void testGetBestMovie() {
        final double rating1 = 90.5;
        final double rating2 = 65.0;
        final double rating3 = 70.5;
        final String[] actorList1 = {actorMacchio, actorFreeman};
        final String[] actorList2 = {actorMacchio, actorBale, actorJolie};
        final String[] actorList3 = {actorJolie, actorFreeman};

        movieDatabase.addMovie(karateMovie, actorList1);
        movieDatabase.addMovie(gloryMovie, actorList2);
        movieDatabase.addMovie(sevenMovie, actorList3);
        movieDatabase.addRating(karateMovie, rating1);
        movieDatabase.addRating(gloryMovie, rating2);
        movieDatabase.addRating(sevenMovie, rating3);
        assertEquals(karateMovie, movieDatabase.getBestMovie());
    }

    /**
     * Method to test addRating method.
     */
    @Test
    public void testUpdateRating() {
        final double rating1 = 70.0;
        final double rating2 = 65.0;
        final double rating3 = 90.5;
        final double delta = 0.0;
        final String[] actorList1 = {actorMacchio, actorFreeman};
        final String[] actorList2 = {actorMacchio, actorBale, actorJolie};
        final String[] actorList3 = {actorJolie, actorFreeman};

        movieDatabase.addMovie(karateMovie, actorList1);
        movieDatabase.addMovie(gloryMovie, actorList2);
        movieDatabase.addMovie(sevenMovie, actorList3);
        movieDatabase.addRating(karateMovie, rating1);
        movieDatabase.addRating(gloryMovie, rating2);
        movieDatabase.addRating(sevenMovie, rating3);
        assertEquals(rating1, movieDatabase.getMovieList().get(0).getRating(), delta);
        assertEquals(rating2, movieDatabase.getMovieList().get(1).getRating(), delta);
        assertEquals(rating3, movieDatabase.getMovieList().get(2).getRating(), delta);

    }

    /**
     * Method to test updateRating method.
     */
    @Test
    public void testAddRating() {
        final double rating1 = 70.0;
        final double rating2 = 65.0;
        final double rating3 = 90.5;
        final double delta = 0.0;
        final String[] actorList1 = {actorMacchio, actorFreeman};
        final String[] actorList2 = {actorMacchio, actorBale, actorJolie};
        final String[] actorList3 = {actorJolie, actorFreeman};

        movieDatabase.addMovie(karateMovie, actorList1);
        movieDatabase.addMovie(gloryMovie, actorList2);
        movieDatabase.addMovie(sevenMovie, actorList3);
        movieDatabase.addRating(karateMovie, rating1);
        movieDatabase.addRating(gloryMovie, rating2);
        movieDatabase.addRating(sevenMovie, rating3);
        movieDatabase.updateRating(karateMovie, rating2);
        assertEquals(rating2, movieDatabase.getMovieList().get(0).getRating(), delta);
        assertEquals(rating2, movieDatabase.getMovieList().get(1).getRating(), delta);
        assertEquals(rating3, movieDatabase.getMovieList().get(2).getRating(), delta);
    }

}
