package com.zarek.crm.dao;

import com.zarek.crm.pojo.domain.DicType;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DicTypeMapper {
    int deleteByPrimaryKey(String code);

    int insert(DicType record);

    DicType selectByPrimaryKey(String code);

    List<DicType> selectAll();

    int updateByPrimaryKey(DicType record);
}