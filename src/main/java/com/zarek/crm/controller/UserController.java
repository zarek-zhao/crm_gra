package com.zarek.crm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zarek.crm.Service.UserService;
import com.zarek.crm.pojo.domain.User;
import com.zarek.crm.pojo.dto.Dto;
import com.zarek.crm.utils.MD5Util;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author zarek
 * @version 1.0.0
 * @since 1.0.0
 */
@Controller
@Log4j2
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/settings/user/login.do")
    @ResponseBody
    public Dto<Object> login(HttpServletRequest request, HttpServletResponse response, HttpSession session)
    {
        Dto<Object> dto = new Dto<Object>();
        System.out.println("进入到验证登录操作");

        String loginAct = request.getParameter("loginAct");
        String loginPwd = request.getParameter("loginPwd");
        //将密码的明文形式转换为MD5的密文形式
        loginPwd = MD5Util.getMD5(loginPwd);
        //接收浏览器端的ip地址
        String ip = request.getRemoteAddr();
        System.out.println("--------------ip:" + ip);
        try {
            User user = userService.login(loginAct, loginPwd, ip);
            System.out.println(user);
            session.setAttribute("user",user);
            log.info("登录成功");
            dto.setSuccess("true");
            dto.setMsg("");
            dto.setData(user);
        } catch (Exception e) {
            log.info("登录失败");
            e.printStackTrace();
            String msg = e.getMessage();
            dto.setSuccess("false");
            dto.setMsg(msg);
        }
        return dto;
    }

    /**
     *
     * @param model 携带数据返回
     * @param pageSize 一页显示多少条-非必传值
     * @param pageNum 显示当前页--必传值
     * @return 前端页面
     * @Author: Zoutao
     * @Date: 2018/12/6
     */
//分页查询数据
    @GetMapping("/usermanage")
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
        PageHelper.startPage(pageNum,pageSize,"id+0");
        //2.紧跟的查询就是一个分页查询-必须紧跟.后面的其他查询不会被分页，除非再次调用PageHelper.startPage
        try {
            List<User> userList = userService.getAll();
            System.out.println("分页数据："+userList);
            //3.使用PageInfo包装查询后的结果,5是连续显示的条数,结果list类型是Page<E>
            PageInfo<User> pageInfo = new PageInfo<User>(userList,pageSize);
            //4.使用model/map/modelandview等带回前端
            model.addAttribute("pageInfo",pageInfo);
            for (User user : pageInfo.getList()) {
                System.out.println("user = " + user);
            }
        }finally {
            PageHelper.clearPage(); //清理 ThreadLocal 存储的分页参数,保证线程安全
        }
        //5.设置返回的jsp/html等前端页面
        // thymeleaf默认就会拼串classpath:/templates/xxxx.html
//        System.out.println("model.getAttribute(\"pageInfo\") = " + model.getAttribute("pageInfo"));
        return "admin/user/list";
    }

}
