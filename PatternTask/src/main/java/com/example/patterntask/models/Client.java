package com.example.patterntask.models;

import java.util.List;

public class Client {
    private final String name;
    private final List<Movie> rentedMovies;

    public String getName() {
        return name;
    }

    public List<Movie> getRentedMovies() {
        return rentedMovies;
    }

    public Client(String name, List<Movie> rentedMovies) {
        this.name = name;
        this.rentedMovies = rentedMovies;
    }
}
