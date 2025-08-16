package com.pahanabookshop.test;

import com.pahanabookshop.util.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;


public class DBConnectionTest {
	
	public static void main(String[] args) {
        try (Connection conn = DBUtil.getConnection()) {
            if (conn != null && !conn.isClosed()) {
                System.out.println("Database connection successful!");
            } else {
                System.out.println("Failed to connect to the database.");
            }
        } catch (SQLException e) {
            System.err.println("Error connecting to database: " + e.getMessage());
            e.printStackTrace();
        }
    }
}