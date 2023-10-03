package com.example.patterntask.controllers;

import com.example.patterntask.interfaces.CatalogService;
import com.example.patterntask.models.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {
    private final CatalogService catalogService;

    public MainController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }
    @GetMapping("/catalog")
    public String getCatalog(Model model) {
        catalogService.displayCatalog();
        List<Movie> movies = catalogService.getCatalog();
        model.addAttribute("catalog", movies);
        return "catalog";
    }
}
