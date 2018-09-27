package org.minions.devfund.benjamin;

import java.util.ArrayList;

/**
 * Class Actor.
 */
public class Actor {
    private String name;
    private ArrayList<Movie> movies;
    /**
     *
     * Constructor.
     * */
    public Actor() {
        this.movies = new ArrayList<>();
    }

    /**
     * Get actor name.
     * @return actor name as string.
     */
    public String getName() {
        return name;
    }

    /**
     * Add an actor.
     * @param name String to add.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Add movies for an actor.
     * @param movieName movie that will be added.
     */
    public void addMovie(final String movieName) {
        Movie movie = new Movie();
        movie.setName(movieName);
        movies.add(movie);
    }

    /**
     * Function only to help the test of Addmovies function.
     * @return string.
     */
    public String getMovie() {
        return movies.get(0).getName();
    }

    /**
     * Get averga function.
     * @return double.
     */
    public double getAverage() {
        return (movies
                .stream()
                .mapToDouble(Movie::getRating)
                .average().orElse(0.0));
    }
}
