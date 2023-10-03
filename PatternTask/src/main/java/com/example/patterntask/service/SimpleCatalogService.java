package com.example.patterntask.service;

import com.example.patterntask.interfaces.CatalogService;
import com.example.patterntask.interfaces.FileService;
import com.example.patterntask.models.Movie;
import com.example.patterntask.models.SearchCriteria;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SimpleCatalogService implements CatalogService {
    private final List<Movie> catalog = new ArrayList<>();

    @Override
    public void displayCatalog() {
        for (Movie movie : catalog) {
            System.out.println(movie.getTitle());
        }
    }

    @Override
    public void addMovie(Movie movie) {
        catalog.add(movie);
    }

    @Override
    public List<Movie> searchMoviesByCriteria(SearchCriteria criteria) {
        if (criteria == null) {
            return Collections.emptyList();
        }

        String titleToSearch = criteria.getTitle();
        if (titleToSearch == null || titleToSearch.isEmpty()) {
            return Collections.emptyList();
        }

        return catalog.stream()
                .filter(movie -> movie.getTitle().toLowerCase().contains(titleToSearch.toLowerCase()))
                .collect(Collectors.toList());

    }
    @Override
    public String getCatalogAsHtml() {
        return "catalog";
    }
    @Override
    public List<Movie> getCatalog() {
        return new ArrayList<>(catalog);
    }
}
