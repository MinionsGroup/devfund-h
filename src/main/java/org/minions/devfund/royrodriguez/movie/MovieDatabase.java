package org.minions.devfund.royrodriguez.movie;

import java.util.ArrayList;
import java.util.List;

/**
 * Movie database class.
 */
public class MovieDatabase {
    private List<Movie> movieList;
    private List<Actor> actorList;

    /**
     * Gets movies' list.
     *
     * @return List of movies.
     */
    public List<Movie> getMovieList() {
        return movieList;
    }

    /**
     * Sets movie list.
     *
     * @param movieList list of movies.
     */
    public void setMovieList(final List<Movie> movieList) {
        this.movieList = movieList;
    }

    /**
     * Gets actors' list.
     *
     * @return list of actors.
     */
    public List<Actor> getActorList() {
        return actorList;
    }

    /**
     * Sets actor's list.
     *
     * @param actorList to set.
     */
    public void setActorList(final List<Actor> actorList) {
        this.actorList = actorList;
    }

    /**
     * Constructor.
     */
    public MovieDatabase() {
        movieList = new ArrayList<>();
        actorList = new ArrayList<>();
    }

    /**
     * Adds a new movie to the database.
     *
     * @param name   of the movie.
     * @param actors in the movie.
     */
    public void addMovie(final String name, final String[] actors) {
        if (movieList.stream().noneMatch(movie -> movie.getName().equals(name))) {
            Movie newMovie = new Movie();
            newMovie.setName(name);
            movieList.add(newMovie);
        }

        for (String actorName : actors) {
            if (actorList.stream().noneMatch(actor -> actor.getName().equals(actorName))) {
                Actor newActor = new Actor();
                newActor.setName(actorName);
                actorList.add(newActor);
            }
        }
    }

    /**
     * Adds rating to a movie.
     *
     * @param name   of the movie.
     * @param rating of the movie.
     */
    public void addRating(final String name, final double rating) {
        movieList.stream().findFirst()
                .filter(movie -> movie.getName().equals(name))
                .ifPresent(movie -> movie.setRating(rating));
    }

    /**
     * Updates rating of a movie.
     *
     * @param name      of the movie.
     * @param newRating of the movie.
     */
    public void updateRating(final String name, final double newRating) {
        movieList.stream().findFirst()
                .filter(movie -> movie.getName().equals(name))
                .ifPresent(movie -> movie.setRating(newRating));
    }

    /**
     * Gets best movie.
     *
     * @return name of the best movie.
     */
    public String getBestMovie() {
        movieList.sort((firstMovie, secondMovie) -> {
            if (Double.compare(firstMovie.getRating(), secondMovie.getRating()) > 0) {
                return -1;
            } else {
                return Double.compare(firstMovie.getRating(), secondMovie.getRating()) < 0 ? 1 : 0;
            }
        });
        return movieList.get(0).getName();
    }

    /**
     * Gets best movie.
     *
     * @return name of the best actor.
     */
    public String getBestActor() {
        actorList.sort((actorOne, actorTwo) -> {
            if (Double.compare(actorOne.getAverageRating(), actorTwo.getAverageRating()) > 0) {
                return -1;
            } else {
                return Double.compare(actorOne.getAverageRating(), actorTwo.getAverageRating()) < 0 ? 1 : 0;
            }
        });
        return actorList.get(0).getName();
    }
}
