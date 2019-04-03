package com.codecool.web.model;


import java.math.BigDecimal;

public class PricedProduct extends Product {
    private BigDecimal price;
    public PricedProduct(String name, String company, BigDecimal price) {
        super(name, company);
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
