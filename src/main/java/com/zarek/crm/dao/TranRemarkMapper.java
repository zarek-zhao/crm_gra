package com.zarek.crm.dao;

import com.zarek.crm.pojo.domain.TranRemark;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TranRemarkMapper {
    int deleteByPrimaryKey(String transactionremarkid);

    int insert(TranRemark record);

    TranRemark selectByPrimaryKey(String transactionremarkid);

    List<TranRemark> selectAll();

    int updateByPrimaryKey(TranRemark record);
}