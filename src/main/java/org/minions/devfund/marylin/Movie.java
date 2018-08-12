package org.minions.devfund.marylin;

import java.util.ArrayList;

/**
 * Movie class.
 */
public class Movie {
    private String name;
    private ArrayList<Actor> actors;
    private double rating;

    /**
     * Constructor empty.
     */
    public Movie() {
        this.name = "";
        this.actors = new ArrayList<>();
        this.rating = 0;
    }

    /**
     * Constructor with movie name and actors.
     *
     * @param name   movie name.
     * @param actors actors array.
     * @return Movie.
     */
    public Movie setMovie(final String name, final String[] actors) {
        setName(name);
        setRating(0);
        setActorsList(actors);
        return this;
    }


    /**
     * Gets movie name.
     *
     * @return movie name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets movie name.
     *
     * @param name movie name.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Gets Actor List.
     *
     * @return actors list
     */
    public ArrayList<Actor> getActors() {
        return actors;
    }

    /**
     * Gets rating.
     *
     * @return rating.
     */
    public double getRating() {
        return rating;
    }

    /**
     * Sets rating.
     *
     * @param rating rating.
     */
    public void setRating(double rating) {
        this.rating = rating;
    }

    /**
     * Gets Actors array into list.
     *
     * @param actors array.
     */
    private void setActorsList(final String[] actors) {
        for (String actorName : actors) {
            Actor actor = new Actor();
            actor.setName(actorName);
            this.actors.add(actor);
        }
    }
}
