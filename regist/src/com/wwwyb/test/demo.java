package com.wwwyb.test;

import com.wwwyb.domain.User;
import com.wwwyb.excption.UserExistException;
import com.wwwyb.service.impl.BusinessServiceImpl;
import com.wwwyb.until.JdbcUtil;

import java.sql.*;
import java.util.Date;

/**
 * Created by 吴亚斌 on 2017/2/16.
 */
public class demo {
    public static void main(String[] args) {
        BusinessServiceImpl s = new BusinessServiceImpl();
        User user = new User();
        user.setUsername("22222哈");
        user.setPassword("123");
        user.setEmail("1111");
        Date birthday = new Date();
        user.setBirthday(birthday);
        try {
            s.regist(user);
            Connection conn=JdbcUtil.getConnection();
            PreparedStatement stat=conn.prepareStatement("SELECT * FROM user");
            ResultSet rs=stat.executeQuery();
            while (rs.next()){
                System.out.print(rs.getString("username")+"\n");
            }

        } catch (UserExistException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }}
