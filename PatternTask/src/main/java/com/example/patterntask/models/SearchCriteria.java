package com.example.patterntask.models;

public class SearchCriteria {
    private String title;
    private Movie.MovieType priceCode;
    private String director;

    public SearchCriteria() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
