package com.zarek.crm.dao;

import com.zarek.crm.pojo.domain.ActivityRemark;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ActivityRemarkMapper {

    int getCountByAids(String[] ids);

    int deleteByAids(String[] ids);

    List<ActivityRemark> getRemarkListByAid(String activityId);

    int deleteById(String id);

    int saveRemark(ActivityRemark ar);

    int updateRemark(ActivityRemark ar);
}