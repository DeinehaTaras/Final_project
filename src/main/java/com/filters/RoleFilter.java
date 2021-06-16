package com.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RoleFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        int admin;
        int manager;
        String user;
        String uri = httpServletRequest.getRequestURI();
        try {
            admin = Integer.parseInt(httpServletRequest.getSession().getAttribute("admin").toString());
            manager = Integer.parseInt(httpServletRequest.getSession().getAttribute("manager").toString());
            user = httpServletRequest.getSession().getAttribute("userName").toString();
        } catch (NullPointerException e) {
            admin = 0;
            manager = 0;
            user = null;
        }
        if (admin != 1 && (uri.endsWith("mainAdmin.jsp")
                || uri.endsWith("addCar.jsp")
                || uri.endsWith("addManager.jsp")
                || uri.endsWith("appointManager.jsp")
                || uri.endsWith("banUser.jsp")
                || uri.endsWith("createManager.jsp")
                || uri.endsWith("removeCar.jsp")
                || uri.endsWith("unbanUser.jsp"))) {
            httpServletResponse.sendRedirect("index.jsp");
        } else if (manager != 1 && (uri.endsWith("mainManager.jsp")
                || uri.endsWith("approveOrDecline.jsp")
                || uri.endsWith("approveOrder.jsp")
                || uri.endsWith("declineOrder.jsp")
                || uri.endsWith("giveFine.jsp")
                || uri.endsWith("takeCar.jsp")
                || uri.endsWith("takeOrFine.jsp"))) {
            httpServletResponse.sendRedirect("index.jsp");
        } else if (user==null && (uri.endsWith("mainUser.jsp")
                || uri.endsWith("pay.jsp")
                || uri.endsWith("rent.jsp")
                || uri.endsWith("thxForOrder.jsp"))) {
            httpServletResponse.sendRedirect("index.jsp");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
