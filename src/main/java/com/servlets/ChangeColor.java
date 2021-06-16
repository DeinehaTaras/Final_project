package com.servlets;

import com.DAO.CarDAOImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value ="/changeColor")
public class ChangeColor extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        CarDAOImpl dao = new CarDAOImpl();
        dao.changeColor(req, resp);
        try {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/mainAdmin");
            dispatcher.forward(req, resp);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }
}
