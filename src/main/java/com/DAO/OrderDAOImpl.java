package com.DAO;

import com.connection.ConnectionDB;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class OrderDAOImpl {
    private static Connection c;

    public OrderDAOImpl() {
        ConnectionDB connectionDB = new ConnectionDB();
        c = connectionDB.getConnection();
    }

    public static void makeOrder(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
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
            query1 = "SELECT * FROM cars ORDER BY carId LIMIT 1 OFFSET " + (activePage);
        } else if (session.getAttribute("rent2Val") != null) {
            query1 = "SELECT * FROM cars ORDER BY carId LIMIT 1 OFFSET " + (1 + activePage);
        } else if (session.getAttribute("rent3Val") != null) {
            query1 = "SELECT * FROM cars ORDER BY carId LIMIT 1 OFFSET " + (2 + activePage);
        } else if (session.getAttribute("rent4Val") != null) {
            query1 = "SELECT * FROM cars ORDER BY carId LIMIT 1 OFFSET " + (3 + activePage);
        }
        Statement statement1 = null;
        ResultSet resultSet1 = null;
        System.out.println(query1);
        try {
            statement1 = c.createStatement();
            assert statement1 != null;
            resultSet1 = statement1.executeQuery(query1);
            while (resultSet1.next()) {
                carId = resultSet1.getString("carId");
                price = Integer.parseInt(resultSet1.getString("price"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
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
        String timeStr = req.getParameter("time");
        String flag = Arrays.toString(req.getParameterValues("driver"));
        String flag2 = Arrays.toString(req.getParameterValues("driver2"));
        System.out.println(seriesStr + " " + nameStr + " " + numberStr + " " + timeStr + " | " + flag + " | " + flag2);
        String query2 = "SELECT * FROM users WHERE login = '" + nameStr + "'";
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = c.createStatement();
            assert statement != null;
            resultSet = statement.executeQuery(query2);
            while (resultSet.next()) {
                userId = resultSet.getString("userId");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String query3 = "INSERT INTO orders (users_UserId, cars_CarId, endTime, driver, price) \n" +
                "   VALUES (" + userId + ", " + carId + ", " + Integer.parseInt(req.getParameter("time"))
                + ", " + driver + ", " + price + ")";

        Statement statement3 = null;
        try {
            statement3 = c.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            assert statement3 != null;
            statement3.executeUpdate(query3);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("Adding to database");

        String query4 = "UPDATE cars SET isFree = 0 WHERE CarId = " + carId;
        Statement statement4 = null;
        try {
            statement4 = c.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            assert statement4 != null;
            statement4.executeUpdate(query4);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        String query5 = "UPDATE users SET passportSeries = '" + seriesStr + "', passportNumber = '"
                + numberStr + "', WHERE UserId = " + userId;
        Statement statement5 = null;
        try {
            statement5 = c.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            assert statement5 != null;
            statement5.executeUpdate(query5);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void approve(HttpServletRequest req, HttpServletResponse resp) {
        int orderId = Integer.parseInt(req.getParameter("orderId"));
        String query = "SELECT endTime FROM orders WHERE orderId = '" + orderId + "'";
        Statement statement = null;
        ResultSet resultSet = null;
        int endTime = 0;
        try {
            statement = c.createStatement();
            assert statement != null;
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                endTime = Integer.parseInt(resultSet.getString("endTime"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(ZonedDateTime.now().format(formatter));
        String query2 = "UPDATE orders SET isApproved = " + 1 + ", startTime = '"
                + ZonedDateTime.now().format(formatter) + "', endTime = '"
                + ZonedDateTime.now().plusHours(endTime).format(formatter)
                + "' WHERE orderId = " + orderId;
        try {
            statement = c.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            assert statement != null;
            statement.executeUpdate(query2);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("Approving an order");
    }

    public static void decline(HttpServletRequest req, HttpServletResponse resp) {
        int orderId = Integer.parseInt(req.getParameter("orderId"));
        String comment = req.getParameter("comment");
        String query = "UPDATE orders SET isApproved = " + 0 + ", Comment = '" + comment
                + "' WHERE orderId = " + orderId;
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
        System.out.println("Declining an order");
    }

    public static void take(HttpServletRequest req, HttpServletResponse resp) {
        int carId = 0;
        int orderID = Integer.parseInt(req.getParameter("orderId"));
        String query = "SELECT cars_CarId FROM orders WHERE orderId = " + orderID;
        Statement statement = null;
        try {
            statement = c.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            assert statement != null;
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                carId = Integer.parseInt(resultSet.getString("cars_CarId"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        String query2 = "UPDATE cars SET isFree = 1 WHERE CarId = " + carId;
        Statement statement2 = null;
        try {
            statement2 = c.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            assert statement2 != null;
            statement2.executeUpdate(query2);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}