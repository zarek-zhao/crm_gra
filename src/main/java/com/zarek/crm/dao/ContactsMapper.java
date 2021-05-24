package com.zarek.crm.dao;

import com.zarek.crm.pojo.domain.Contacts;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ContactsMapper {
    int deleteByPrimaryKey(String contactsid);

    int insert(Contacts record);

    Contacts selectByPrimaryKey(String contactsid);

    List<Contacts> selectAll();

    int updateByPrimaryKey(Contacts record);
}