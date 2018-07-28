package org.minions.devfund.noemiguzman.moviedatabase;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * class movie.
 */

public class Movie implements Comparable<Movie> {
    private String name;
    private List<Actor> actors;
    private double rating;

    /**
     * Initializes a Movie object.
     * @param name The String of the name of the movie
     */
    public Movie(final String name) {
        this.name = name;
        this.actors = new ArrayList<>();
    }

    /**
     * Getter for the movies Name.
     * @return String for the name
     */
    public String getName() {
        return name;
    }
    /**
     * Setter for the movie name.
     * @param name The String name
     */
    public void setName(final String name) {
        this.name = name;
    }



    /**
     * Getter for the names of the actors of this movie.
     * @return ArrayList of Strings of the actors' names
     */
    private ArrayList<String> getActorNames() {
        ArrayList<String> actorNames = new ArrayList<>();
        for (Actor actor: this.actors) {
            actorNames.add(actor.getName());
        }
        return actorNames;
    }

    /**
     * Add an actor to the movie's list of actors.
     * @param actor an instance of class Actor
     */
    public void addActor(final Actor actor) {
        if (!this.getActorNames().contains(actor.getName())) {
            this.actors.add(actor);
        }
    }

    /**
     * Getter for the movie's rating.
     * @return the movie's rating
     */
    public double getRating() {
        return rating;
    }

    /**
     * Setter for the movie's rating.
     * @param rating the double for the movie's rating
     */
    public void setRating(double rating) {
        this.rating = rating;
    }

    /**
     * Compare movie object.
     * @param object object to compare
     * @return true if the object are equal
     */
    public boolean equals(final Object object) {
        if (object == null) {
            return  false;
        }
        if (!(object instanceof Movie)) {
            return  false;
        }
        return ((Movie) object).getName().equals(name);
    }

    /**
     * Convert to string.
     * @return name and rating
     */
    public String toString() {
        return name + " Rating:" + rating;
    }

    /**
     *  Compare current movie to other.
     * @param o other movie object
     * @return
     */
    @Override
    public int compareTo(final Movie o) {
        return Double.compare(rating, o.getRating());
    }
    @Override
    public int hashCode() {
        int result = (int) Math.round(rating) + ((name == null) ? 0 : name.hashCode());
        return result;
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
    /**
     * Sets the actors list.
     *
     * @param actors new actor list.
     */
    public void setActors(final List<Actor> actors) {
        this.actors = actors;
    }
    /**
     * Gets the collection actors.
     *
     * @return actor list.
     */
    public List<Actor> getActors() {
        return actors;
    }
}
