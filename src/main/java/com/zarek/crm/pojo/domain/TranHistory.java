package com.zarek.crm.pojo.domain;

import java.io.Serializable;

public class TranHistory implements Serializable {
    private String transactionhistoryid;

    private String stage;

    private String money;

    private String expecteddate;

    private String createtime;

    private String createby;

    private String transactionid;

    private static final long serialVersionUID = 1L;

    public String getTransactionhistoryid() {
        return transactionhistoryid;
    }

    public void setTransactionhistoryid(String transactionhistoryid) {
        this.transactionhistoryid = transactionhistoryid == null ? null : transactionhistoryid.trim();
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage == null ? null : stage.trim();
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money == null ? null : money.trim();
    }

    public String getExpecteddate() {
        return expecteddate;
    }

    public void setExpecteddate(String expecteddate) {
        this.expecteddate = expecteddate == null ? null : expecteddate.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    public String getCreateby() {
        return createby;
    }

    public void setCreateby(String createby) {
        this.createby = createby == null ? null : createby.trim();
    }

    public String getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(String transactionid) {
        this.transactionid = transactionid == null ? null : transactionid.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", transactionhistoryid=").append(transactionhistoryid);
        sb.append(", stage=").append(stage);
        sb.append(", money=").append(money);
        sb.append(", expecteddate=").append(expecteddate);
        sb.append(", createtime=").append(createtime);
        sb.append(", createby=").append(createby);
        sb.append(", transactionid=").append(transactionid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}