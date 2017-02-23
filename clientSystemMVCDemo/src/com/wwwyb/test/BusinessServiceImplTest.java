package com.wwwyb.test;

import com.wwwyb.domain.Customer;
import com.wwwyb.service.BusinessService;
import com.wwwyb.service.impl.BusinessServiceImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by 吴亚斌 on 2017/2/15.
 */
public class BusinessServiceImplTest   {
    private BusinessService s=new BusinessServiceImpl();
    @Test
    public void  testAddCustomer(){
        Customer c=new Customer();

        c.setName("吴亚斌");
        c.setGender("male");
        c.setEmail("923185028@qq.com");
        c.setCellphone("110");
        c.setDescription("哈哈");
        c.setType("VIP");
        c.setBirthday(new Date());
        s.addCustomer(c);

    }
    @Test
    public void  testFindAll(){
        List<Customer> list=s.findAll();
        for (Customer c: list){
            System.out.print(c);
        }
    }
    @Test
    public void testFindById(){
       Customer c= s.findCustomerById("11");
       c.setId("1");
       s.updateCustomer(c);
    }
    @Test(expected = java.lang.IllegalArgumentException.class)
    public void testFindById1(){
        Customer c=new Customer();
        c.setName("abc");
        s.updateCustomer(c);
    }
    @Test
    public void DeletTest(){
        s.delectCustomer("11");
    }
}
