package com.codecool.web.servlet;


import com.codecool.web.dao.Task1Dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/task1")
public final class Task1Servlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String msg = "";
        try {
            Connection connection = getConnection(getServletContext());
            Task1Dao db = new Task1Dao(connection);
            msg = db.getTask1Stuff();
        } catch (SQLException e) {
            msg = e.getLocalizedMessage();
        }
        req.setAttribute("msg", msg);
        req.getRequestDispatcher("task1.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
