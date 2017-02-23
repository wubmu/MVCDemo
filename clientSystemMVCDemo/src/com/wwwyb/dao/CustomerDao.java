package com.wwwyb.dao;

import com.wwwyb.domain.Customer;

import java.util.List;

/**
 * Created by 吴亚斌 on 2017/2/14.
 */
    public interface CustomerDao {
    @Deprecated
    List<Customer> findAll();

    void save(Customer c);

    Customer findById(String customerId);

    void update(Customer c);


    void delect(String customrId);

    /**
     * 获取所有记录单的条数
     * @return
     */
    int getTotalRecored();

    /**
     * 查询分页记录
     * @param starIndex
     * @param pageSize
     * @return
     */
    List<Customer> findPageRecords(int starIndex,int pageSize);
}
