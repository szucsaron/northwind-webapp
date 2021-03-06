package com.codecool.web.servlet;


import com.codecool.web.dao.ProductDao;
import com.codecool.web.model.Product;
import com.codecool.web.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/task1")
public final class Task1Servlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Connection connection = getConnection(getServletContext());
            ProductDao db = new ProductDao(connection);
            ProductService productService = new ProductService(db);
            List<Product> products = productService.getProducts(req.getParameter("company"));
            req.setAttribute("products", products);
            req.getRequestDispatcher("task1.jsp").forward(req, resp);

        } catch (SQLException e) {
            redirectToErrorPage(req, resp, e);
        }
    }


}
