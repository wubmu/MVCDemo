package com.wwwyb.service.impl;

import com.wwwyb.dao.UserDao;
import com.wwwyb.dao.impl.UserDaoDom4impl;
import com.wwwyb.dao.impl.UserDaoMysqlImpl;
import com.wwwyb.domain.User;
import com.wwwyb.excption.UserExistException;
import com.wwwyb.service.BusinessService;
import com.wwwyb.until.BeanFactory;

/**
 * Created by 吴亚斌 on 2017/2/2.
 */
public class BusinessServiceImpl implements BusinessService {
    private UserDao dao = BeanFactory.getInstance().getUserDao();

    @Override
    public void regist(User user) throws UserExistException {
        boolean exist = dao.findUserByUsername(user.getUsername());
        if (exist)
            throw new UserExistException("用户名" + user.getUsername() + "已存在");
        //可以注册
        dao.addUser(user);
    }

    @Override
    public User logic(String username, String password) {
        return dao.findUser(username, password);
    }
}
