package com.example.patterntask.components;

import com.example.patterntask.interfaces.CatalogService;
import com.example.patterntask.interfaces.FileService;
import com.example.patterntask.models.Movie;
import com.example.patterntask.models.SearchCriteria;;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;
@Component
public class Menu {
    private final CatalogService catalogService;
    private final FileService fileService;


    public Menu(CatalogService catalogService, FileService fileService) {
        this.catalogService = catalogService;
        this.fileService = fileService;
    }



    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("===== Movie Catalog Menu =====");
            System.out.println("1. Add Movie");
            System.out.println("2. Search Movies");
            System.out.println("3. Show all catalog");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addMovie();
                    break;
                case 2:
                    searchMovies();
                    break;
                case 3:
                    catalogService.displayCatalog();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }

    private void addMovie() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the title of the movie: ");
        String title = scanner.nextLine();

        System.out.print("Enter the country of origin: ");
        String countryOfOrigin = scanner.nextLine();

        System.out.print("Enter the description: ");
        String description = scanner.nextLine();

        System.out.print("Enter the director: ");
        String director = scanner.nextLine();


        Movie movie = new Movie(title, Movie.MovieType.REGULAR, countryOfOrigin, description, director, List.of("Actor1", "Actor2"));
        catalogService.addMovie(movie);

        System.out.println("Movie added successfully!");
    }

    private void searchMovies() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the title to search: ");
        String title = scanner.nextLine();

        SearchCriteria criteria = new SearchCriteria();
        criteria.setTitle(title);

        List<Movie> searchResult = catalogService.searchMoviesByCriteria(criteria);

        if (!searchResult.isEmpty()) {
            System.out.println("Search results:");
            for (Movie movie : searchResult) {
                System.out.println("Title: " + movie.getTitle());
                System.out.println("Country of Origin: " + movie.getCountryOfOrigin());
                System.out.println("Description: " + movie.getDescription());
                System.out.println("Director: " + movie.getDirector());
                System.out.println("------------------------");
            }
        } else {
            System.out.println("No movies found for the given criteria.");
        }
    }
}
