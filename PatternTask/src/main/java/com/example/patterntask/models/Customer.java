package com.example.patterntask.models;

import java.util.List;

import static com.example.patterntask.models.Movie.MovieType.NEW_RELEASE;

public class Customer {
    private final String name;
    private final List<Rental> rentals;

    public Customer(String name, List<Rental> rentals) {
        this.name = name;
        this.rentals = rentals;
    }


    public String getName() {
        return name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = "Rental Record for " + getName() + "\n";
        for (Rental each : rentals) {
            double thisAmount = 0;
            switch (each.getMovie().getPriceCode()) {
                case REGULAR -> {
                    thisAmount += 2;
                    if (each.getDaysRented() > 2)
                        thisAmount += (each.getDaysRented() - 2) * 1.5;
                }
                case NEW_RELEASE -> thisAmount += each.getDaysRented() * 3;
                case CHILDREN -> {
                    thisAmount += 1.5;
                    if (each.getDaysRented() > 3)
                        thisAmount += (each.getDaysRented() - 3) * 1.5;
                }
            }
            frequentRenterPoints++;
            if ((each.getMovie().getPriceCode() == NEW_RELEASE) && each.getDaysRented() > 1)
                frequentRenterPoints++;
            result += "\t" + each.getMovie().getTitle() + "\t" + thisAmount + "\n";
            totalAmount += thisAmount;
        }
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points";
        return result;
    }
}
