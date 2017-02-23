package com.wwwyb.service;

import com.wwwyb.domain.User;
import com.wwwyb.excption.UserExistException;

/**
 * Created by 吴亚斌 on 2017/2/2.
 * 业务接口
 */
public interface BusinessService {
    /**
     * 完成用户注册
     * @param user
     * @throws UserExistException 如果用户已存在抛出异常
     */
    void regist(User user) throws UserExistException;

    /**
     * 登陆
     * @param username
     * @param password
     * @return 如果用户不存在 返回null
     */
    User logic(String username,String password);
}
