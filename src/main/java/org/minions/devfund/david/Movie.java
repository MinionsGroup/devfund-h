package org.minions.devfund.david;

import java.util.ArrayList;

public class Movie {
    private String name;
    private ArrayList<Actor> actors;
    private double rating;

    public Movie(){
        actors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Actor> getActors() {
        return actors;
    }

    public void setActors(String[] actorList, String movie) {
        for (String singleActor : actorList){
            Actor actor = new Actor();
            actor.setMovies(movie);
            actor.setName(singleActor);
            actors.add(actor);
        }
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
