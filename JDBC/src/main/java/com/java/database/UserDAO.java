package com.java.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDAO {

    // Create table
    public static void createUserTable(Connection con) throws Exception {
        String sql = "CREATE TABLE IF NOT EXISTS user (" +
                "user_id INT AUTO_INCREMENT PRIMARY KEY, " +
                "user_name VARCHAR(50), " +
                "user_age INT)";
        try (Statement smt = con.createStatement()) {
            smt.executeUpdate(sql);
            System.out.println("Table created (if not exists): user");
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    // Insert user
    public static void insertUser(Connection con, String userName, int userAge) throws Exception {
        String sql = "INSERT INTO user(user_name, user_age) VALUES (?, ?)";
        try (PreparedStatement smt = con.prepareStatement(sql)) {
            smt.setString(1, userName);
            smt.setInt(2, userAge);
            smt.executeUpdate();
            System.out.println("Inserted user: " + userName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Read all users
    public static void readUsers(Connection con) throws Exception {
        String sql = "SELECT * FROM user";
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("Users in DB:");
            while (rs.next()) {
                System.out.println(rs.getInt("user_id") + " | " +
                        rs.getString("user_name") + " | " +
                        rs.getInt("user_age"));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}