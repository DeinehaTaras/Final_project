package com.DAO;

import com.connection.ConnectionDB;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CarDAOImpl {

    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(ConnectionDB.class);
    private static Connection c;

    public CarDAOImpl() {
        ConnectionDB connectionDB = new ConnectionDB();
        c = connectionDB.getConnection();
    }

    public void addCar(HttpServletRequest req) {
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            Logger.getLogger(CarDAOImpl.class.getName()).log(Level.SEVERE, "UnsupportedEncodingException.", e);
        }
        String brandStr = req.getParameter("brand");
        String modelStr = req.getParameter("model");
        int yearStr = Integer.parseInt(req.getParameter("year"));
        String colorStr = req.getParameter("color");
        int priceStr = Integer.parseInt(req.getParameter("price"));
        String imageStr = req.getParameter("pathToImage");
        String classComfortStr = req.getParameter("comfortClass");
        String query = "INSERT INTO cars (brand, model, year, color, price, image, isFree, comfortClass) \n" +
                "   VALUES ('" + brandStr + "', '" + modelStr + "', " + yearStr + ", '" + colorStr + "', " + priceStr +
                ", '" + imageStr + "', " + 1 + ", '" + classComfortStr + "')";
        try {
            Statement statement = c.createStatement();
            assert statement != null;
            statement.executeUpdate(query);
        } catch (SQLException throwables) {
            Logger.getLogger(CarDAOImpl.class.getName()).log(Level.SEVERE, "SQLException.", throwables);
        }
        LOG.info("Adding car to database");
    }

    public void removeCar(HttpServletRequest req) {
        int carId = Integer.parseInt(req.getParameter("carId"));
        String query = "DELETE FROM cars WHERE CarId = " + carId;
        try {
            Statement statement = c.createStatement();
            assert statement != null;
            statement.execute(query);
        } catch (SQLException throwables) {
            Logger.getLogger(CarDAOImpl.class.getName()).log(Level.SEVERE, "SQLException.", throwables);
        }
        LOG.info("Removing car from database");
    }

    public void changeColor(HttpServletRequest req) {
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            Logger.getLogger(CarDAOImpl.class.getName()).log(Level.SEVERE, "UnsupportedEncodingException.", e);
        }

        String colorStr = req.getParameter("color");
        int carId = Integer.parseInt(req.getParameter("carId"));

        String query = "UPDATE cars SET color = '" + colorStr + "' WHERE CarId = " + carId;
        try {
            Statement statement = c.createStatement();
            assert statement != null;
            statement.executeUpdate(query);
        } catch (SQLException throwables) {
            Logger.getLogger(CarDAOImpl.class.getName()).log(Level.SEVERE, "SQLException.", throwables);
        }
        LOG.info("Changing color");
    }

    public void changePrice(HttpServletRequest req) {
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            Logger.getLogger(CarDAOImpl.class.getName()).log(Level.SEVERE, "UnsupportedEncodingException.", e);
        }
        int priceStr = Integer.parseInt(req.getParameter("price"));
        int carId = Integer.parseInt(req.getParameter("carId"));
        String query = "UPDATE cars SET price = '" + priceStr + "' WHERE CarId = " + carId;

        try {
            Statement statement = c.createStatement();
            assert statement != null;
            statement.executeUpdate(query);
        } catch (SQLException throwables) {
            Logger.getLogger(CarDAOImpl.class.getName()).log(Level.SEVERE, "SQLException.", throwables);
        }
        LOG.info("Changing price");
    }

    public void changeImage(HttpServletRequest req) {
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            Logger.getLogger(CarDAOImpl.class.getName()).log(Level.SEVERE, "UnsupportedEncodingException.", e);
        }
        String imgaeStr = req.getParameter("image");
        int carId = Integer.parseInt(req.getParameter("carId"));
        String query = "UPDATE cars SET image = '" + imgaeStr + "' WHERE CarId = " + carId;

        try {
            Statement statement = c.createStatement();
            assert statement != null;
            statement.executeUpdate(query);
        } catch (SQLException throwables) {
            Logger.getLogger(CarDAOImpl.class.getName()).log(Level.SEVERE, "SQLException.", throwables);
        }
        LOG.info("Changing image");
    }

    public void sortByPrice(HttpServletRequest req) {

    }
}
