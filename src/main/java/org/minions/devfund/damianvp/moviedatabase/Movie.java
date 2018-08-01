package org.minions.devfund.damianvp.moviedatabase;

import java.util.ArrayList;

public class Movie {
    private String name;
    private ArrayList<Actor> actors;
    private double rating;

    Movie(String name) {
        this.name = name;
        this.actors = new ArrayList<>();
        this.rating = 0.0;
    }

    String getName() {
        return this.name;
    }

    ArrayList<Actor> getActors() {
        return this.actors;
    }

    double getRating() {
        return this.rating;
    }

    void setRating(double rating) {
        this.rating = rating;
    }

    void addActor(Actor actor) {
        if (!actorExists(actor.getName())) {
            Actor newActor = new Actor(actor.getName());
            newActor.addMovie(this);
            this.actors.add(actor);
        }
    }


    public boolean actorExists(final String name){
        return this.actors.stream().anyMatch(o -> o.getName().equals(name));
    }
}
