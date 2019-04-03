package com.codecool.web.dao;

import com.codecool.web.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao extends AbstractDao {

    public ProductDao(Connection connection) {
        super(connection);
    }

    public List<Product> getFiltered(String companyName) throws SQLException {
        companyName += "%";
        String sql = "select product_name as Product, company_name as Company " +
                "from products " +
                "left join suppliers on products.supplier_id = suppliers.supplier_id " +
                "where company_name like ? " +
                "order by product, company";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, companyName);

            ResultSet resultSet = statement.executeQuery();
            List<Product> products = new ArrayList<>();
            while (resultSet.next()) {
                products.add(new Product(
                        resultSet.getString("product"),
                        resultSet.getString("company")));
            }
            return products;
        }

    }
}
