package com.zarek.crm.dao;

import com.zarek.crm.pojo.domain.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CustomerMapper {
    int deleteByPrimaryKey(String customerid);

    int insert(Customer record);

    Customer selectByPrimaryKey(String customerid);

    List<Customer> selectAll();

    int updateByPrimaryKey(Customer record);
}