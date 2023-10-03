package com.example.patterntask.interfaces;

import com.example.patterntask.models.Movie;
import com.example.patterntask.models.SearchCriteria;

import java.util.List;

public interface CatalogService {
    void displayCatalog();
    void addMovie(Movie movie);
    List<Movie> searchMoviesByCriteria(SearchCriteria criteria);
    String getCatalogAsHtml();
    List<Movie> getCatalog();
}
