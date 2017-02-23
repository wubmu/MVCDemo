package com.wwwyb.dao.impl;

import com.wwwyb.dao.UserDao;
import com.wwwyb.domain.User;
import com.wwwyb.until.JdbcUtil;

import java.sql.*;


/**
 * Created by 吴亚斌 on 2017/2/10.
 */

/**
 create database IF NOT EXISTS mydb2;
 use mydb2;
 Create table user(
    username varchar(100) primary key,
    password varchar(100)  not null,
    email varchar(100) not null,
    birthday varchar(100) not null
 );
 */
public class UserDaoMysqlImpl implements UserDao {
    @Override
    public void addUser(User user) {
        Connection conn=null;
        PreparedStatement statm=null;
        try {
            conn=JdbcUtil.getConnection();
            statm=conn.prepareStatement("INSERT  INTO user (username,password,email,birthday) VALUES(?,?,?,?)");
            statm.setString(1,user.getUsername());
            statm.setString(2,user.getPassword());
            statm.setString(3,user.getEmail());
            statm.setDate(4,new java.sql.Date(user.getBirthday().getTime()));
            statm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.release(conn,null,statm);
        }

    }

    @Override
    //有sql注入问题
    public boolean findUserByUsername(String Username) {
        Connection conn=null;
        PreparedStatement statm=null;
        ResultSet rs=null;
        try {
            conn=JdbcUtil.getConnection();
            statm=conn.prepareStatement("SELECT username FROM user WHERE username=?");
            statm.setString(1,Username);
            rs=statm.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.release(conn,rs,statm);
        }
        return false;
    }

    @Override
    public User findUser(String username, String password) {
        Connection conn=null;
        PreparedStatement statm=null;
        ResultSet rs=null;
        try {
            conn=JdbcUtil.getConnection();
            statm=conn.prepareStatement("SELECT * FROM user WHERE username=?AND password=?");
            statm.setString(1,username);
            statm.setString(2,password);
            rs=statm.executeQuery();
            if (rs.next()){
                User user=new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
//                user.setBirthday(rs.getDate("birthday"));
                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.release(conn,rs,statm);
        }
        return null; }
}
