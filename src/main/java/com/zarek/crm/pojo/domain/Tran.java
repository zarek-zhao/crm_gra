package com.zarek.crm.pojo.domain;

import java.io.Serializable;

public class Tran implements Serializable {
    private String transactionid;

    private String owner;

    private String money;

    private String name;

    private String expecteddate;

    private String customerid;

    private String stage;

    private String type;

    private String source;

    private String activityid;

    private String contactsid;

    private String createby;

    private String createtime;

    private String editby;

    private String edittime;

    private String description;

    private String contactsummary;

    private String nextcontacttime;

    private static final long serialVersionUID = 1L;

    public String getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(String transactionid) {
        this.transactionid = transactionid == null ? null : transactionid.trim();
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner == null ? null : owner.trim();
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money == null ? null : money.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getExpecteddate() {
        return expecteddate;
    }

    public void setExpecteddate(String expecteddate) {
        this.expecteddate = expecteddate == null ? null : expecteddate.trim();
    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid == null ? null : customerid.trim();
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage == null ? null : stage.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getActivityid() {
        return activityid;
    }

    public void setActivityid(String activityid) {
        this.activityid = activityid == null ? null : activityid.trim();
    }

    public String getContactsid() {
        return contactsid;
    }

    public void setContactsid(String contactsid) {
        this.contactsid = contactsid == null ? null : contactsid.trim();
    }

    public String getCreateby() {
        return createby;
    }

    public void setCreateby(String createby) {
        this.createby = createby == null ? null : createby.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    public String getEditby() {
        return editby;
    }

    public void setEditby(String editby) {
        this.editby = editby == null ? null : editby.trim();
    }

    public String getEdittime() {
        return edittime;
    }

    public void setEdittime(String edittime) {
        this.edittime = edittime == null ? null : edittime.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getContactsummary() {
        return contactsummary;
    }

    public void setContactsummary(String contactsummary) {
        this.contactsummary = contactsummary == null ? null : contactsummary.trim();
    }

    public String getNextcontacttime() {
        return nextcontacttime;
    }

    public void setNextcontacttime(String nextcontacttime) {
        this.nextcontacttime = nextcontacttime == null ? null : nextcontacttime.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", transactionid=").append(transactionid);
        sb.append(", owner=").append(owner);
        sb.append(", money=").append(money);
        sb.append(", name=").append(name);
        sb.append(", expecteddate=").append(expecteddate);
        sb.append(", customerid=").append(customerid);
        sb.append(", stage=").append(stage);
        sb.append(", type=").append(type);
        sb.append(", source=").append(source);
        sb.append(", activityid=").append(activityid);
        sb.append(", contactsid=").append(contactsid);
        sb.append(", createby=").append(createby);
        sb.append(", createtime=").append(createtime);
        sb.append(", editby=").append(editby);
        sb.append(", edittime=").append(edittime);
        sb.append(", description=").append(description);
        sb.append(", contactsummary=").append(contactsummary);
        sb.append(", nextcontacttime=").append(nextcontacttime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}