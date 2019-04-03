package com.codecool.web.service;

import com.codecool.web.dao.CompanyDao;
import com.codecool.web.model.Company;

import java.sql.SQLException;
import java.util.List;

public class CompanyService {
    private CompanyDao companyDao;

    public CompanyService(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    public List<Company> getCompaniesByProductNumber(String productNumberParameter) throws SQLException {
        try {
            int minimumNumberOfProducts = Integer.parseInt(productNumberParameter);
            return companyDao.getFilteredCompanies(minimumNumberOfProducts);

        } catch (NumberFormatException e) {
            return companyDao.getFilteredCompanies(0);
        }
    }

    public List<Company> getCompaniesByName(String companyName) throws SQLException {
        if (companyName == null) {
            return companyDao.getFilteredCompanies("");
        }
        return companyDao.getFilteredCompanies(companyName);
    }
}
