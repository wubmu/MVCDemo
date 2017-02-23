package com.wwwyb.test;

import com.wwwyb.domain.User;
import com.wwwyb.excption.UserExistException;
import com.wwwyb.service.BusinessService;
import com.wwwyb.service.impl.BusinessServiceImpl;
import com.wwwyb.until.JdbcUtil;
import org.junit.Test;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by 吴亚斌 on 2017/2/2.
 */
public class BusinessServiceImplTest {
    private BusinessServiceImpl s = new BusinessServiceImpl();
    @Test
    public void addUserTest(){
        User user=new User();
        user.setUsername("demo");
       user.setBirthday(new Date());

        user.setPassword("123");
        user.setEmail("110@.com");
        try {
            s.regist(user);
        } catch (UserExistException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testLogic(){
        s.logic("吴亚斌1122221","123212");

    }
}


