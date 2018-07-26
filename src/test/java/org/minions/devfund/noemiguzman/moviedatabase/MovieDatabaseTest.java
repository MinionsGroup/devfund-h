package org.minions.devfund.noemiguzman.moviedatabase;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MovieDatabaseTest {
    private MovieDatabase mdb1;
    private MovieDatabase mdb2;
    private MovieDatabase mdb3;

    private Movie movie1;
    private Movie movie2;
    private Movie movie3;

    private ArrayList<Movie> movieList1;
    private ArrayList<Movie> movieList2;
    private ArrayList<Movie> movieList3;

    private Actor actor_1;
    private Actor actor_2;
    private Actor actor_3;

    private ArrayList<Movie> movieList;
    private ArrayList<Actor> actorList;



    @Before
    public void setUpMovieDatabases() {
        mdb1 = new MovieDatabase();
        mdb2 = new MovieDatabase();
        mdb3 = new MovieDatabase();

        movie1 = new Movie("movie1");
        movie2 = new Movie("movie2");
        movie3 = new Movie("movie3");

        movieList1 = new ArrayList<>();
        movieList1.add(movie1);
        movieList2 = new ArrayList<>();
        movieList2.add(movie2);
        movieList3 = new ArrayList<>();
        movieList3.add(movie3);

        actor_1 = new Actor("actor_1", movieList1);
        actor_2 = new Actor("actor_2", movieList2);
        actor_3 = new Actor("actor_3", movieList3);

        movie1.addActor(actor_1);
        movie2.addActor(actor_2);
        movie3.addActor(actor_3);

        movieList = new ArrayList<>();
        actorList = new ArrayList<>();

    }

    @Test
    public void testConstructor() {
        assertEquals(movieList, mdb1.getMovieList());
        assertEquals(actorList, mdb2.getActorList());
    }

    @Test
    public void testAddMovie() {
        String [] actors_1;
        actors_1 = new String[] {"actor_1", "actor_2"};
        mdb3.addMovie("movie1", actors_1);
        movie1.addActor(actor_2);
        actor_2.addMovie(movie2);
        movieList.add(movie1);
        actorList.add(actor_1);
        actorList.add(actor_2);

        assertTrue(movieList.equals(mdb3.getMovieList()));

        String[] actors_2;
        actors_2 = new String[] {"actor_1","actor_2","actor_3"};
        ArrayList<Actor> newActorList;
        newActorList = new ArrayList<>(actorList);
        newActorList.add(actor_3);
        movieList.add(movie2);

        mdb3.addMovie("movie2", actors_2);
        assertTrue(movieList.equals(mdb3.getMovieList()));
        assertTrue(newActorList.equals(mdb3.getActorList()));

        String[] newActors_2 = actors_2.clone();
        assertArrayEquals(newActors_2, actors_2);
        assertFalse(newActors_2 == actors_2);
        mdb3.addMovie("movie2", newActors_2);
        assertTrue(movieList.equals(mdb3.getMovieList()));
        assertTrue(newActorList.equals(mdb3.getActorList()));
    }

    @Test
    public void testAddRating() {
        String[] actors = new String[] {"actor_1", "actor_2"};
        mdb2.addMovie("movie2", actors);
        mdb2.addRating("movie2", 7.8);
        assertEquals(7.8, mdb2.getMovieList().get(0).getRating(), 0);

    }
    @Test
    public void testUpdateRating() {
        String[] actors = new String[] {"actor_1", "actor_2"};
        mdb2.addMovie("movie2", actors);
        mdb2.addRating("movie2", 25.10);
        mdb2.updateRating("movie2", 32.10);
        assertEquals(32.10, mdb2.getMovieList().get(0).getRating(), 0);
    }

    @Test
    public void testGetBestActor() {
        String[] actors_1;
        actors_1 = new String[] {"actor_1", "actor_2"};
        mdb1.addMovie("movie1", actors_1);
        mdb1.addRating("movie1", 5.5);

        String[] actors_2;
        actors_2 = new String[] {"actor_2", "actor_1", "actor_3"};
        mdb1.addMovie("movie2", actors_2);
        mdb1.addRating("movie2", 6.5);

        String[] actors_3;
        actors_3 = new String[] {"actor_2", "actor_3"};
        mdb1.addMovie("movie3", actors_3);
        mdb1.addRating("movie3", 7.5);

        // actor_1 movies
        movie1.addActor(actor_2);
        movie2.addActor(actor_1);
        movie2.addActor(actor_3);
        movie3.addActor(actor_2);

        movieList1.add(movie2);

        // actor_2 movies
        movieList2.add(movie1);
        movieList2.add(movie3);

        // actor_3 movies
        movieList3.add(movie2);

        // Test movie ratings
        movie1.setRating(5.5);
        movie2.setRating(6.5);
        movie3.setRating(7.5);

        // Getting the actual and expected lists then sorting
        // them to enable equality test
        ArrayList<Movie> actual1 = mdb1.getActorList().get(0).getMovies();
//        Collections.sort(actual1);

//        Collections.sort(movieList1);
        //assertArrayEquals(movieList1, actual1);
        System.out.print(actual1);
        System.out.print(movieList1);

        assertTrue(movieList1.equals(actual1));

        ArrayList<Movie> actual_2 = mdb1.getActorList().get(1).getMovies();
//        Collections.sort(movieList2);
//        Collections.sort(actual_2);
        assertTrue(movieList2.equals(actual_2));

        ArrayList<Movie> actual_3 = mdb1.getActorList().get(2).getMovies();
//        Collections.sort(actual_3);
//        Collections.sort(movieList3);
        assertTrue(movieList3.equals(actual_3));

        ArrayList<Actor> actualActors = mdb1.getActorList();
        ArrayList<Actor> actorList = new ArrayList<>();
        actorList.add(actor_1);
        actorList.add(actor_2);
        actorList.add(actor_3);
//        Collections.sort(actorList);
//        Collections.sort(actualActors);
        assertTrue(actorList.equals(actualActors));

        assertTrue("actor_3".equals(mdb1.getBestActor()));
        assertTrue("movie3".equals(mdb1.getBestMovie()));
    }
    @Test
    public void testGetBestMovie() {
        String[] actors_1;
        actors_1 = new String[] {"actor_1", "actor_2"};
        mdb1.addMovie("movie1", actors_1);
        mdb1.addRating("movie1", 5.5);

        String[] actors_2;
        actors_2 = new String[] {"actor_2", "actor_1", "actor_3"};
        mdb1.addMovie("movie2", actors_2);
        mdb1.addRating("movie2", 6.5);

        String[] actors_3;
        actors_3 = new String[] {"actor_2", "actor_3"};
        mdb1.addMovie("movie3", actors_3);
        mdb1.addRating("movie3", 7.5);

        // actor_1 movies
        movie1.addActor(actor_2);
        movie2.addActor(actor_1);
        movie2.addActor(actor_3);
        movie3.addActor(actor_2);

        movieList1.add(movie2);

        // actor_2 movies
        movieList2.add(movie1);
        movieList2.add(movie3);

        // actor_3 movies
        movieList3.add(movie2);

        // Test movie ratings
        movie1.setRating(5.5);
        movie2.setRating(6.5);
        movie3.setRating(7.5);

        // Getting the actual and expected lists then sorting
        // them to enable equality test
        ArrayList<Movie> actual1 = mdb1.getActorList().get(0).getMovies();
//        Collections.sort(actual1);
//        Collections.sort(movieList1);
        assertTrue(movieList1.equals(actual1));

        ArrayList<Movie> actual_2 = mdb1.getActorList().get(1).getMovies();
//        Collections.sort(movieList2);
//        Collections.sort(actual_2);
        assertTrue(movieList2.equals(actual_2));

        ArrayList<Movie> actual_3 = mdb1.getActorList().get(2).getMovies();
//        Collections.sort(actual_3);
//        Collections.sort(movieList3);
        assertTrue(movieList3.equals(actual_3));

        ArrayList<Actor> actualActors = mdb1.getActorList();
        ArrayList<Actor> actorList = new ArrayList<>();
        actorList.add(actor_1);
        actorList.add(actor_2);
        actorList.add(actor_3);
//        Collections.sort(actorList);
//        Collections.sort(actualActors);
        assertTrue(actorList.equals(actualActors));

        assertTrue("actor_3".equals(mdb1.getBestActor()));
        assertTrue("movie3".equals(mdb1.getBestMovie()));
    }
}