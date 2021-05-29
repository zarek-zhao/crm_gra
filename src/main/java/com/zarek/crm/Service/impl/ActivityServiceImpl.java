package com.zarek.crm.Service.impl;

import com.zarek.crm.Service.ActivityService;
import com.zarek.crm.dao.ActivityMapper;
import com.zarek.crm.pojo.domain.Activity;
import com.zarek.crm.pojo.vo.PaginationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author zarek
 * @version 1.0.0
 * @since 1.0.0
 */
@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityMapper activityMapper;

    @Override
    public int insertActivity(Activity activity){

        return activityMapper.insert(activity);
    }

    @Override
    public List<Activity> selectActivityList()
    {
        return activityMapper.selectAll();
    }

    @Override
    public PaginationVO<Activity> pageList(Map<String, Object> map)
    {
        PaginationVO<Activity> paginationVO = new PaginationVO<Activity>();
        paginationVO.setDataList(activityMapper.getActivityListByCondition(map));
        paginationVO.setTotal(activityMapper.getTotalByCondition(map));
        return paginationVO;
    }

    @Override
    public Activity detail(String id)
    {
        return activityMapper.detail(id);
    }


}
