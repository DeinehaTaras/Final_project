package com.servlets;

import com.DAO.OrderDAOImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(value = "/giveFine")
public class GiveFine extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        OrderDAOImpl dao = new OrderDAOImpl();
        dao.giveAFine(req);
        try {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/mainManager");
            dispatcher.forward(req, resp);
        } catch (IOException | ServletException e) {
            Logger.getLogger(GiveFine.class.getName()).log(Level.SEVERE, "Exception.", e);
        }
    }
}
