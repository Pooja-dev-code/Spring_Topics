package com.java.database;

import java.sql.Connection;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String dbName = "testjdbc";
        DatabaseConnection dbConn = new DatabaseConnection();

        try {
            // 1️⃣ Create database if not exists
            try (Connection con = dbConn.getConnection();
                 Statement stmt = con.createStatement()) {

                stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS " + dbName);
                System.out.println("Database ensured: " + dbName);
            }

            // 2️⃣ Connect to the database
            try (Connection con = dbConn.getConnectionWithDB(dbName)) {

                // 3️⃣ Create table
                UserDAO.createUserTable(con);

                // 4️⃣ Insert users
                UserDAO.insertUser(con, "Pooja", 25);
                UserDAO.insertUser(con, "Amit", 30);

                // 5️⃣ Read users
                UserDAO.readUsers(con);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}