package com.allef.controller;

import com.allef.dao.ProductDAO;
import com.allef.exception.FormException;
import com.allef.model.InputError;
import com.allef.model.Pagination;
import com.allef.model.Product;
import com.allef.model.dto.CreateProductDTO;
import com.allef.model.dto.ListProductsDTO;
import com.allef.model.validator.CreateProductValidator;

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


    public void create(CreateProductDTO dto) throws FormException {
        CreateProductValidator validator = new CreateProductValidator(dto);
        InputError validation = validator.validate();
        if (validation.hasErrors()) {
            throw new FormException(validation);
        }
        Product product = new Product(
                dto.getName(),
                dto.getAmount(),
                dto.getBarCode(),
                dto.getPrice(),
                dto.getProfitMargin(),
                dto.getSellingValue()
        );
        productDAO.create(product);
    }
}
