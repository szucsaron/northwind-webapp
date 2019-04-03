package com.codecool.web.dao;

import com.codecool.web.model.Company;
import com.codecool.web.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompanyDao extends AbstractDao {

    public CompanyDao(Connection connection) {
        super(connection);
    }

    public List<Company> getCompanies(int minimumProductNum) throws SQLException {

        String sql = "select suppliers.company_name as Company, count (*) as NumberOfProducts\n" +
                "from suppliers  \n" +
                "right join products on products.supplier_id = suppliers.supplier_id\n" +
                "group by suppliers.supplier_id\n" +
                "having count(*) >= ?\n" +
                "order by count(*);";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, minimumProductNum);

            ResultSet resultSet = statement.executeQuery();
            List<Company> companies = new ArrayList<>();
            while (resultSet.next()) {
                companies.add(new Company(
                        resultSet.getString("company"),
                        resultSet.getInt("numberofproducts")));
            }
            return companies;
        }

    }
}
