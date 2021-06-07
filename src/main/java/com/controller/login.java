package com.controller;

import com.DAOImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(value = "/login")
public class login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost");
        DAOImpl dao = new DAOImpl();
        boolean flag = false;
        try {
            flag = dao.login(req, resp);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        if (flag == true) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/mainUser");
            dispatcher.forward(req, resp);
        } else{
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Choice.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
