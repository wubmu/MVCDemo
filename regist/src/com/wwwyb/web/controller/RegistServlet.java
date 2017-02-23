package com.wwwyb.web.controller;

import com.wwwyb.domain.User;
import com.wwwyb.excption.UserExistException;
import com.wwwyb.service.BusinessService;
import com.wwwyb.service.impl.BusinessServiceImpl;
import com.wwwyb.until.WebUtil;
import com.wwwyb.web.bean.UserRegistFormBean;
import javafx.scene.input.DataFormat;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.converters.IntegerConverter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * Created by 吴亚斌 on 2017/2/6.
 */
//最关键的部分
//完成用户的注册
@WebServlet(name = "RegistServlet")
public class RegistServlet extends HttpServlet {
    private BusinessService s = new BusinessServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");//智能解决POST请求方式的参数编码
        response.setContentType("text/html;charset=UTF-8");
        UserRegistFormBean formBean=null;
        try {

            //获取用户的请求参数：注意编码参数。封装数据到FormBean
            //FormBean:服务于表现层。字段：全部都是String.属性名称和表单完全对应。完成验证功能，保存错误消息提示
            formBean= new WebUtil().fillBean(request, UserRegistFormBean.class);
            //验证用户输入的合法性
            if (!formBean.vailidate()){
                //回显错误信息
                request.setAttribute("forBean",formBean);
                request.getRequestDispatcher("/WEB-IN/pages/regist.jsp").forward(request,response);
            }
            //类型转换：界面用户的说有输入都是String类型。保存（String-->其他类型），显示(其他类型-->String)
            User user = new User();
            user.setEmail(formBean.getEmail());
            user.setUsername(formBean.getUsername());
            user.setPassword(formBean.getPassword());
            SimpleDateFormat df = new SimpleDateFormat("yyyy--mm--dd");

            Date birthday = df.parse(formBean.getBirthday());
            user.setBirthday(birthday);
            //特点formBean和user的属性一样
            //注册类型转换器（String-->Date时使用）
            ConvertUtils.register(new DateLocaleConverter(), Date.class);
            ConvertUtils.register(new IntegerConverter(), Integer.class);
//            ConvertUtils.register(new Converter() {
//                @Override
//                /**
//                 * type:转换目标的类型
//                 * value；当前的值
//                 */
//                public Object convert(Class type, Object o) {
//                    SimpleDateFormat df=new SimpleDateFormat("yyyy--mm--dd");
//                    if (type==Date.class){
//                        String s=(String)o;
//                        try {
//                            return df.parse(s);
//                        } catch (ParseException e) {
//                            throw new RuntimeException("解析日期失败");
//                        }
//                    }
//                        //value是String类型：String-->Date
//                    else if (type==String.class){
//                        Date d= (Date) o;
//                        return df.format(d);
//                    }
//                        //value是Date类型 ： Date-->String
//                    return null;
//                }
//            },Date.class);

            BeanUtils.copyProperties(user, formBean);

            s.regist(user);
            //注册成功提示，2秒后转向主页面
            response.getWriter().write("注册成功，2秒后转向主页面");
            response.setHeader("Refresh","2;URL="+request.getContextPath());
            //调用业务处理类的注册方法
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (UserExistException e) {
            //回显错误信息
            formBean.getErrors().put("username",e.getMessage());
            request.setAttribute("forBean",formBean);
            request.getRequestDispatcher("/WEB-IN/pages/regist.jsp").forward(request,response);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
