package com.wwwyb.web.bean;



import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import java.text.*;
import java.util.*;
import java.util.Map;

/**
 * Created by 吴亚斌 on 2017/2/6.
 */
public class UserRegistFormBean {
    private String username;
    private String password;
    private String repassword;
    private String email;
    Map errors=new HashMap();
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Map getErrors() {
        return errors;
    }

    public void setErrors(Map errors) {
        this.errors = errors;
    }

    /**
     * 验证方法
     * @return 验证通过返回true
     */
    public  boolean vailidate(){
        //有错误，向errors中填充数据
        if (username==null||username.trim().equals("")) {
            errors.put("username", "请输入用户名");
        }
        else if (!username.matches("[a-zA-Z]{3,8}")){
            errors.put("username","用户名必须由3~8位字符组成");
        }
        if (password==null||password.trim().equals("")) {
            errors.put("password", "请输入密码");
        }
        else if (!password.matches("\\d{3,8}")){
            errors.put("username","密码必须由3~8位数字组成");
        }
        if (password!=repassword){
            errors.put("repassword","两次密码必须一致");
        }
        if (birthday==null||birthday.trim().equals("")){
            errors.put("birthday","请输入出生日期");
        }
        else{
            try {
//                SimpleDateFormat df= new SimpleDateFormat("YYYY-mm-dd");
//                df.parse(birthday);
                DateLocaleConverter dlc=new DateLocaleConverter();
                dlc.convert(birthday);
            } catch (Exception e) {
                errors.put("birthday","请输入正确的出生日期");
            }
        }

        return errors.isEmpty();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    private String birthday;

}

