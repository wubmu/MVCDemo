package com.wwwyb.service;

import com.wwwyb.domain.Customer;
import com.wwwyb.web.Beans.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 吴亚斌 on 2017/2/14.
 */
public interface BusinessService {
    /**
     * 查询所有客户信息
     * @return list
     */
    @Deprecated
    List<Customer>  findAll();

    /**
     * 添加客户信息
     * @param c
     */
    void addCustomer(Customer c);

    /**
     * 根据ID查询客户信息
     * @param customerId
     * @return 没有返回null
     */
    Customer findCustomerById(String customerId);

    /**
     * 更新客户信息
     * @param c
     */
    void updateCustomer(Customer c);

    /**
     * 根据客户ID删除客户信息
     * @param customrId
     */
    void delectCustomer(String customrId);

    /**
     * 根据用户要查看的页码,获取封装了所有分页有关的对象Page
     * @param num
     * @return num用户要查看的页码默认为1
     */
    Page finPageReocrds(String num);

}
