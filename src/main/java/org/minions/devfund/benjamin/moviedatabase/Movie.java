package org.minions.devfund.benjamin.moviedatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Movie class.
 */
public class Movie {
    private String name;
    private List<Actor> actors;
    private double rating;

    /**
     *
     * Constructor.
     */
    public Movie() {
       this("");
    }

    /**
     * Initializes an instance of {@link Movie}.
     *
     * @param name movie's name value.
     */
    public Movie(final String name) {
        this.name = name;
        actors = new ArrayList<>();
    }

    /**
     * Function to set movie name.
     * @param movieName string to save as name.
     */
    public void setName(final String movieName) {
        name = movieName;
    }

    /**
     * Function to get Movie name.
     * @return name as string.
     */
    public String getName() {
        return name;
    }

    /**
     * Get movie rating.
     * @return rating as double.
     */
    public double getRating() {
        return rating;
    }

    /**
     * Set value for rating.
     * @param rating double.
     */
    public void setRating(final double rating) {
        this.rating = rating;
    }

    /**
     * Add actors for a movie.
     * @param actors a list of actors to be added.
     */
    public void addActors(final String[] actors) {
        for (String actor : actors) {
            Actor currentActor = new Actor();
            currentActor.setName(actor);
            this.actors.add(currentActor);
        }
    }

    /**
     * get size.
     * @return size as integer.
     */
    public int getSize() {
        return actors.size();
    }
}
