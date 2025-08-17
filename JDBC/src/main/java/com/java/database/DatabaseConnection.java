package com.java.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Pooja@Root29";

    // Connect without DB (for creating DB)
    public Connection getConnection() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    // Connect with DB
    public Connection getConnectionWithDB(String dbName) throws SQLException {
        return DriverManager.getConnection(
                URL + dbName + "?useSSL=false&serverTimezone=UTC",
                USERNAME,
                PASSWORD
        );
    }
}