package org.minions.devfund.damianvp.moviedatabase;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * class to test the Movie class.
 */
public class MovieTest {

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
    public void setUpMovieTest() {
        movie1 = new Movie(karateMovie);
        movie2 = new Movie(gloryMovie);
        movie3 = new Movie(sevenMovie);
        movie4 = new Movie(theShawshankRedemtionMovie);
    }

    /**
     * Method to test Movie class constructor.
     */
    @Test
    public void testMovieConstructor() {
        final ArrayList<Actor> emptyMovieList = new ArrayList<>();
        assertEquals(karateMovie, movie1.getName());
        assertEquals(emptyMovieList, movie1.getActors());
        assertEquals(gloryMovie, movie2.getName());
        assertEquals(emptyMovieList, movie2.getActors());
        assertEquals(sevenMovie, movie3.getName());
        assertEquals(emptyMovieList, movie3.getActors());
        assertEquals(theShawshankRedemtionMovie, movie4.getName());
        assertEquals(emptyMovieList, movie4.getActors());
    }

    /**
     *  Method to test addActor method.
     */
    @Test
    public void testAddMovieActor() {
        final ArrayList<Actor> expectedList1 = new ArrayList<>();
        final ArrayList<Actor> expectedList2 = new ArrayList<>();
        final ArrayList<Actor> expectedList3 = new ArrayList<>();

        actor1 = new Actor(actorMacchio);
        actor2 = new Actor(actorFreeman);

        movie1.addActor(actor1);
        movie1.addActor(actor2);
        expectedList1.add(actor1);
        expectedList1.add(actor2);
        movie2.addActor(actor1);
        expectedList2.add(actor1);
        movie3.addActor(actor2);
        expectedList3.add(actor2);
        movie4.addActor(actor1);
        movie4.addActor(actor2);

        assertEquals(expectedList1, movie1.getActors());
        assertEquals(expectedList2, movie2.getActors());
        assertEquals(expectedList3, movie3.getActors());
        assertEquals(expectedList1, movie4.getActors());
    }

    /**
     * Method to test getName method.
     */
    @Test
    public void testGetName() {
        assertEquals(karateMovie, movie1.getName());
        assertEquals(gloryMovie, movie2.getName());
        assertEquals(sevenMovie, movie3.getName());
        assertEquals(theShawshankRedemtionMovie, movie4.getName());
    }

    /**
     * Method to test setName method.
     */
    @Test
    public void testSetName() {
        final String newName1 = "Karate Kid 2";
        final String newName2 = "Seven Day";
        movie1.setName(newName1);
        movie3.setName(newName2);
        assertEquals(newName1, movie1.getName());
        assertEquals(gloryMovie, movie2.getName());
        assertEquals(newName2, movie3.getName());
        assertEquals(theShawshankRedemtionMovie, movie4.getName());
    }

    /**
     * Method to test getRating method.
     */
    @Test
    public void testGetRating() {
        final double expectedRating = 0.0;
        assertEquals(expectedRating, movie1.getRating(), expectedRating);
        assertEquals(expectedRating, movie2.getRating(), expectedRating);
        assertEquals(expectedRating, movie3.getRating(), expectedRating);
        assertEquals(expectedRating, movie4.getRating(), expectedRating);
    }

    /**
     * Method to test setRating method.
     */
    @Test
    public void testSetRating() {
        final double delta = 0.0;
        final double expectedRating1 = 70.0;
        final double expectedRating2 = 65.0;
        final double expectedRating3 = 85.5;
        movie1.setRating(expectedRating1);
        movie2.setRating(expectedRating2);
        movie3.setRating(expectedRating1);
        movie4.setRating(expectedRating3);
        movie1.setRating(expectedRating2);
        assertEquals(expectedRating2, movie1.getRating(), delta);
        assertEquals(expectedRating2, movie2.getRating(), delta);
        assertEquals(expectedRating1, movie3.getRating(), delta);
        assertEquals(expectedRating3, movie4.getRating(), delta);
    }
}
