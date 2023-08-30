package com.allef.database;

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DatabaseConnection {
    private static final String DB_FOLDER = "db";
    private static final String DB_FILE = "data.db";

    public static Connection getConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection("jdbc:sqlite:" + DB_FOLDER + "/" + DB_FILE);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void createDatabaseIfNotExists() {
        File dbFolder = new File(DB_FOLDER);
        if (!dbFolder.exists()) {
            dbFolder.mkdirs();
        }
        File dbFile = new File(DB_FOLDER, DB_FILE);
        if (!dbFile.exists()) {
            try {
                dbFile.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void initializeDatabase() {
        createDatabaseIfNotExists();
        try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
            Migration migration = new Migration();
            Seed seed = new Seed();

            List<String> seedSQLs = new ArrayList<>();
            for (Map.Entry<String, String[]> entry : seed.getSQLs().entrySet()) {
            	String tableName = entry.getKey();
				if (tableExists(tableName)) {
					for (String sql : entry.getValue()) {
						seedSQLs.add(sql);
					}
				}
            }

            for (String sql: migration.getSQLs()) {
            	statement.executeUpdate(sql);
            }
            for (String sql: seedSQLs) {
            	statement.executeUpdate(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean tableExists(String tableName) {
        try (Connection connection = getConnection()) {
            DatabaseMetaData md = connection.getMetaData();
            ResultSet rs = md.getTables(null, null, tableName, null);
            if (rs.next()) {
                return rs.getRow() > 0;
            }
            return false;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
