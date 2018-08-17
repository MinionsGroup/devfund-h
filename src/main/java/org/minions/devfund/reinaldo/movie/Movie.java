package org.minions.devfund.reinaldo.movie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by reinaldo on 25-07-18.
 */
public class Movie {

    private String name;
    private List<Actor> actors;
    private double rating;

    /**
     * Constructor for the movie class.
     *
     * @param name movie value.
     */
    public Movie(final String name) {
        this.name = name;
        actors = new ArrayList<>();
    }

    /**
     * Gets the movie name.
     *
     * @return movie name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the movie name .
     *
     * @param name new movie.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Gets the collection actors.
     *
     * @return actor list.
     */
    public List<Actor> getActors() {
        return actors;
    }

    /**
     * Sets the actors.
     *
     * @param actors new actor list.
     */
    public void setActors(final List<Actor> actors) {

        this.actors = actors;
    }

    /**
     * Gets the rating value.
     *
     * @return rating.
     */
    public double getRating() {
        return rating;
    }

    /**
     * Sets the rating value.
     *
     * @param rating rating.
     */
    public void setRating(final double rating) {
        this.rating = rating;
    }

    /**
     * Methods that add the actor.
     * @param actors list.
     */
    public void addActor(final String[] actors) {
        setActors(Arrays.stream(actors)
                .map(Actor::new)
                .collect(Collectors.toList()));
    }
}
