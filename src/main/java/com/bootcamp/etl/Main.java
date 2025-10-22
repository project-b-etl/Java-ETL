package com.bootcamp.etl;
import java.sql.*;

public class Main {
    public static void main(String[] args) {

        try (Connection conn = DatabaseConnection.getConnection()) {
            if (conn != null) {
                System.out.println("Connected to the database at " + Config.get("db.url"));

                //Test a simple SQL query
                String testQuery = "SELECT version();";
                try (PreparedStatement ps = conn.prepareStatement(testQuery);
                     ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        System.out.println("PostgreSQL version: " + rs.getString(1));
                    }
                }
            } else {
                System.out.println("Failed to connect.");
            }
        } catch (SQLException e) {
            System.out.println("Connection error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}