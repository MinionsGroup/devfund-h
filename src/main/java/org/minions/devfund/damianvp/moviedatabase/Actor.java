package org.minions.devfund.damianvp.moviedatabase;

import java.util.ArrayList;

public class Actor extends MovieDatabase {
    private String name;
    private ArrayList<Movie> movies;

    Actor(String name) {
        this.name = name;
        this.movies = new ArrayList<>();
    }

    String getName() {
        return this.name;
    }

    ArrayList<Movie> getMovies() {
        return this.movies;
    }

    void addMovie(Movie movie) {
        System.out.println("--------addMovie on actor class----------");
        if (!movieExists(name)) {
            this.movies.add(movie);
        }
    }

    public boolean movieExists(final String name){
        return this.movies.stream().anyMatch(o -> o.getName().equals(name));
    }



}
