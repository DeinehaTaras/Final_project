package com.DAO;

import com.connection.ConnectionDB;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CarDAOImpl {

    private static Connection c;

    public CarDAOImpl() {
        ConnectionDB connectionDB = new ConnectionDB();
        c = connectionDB.getConnection();
    }

    public static void addCar(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
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
        System.out.println("Connect = " + c);
        Statement statement = null;
        try {
            statement = c.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            assert statement != null;
            statement.executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("Adding car to database");
    }

    public static void removeCar(HttpServletRequest req, HttpServletResponse resp) {
        int carId = Integer.parseInt(req.getParameter("carId"));
        String query = "DELETE FROM cars WHERE CarId = " + carId;
        Statement statement = null;
        try {
            statement = c.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            assert statement != null;
            statement.execute(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("Removing car from database");
    }

    public static void changeColor(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String colorStr = req.getParameter("color");
        int carId = Integer.parseInt(req.getParameter("carId"));
        String query = "UPDATE cars SET color = '" + colorStr + "' WHERE CarId = " + carId;
        Statement statement = null;
        try {
            statement = c.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            assert statement != null;
            statement.executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("Changing color");
    }

    public static void changePrice(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        int priceStr = Integer.parseInt(req.getParameter("price"));
        int carId = Integer.parseInt(req.getParameter("carId"));
        String query = "UPDATE cars SET price = '" + priceStr + "' WHERE CarId = " + carId;
        Statement statement = null;
        try {
            statement = c.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            assert statement != null;
            statement.executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("Changing price");
    }

    public static void changeImage(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String imgaeStr = req.getParameter("image");
        int carId = Integer.parseInt(req.getParameter("carId"));
        String query = "UPDATE cars SET image = '" + imgaeStr + "' WHERE CarId = " + carId;
        Statement statement = null;
        try {
            statement = c.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            assert statement != null;
            statement.executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("Changing image");
    }
}
