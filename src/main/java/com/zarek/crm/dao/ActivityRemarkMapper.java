package com.zarek.crm.dao;

import com.zarek.crm.pojo.domain.ActivityRemark;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRemarkMapper {
    int deleteByPrimaryKey(String id);

    int insert(ActivityRemark record);

    ActivityRemark selectByPrimaryKey(String id);

    List<ActivityRemark> selectAll();

    int updateByPrimaryKey(ActivityRemark record);
}