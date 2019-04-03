package com.codecool.web.dao;

import com.codecool.web.model.Orders;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrdersDao extends AbstractDao {
    public OrdersDao(Connection connection) {
        super(connection);
    }

    public List<Orders> getFiltered(String customerName) throws SQLException {
        customerName += "%";
        String sql = "select company_name as CompanyName, " +
                "array_to_string(array_agg(orders.order_id), ',') as Orders " +
                "from customers " +
                "right join orders on customers.customer_id = orders.customer_id  " +
                "group by customers.company_name " +
                "having company_name like ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, customerName);

            ResultSet resultSet = statement.executeQuery();
            List<Orders> ordersLst = new ArrayList<>();
            while (resultSet.next()) {
                Orders orders = new Orders(resultSet.getString("companyname"));
                Array a = resultSet.getArray("orders");
                String[] ordStrArr = a.toString().split(",");
                for (String ordName : ordStrArr) {
                    orders.addOrder(Integer.parseInt(ordName) );
                }
                ordersLst.add(orders);


            }
            return ordersLst;
        }

    }
}
