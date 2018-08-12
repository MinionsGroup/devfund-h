package org.minions.devfund.marylin;

import java.util.ArrayList;

/**
 * Actor class.
 */
public class Actor {
    private String name;
    private ArrayList<Movie> movies;

    /**
     * Constructor empty.
     */
    public Actor() {
        this.name = "";
        this.movies = new ArrayList<>();
    }

    /**
     * Constructor with actor name.
     *
     * @param name actor name.
     */
    public Actor(final String name) {
        this.name = name;
        this.movies = new ArrayList<>();
    }

    /**
     * Gets actor name.
     *
     * @return actor name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets actor name.
     *
     * @param name actor name.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * get array movies list.
     *
     * @return movies list.
     */
    public ArrayList<Movie> getMovies() {
        return movies;
    }

    /**
     * add a movie if it does not exist.
     *
     * @param movie to be added.
     */
    public void addMovie(final Movie movie) {
        if (!isMovieSaved(movie.getName())) {
            movies.add(movie);
        }
    }

    /**
     * Verifies if the movies is already save.
     *
     * @param movieName movie name.
     * @return true if the movie is saved, false otherwise.
     */
    public boolean isMovieSaved(final String movieName) {
        return getMovies().stream().filter(movie -> movieName.equals(movie.getName())).findFirst().orElse(null) == null;
    }
}
