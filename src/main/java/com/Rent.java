package com;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/rent")
public class Rent extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
        try {
            System.out.println("Rent#doPost");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Rent.jsp");
            dispatcher.forward(req, resp);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}
