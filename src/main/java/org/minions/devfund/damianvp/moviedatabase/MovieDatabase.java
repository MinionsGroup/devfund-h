package org.minions.devfund.damianvp.moviedatabase;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class MovieDatabase {

    private ArrayList<Movie> movieList;
    private ArrayList<Actor> actorList;

    MovieDatabase() {
        this.movieList = new ArrayList<>();
        this.actorList = new ArrayList<>();
    }

    ArrayList<Movie> getMovieList() {
        return this.movieList;
    }

    ArrayList<Actor> getActorList() {
        return this.actorList;
    }

    void addMovie(String name, String[] actors) {
        if (!containsMovie(name)) {
            Movie newMovie = new Movie(name);
            for(int i = 0; i < actors.length; i++) {
                Actor actor;
                if (!containsActor(actors[i])) {
                    actor = new Actor(actors[i]);
                    this.actorList.add(actor);
                } else {
                    actor = getExistentActorObject(actors[i]);
                }
                actor.addMovie(newMovie);
                newMovie.addActor(actor);
            }
        }
    }

    public boolean containsMovie(final String name){
        return this.movieList.stream().anyMatch(o -> o.getName().equals(name));
    }

    public boolean containsActor(final String name){
        return this.actorList.stream().anyMatch(o -> o.getName().equals(name));
    }
    
    public Actor getExistentActorObject(String name) {
        int i = 0;
        while (this.actorList.get(i).getName() != name) {
            i++;
        }
        return this.actorList.get(i);
    }

    public Movie getExistentMovieObject(String name) {
        int i = 0;
        while (this.movieList.get(i).getName() != name) {
            i++;
        }
        return this.movieList.get(i);
    }

    void addRating(String name, double rating) {
        if (!containsMovie(name)) {
            Movie movie = getExistentMovieObject(name);
            movie.setRating(rating);
        }
    }

    void updateRating(String name, double newRating) {
        addRating(name, newRating);
    }

    String getBestActor() {
        Comparator<Actor> comparator = Comparator.comparing(Actor::getActorRatingAverage);
        return this.actorList.stream().max(comparator).getClass().getName();
    }

    String getBestMovie() {
        Comparator<Movie> comparator = Comparator.comparing(Movie::getRating);
        return this.movieList.stream().max(comparator).getClass().getName();
    }
}
