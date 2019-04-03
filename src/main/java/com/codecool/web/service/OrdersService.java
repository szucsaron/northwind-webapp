package com.codecool.web.service;

import com.codecool.web.dao.OrdersDao;
import com.codecool.web.model.Orders;

import java.sql.SQLException;
import java.util.List;

public class OrdersService {
    private OrdersDao orderDao;

    public OrdersService(OrdersDao orderDao) {
        this.orderDao = orderDao;
    }

    public List<Orders> getOrders(String companyName) throws SQLException {
        if (companyName == null) {
            return orderDao.getFiltered("");
        }
        return orderDao.getFiltered(companyName);
    }


}
