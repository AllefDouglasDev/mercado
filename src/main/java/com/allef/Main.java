package com.allef;

import com.allef.controller.ProductController;
import com.allef.database.DatabaseConnection;
import com.allef.model.Pagination;
import com.allef.model.Product;
import com.allef.model.dto.ListProductsDTO;
import com.allef.view.Login;
import com.allef.view.product.CreateProduct;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection.initializeDatabase();

        ProductController productController = new ProductController();
        ListProductsDTO listProductsDTO = new ListProductsDTO();
        listProductsDTO.setSize(1);
        listProductsDTO.setSearch("12");
        Pagination<Product> products = productController.list(listProductsDTO);
        System.out.println("Total: " + products.getTotal());
        products.getData().forEach(System.out::println);

        // new Login().setVisible(true);
        // new CreateProduct().setVisible(true);
    }
}
