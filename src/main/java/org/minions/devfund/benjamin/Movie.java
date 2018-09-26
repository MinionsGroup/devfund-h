package org.minions.devfund.benjamin;

import java.util.ArrayList;

/**
 * Movie class.
 */
public class Movie {
    private String name;
    private ArrayList<Actor> actors;
    private double rating;

    /**
     *
     * Constructor.
     */
    public Movie() {
       actors = new ArrayList<Actor>();
       rating = 0.0;
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
