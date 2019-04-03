package com.codecool.web.model;

public class Company {
    private String name;
    private int numberOfProducts;

    public Company(String name, int numberOfProducts) {
        this.name = name;
        this.numberOfProducts = numberOfProducts;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfProducts() {
        return numberOfProducts;
    }
}
