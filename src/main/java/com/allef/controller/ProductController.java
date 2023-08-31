package com.allef.controller;

import com.allef.dao.ProductDAO;
import com.allef.model.Pagination;
import com.allef.model.Product;
import com.allef.model.dto.ListProductsDTO;

public class ProductController {
    private ProductDAO productDAO;

    public ProductController() {
        this.productDAO = new ProductDAO();
    }

    public Product get(int id) {
        return productDAO.get(id);
    }

    public Pagination<Product> list(ListProductsDTO dto) {
        return productDAO.list(dto);
    }


    public void save(Product product) {
        productDAO.save(product);
    }
}
