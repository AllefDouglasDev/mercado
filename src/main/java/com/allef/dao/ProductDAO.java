package com.allef.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.allef.database.DatabaseConnection;
import com.allef.model.Product;

public class ProductDAO {
    private Connection connection; 

    public ProductDAO() {
        this.connection = DatabaseConnection.getConnection();        
    }

    public Product get(int id) {
        String query = "SELECT * FROM products WHERE id = ?";
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Product(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("amount"),
                        resultSet.getString("bar_code"),
                        resultSet.getInt("entry_value"),
                        resultSet.getInt("profit_margin"),
                        resultSet.getInt("selling_value"),
                        resultSet.getInt("is_deleted"),
                        resultSet.getDate("created_at"),
                        resultSet.getDate("updated_at")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
