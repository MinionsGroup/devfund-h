package org.minions.devfund.noemiguzman.moviedatabase;

import java.util.ArrayList;

/**
 * Class Actor.
 */

public class Actor {
    private String name;
    private ArrayList<Movie> movies;

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
     * Getter for the actor's list of movies.
     * @return an ArrayList of movie objects
     */
    public ArrayList<Movie> getMovies() {

        return movies;
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

        System.out.println("getMovieName");
        System.out.println(name);
        System.out.println(movieNames.toString());
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
}
