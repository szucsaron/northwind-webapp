package com.codecool.web.servlet;


import com.codecool.web.dao.CompanyDao;
import com.codecool.web.dao.OrdersDao;
import com.codecool.web.model.Company;
import com.codecool.web.model.Orders;
import com.codecool.web.service.CompanyService;
import com.codecool.web.service.OrdersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/task4")
public final class Task4Servlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Connection connection = getConnection(getServletContext());
            OrdersDao db = new OrdersDao(connection);
            OrdersService ordersService = new OrdersService(db);
            List<Orders> orders = ordersService.getOrders(req.getParameter("companyName"));
            req.setAttribute("orderLst", orders);

            req.getRequestDispatcher("task4.jsp").forward(req, resp);

        } catch (SQLException e) {
            redirectToErrorPage(req, resp, e);
        }
    }


}
