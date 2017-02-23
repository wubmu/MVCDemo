package com.wwwyb.until;

import com.wwwyb.dao.UserDao;
import com.wwwyb.dao.impl.UserDaoMysqlImpl;

import java.io.InputStream;
import java.util.Properties;

/**
 * Created by 吴亚斌 on 2017/2/14.
 */
//工厂模型
//单例模型
public class BeanFactory {
    private static BeanFactory instance =new BeanFactory();
    private BeanFactory(){}
    public static BeanFactory getInstance(){
        return instance;
    }
//    public UserDao getUserDao(){
//        return new UserDaoMysqlImpl();
//    }
    public UserDao getUserDao(){


        try {
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("dao.properties");
            Properties props=new Properties();
            props.load(in);

            String className=props.getProperty("useDao");
            UserDao userDao = new UserDaoMysqlImpl();
            return userDao;
        } catch (Exception e) {
            throw new RuntimeException("创建useDao实例失败");
        }


    }

}
