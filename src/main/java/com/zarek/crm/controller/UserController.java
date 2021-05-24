package com.zarek.crm.controller;

import com.zarek.crm.Service.UserService;
import com.zarek.crm.pojo.domain.User;
import com.zarek.crm.pojo.dto.Dto;
import com.zarek.crm.utils.MD5Util;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    public Dto<Object> login(HttpServletRequest request, HttpServletResponse response)
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
            request.getSession().setAttribute("user", user);
            log.info("登录成功");
            dto.setSuccess("true");
            dto.setMsg("");
        } catch (Exception e) {
            log.info("登录失败");
            e.printStackTrace();
            String msg = e.getMessage();
            dto.setSuccess("false");
            dto.setMsg(msg);
        }
        return dto;
    }

}
