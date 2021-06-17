package com.servlets;

import com.DAO.UserDAOImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(value ="/createManager")
public class CreateManager extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        UserDAOImpl dao = new UserDAOImpl();
        dao.createManager(req);
        try {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/mainAdmin");
            dispatcher.forward(req, resp);
        } catch (IOException | ServletException e) {
            Logger.getLogger(CreateManager.class.getName()).log(Level.SEVERE, "Exception.", e);
        }
    }
}
