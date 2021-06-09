package com.DAO;

import com.connection.ConnectionDB;
import com.entity.Car;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DAOImpl {
    private static Connection c;

    public DAOImpl() {
        ConnectionDB connectionDB = new ConnectionDB();
        c = connectionDB.getConnection();
    }

    public static void registration(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String surnameStr = req.getParameter("surname");
        String nameStr = req.getParameter("name");
        String secondNameStr = req.getParameter("secondName");
        String dateStr = req.getParameter("date");
        String phoneNumberStr = req.getParameter("phoneNumber");
        String loginStr = req.getParameter("login");
        String passStr = req.getParameter("password");
        String query = "INSERT INTO users (Surname, name, secondName, dateOfBirth, phoneNumber, login, password) \n" +
                "   VALUES ('" + surnameStr + "', '" + nameStr + "', '" + secondNameStr + "', '" + dateStr + "', '" + phoneNumberStr +
                "', '" + loginStr + "', '" + passStr + "')";
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
        System.out.println("Adding to database");
    }

    public static boolean login(HttpServletRequest req, HttpServletResponse resp) {

        String loginStr = req.getParameter("login");
        String passStr = req.getParameter("password");
        String query = "SELECT * FROM users WHERE login = '" + loginStr + "'";
        System.out.println("Connect = " + c);
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = c.createStatement();
            assert statement != null;
            resultSet = statement.executeQuery(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        System.out.println("Retrieving data from database...");
        try {
            while (resultSet.next()) {
                if (resultSet.getString("login").equals(loginStr) && resultSet.getString("password").equals(passStr)) {
                    return true;
                } else
                    return false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public List<Car> checkCars() {
        List<Car> carList = new ArrayList<>();
        String brandStr;
        String modelStr;
        int yearStr;
        String colorStr;
        String priceStr;
        String imageStr;
        String classStr;
        int status;
        String query = "SELECT * FROM cars";
        try {
            Statement statement = c.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            System.out.println("Checking cars...");
            while (resultSet.next()) {
                brandStr = resultSet.getString("brand");
                modelStr = resultSet.getString("model");
                yearStr = resultSet.getInt("year");
                colorStr = resultSet.getString("color");
                priceStr = resultSet.getString("price");
                imageStr = resultSet.getString("image");
                classStr = resultSet.getString("comfortClass");
                status = Integer.parseInt(resultSet.getString("isFree"));
                if (status == 1) {
                    carList.add(new Car(brandStr, modelStr, yearStr, colorStr,
                            priceStr, imageStr, classStr, "free"));
                } else
                    carList.add(new Car(brandStr, modelStr, yearStr, colorStr,
                            priceStr, imageStr, classStr, "don't free"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carList;
    }

    public static void makeOrder(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String seriesStr = req.getParameter("series__passport");
        String nameStr = session.getAttribute("userName").toString();
        String numberStr = req.getParameter("number__passport");
        String timeStr = req.getParameter("time");
        String flag = Arrays.toString(req.getParameterValues("driver"));
        String flag2 = Arrays.toString(req.getParameterValues("driver2"));
        System.out.println(seriesStr + " " + nameStr + " " + numberStr + " " + timeStr + " | " + flag + " | " + flag2);
        // String query = "INSERT INTO orders (Surname, name, secondName, phone_number, login, password) \n" +
        //     "   VALUES ('" + surnameStr +"', '" + nameStr + "', '" + secondNameStr + "', '" + phoneNumberStr +
        //   "', '" + loginStr + "', '" + passStr + "')";
        System.out.println("Connect = " + c);
        try {
            Statement statement = c.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        // statement.executeUpdate(query);
        System.out.println("Adding to database");
    }

}