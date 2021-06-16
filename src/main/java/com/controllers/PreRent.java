package com.controllers;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value ="/preRent")
public class PreRent extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("preRent#doPost");
        HttpSession session = req.getSession();
        session.setAttribute("rent1Val", req.getParameter("rent1"));
        session.setAttribute("rent2Val", req.getParameter("rent2"));
        session.setAttribute("rent3Val", req.getParameter("rent3"));
        session.setAttribute("rent4Val", req.getParameter("rent4"));

        try {
            resp.sendRedirect("rent.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
