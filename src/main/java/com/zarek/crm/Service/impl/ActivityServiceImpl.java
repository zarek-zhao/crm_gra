package com.zarek.crm.Service.impl;

import com.zarek.crm.Service.ActivityService;
import com.zarek.crm.dao.ActivityMapper;
import com.zarek.crm.dao.ActivityRemarkMapper;
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
    @Autowired
    private ActivityRemarkMapper activityRemarkMapper;

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

    @Override
    public boolean delete(String[] ids)
    {
        boolean flag = true;

        //查询出需要删除的备注的数量
        int count1 = activityRemarkMapper.getCountByAids(ids);

        //删除备注，返回受到影响的条数（实际删除的数量）
        int count2 = activityRemarkMapper.deleteByAids(ids);

        if(count1!=count2){

            flag = false;

        }

        //删除市场活动
        int count3 = activityMapper.delete(ids);
        if(count3!=ids.length){

            flag = false;

        }

        return flag;
    }


}
