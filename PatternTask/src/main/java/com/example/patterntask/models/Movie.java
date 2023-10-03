package com.example.patterntask.models;

import java.util.List;

public class Movie {

    private final String title;
    private final MovieType priceCode;
    private final String countryOfOrigin;
    private final String description;
    private final String director;
    private final List<String> actors;

    public enum MovieType {
        REGULAR, NEW_RELEASE, CHILDREN
    }

    public Movie(String title, MovieType priceCode, String countryOfOrigin, String description, String director, List<String> actors) {
        this.title = title;
        this.priceCode = priceCode;
        this.countryOfOrigin = countryOfOrigin;
        this.description = description;
        this.director = director;
        this.actors = actors;
    }
    public MovieType getPriceCode() {
        return priceCode;
    }

    public String getTitle() {
        return title;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public String getDescription() {
        return description;
    }

    public String getDirector() {
        return director;
    }

    public List<String> getActors() {
        return actors;
    }
}
