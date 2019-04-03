package com.codecool.web.servlet;


import com.codecool.web.dao.CompanyDao;
import com.codecool.web.model.Company;
import com.codecool.web.service.CompanyService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/task3")
public final class Task3Servlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Connection connection = getConnection(getServletContext());
            CompanyDao db = new CompanyDao(connection);
            CompanyService companyService = new CompanyService(db);
            List<Company> companies = companyService.getCompaniesByName(req.getParameter("companyName"));
            req.setAttribute("companies", companies);
            req.getRequestDispatcher("task3.jsp").forward(req, resp);

        } catch (SQLException e) {
            redirectToErrorPage(req, resp, e);
        }
    }


}
