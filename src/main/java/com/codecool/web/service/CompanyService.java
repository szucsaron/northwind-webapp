package com.codecool.web.service;

import com.codecool.web.dao.CompanyDao;
import com.codecool.web.dao.ProductDao;
import com.codecool.web.model.Company;
import com.codecool.web.model.Product;

import java.sql.SQLException;
import java.util.List;

public class CompanyService {
    private CompanyDao companyDao;

    public CompanyService(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    public List<Company> getCompanies(String productNumberParameter) throws SQLException {
        try {
            int minimumNumberOfProducts = Integer.parseInt(productNumberParameter);
            return companyDao.getCompanies(minimumNumberOfProducts);

        } catch (NumberFormatException e) {
            return companyDao.getCompanies(0);
        }
    }
}
