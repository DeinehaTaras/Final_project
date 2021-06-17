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
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAOImpl {

    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(UserDAOImpl.class);
    private static Connection c;

    public UserDAOImpl() {
        ConnectionDB connectionDB = new ConnectionDB();
        c = connectionDB.getConnection();
    }

    public void registration(HttpServletRequest req) {
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            Logger.getLogger(CarDAOImpl.class.getName()).log(Level.SEVERE, "UnsupportedEncodingException.", e);
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
        Statement statement;
        try {
            statement = c.createStatement();
            assert statement != null;
            statement.executeUpdate(query);
        } catch (SQLException throwables) {
            Logger.getLogger(CarDAOImpl.class.getName()).log(Level.SEVERE, "SQLException.", throwables);
        }
        LOG.info("Adding user to database");
    }

    public boolean login(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
        String loginStr = req.getParameter("login");
        String passStr = req.getParameter("password");
        String query = "SELECT * FROM users WHERE login = '" + loginStr + "'";
        System.out.println("Connect = " + c);
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = c.createStatement();
            assert statement != null;
            resultSet = statement.executeQuery(query);
        } catch (SQLException throwables) {
            Logger.getLogger(CarDAOImpl.class.getName()).log(Level.SEVERE, "SQLException.", throwables);
        }
        LOG.info("Retrieving user data from database...");
        try {
            while (resultSet.next()) {
                int ban = Integer.parseInt(resultSet.getString("isBanned"));
                if (ban == 1) {
                    req.getRequestDispatcher("/youWasBanned.jsp").forward(req, resp);
                }
                if (resultSet.getString("login").equals(loginStr) && resultSet.getString("password").equals(passStr)) {
                    session.setAttribute("admin", resultSet.getString("isAdmin"));
                    session.setAttribute("manager", resultSet.getString("isManager"));
                    return true;
                } else
                    return false;
            }
        } catch (SQLException | ServletException | IOException throwables) {
            Logger.getLogger(CarDAOImpl.class.getName()).log(Level.SEVERE, "Exception.", throwables);
        }
        return false;
    }

    public List<Car> checkCars(HttpSession session) {
        String sort;
        try {
             sort = session.getAttribute("sort").toString();
        } catch (NullPointerException e){
            sort = "CarId";
        }
        List<Car> carList = new ArrayList<>();
        String brandStr;
        String modelStr;
        int yearStr;
        String colorStr;
        String priceStr;
        String imageStr;
        String classStr;
        int status;
        String query = "SELECT * FROM cars ORDER BY " + sort;
        try {
            Statement statement = c.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            LOG.info("Checking cars in database");
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
            Logger.getLogger(CarDAOImpl.class.getName()).log(Level.SEVERE, "SQLException.", e);
        }
        return carList;
    }

    public void ban(HttpServletRequest req) {
        int userId = Integer.parseInt(req.getParameter("userId"));
        String query = "UPDATE users SET isBanned = " + 1 + " WHERE userId = " + userId;
        try {
            Statement statement = c.createStatement();
            assert statement != null;
            statement.executeUpdate(query);
        } catch (SQLException throwables) {
            Logger.getLogger(CarDAOImpl.class.getName()).log(Level.SEVERE, "SQLException.", throwables);
        }
        LOG.info("Banning user in database");
    }

    public void unban(HttpServletRequest req) {
        int userId = Integer.parseInt(req.getParameter("userId"));
        String query = "UPDATE users SET isBanned = " + 0 + " WHERE userId = " + userId;
        try {
            Statement statement = c.createStatement();
            assert statement != null;
            statement.executeUpdate(query);
        } catch (SQLException throwables) {
            Logger.getLogger(CarDAOImpl.class.getName()).log(Level.SEVERE, "SQLException.", throwables);
        }
        LOG.info("Unbanning user in database");
    }

    public void appoint(HttpServletRequest req) {
        int userId = Integer.parseInt(req.getParameter("userId"));
        String query = "UPDATE users SET isManager = " + 1 + " WHERE userId = " + userId;
        try {
            Statement statement = c.createStatement();
            assert statement != null;
            statement.executeUpdate(query);
        } catch (SQLException throwables) {
            Logger.getLogger(CarDAOImpl.class.getName()).log(Level.SEVERE, "SQLException.", throwables);
        }
        LOG.info("Appointing a manager");
    }

    public void createManager(HttpServletRequest req) {
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            Logger.getLogger(CarDAOImpl.class.getName()).log(Level.SEVERE, "UnsupportedEncodingExceptionption.", e);
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
        try {
            Statement statement = c.createStatement();
            assert statement != null;
            statement.executeUpdate(query);
        } catch (SQLException throwables) {
            Logger.getLogger(CarDAOImpl.class.getName()).log(Level.SEVERE, "SQLException.", throwables);
        }
        LOG.info("Adding a manager to database");
    }
}

