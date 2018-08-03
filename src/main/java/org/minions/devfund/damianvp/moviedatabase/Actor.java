package org.minions.devfund.damianvp.moviedatabase;

import java.util.ArrayList;

/**
 * Actor class.
 */
public class Actor {
    private String name;
    private ArrayList<Movie> movies;

    /**
     * Class Constructor.
     * @param name String type.
     */
    Actor(final String name) {
        this.name = name;
        this.movies = new ArrayList<>();
    }

    /**
     * Class Constructor, empty values.
     */
    Actor() {
        this.name = "";
        this.movies = new ArrayList<>();
    }

    /**
     * Class Constructor.
     * @param name  String type.
     * @param movies  ArrayList of Movie Objects.
     */
    Actor(final String name, final ArrayList<Movie> movies) {
        this.name = name;
        this.movies = movies;
    }

    /**
     * Method to get the Actor name.
     * @return String, name property.
     */
    String getName() {
        return this.name;
    }

    /**
     * Method to set the name.
     * @param name String type.
     */
    void setName(final String name) {
        this.name = name;
    }

    /**
     * Method to return the Rating Average of current Actor.
     * @return Double, average of Movie ratings.
     */
    Double getRatingAverage() {
        return this.movies.stream().mapToDouble(Movie::getRating).average().getAsDouble();
    }

    /**
     * Method to get the Movies.
     * @return ArrayList<Movie>
     */
    ArrayList<Movie> getMovies() {
        return this.movies;
    }

    /**
     * Method to add a movie in arrayList<Movie>.
     * @param movie Movie object.
     */
    void addMovie(final Movie movie) {
        if (!movieExists(movie.getName())) {
            this.movies.add(movie);
        }
    }

    /**
     * Boolean method to check if a movie already exist.
     * @param name String type.
     * @return true: if movie exists.
     *         false: if movie does not exists.
     */
    private boolean movieExists(final String name) {
        return this.movies.stream().anyMatch(o -> o.getName().equals(name));
    }
}
