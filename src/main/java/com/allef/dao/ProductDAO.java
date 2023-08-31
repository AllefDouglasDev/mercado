package com.allef.dao;

import java.sql.Date;
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

    public void save(Product product) {
        String query = "INSERT INTO products (name, amount, bar_code, entry_value, profit_margin, selling_value, is_deleted, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(query)) {
            Date currentDate = new Date(new java.util.Date().getTime());
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getAmount());
            preparedStatement.setString(3, product.getBarCode());
            preparedStatement.setInt(4, product.getEntryValue());
            preparedStatement.setInt(5, product.getProfitMargin());
            preparedStatement.setInt(6, product.getSellingValue());
            preparedStatement.setInt(7, product.getIsDeleted());
            preparedStatement.setDate(8, currentDate);
            preparedStatement.setDate(9, currentDate);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
