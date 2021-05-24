package com.zarek.crm.dao;

import com.zarek.crm.pojo.domain.DicValue;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DicValueMapper {
    int deleteByPrimaryKey(String id);

    int insert(DicValue record);

    DicValue selectByPrimaryKey(String id);

    List<DicValue> selectAll();

    int updateByPrimaryKey(DicValue record);
}