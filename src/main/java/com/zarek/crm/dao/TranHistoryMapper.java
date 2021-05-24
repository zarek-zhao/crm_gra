package com.zarek.crm.dao;

import com.zarek.crm.pojo.domain.TranHistory;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TranHistoryMapper {
    int deleteByPrimaryKey(String transactionhistoryid);

    int insert(TranHistory record);

    TranHistory selectByPrimaryKey(String transactionhistoryid);

    List<TranHistory> selectAll();

    int updateByPrimaryKey(TranHistory record);
}