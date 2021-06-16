package com.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/giveFine")
public class GiveFine extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/mainManager");
            dispatcher.forward(req, resp);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }
}
