package com.wwwyb.web.controller;

import com.wwwyb.domain.Customer;
import com.wwwyb.service.BusinessService;
import com.wwwyb.service.impl.BusinessServiceImpl;
import com.wwwyb.util.WebUtil;
import com.wwwyb.web.Beans.CustomerFormBean;
import com.wwwyb.web.Beans.Page;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

/**
 * Created by 吴亚斌 on 2017/2/17.
 */
@WebServlet(name = "Controller")
public class Controller extends HttpServlet {
    BusinessService s = new BusinessServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        String op = request.getParameter("op");//用户操作
        if ("showAllCustomers".equals(op)){
            showAllCustomers(request, response);
        }else if ("addCustomer".equals(op)){
            addCustomer(request,response);
        }
    }
    //添加客户信息
    private void addCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //封装FormBean中
        CustomerFormBean formBean= WebUtil.fillBean(request,CustomerFormBean.class);
        //数据回显
        if (formBean.validate()){
            request.setAttribute("forBean",formBean);
            request.getRequestDispatcher("/addCustomer.jsp").forward(request,response);
            return;
        }
        //填充类型转换(类型转换问题)
        Customer c=new Customer();
        ConvertUtils.register(new DateLocaleConverter(), Date.class);
        try {
            BeanUtils.copyProperties(c,formBean);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //爱好单独处理
        String[] hobbies=formBean.getHobbies();
        if (hobbies!=null&&hobbies.length>0){//防止空指针异常
            StringBuffer sb=new StringBuffer();
            for (int i=0;i<hobbies.length;i++){
                if (i>0)
                    sb.append(",");
                sb.append(hobbies[i]);
            }
            c.setHobby(sb.toString());
        }
        //执行保存
        s.addCustomer(c);
        //提示添加成功：2秒后自动重定列表页面
        response.sendRedirect("/index.jsp");
        response.getWriter().write("保存成功！2秒后跳转页面    ");
    }


    private void showAllCustomers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> cs=s.findAll();
        request.setAttribute("cs",cs);
//        String num=request.getParameter("num");
//        Page page=s.finPageReocrds(num);
//        request.setAttribute("page",page);
        request.getRequestDispatcher("/listCustomers.jsp").forward(request,response);
    }
}
