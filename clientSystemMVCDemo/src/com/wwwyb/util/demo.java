package com.wwwyb.util;

import com.wwwyb.Exception.DaoException;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by 吴亚斌 on 2017/2/15.
 */
public class demo {
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement statm=null;
        try {
            conn =JdbcUtil.getConnection();
            statm=conn.prepareStatement("INSERT INTO  customer (id,name,gender,cellphone,email,type,description) VALUES (?,?,?,?,?,?,?)");
            statm.setString(1,"1");
            statm.setString(2,"吴亚斌");
            statm.setString(3,"male");
            statm.setString(4,"110");
            statm.setString(5,"asda");
            statm.setString(6,"vip");
            statm.setString(7,"wan");
            statm.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.release(conn,null,statm);
        }
    }
    }

