package org.minions.devfund.noemiguzman.moviedatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class Actor.
 */

public class Actor {
    private String name;
    private List<Movie> movies;

    /**
     * Overloaded constructor that takes the arguments.
     * @param name  name of the actor
     * @param movies ArrayList of Movies that the actor
     *               has acted in.
     */
    public Actor(final String name, final ArrayList<Movie> movies) {
        this.name = name;
        this.movies = new ArrayList<>();
        this.movies.addAll(movies);
    }
    /**
     * Constructor for the Actor Class.     *
     * @param name actor.
     */
    public Actor(final String name) {
        this.name = name;
        movies = new ArrayList<>();
    }
    /**
     * Getter for the actor's name.
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the actor name.
     * @param name The String name
     */
    public void setName(final String name) {
        this.name = name;
    }


    /**
     * Getter for movie names.
     * @return ArrayList of Strings of the movie names
     */
    private ArrayList<String> getMovieNames() {
        ArrayList<String> movieNames = new ArrayList<>();
        for (Movie movie: this.movies) {
            movieNames.add(movie.getName());
        }
        return movieNames;
    }

    /**
     * Adds a movie to the actor's list of movies.
     * @param movie Movie object to be added
     */
    public void addMovie(final Movie movie) {
        if (!this.getMovieNames().contains(movie.getName())) {
            this.movies.add(movie);
        }
    }
    /**
     * Rating averages of the actor on the list.
     *
     * @return movie rating average.
     */
    public double movieRatingAverage() {
        return movies.stream()
                .collect(Collectors.averagingDouble(Movie::getRating));
    }
    /**
     * Gets the collection movies.
     * @return list for movie save.
     */
    public List<Movie> getMovies() {
        return movies;
    }

}
