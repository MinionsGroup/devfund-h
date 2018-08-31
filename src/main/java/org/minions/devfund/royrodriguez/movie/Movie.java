package org.minions.devfund.royrodriguez.movie;

import java.util.List;

/**
 * Movie class.
 */
public class Movie {
    private String name;
    private List<Actor> actors;
    private double rating;

    /**
     * Gets movie's name.
     *
     * @return movie's name string.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets movie's rating.
     *
     * @return movie's rating double.
     */
    public double getRating() {
        return rating;
    }

    /**
     * Sets movie's rating.
     *
     * @param rating to set.
     */
    public void setRating(final double rating) {
        this.rating = rating;
    }

    /**
     * Sets movie's name.
     *
     * @param name to set.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Gets actors' list.
     *
     * @return list of actors.
     */
    public List getActors() {
        return actors;
    }

    /**
     * Sets actors' list.
     *
     * @param actors list.
     */
    public void setActors(final List<Actor> actors) {
        this.actors = actors;
    }
}
