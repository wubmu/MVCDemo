package com.wwwyb.service.impl;

import com.wwwyb.dao.CustomerDao;
import com.wwwyb.dao.Impl.CustomerDaoMySQLImpl;
import com.wwwyb.domain.Customer;
import com.wwwyb.service.BusinessService;
import com.wwwyb.web.Beans.Page;

import java.util.List;
import java.util.UUID;

/**
 * Created by 吴亚斌 on 2017/2/14.
 */
public class BusinessServiceImpl  implements BusinessService{
    private CustomerDao dao = new CustomerDaoMySQLImpl();
    @Override
    public List<Customer> findAll() {
        return dao.findAll();
    }

    @Override
    public void addCustomer(Customer c) {
        if (c==null)
            throw  new IllegalArgumentException("the param customer`s id can not be empty");
        c.setId(UUID.randomUUID().toString());
        dao.save(c);
    }

    @Override
    public Customer findCustomerById(String customerId) {
        if (customerId==null||customerId.trim().equals(""))
            throw  new IllegalArgumentException("the param customer`s id can not be empty");
        return dao.findById(customerId);
    }

    @Override
    public void updateCustomer(Customer c) {
        if (c.getId()==null||c.getId().trim().equals(""))
            throw  new IllegalArgumentException("the param customer`s id can not be empty");
        dao.update(c);
    }

    @Override
    public void delectCustomer(String customrId) {
        if (customrId==null||customrId.trim().equals(""))
            throw  new IllegalArgumentException("the param customer`s id can not be empty");
        dao.delect(customrId);
    }

    @Override
    public Page finPageReocrds(String num) {
        int pageNum=1;//默认的页码
        if (num!=null&& !num.trim().equals("")){
            pageNum=Integer.parseInt(num);
        }
        int totalRecords=dao.getTotalRecored();
        Page page=new Page(pageNum,totalRecords);
        //查询分页记录
        List records =dao.findPageRecords(page.getStartIndex(),page.getPageSize());
        page.setRecods(records);
        return page;
    }
}
