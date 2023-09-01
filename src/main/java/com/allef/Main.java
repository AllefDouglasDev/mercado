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

        new Login().setVisible(true);
        // new CreateProduct().setVisible(true);
    }
}
