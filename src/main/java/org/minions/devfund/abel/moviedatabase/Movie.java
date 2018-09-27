package org.minions.devfund.abel.moviedatabase;

import java.util.HashSet;
import java.util.Set;

/**
 * Class to handle Movies.
 */
public class Movie {
    private String name;
    private Set<Actor> actors;
    private double rating;

    /**
     * Default constructor.
     */
    public Movie() {
        this.actors = new HashSet<>();
    }

    /**
     * Get the Movie name.
     *
     * @return String.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the Movie name.
     *
     * @param name String.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Get the movie rating.
     *
     * @return double.
     */
    public double getRating() {
        return rating;
    }

    /**
     * Set the movie rating.
     *
     * @param rating double.
     */
    public void setRating(double rating) {
        this.rating = rating;
    }

    /**
     * Add new Actors to the movie.
     *
     * @param actors String[].
     */
    public void addActors(final String[] actors) {
        for (String actor : actors) {
            Actor currentActor = new Actor();
            currentActor.setName(actor);
            this.actors.add(currentActor);
        }
    }
}
