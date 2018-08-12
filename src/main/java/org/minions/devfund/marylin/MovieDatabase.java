package org.minions.devfund.marylin;

import java.util.ArrayList;

/**
 * MovieDatabase class.
 */
public class MovieDatabase {
    private ArrayList<Movie> movieList;
    private ArrayList<Actor> actorList;

    /**
     * Constructor.
     */
    public MovieDatabase() {
        this.movieList = new ArrayList<Movie>();
        this.actorList = new ArrayList<Actor>();
    }

    /**
     * Gets movie list.
     *
     * @return movies list.
     */
    public ArrayList<Movie> getMovieList() {
        return movieList;
    }

    /**
     * Get Actor list.
     *
     * @return actors list.
     */
    public ArrayList<Actor> getActorList() {
        return actorList;
    }

    /**
     * Verifies if the movie is saved.
     *
     * @param movieName movie name.
     * @return true if it is saved, false otherwise.
     */
    public boolean isMovie(final String movieName) {
        for (Movie movie : movieList) {
            if (movie.getName().equals(movieName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Verifies if the actor is saved.
     *
     * @param actorName actor name.
     * @return true if it is saved, false otherwise.
     */
    public boolean isActor(final String actorName) {
        for (Actor actor : actorList) {
            if (actor.getName().equals(actorName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Add a movie.
     *
     * @param name   movie name.
     * @param actors array list.
     */
    void addMovie(final String name, final String[] actors) {
        if (!isMovie(name)) {
            movieList.add(new Movie(name, actors));
        }
        for (String actor : actors) {
            if (!isActor(actor)) {
                Actor actorTemp = new Actor(actor);
                actorTemp.addMovie(new Movie(name, actors));
                actorList.add(actorTemp);
            }
        }
    }

    /**
     * Add a rating to a movie.
     *
     * @param name   movie name.
     * @param rating rating.
     */
    void addRating(final String name, double rating) {
        for (Movie movie : movieList) {
            if (movie.getName().equals(name)) {
                movie.setRating(rating);
            }
        }
    }

    /**
     * Update the rating.
     *
     * @param name      movie name.
     * @param newRating new rating.
     */
    void updateRating(final String name, double newRating) {
        addRating(name, newRating);
    }


    /**
     * Gets best actor.
     *
     * @return the best actor.
     */
    String getBestActor() {
        double bestRatingAverage = 0;
        String actorNameWithBestAverage = "";
        for (Actor actor : actorList) {
            int countMovies = 0;
            double totalRating = 0;
            for (Movie movie : movieList) {
                for (Actor actorTemp : movie.getActors()) {
                    if (actorTemp.getName().equals(actor.getName())) {
                        totalRating = totalRating + movie.getRating();
                        countMovies++;
                        break;
                    }
                }
            }
            if ((totalRating / countMovies) > bestRatingAverage) {
                bestRatingAverage = totalRating / countMovies;
                actorNameWithBestAverage = actor.getName();
            }
        }
        return actorNameWithBestAverage;
    }

    /**
     * Gets best movie.
     *
     * @return best movie.
     */
    String getBestMovie() {
        double movieHighestRating = 0;
        String movieNameWithHighestRating = "";
        for (Movie movie : movieList) {
            if (movie.getRating() > movieHighestRating) {
                movieHighestRating = movie.getRating();
                movieNameWithHighestRating = movie.getName();
            }
        }
        return movieNameWithHighestRating;
    }

    /**
     * Count the number of occurrences in actors list.
     *
     * @param actorName actor name.
     * @return quantity.
     */
    int getActorCount(final String actorName) {
        int count = 0;
        for (Actor actor : actorList) {
            if (actor.getName().equals(actorName)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Count the number of occurrences in movies list.
     *
     * @param movieName movie name.
     * @return quantity.
     */
    int getMovieCount(final String movieName) {
        int count = 0;
        for (Movie movie : movieList) {
            if (movie.getName().equals(movieName)) {
                count++;
            }
        }
        return count;
    }
}
