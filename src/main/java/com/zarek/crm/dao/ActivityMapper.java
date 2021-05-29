package com.zarek.crm.dao;

import com.zarek.crm.pojo.domain.Activity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ActivityMapper {
    int deleteByPrimaryKey(String activityid);

    int insert(Activity record);

    Activity selectByPrimaryKey(String activityid);

    List<Activity> selectAll();

    int updateByPrimaryKey(Activity record);




    List<Activity> getActivityListByCondition(Map<String, Object> map);

    int getTotalByCondition(Map<String, Object> map);

    int delete(String[] ids);

    Activity getById(String id);

    int update(Activity a);

    Activity detail(String id);

    List<Activity> getActivityListByClueId(String clueId);

    List<Activity> getActivityListByNameAndNotByClueId(Map<String, String> map);

    List<Activity> getActivityListByName(String aname);

}