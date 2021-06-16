package com.connection;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionDB {

    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(ConnectionDB.class);

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, "ClassNotFoundException.", e);
        }
        String url = "jdbc:mysql://localhost:3306/carRental?";
        String username = "root";
        String password = "1234";

        try {
            LOG.info("Connect to database: " + url);
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException throwables) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, "SQLException.", throwables);
            return null;
        }
    }
}
