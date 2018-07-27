package org.minions.devfund.david;

import java.util.ArrayList;

public class Actor {

    private String name;
    private ArrayList<Movie> movies;

    public Actor(){
        movies = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(String name) {
        Movie movie = new Movie();
        movie.setName(name);
        movies.add(movie);
    }
}
