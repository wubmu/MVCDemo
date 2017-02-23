package com.wwwyb.web.controller;

import com.wwwyb.domain.User;
import com.wwwyb.service.BusinessService;
import com.wwwyb.service.impl.BusinessServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 吴亚斌 on 2017/2/6.
 */
@WebServlet(name = "LogicServlet")
public class LogicServlet extends HttpServlet {
    private BusinessService s=new BusinessServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            String username=request.getParameter("username");
            String password=request.getParameter("password");

            User user=s.logic(username,password);
            if (user==null){
                response.getWriter().write("错误的用户名和密码,2秒后转向登陆页面");
                response.setHeader("Refresh","2;URL="+request.getContextPath()+"/servlet/LoginUIServlet");
                return;
            }
            request.getSession().setAttribute("user",user);
            response.getWriter().write("登陆成功，2秒后转向主页");
            response.setHeader("Refresh","2;URL="+request.getContextPath());
    }
}
