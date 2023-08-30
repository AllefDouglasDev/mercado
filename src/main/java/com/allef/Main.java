package com.allef;

import com.allef.database.DatabaseConnection;
import com.allef.view.Home;
import com.allef.view.Login;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection.initializeDatabase();
        Login login = new Login();
        login.setVisible(true);
//        new Home().setVisible(true);
    }
}