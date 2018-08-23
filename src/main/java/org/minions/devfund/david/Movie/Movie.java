package org.minions.devfund.david.Movie;

import java.util.ArrayList;
import java.util.List;

/**
 * Movie object.
 */
public class Movie {
    private String name;
    private List<Actor> actors;
    private double rating;

    /**
     * Constructor of Movie.
     */
    public Movie() {
        actors = new ArrayList<>();
    }

    /**
     * Gets Movie name.
     *
     * @return name of the movie.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets Movie name.
     *
     * @param name of the Movie.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Gets Actor for each movie.
     *
     * @return Actors as array list.
     */
    public List<Actor> getActors() {
        return actors;
    }

    /**
     * Sets actors in movie object.
     *
     * @param actorList a List of actors.
     * @param movie     name.
     */
    public void setActors(final String[] actorList, final String movie) {
        for (String singleActor : actorList) {
            Actor actor = new Actor();
            actor.setMovies(movie);
            actor.setName(singleActor);
            actors.add(actor);
        }
    }

    /**
     * Gets rating of the movie.
     *
     * @return rating.
     */
    public double getRating() {
        return rating;
    }

    /**
     * Sets rating into movie.
     *
     * @param rating value.
     */
    public void setRating(double rating) {
        this.rating = rating;
    }
}
