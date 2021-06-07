package com;

import java.sql.*;

public class CheckBD {
    private static Connection c;
    public static void main(String[] args) throws ClassNotFoundException {
    CheckBD checkBD = new CheckBD();
    c = checkBD.getConnection();
    System.out.println(c);
    }
    public Connection getConnection() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/carsharing?";
        String username = "root";
        String password = "1234";

        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
}
