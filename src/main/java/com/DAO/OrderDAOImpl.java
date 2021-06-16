package com.DAO;

import com.connection.ConnectionDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderDAOImpl {
    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(ConnectionDB.class);
    private static Connection c;

    public OrderDAOImpl() {
        ConnectionDB connectionDB = new ConnectionDB();
        c = connectionDB.getConnection();
    }

    public void makeOrder(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            Logger.getLogger(OrderDAOImpl.class.getName()).log(Level.SEVERE, "UnsupportedEncodingException.", e);
        }

        int activePage = 0;
        if (session.getAttribute("active__item2") != null) {
            activePage = 4;
        } else if (session.getAttribute("active__item3") != null) {
            activePage = 8;
        }

        int price = 0;
        String query1 = null;
        int driver = 0;
        String carId = null;
        if (session.getAttribute("rent1Val") != null) {
            query1 = "SELECT * FROM cars ORDER BY " + session.getAttribute("sort") + " LIMIT 1 OFFSET " + (activePage);
        } else if (session.getAttribute("rent2Val") != null) {
            query1 = "SELECT * FROM cars ORDER BY " + session.getAttribute("sort") + " LIMIT 1 OFFSET " + (1 + activePage);
        } else if (session.getAttribute("rent3Val") != null) {
            query1 = "SELECT * FROM cars ORDER BY " + session.getAttribute("sort") + " LIMIT 1 OFFSET " + (2 + activePage);
        } else if (session.getAttribute("rent4Val") != null) {
            query1 = "SELECT * FROM cars ORDER BY " + session.getAttribute("sort") + " LIMIT 1 OFFSET " + (3 + activePage);
        }
        int carStatus;
        try {
            Statement statement1 = c.createStatement();
            assert statement1 != null;
            ResultSet resultSet1 = statement1.executeQuery(query1);
            while (resultSet1.next()) {
                carId = resultSet1.getString("carId");
                carStatus = Integer.parseInt(resultSet1.getString("isFree"));
                if (carStatus == 0) {
                    req.getRequestDispatcher("/carIsBusy.jsp").forward(req, resp);
                    return;
                }
                price = Integer.parseInt(resultSet1.getString("price"));
            }
        } catch (SQLException | ServletException | IOException throwables) {
            Logger.getLogger(OrderDAOImpl.class.getName()).log(Level.SEVERE, "Exception.", throwables);
        }
        price *= Integer.parseInt(req.getParameter("time"));
        if (req.getParameter("driver1") != null) {
            price += 5 * Integer.parseInt(req.getParameter("time"));
            driver = 1;
        }
        req.setAttribute("price", price);

        String userId = null;
        String seriesStr = req.getParameter("series__passport");
        String nameStr = session.getAttribute("userName").toString();
        String numberStr = req.getParameter("number__passport");
        String query2 = "SELECT * FROM users WHERE login = '" + nameStr + "'";

        try {
            Statement statement = c.createStatement();
            assert statement != null;
            ResultSet resultSet = statement.executeQuery(query2);
            while (resultSet.next()) {
                userId = resultSet.getString("userId");
            }
        } catch (SQLException throwables) {
            Logger.getLogger(OrderDAOImpl.class.getName()).log(Level.SEVERE, "SQLException.", throwables);
        }
        String query3 = "INSERT INTO orders (users_UserId, cars_CarId, endTime, driver, price) \n" +
                "   VALUES (" + userId + ", " + carId + ", " + Integer.parseInt(req.getParameter("time"))
                + ", " + driver + ", " + price + ")";

        try {
            Statement statement3 = c.createStatement();
            assert statement3 != null;
            statement3.executeUpdate(query3);
        } catch (SQLException throwables) {
            Logger.getLogger(OrderDAOImpl.class.getName()).log(Level.SEVERE, "SQLException.", throwables);
        }
        LOG.info("Adding order to database");

        String query4 = "UPDATE cars SET isFree = 0 WHERE CarId = " + carId;

        try {
            Statement statement4 = c.createStatement();
            assert statement4 != null;
            statement4.executeUpdate(query4);
        } catch (SQLException throwables) {
            Logger.getLogger(OrderDAOImpl.class.getName()).log(Level.SEVERE, "SQLException.", throwables);
        }
        LOG.info("Update car info");

        String query5 = "UPDATE users SET passportSeries = '" + seriesStr + "', passportNumber = '"
                + numberStr + "' WHERE UserId = " + userId;

        try {
            Statement statement5 = c.createStatement();
            assert statement5 != null;
            statement5.executeUpdate(query5);
        } catch (SQLException throwables) {
            Logger.getLogger(OrderDAOImpl.class.getName()).log(Level.SEVERE, "SQLException.", throwables);
        }
        LOG.info("Adding passport info to database");
    }

    public void approve(HttpServletRequest req) {
        int orderId = Integer.parseInt(req.getParameter("orderId"));
        String query = "SELECT endTime FROM orders WHERE orderId = '" + orderId + "'";
        Statement statement = null;
        int endTime = 0;
        try {
            statement = c.createStatement();
            assert statement != null;
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                endTime = Integer.parseInt(resultSet.getString("endTime"));
            }
        } catch (SQLException throwables) {
            Logger.getLogger(OrderDAOImpl.class.getName()).log(Level.SEVERE, "SQLException.", throwables);
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String query2 = "UPDATE orders SET isApproved = " + 1 + ", startTime = '"
                + ZonedDateTime.now().format(formatter) + "', endTime = '"
                + ZonedDateTime.now().plusHours(endTime).format(formatter)
                + "' WHERE orderId = " + orderId;
        try {
            statement = c.createStatement();
            assert statement != null;
            statement.executeUpdate(query2);
        } catch (SQLException throwables) {
            Logger.getLogger(OrderDAOImpl.class.getName()).log(Level.SEVERE, "SQLException.", throwables);
        }
        LOG.info("Approving an order");
    }

    public void decline(HttpServletRequest req) {
        int orderId = Integer.parseInt(req.getParameter("orderId"));
        String comment = req.getParameter("comment");
        String query = "UPDATE orders SET isApproved = " + 0 + ", Comment = '" + comment
                + "' WHERE orderId = " + orderId;
        try {
            Statement statement = c.createStatement();
            assert statement != null;
            statement.executeUpdate(query);
        } catch (SQLException throwables) {
            Logger.getLogger(OrderDAOImpl.class.getName()).log(Level.SEVERE, "SQLException.", throwables);
        }
        LOG.info("Declining an order");
    }

    public void take(HttpServletRequest req) {
        int carId = 0;
        int orderID = Integer.parseInt(req.getParameter("orderId"));
        String query = "SELECT cars_CarId FROM orders WHERE orderId = " + orderID;
        Statement statement;
        try {
            statement = c.createStatement();
            assert statement != null;
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                carId = Integer.parseInt(resultSet.getString("cars_CarId"));
            }
        } catch (SQLException throwables) {
            Logger.getLogger(OrderDAOImpl.class.getName()).log(Level.SEVERE, "SQLException.", throwables);
        }

        String query2 = "UPDATE cars SET isFree = 1 WHERE CarId = " + carId;
        try {
            statement = c.createStatement();
            assert statement != null;
            statement.executeUpdate(query2);
        } catch (SQLException throwables) {
            Logger.getLogger(OrderDAOImpl.class.getName()).log(Level.SEVERE, "SQLException.", throwables);
        }
        LOG.info("Getting a car");
    }

    public void giveAFine(HttpServletRequest req) {
        int orderId = Integer.parseInt(req.getParameter("orderId"));
        int fine = Integer.parseInt(req.getParameter("fine"));
        String query = "UPDATE orders SET Fine = " + fine + " WHERE orderId = " + orderId;
        try {
            Statement statement = c.createStatement();
            assert statement != null;
            statement.executeUpdate(query);
        } catch (SQLException throwables) {
            Logger.getLogger(OrderDAOImpl.class.getName()).log(Level.SEVERE, "SQLException.", throwables);
        }
        LOG.info("Writing a fine to database");
    }
}