package org.minions.devfund.damianvp.moviedatabase;

import java.util.ArrayList;

public class Actor extends MovieDatabase {
    private String name;
    private ArrayList<Movie> movies;
    private Double actorRatingAverage;

    Actor(String name) {
        this.name = name;
        this.movies = new ArrayList<>();
        this.actorRatingAverage = 0.0;
    }

    String getName() {
        return this.name;
    }

    Double getActorRatingAverage() { return this.actorRatingAverage; }

    ArrayList<Movie> getMovies() {
        return this.movies;
    }

    void addMovie(Movie movie) {
        if (!movieExists(name)) {
            this.movies.add(movie);
        }
        this.actorRatingAverage = (this.actorRatingAverage + movie.getRating()) / this.movies.size();
    }

    private boolean movieExists(final String name){
        return this.movies.stream().anyMatch(o -> o.getName().equals(name));
    }




}
