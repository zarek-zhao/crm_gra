package com.zarek.crm.Service;

import com.zarek.crm.pojo.domain.User;

import javax.security.auth.login.LoginException;
import java.util.List;

/**
 * @author zarek
 * @version 1.0.0
 * @since 1.0.0
 */
public interface UserService {
    User login(String loginAct, String loginPwd, String ip) throws LoginException;

    List<User> getUserList();
}
