package com.allef.dao;

import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.allef.database.DatabaseConnection;
import com.allef.model.Pagination;
import com.allef.model.Product;
import com.allef.model.dto.ListProductsDTO;

public class ProductDAO {
    private Connection connection;

    public ProductDAO() {
        this.connection = DatabaseConnection.getConnection();
    }

    public Product get(int id) {
        String query = "SELECT * FROM products WHERE id = ? AND is_deleted = 0";
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
                        resultSet.getDate("updated_at"));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            
        }
        return null;
    }

    public Pagination<Product> list(ListProductsDTO dto) {
        int total = 0;
        List<Product> products = new ArrayList<>();
        int offset = (dto.getPage() - 1) * dto.getSize();
        String baseQuery = "SELECT * FROM products ";
        String countBaseQuery = "SELECT COUNT(*) FROM products ";
        StringBuilder whereClause = new StringBuilder();
        List<Object> parameters = new ArrayList<>();
        if (dto.getSearch() != null && !dto.getSearch().isEmpty()) {
            whereClause.append(
                    " WHERE LOWER(REMOVE_DIACRITICS(name)) LIKE LOWER(REMOVE_DIACRITICS(?)) "
                    + " OR LOWER(REMOVE_DIACRITICS(bar_code)) LIKE LOWER(REMOVE_DIACRITICS(?)) ");
            parameters.add("%" + dto.getSearch() + "%");
            parameters.add("%" + dto.getSearch() + "%");
        }
        whereClause.append(" AND is_deleted = 0 ");
        String query = baseQuery + whereClause.toString() + " LIMIT ? OFFSET ? ";
        String countQuery = countBaseQuery + whereClause.toString();
        try {
            DatabaseConnection.createFunctionToRemoveDiacritics(this.connection);
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            for (int i = 0; i < parameters.size(); i++) {
                preparedStatement.setObject(i + 1, parameters.get(i));
            }
            preparedStatement.setInt(parameters.size() + 1, dto.getSize());
            preparedStatement.setInt(parameters.size() + 2, offset);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                products.add(new Product(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("amount"),
                        resultSet.getString("bar_code"),
                        resultSet.getInt("entry_value"),
                        resultSet.getInt("profit_margin"),
                        resultSet.getInt("selling_value"),
                        resultSet.getInt("is_deleted"),
                        resultSet.getDate("created_at"),
                        resultSet.getDate("updated_at")));
            }
            resultSet.close();
            PreparedStatement countPreparedStatement = this.connection.prepareStatement(countQuery);
            for (int i = 0; i < parameters.size(); i++) {
                countPreparedStatement.setObject(i + 1, parameters.get(i));
            }
            ResultSet countResultSet = countPreparedStatement.executeQuery();
            if (countResultSet.next()) {
                total = countResultSet.getInt(1);
            }
            countResultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Pagination<>(
                dto.getPage(),
                dto.getSize(),
                total,
                products);
    }

    public void create(Product product) {
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
