package org.minions.devfund.noemiguzman.moviedatabase;


import java.util.ArrayList;

/**
 * class movie.
 */

public class Movie implements Comparable<Movie> {
    private String name;
    private ArrayList<Actor> actors;
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
     * Getter for the movie's list of actors.
     * @return ArrayList of Actor objects
     */
    public ArrayList<Actor> getActors() {
        return actors;
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
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }
}
