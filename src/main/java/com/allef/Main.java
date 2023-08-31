package com.allef;

import com.allef.database.DatabaseConnection;
import com.allef.view.Login;
import com.allef.view.product.CreateProduct;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection.initializeDatabase();
        new Login().setVisible(true);
        // new CreateProduct().setVisible(true);
    }
}
