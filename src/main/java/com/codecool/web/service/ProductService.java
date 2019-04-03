package com.codecool.web.service;

import com.codecool.web.dao.ProductDao;
import com.codecool.web.model.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductService {
    private ProductDao productDao;

    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public List<Product> getProducts(String companyName) throws SQLException {
        if (companyName == null) {
            return productDao.getProducts("");
        }
        return productDao.getProducts(companyName);
    }


}
