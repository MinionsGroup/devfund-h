package org.minions.devfund.katerinaanzoleaga.moviedatabase;


import java.util.ArrayList;

/**
 * Movie database.
 */
public class Movie {
    private String name;
    private ArrayList<Actor> actors;
    private double rating;

    /**
     * Movie constructor to be defined the way we are going to set the actors list.
     * @param name Movie name
     */
    public Movie(final String name) {
        this.name = name;
        this.rating = 0;
        this.actors = new ArrayList<>();
    }

    /**
     * Name getter.
     * @return string name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Name setter.
     * @param name string Movie name
     */
    public void setName(final String name) {
        this.name = name;
    }


    /**
     * Returns true if setting the rating was possible.
     * @param rating double
     * @return boolean
     */
    public boolean setRating(final double rating) {
        if (rating > 0) {
            this.rating = rating;
            return true;
        }
        return false;
    }

    /**
     * Rating getter.
     * @return double
     */
    public double getRating() {
        return this.rating;
    }

    /**
     * Adds an actor to the movie.
     * @param actor the actor to add
     */
    public void addActor(final Actor actor) {
        this.actors.add(actor);
    }

    /**
     * Returns true if the movie has the actor in its actors' list.
     * @param name actors name
     * @return boolean
     */
    public boolean hasActor(final String name) {
        for (Actor anActor : this.actors) {
            if (anActor.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Actors list getter.
     * @return list of strings
     */
    public String[] getActors() {
        String[] theActors = new String[this.actors.size()];
        for (int i = 0; i < this.actors.size(); i++) {
            theActors[i] = this.actors.get(i).getName();
        }
        return theActors;
    }

}

