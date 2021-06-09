package com.controller;

import com.DAO.DAOImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/login")
public class SignIn extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("doPost");
        String loginStr = req.getParameter("login");
        DAOImpl dao = new DAOImpl();
        boolean flag = false;
        flag = dao.login(req, resp);
        if (flag) {
            HttpSession session = req.getSession();
            session.setAttribute("userName", loginStr);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/mainUser");
            try {
                dispatcher.forward(req, resp);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        } else {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/choice.jsp");
            try {
                dispatcher.forward(req, resp);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}
