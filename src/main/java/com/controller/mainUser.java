package com.controller;

import com.DAOImpl;
import com.entity.Car;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/mainUser")
public class mainUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        int number = 4;
        int brandNum = 0;
        String back = req.getParameter("back");
        String pageNum1 = req.getParameter("pageNum1");
        String pageNum2 = req.getParameter("pageNum2");
        String pageNum3 = req.getParameter("pageNum3");
        String forward = req.getParameter("forward");
        if (pageNum1 != null) {
            number = 4;
            brandNum = 0;
            req.setAttribute("active__item1", "pagination__item--active");
        } else if (pageNum2 != null) {
            number = 8;
            brandNum = 4;
            req.setAttribute("active__item2", "pagination__item--active");
        } else if (pageNum3 != null) {
            number = 12;
            brandNum = 8;
            req.setAttribute("active__item3", "pagination__item--active");
        } else {
            req.setAttribute("active__item1", "pagination__item--active");
        }
        DAOImpl dao = new DAOImpl();
        List<Car> cars = null;
        try {
            cars = dao.checkCars();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        for (int i = number - 4; i < number; i++) {
            req.setAttribute("brand" + (i + 1 - brandNum), cars.get(i).getBrand());
            req.setAttribute("model" + (i + 1 - brandNum), cars.get(i).getModel());
            req.setAttribute("year" + (i + 1 - brandNum), cars.get(i).getYear());
            req.setAttribute("color" + (i + 1 - brandNum), cars.get(i).getColor());
            req.setAttribute("price" + (i + 1 - brandNum), cars.get(i).getPrice());
            req.setAttribute("image" + (i + 1 - brandNum), cars.get(i).getImage());
        }
        try {
            req.getRequestDispatcher("/mainUser.jsp").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


