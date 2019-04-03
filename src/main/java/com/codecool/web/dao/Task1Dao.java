package com.codecool.web.dao;

import com.codecool.web.model.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Task1Dao extends AbstractDao {

    public Task1Dao(Connection connection) {
        super(connection);
    }

    public List<Product> getTask1Stuff() throws SQLException {
        StringBuilder sb = new StringBuilder();
        String sql = "select product_name as Product, company_name as Company \n" +
                "from products \n" +
                "left join suppliers on products.supplier_id = suppliers.supplier_id\n" +
                "order by product, company;";
        String sql2 = "SELECT * FROM products";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            List<Product> products = new ArrayList<>();
            while (resultSet.next()) {
                products.add(new Product(resultSet.getString("product"),
                                         resultSet.getString("company")));
            }
            return products;
        }

    }
}
