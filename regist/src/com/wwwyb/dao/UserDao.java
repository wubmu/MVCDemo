package com.wwwyb.dao;

import com.wwwyb.domain.User;

/**
 * Created by 吴亚斌 on 2017/2/2.
 */
public interface UserDao {
    /**
     * 添加信息到数据库
     * @param user
     */
    void addUser(User user);

    /**
     *
     * 根据用户名查找用户
     * @param Username
     * @return 不存在返回false
     */
    boolean findUserByUsername(String Username);

    /**
     * 根据用户名和密码查询用户
     * @param username
     * @param password
     * @return 不存在返回null
     */
    User findUser(String username,String password);
}
