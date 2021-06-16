package com.controllers;

import com.DAO.CarDAOImpl;
import com.DAO.OrderDAOImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value ="/takeCar")
public class TakeCar extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        OrderDAOImpl dao = new OrderDAOImpl();
        dao.take(req, resp);
        try {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/mainManager");
            dispatcher.forward(req, resp);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }
}
