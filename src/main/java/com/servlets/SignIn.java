package com.servlets;

import com.DAO.UserDAOImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import org.apache.log4j.Logger;

@WebServlet(value = "/login")
public class SignIn extends HttpServlet {
    private static final Logger log = Logger.getLogger(SignIn.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("doPost");
        String loginStr = req.getParameter("login");
        UserDAOImpl dao = new UserDAOImpl();
        boolean flag = false;
        HttpSession session = req.getSession();
        flag = dao.login(req, resp, session);
        if (flag) {
            session.setAttribute("userName", loginStr);

            if (Integer.parseInt(session.getAttribute("admin").toString())==1) {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/mainAdmin");
                try {
                    dispatcher.forward(req, resp);
                } catch (ServletException | IOException e) {
                    e.printStackTrace();
                }
            } else if(Integer.parseInt(session.getAttribute("manager").toString())==1) {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/mainManager");
                try {
                    dispatcher.forward(req, resp);
                } catch (ServletException | IOException e) {
                    e.printStackTrace();
                }
            }
            else
            {
                try {
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/mainUser");
                    dispatcher.forward(req, resp);
                } catch (IOException | ServletException e) {
                    e.printStackTrace();
                }
            }
        }else {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/choice.jsp");
            try {
                dispatcher.forward(req, resp);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
        log.info(loginStr + " logging");
    }
}
