package com.zarek.crm.pojo.domain;

import java.io.Serializable;

public class TranRemark implements Serializable {
    private String transactionremarkid;

    private String notecontent;

    private String createby;

    private String createtime;

    private String editby;

    private String edittime;

    private String editflag;

    private String transactionid;

    private static final long serialVersionUID = 1L;

    public String getTransactionremarkid() {
        return transactionremarkid;
    }

    public void setTransactionremarkid(String transactionremarkid) {
        this.transactionremarkid = transactionremarkid == null ? null : transactionremarkid.trim();
    }

    public String getNotecontent() {
        return notecontent;
    }

    public void setNotecontent(String notecontent) {
        this.notecontent = notecontent == null ? null : notecontent.trim();
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

    public String getEditflag() {
        return editflag;
    }

    public void setEditflag(String editflag) {
        this.editflag = editflag == null ? null : editflag.trim();
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
        sb.append(", transactionremarkid=").append(transactionremarkid);
        sb.append(", notecontent=").append(notecontent);
        sb.append(", createby=").append(createby);
        sb.append(", createtime=").append(createtime);
        sb.append(", editby=").append(editby);
        sb.append(", edittime=").append(edittime);
        sb.append(", editflag=").append(editflag);
        sb.append(", transactionid=").append(transactionid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}