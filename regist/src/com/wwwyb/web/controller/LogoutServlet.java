package com.wwwyb.web.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 吴亚斌 on 2017/2/6.
 */
@WebServlet(name = "LogoutServlet")
public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.getSession().invalidate();
        request.getSession().removeAttribute("user");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write("注销成功");
        response.setHeader("Refresh","2;URL="+request.getContextPath());

    }
}
