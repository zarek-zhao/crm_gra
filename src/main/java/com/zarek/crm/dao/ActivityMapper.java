package com.zarek.crm.dao;

import com.zarek.crm.pojo.domain.Activity;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ActivityMapper {
    int deleteByPrimaryKey(String activityid);

    int insert(Activity record);

    Activity selectByPrimaryKey(String activityid);

    List<Activity> selectAll();

    int updateByPrimaryKey(Activity record);
}