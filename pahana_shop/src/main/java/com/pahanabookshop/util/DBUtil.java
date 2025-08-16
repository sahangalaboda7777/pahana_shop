package com.pahanabookshop.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/pahana_db?user=root";
    private static final String USER = "root"; // change if needed
    private static final String PASSWORD = "root"; // change if needed

    private DBUtil() {} // prevent instantiation

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL Driver not found!", e);
        }
    }
}
