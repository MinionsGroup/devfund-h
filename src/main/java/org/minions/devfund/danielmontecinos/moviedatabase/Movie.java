package org.minions.devfund.danielmontecinos.moviedatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Creates Movie objects.
 */
public class Movie {
    private double rating;
    private String name;
    private List<Actor> actors;

    /**
     * Creates an instance of {@link Movie}.
     */
    public Movie() {
        actors = new ArrayList<>();
    }

    /**
     * Gets name instance.
     *
     * @return value of name instance.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets value for name instance.
     *
     * @param name as String.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Gets actorList instance.
     *
     * @return list of Actor objects.
     */
    public List<Actor> getActors() {
        return actors;
    }

    /**
     * Sets actors instance.
     *
     * @param movieName as String.
     * @param actorList as an Array of actors.
     */
    public void setActors(final String movieName, final String[] actorList) {
        for (String actor : actorList) {
            Actor newActor = new Actor();
            newActor.setName(actor);
            newActor.setMovie(movieName);
            actors.add(newActor);
        }
    }

    /**
     * Gets rating instance.
     *
     * @return rating instance value.
     */
    public double getRating() {
        return rating;
    }

    /**
     * Sets rating instance value.
     *
     * @param rating as double.
     */
    public void setRating(final double rating) {
        this.rating = rating;
    }
}
