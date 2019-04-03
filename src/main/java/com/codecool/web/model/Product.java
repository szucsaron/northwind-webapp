package com.codecool.web.model;

public class Product {


    private String company;
    private String name;

    public Product(String name, String company) {
        this.name = name;
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return String.format("name: %s, company: %s", name, company);
    }
}
