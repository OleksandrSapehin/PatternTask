package com.example.patterntask.service;

import com.example.patterntask.interfaces.FileService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
@Service
public class TextFileService implements FileService {
    private final String fileName = "movie_catalog.txt";

    @Override
    public void saveData(String data) {
        try {
            Files.write(Path.of(fileName), data.getBytes());
            System.out.println("Data saved to " + fileName);
        } catch (IOException e) {
            System.err.println("Error saving data to file: " + e.getMessage());
        }
    }

    @Override
    public String loadData(String fileName) {
        try {
            return Files.readString(Path.of(fileName));
        } catch (IOException e) {
            System.err.println("Error loading data from file: " + e.getMessage());
            return "";
        }
    }
}
