package com.zarek.crm.pojo.domain;

import java.io.Serializable;

public class ContactsRemark implements Serializable {
    private String contactremarkid;

    private String notecontent;

    private String createby;

    private String createtime;

    private String editby;

    private String edittime;

    private String editflag;

    private String contactsid;

    private static final long serialVersionUID = 1L;

    public String getContactremarkid() {
        return contactremarkid;
    }

    public void setContactremarkid(String contactremarkid) {
        this.contactremarkid = contactremarkid == null ? null : contactremarkid.trim();
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

    public String getContactsid() {
        return contactsid;
    }

    public void setContactsid(String contactsid) {
        this.contactsid = contactsid == null ? null : contactsid.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", contactremarkid=").append(contactremarkid);
        sb.append(", notecontent=").append(notecontent);
        sb.append(", createby=").append(createby);
        sb.append(", createtime=").append(createtime);
        sb.append(", editby=").append(editby);
        sb.append(", edittime=").append(edittime);
        sb.append(", editflag=").append(editflag);
        sb.append(", contactsid=").append(contactsid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}