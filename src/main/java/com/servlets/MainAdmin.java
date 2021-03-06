package com.servlets;

import com.DAO.UserDAOImpl;
import com.entity.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(value = "/mainAdmin")
public class MainAdmin extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        int number = 4;
        int brandNum = 0;
        int minus = 4;

        String sortName = req.getParameter("sortButton1");
        String sortPrice = req.getParameter("sortButton2");
        String sortComfort = req.getParameter("sortButton3");
        if (sortPrice != null) {
            session.setAttribute("sort", "price");
        }else if(sortName != null) {
            session.setAttribute("sort", "brand");
        }else if(sortComfort != null) {
            session.setAttribute("sort", "comfortClass");
        }

        UserDAOImpl dao = new UserDAOImpl();
        List<Car> cars;
        cars = dao.checkCars(session);

        String pageNum1 = req.getParameter("pageNum1");
        String pageNum2 = req.getParameter("pageNum2");
        String pageNum3 = req.getParameter("pageNum3");
        if (pageNum1 != null) {
            session.setAttribute("active__item1", "pagination__item--active");
            session.removeAttribute("active__item2");
            session.removeAttribute("active__item3");
        } else if (pageNum2 != null) {
            number = 8;
            brandNum = 4;
            session.setAttribute("active__item2", "pagination__item--active");
            session.removeAttribute("active__item1");
            session.removeAttribute("active__item3");
        } else if (pageNum3 != null) {
            number = cars.size();
            minus = cars.size() % 4;
            if(minus==0) minus =4;
            brandNum = 8;
            session.setAttribute("active__item3", "pagination__item--active");
            session.removeAttribute("active__item1");
            session.removeAttribute("active__item2");
        } else {
            session.setAttribute("active__item1", "pagination__item--active");
            session.removeAttribute("active__item2");
            session.removeAttribute("active__item3");
        }
        int counter =0;
        for (int i = number - minus; i < number; i++) {
            req.setAttribute("brand" + (i + 1 - brandNum), cars.get(i).getBrand());
            req.setAttribute("model" + (i + 1 - brandNum), cars.get(i).getModel());
            req.setAttribute("year" + (i + 1 - brandNum), cars.get(i).getYear());
            req.setAttribute("color" + (i + 1 - brandNum), cars.get(i).getColor());
            req.setAttribute("price" + (i + 1 - brandNum), cars.get(i).getPrice());
            req.setAttribute("image" + (i + 1 - brandNum), cars.get(i).getImage());
            req.setAttribute("comfortClass" + (i + 1 - brandNum), cars.get(i).getComfortClass());
            req.setAttribute("status" + (i + 1 - brandNum), cars.get(i).getStatus());
            counter++;
        }
        session.setAttribute("counter", counter);
        try {
            req.getRequestDispatcher("/mainAdmin.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            Logger.getLogger(MainAdmin.class.getName()).log(Level.SEVERE, "Exception.", e);
        }
    }
}


