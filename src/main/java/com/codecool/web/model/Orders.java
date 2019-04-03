package com.codecool.web.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Orders{
    private String companyName;

    private List<Integer> orders = new ArrayList<>();

    public String getCompanyName() {
        return companyName;
    }

    public Orders(String companyName) {
        this.companyName = companyName;
    }

    public void addOrder(int order) {
        orders.add(order);
    }

    public List<Integer> getOrders() {
        return orders;
    }


}
