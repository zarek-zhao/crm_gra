package com.zarek.crm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zarek.crm.Service.ActivityService;
import com.zarek.crm.Service.UserService;
import com.zarek.crm.pojo.domain.Activity;
import com.zarek.crm.pojo.domain.User;
import com.zarek.crm.pojo.dto.Dto;
import com.zarek.crm.pojo.vo.PaginationVO;
import com.zarek.crm.utils.DateTimeUtil;
import com.zarek.crm.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zarek
 * @version 1.0.0
 * @since 1.0.0
 */
@Controller
@RequestMapping("/workbench/activity")
public class ActivityController {
    @Autowired
    private ActivityService activityService;
    @Autowired
    private UserService userService;

 /*   @GetMapping("/usermanage")
    public String usermanage(Model model,
                             @RequestParam(required = false,defaultValue="1",value="pageNum")Integer pageNum,
                             @RequestParam(defaultValue="5",value="pageSize")Integer pageSize){

        //为了程序的严谨性，判断非空：
        if(pageNum == null){
            pageNum = 1;   //设置默认当前页
        }
        if(pageNum <= 0){
            pageNum = 1;
        }
        if(pageSize == null){
            pageSize = 5;    //设置默认每页显示的数据数
        }
        System.out.println("当前页是："+pageNum+"显示条数是："+pageSize);

        //1.引入分页插件,pageNum是第几页，pageSize是每页显示多少条,默认查询总数count
        PageHelper.startPage(pageNum,pageSize);
        //2.紧跟的查询就是一个分页查询-必须紧跟.后面的其他查询不会被分页，除非再次调用PageHelper.startPage
        try {
            List<Activity> userList = activityMapper.selectAll();
            System.out.println("分页数据："+userList);
            //3.使用PageInfo包装查询后的结果,5是连续显示的条数,结果list类型是Page<E>
            PageInfo<Activity> pageInfo = new PageInfo<Activity>(userList,pageSize);
            //4.使用model/map/modelandview等带回前端
            model.addAttribute("pageInfo",pageInfo);
        }finally {
            PageHelper.clearPage(); //清理 ThreadLocal 存储的分页参数,保证线程安全
        }
        //5.设置返回的jsp/html等前端页面
        // thymeleaf默认就会拼串classpath:/templates/xxxx.html
        return "test";
    }
*/


    @PostMapping("/save.do")
    @ResponseBody
    public Dto<Object> save(@RequestParam("owner") String owner, HttpServletRequest request, HttpServletResponse response){
        Dto<Object> dto = new Dto<Object>();
        System.out.println("执行市场活动添加操作");

        System.out.println("owner = " + owner);

        String id = UUIDUtil.getUUID();
//        String owner = request.getParameter("owner");
        String name = request.getParameter("name");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String cost = request.getParameter("cost");
        String description = request.getParameter("description");
        //创建时间：当前系统时间
        String createTime = DateTimeUtil.getSysTime();
        //创建人：当前登录用户
        String createBy = ((User)request.getSession().getAttribute("user")).getName();

        Activity a = new Activity();
        a.setActivityid(id);
        a.setCost(cost);
        a.setStartdate(startDate);
        a.setOwner(owner);
        a.setName(name);
        a.setEnddate(endDate);
        a.setDescription(description);
        a.setCreatetime(createTime);
        a.setCreateby(createBy);

        int i = activityService.insertActivity(a);
        if(i!=0){
            dto.setSuccess("true");
        }else{
            dto.setSuccess("false");
        }
        return dto;
    }

    /**
     * <br>查询用户信息<br>
     * @return Dto:用户列表信息，flag
     */
    @GetMapping("/getUserList.do")
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
        List<Activity> activities = activityService.selectActivityList();
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


    @RequestMapping(path="/pageList.do",method=RequestMethod.GET)
    @ResponseBody
    private Dto<Object> pageList(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("进入到查询市场活动信息列表的操作（结合条件查询+分页查询）");
        Dto<Object> dto = new Dto<Object>();
        String name = request.getParameter("name");
        String owner = request.getParameter("owner");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String pageNoStr = request.getParameter("pageNo");
        int pageNo = Integer.valueOf(pageNoStr);
        //每页展现的记录数
        String pageSizeStr = request.getParameter("pageSize");
        int pageSize = Integer.valueOf(pageSizeStr);
        //计算出略过的记录数
        int skipCount = (pageNo-1)*pageSize;

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name", name);
        map.put("owner", owner);
        map.put("startDate",startDate);
        map.put("endDate",endDate);
        map.put("skipCount",skipCount);
        map.put("pageSize",pageSize);

        /*

            前端要： 市场活动信息列表
                    查询的总条数

                    业务层拿到了以上两项信息之后，如果做返回
                    map
                    map.put("dataList":dataList)
                    map.put("total":total)
                    PrintJSON map --> json
                    {"total":100,"dataList":[{市场活动1},{2},{3}]}


                    vo
                    PaginationVO<T>
                        private int total;
                        private List<T> dataList;

                    PaginationVO<Activity> vo = new PaginationVO<>;
                    vo.setTotal(total);
                    vo.setDataList(dataList);
                    PrintJSON vo --> json
                    {"total":100,"dataList":[{市场活动1},{2},{3}]}


                    将来分页查询，每个模块都有，所以我们选择使用一个通用vo，操作起来比较方便




         */
        PaginationVO<Activity> vo = activityService.pageList(map);

        //vo--> {"total":100,"dataList":[{市场活动1},{2},{3}]}

        dto.setData(vo);
        return dto;


    }

    @RequestMapping(path = "/detail.do",method=RequestMethod.GET)
    private String detail(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException
    {

        System.out.println("进入到跳转到详细信息页的操作");

        String id = request.getParameter("id");

        Activity a = activityService.detail(id);

        request.setAttribute("a", a);

        return "/workbench/activity/detail";
    }

    @RequestMapping(path = "/delete.do",method =RequestMethod.POST)
    @ResponseBody
    private Dto<Object> delete(HttpServletRequest request, HttpServletResponse response) {
        Dto<Object> dto = new Dto<Object>();
        System.out.println("执行市场活动的删除操作");

        String ids[] = request.getParameterValues("id");

        boolean flag = activityService.delete(ids);
        if(flag){
            dto.setSuccess("ture");
        }else{
            dto.setSuccess("false");
        }
        return dto;
    }

}
