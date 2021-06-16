package com.servlets;

import com.DAO.OrderDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(value = "/rent")
public class Rent extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        OrderDAOImpl dao = new OrderDAOImpl();
        dao.makeOrder(req, resp, session);
        try {
            req.getRequestDispatcher("/pay.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            Logger.getLogger(Rent.class.getName()).log(Level.SEVERE, "Exception.", e);
        }
    }
}
