package com.wwwyb.dao.Impl;

import com.wwwyb.Exception.DaoException;
import com.wwwyb.dao.CustomerDao;
import com.wwwyb.domain.Customer;
import com.wwwyb.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 吴亚斌 on 2017/2/14.
 */
public class CustomerDaoMySQLImpl implements CustomerDao {

    @Override
    public List<Customer> findAll() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtil.getConnection();
            stmt = conn.prepareStatement("select id,name,gender,birthday,cellphone,email,hobby,type,description from customer");
            rs = stmt.executeQuery();
            List<Customer> cs = new ArrayList<Customer>();
            while (rs.next()) {
                Customer c = new Customer(rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("gender"),
                        rs.getDate("birthday"),
                        rs.getString("cellphone"),
                        rs.getString("email"),
                        rs.getString("hobby"),
                        rs.getString("type"),
                        rs.getString("description"));
                cs.add(c);
            }
            return cs;
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            JdbcUtil.release(conn, rs, stmt);
        }
    }

    @Override
    public void save(Customer c) {
        Connection conn = null;
        PreparedStatement statm = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtil.getConnection();
            statm = conn.prepareStatement("INSERT INTO  customer (id,name,birthday,cellphone,email,type,description) VALUES (?,?,?,?,?,?,?)");
            statm.setString(1, c.getId());
            statm.setString(2, c.getName());
            //   statm.setString(3,c.getGender());
            statm.setDate(3, new java.sql.Date(c.getBirthday().getTime()));
            statm.setString(4, c.getCellphone());
            statm.setString(5, c.getEmail());
            statm.setString(6, c.getType());
            statm.setString(7, c.getDescription());
            statm.execute();
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            JdbcUtil.release(conn, rs, statm);
        }
    }


    @Override
    public Customer findById(String customerId) {
        Connection conn = null;
        PreparedStatement statm = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtil.getConnection();
            statm = conn.prepareStatement("SELECT id,name,gender,birthday,cellphone,email,type,description,hobby from customer WHERE id=?");
            statm.setString(1, customerId);
            rs = statm.executeQuery();
            if (rs.next()) {
                Customer c = new Customer(rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("gender"),
                        rs.getDate("birthday"),
                        rs.getString("cellphone"),
                        rs.getString("email"),
                        rs.getString("hobby"),
                        rs.getString("type"),
                        rs.getString("description"));
                return c;
            }
            return null;
        } catch (Exception e) {
            throw new DaoException();
        } finally {
            JdbcUtil.release(conn, rs, statm);
        }

    }

    @Override
    public void update(Customer c) {
        Connection conn = null;
        PreparedStatement statm = null;
        try {
            conn = JdbcUtil.getConnection();
            statm = conn.prepareStatement("UPDATE customer SET name=?,gender=?,birthday=?,cellphone=?,email=?,type=?,description=? WHERE id=?");

            statm.setString(1, c.getName());
            statm.setString(2, c.getGender());
            statm.setDate(3, new java.sql.Date(c.getBirthday().getTime()));
            statm.setString(4, c.getCellphone());
            statm.setString(5, c.getType());
            statm.setString(6, c.getDescription());
            statm.setString(7, c.getEmail());
            statm.setString(8, c.getId());
            statm.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.release(conn, null
                    , statm);
        }

    }

    @Override
    public void delect(String customrId) {
        Connection conn = null;
        PreparedStatement statm = null;
        try {
            conn = JdbcUtil.getConnection();
            statm = conn.prepareStatement("DELETE FROM customer WHERE id=?");
            statm.setString(1, customrId);
            statm.executeUpdate();
        } catch (Exception e) {
            throw new DaoException();
        } finally {
            JdbcUtil.release(conn, null
                    , statm);
        }
    }

    @Override
    public int getTotalRecored() {
        Connection conn = null;
        PreparedStatement statm = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtil.getConnection();
            statm = conn.prepareStatement("SELECT count(*) FROM  customer");
            rs = statm.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 0;
        } catch (Exception e) {
            throw new DaoException();
        } finally {
            JdbcUtil.release(conn, rs, statm);
        }
    }



    @Override
    public List<Customer> findPageRecords(int starIndex, int pageSize) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtil.getConnection();
            stmt = conn.prepareStatement("select id,name,gender,birthday,cellphone,email,hobby,type,description from customer LIMIT (?,?) ");
            stmt.setInt(1,starIndex);
            stmt.setInt(2,pageSize);
            rs = stmt.executeQuery();
            List<Customer> cs = new ArrayList<Customer>();
            while(rs.next()){
                Customer c = new Customer(rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("gender"),
                        rs.getDate("birthday"),
                        rs.getString("cellphone"),
                        rs.getString("email"),
                        rs.getString("hobby"),
                        rs.getString("type"),
                        rs.getString("description"));
                cs.add(c);
            }
            return cs;
        }catch(Exception e){
            throw new DaoException(e);
        }finally{
            JdbcUtil.release(conn,rs,stmt);
        }
    }

}
