package com;

import com.CheckBD;
import com.entity.Car;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOImpl {
    private static Connection c;
    public DAOImpl(){
        CheckBD checkBD = new CheckBD();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = checkBD.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
    DAOImpl dao = new DAOImpl();
    System.out.println(dao.checkCars().get(0).getBrand());
    }
    public static void registration(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String surnameStr = req.getParameter("surname");
        String nameStr = req.getParameter("name");
        String secondNameStr = req.getParameter("secondName");
        String phoneNumberStr = req.getParameter("phoneNumber");
        String loginStr = req.getParameter("login");
        String passStr = req.getParameter("password");
        String query = "INSERT INTO users (Surname, name, secondName, phone_number, login, password) \n" +
                "   VALUES ('" + surnameStr +"', '" + nameStr + "', '" + secondNameStr + "', '" + phoneNumberStr +
                "', '" + loginStr + "', '" + passStr + "')";
        System.out.println("Connect = " + c);
        Statement statement =  c.createStatement();
        statement.executeUpdate(query);
        System.out.println("Adding to database");
    }
    public static boolean login(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ClassNotFoundException {

        String loginStr = req.getParameter("login");
        String passStr = req.getParameter("password");
        String query = "SELECT * FROM users WHERE login = '" +loginStr + "'";
        System.out.println("Connect = " + c);
        Statement statement =  c.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        System.out.println("Retrieving data from database...");
            while (resultSet.next()) {
                if (resultSet.getString("login").equals(loginStr) && resultSet.getString("password").equals(passStr)) {
                    return true;
                } else
                    return false;
            }
            return false;
    }

    public List<Car> checkCars() throws SQLException {
        List<Car> carList = new ArrayList<>();
        String brandStr;
        String modelStr;
        int yearStr;
        String colorStr;
        String priceStr;
        String imageStr;
        String query = "SELECT * FROM cars";
        Statement statement =  c.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        System.out.println("Checking cars...");
        while (resultSet.next()) {
            brandStr = resultSet.getString("brand");
            modelStr = resultSet.getString("model");
            yearStr = resultSet.getInt("year");
            colorStr = resultSet.getString("color");
            priceStr = resultSet.getString("price");
            imageStr = resultSet.getString("image");
            carList.add(new Car(brandStr, modelStr, yearStr, colorStr,
                    priceStr, imageStr));
        }
        return carList;
    }

}
