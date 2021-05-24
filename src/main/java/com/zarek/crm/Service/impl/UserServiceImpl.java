package com.zarek.crm.Service.impl;

import com.zarek.crm.Service.UserService;
import com.zarek.crm.dao.UserMapper;
import com.zarek.crm.pojo.domain.User;
import com.zarek.crm.utils.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zarek
 * @version 1.0.0
 * @since 1.0.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String loginAct, String loginPwd, String ip) throws LoginException
    {

        Map<String,String> map = new HashMap<String,String>();
        map.put("loginAct", loginAct);
        map.put("loginPwd", loginPwd);

        User user = userMapper.selectByLoginActAndLoginPwd(map);

        if(user==null){

            throw new LoginException("账号密码错误");

        }

        //如果程序能够成功的执行到该行，说明账号密码正确
        //需要继续向下验证其他3项信息

        //验证失效时间
        String expireTime = user.getExpiretime();
        String currentTime = DateTimeUtil.getSysTime();
        if(expireTime.compareTo(currentTime)<0){

            throw new LoginException("账号已失效");

        }

        //判断锁定状态
        String lockState = user.getLockstate();
        if("0".equals(lockState)){

            throw new LoginException("账号已锁定");

        }

        //判断ip地址
//        String allowIps = user.getAllowIps();
//
//        if(!allowIps.contains(ip)){
//
//            throw new LoginException("ip地址受限");
//
//        }


        return user;
    }

    @Override
    public List<User> getUserList()
    {
        return userMapper.selectAll();
    }
}
