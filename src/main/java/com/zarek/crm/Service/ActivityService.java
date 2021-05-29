package com.zarek.crm.Service;

import com.zarek.crm.pojo.domain.Activity;
import com.zarek.crm.pojo.vo.PaginationVO;

import java.util.List;
import java.util.Map;

/**
 * @author zarek
 * @version 1.0.0
 * @since 1.0.0
 */
/*
市场活动和市场活动备注的业务
 */
public interface ActivityService {
    int insertActivity(Activity activity);

    List<Activity> selectActivityList();

    PaginationVO<Activity> pageList(Map<String, Object> map);

    Activity detail(String id);
}
