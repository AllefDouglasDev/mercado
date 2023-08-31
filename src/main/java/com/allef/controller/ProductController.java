package com.allef.controller;

import com.allef.dao.ProductDAO;
import com.allef.model.Product;

public class ProductController {
    private ProductDAO productDAO;

    public ProductController() {
        this.productDAO = new ProductDAO();
    }

    public Product get(int id) {
        return productDAO.get(id);
    }

    public void save(Product product) {
        productDAO.save(product);
    }
}
