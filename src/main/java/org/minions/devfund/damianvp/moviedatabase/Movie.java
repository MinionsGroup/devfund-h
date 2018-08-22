package org.minions.devfund.damianvp.moviedatabase;

import java.util.ArrayList;

/**
 * Movie class.
 */
public class Movie {

    private String name;
    private ArrayList<Actor> actors;
    private double rating;

    /**
     * Constructor.
     * @param name String type.
     */
    Movie(final String name) {
        this.name = name;
        this.actors = new ArrayList<>();
        this.rating = 0.0;
    }

    /**
     * Constructor with empty name.
     */
    Movie() {
        this.name = "";
        this.actors = new ArrayList<>();
        this.rating = 0.0;
    }

    /**
     * method to get the movie name.
     * @return String, name property.
     */
    String getName() {
        return this.name;
    }

    /**
     * Method to set the name.
     * @param name String type.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Method to get the Actors list.
     * @return ArrayList<Actor>, actors.
     */
    ArrayList<Actor> getActors() {
        return this.actors;
    }

    /**
     * Method to get the rating movie.
     * @return double, rating.
     */
    double getRating() {
        return this.rating;
    }

    /**
     * Method to set the rating movie.
     * @param rating double type.
     */
    void setRating(double rating) {
        this.rating = rating;
    }

    /**
     * Method to add an actor.
     * @param actor Actor type.
     */
    void addActor(final Actor actor) {
        if (!actorExists(actor.getName())) {
            this.actors.add(actor);
        }
    }

    /**
     * Method to check if actor already exists.
     * @param name String type.
     * @return true: if actor exists.
     *         false: if actor does not exists.
     */
    public boolean actorExists(final String name) {
        return this.actors.stream().anyMatch(o -> o.getName().equals(name));
    }
}
