package com.zarek.crm.dao;

import com.zarek.crm.pojo.domain.ContactsRemark;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ContactsRemarkMapper {
    int deleteByPrimaryKey(String contactremarkid);

    int insert(ContactsRemark record);

    ContactsRemark selectByPrimaryKey(String contactremarkid);

    List<ContactsRemark> selectAll();

    int updateByPrimaryKey(ContactsRemark record);
}