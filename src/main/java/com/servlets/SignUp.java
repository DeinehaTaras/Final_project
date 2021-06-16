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

@WebServlet(value = "/registration")
public class SignUp extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        UserDAOImpl dao = new UserDAOImpl();
        try {
            dao.registration(req);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, "Exception.", e);
        }
    }

}
