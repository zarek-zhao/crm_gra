package com.zarek.crm.dao;

import com.zarek.crm.pojo.domain.Tran;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TranMapper {
    int deleteByPrimaryKey(String transactionid);

    int insert(Tran record);

    Tran selectByPrimaryKey(String transactionid);

    List<Tran> selectAll();

    int updateByPrimaryKey(Tran record);
}