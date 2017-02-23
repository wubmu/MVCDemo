package com.wwwyb.web.controller;

import java.io.IOException;

/**
 * Created by 吴亚斌 on 2017/2/6.
 */
//作为默认主页
public class IndexServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(request,response);
    }
}
