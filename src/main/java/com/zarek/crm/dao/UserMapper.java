package com.zarek.crm.dao;

import com.zarek.crm.pojo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    User selectByPrimaryKey(String id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    User selectByLoginActAndLoginPwd(Map<String, String> map);
}