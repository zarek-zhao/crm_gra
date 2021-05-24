package com.zarek.crm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zarek.crm.Service.UserService;
import com.zarek.crm.dao.ActivityMapper;
import com.zarek.crm.pojo.domain.Activity;
import com.zarek.crm.pojo.domain.User;
import com.zarek.crm.pojo.dto.Dto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author zarek
 * @version 1.0.0
 * @since 1.0.0
 */
@Controller
public class ActivityController {
    @Autowired
    private ActivityMapper activityMapper;
    @Autowired
    private UserService userService;
    @GetMapping("/workbench/activity/getUserList.do")
    @ResponseBody
    public Dto<Object> getUserList(){
        Dto<Object> dto = new Dto<Object>();
        List<User> userList = userService.getUserList();
        dto.setData(userList);
        dto.setSuccess("true");
        return dto;
    }

    @GetMapping("/queryActivityAll")
    public String getAllActivity(Model model,
                                 @RequestParam(required = false,defaultValue="1",value="pageNum")Integer pageNum,
                                 @RequestParam(defaultValue="5",value="pageSize")Integer pageSize){
        List<Activity> activities = activityMapper.selectAll();
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<Activity> pageInfo = new PageInfo<Activity>(activities,pageSize);
        List<Activity> list = pageInfo.getList();
        for (Activity activity : list) {
            System.out.println("activity = " + activity);
        }
        System.out.println(pageInfo);
        model.addAttribute("pageInfo",pageInfo);
        return "workbench/activity/test2";
    }

}
