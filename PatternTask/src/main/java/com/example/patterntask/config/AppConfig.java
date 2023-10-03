package com.example.patterntask.config;

import com.example.patterntask.components.Menu;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public CommandLineRunner run(Menu menu) {
        return args -> {
            menu.displayMenu();
        };
    }
}
