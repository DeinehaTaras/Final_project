package com.DAO;

import com.connection.ConnectionDB;
import com.entity.Car;

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
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl {
    private static Connection c;

    public UserDAOImpl() {
        ConnectionDB connectionDB = new ConnectionDB();
        c = connectionDB.getConnection();
    }

    public void registration(HttpServletRequest req, HttpServletResponse resp) {
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

    public boolean login(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
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
                int ban = Integer.parseInt(resultSet.getString("isBanned"));
                if(ban==1){
                    req.getRequestDispatcher("/youWasBanned.jsp").forward(req, resp);

                }
                if (resultSet.getString("login").equals(loginStr) && resultSet.getString("password").equals(passStr)) {
                    session.setAttribute("admin", resultSet.getString("isAdmin"));
                    session.setAttribute("manager", resultSet.getString("isManager"));
                    return true;
                } else
                    return false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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

    public void ban(HttpServletRequest req, HttpServletResponse resp) {
    int userId = Integer.parseInt(req.getParameter("userId"));
    String query = "UPDATE users SET isBanned = " + 1 + " WHERE userId = " + userId;
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
        System.out.println("Banning user in database");
    }

    public void unban(HttpServletRequest req, HttpServletResponse resp) {
        int userId = Integer.parseInt(req.getParameter("userId"));
        String query = "UPDATE users SET isBanned = " + 0 + " WHERE userId = " + userId;
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
        System.out.println("Unbanning user in database");
    }

    public void appoint(HttpServletRequest req, HttpServletResponse resp) {
        int userId = Integer.parseInt(req.getParameter("userId"));
        String query = "UPDATE users SET isManager = " + 1 + " WHERE userId = " + userId;
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
        System.out.println("Appointing a manager");
    }

    public void createManager(HttpServletRequest req, HttpServletResponse resp) {
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
        String query = "INSERT INTO users (Surname, name, secondName, dateOfBirth, phoneNumber, login, password, isManager) \n" +
                "   VALUES ('" + surnameStr + "', '" + nameStr + "', '" + secondNameStr + "', '" + dateStr + "', '" + phoneNumberStr +
                "', '" + loginStr + "', '" + passStr + "', " + 1 + ")";
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
        System.out.println("Adding a manager to database");
    }
}

