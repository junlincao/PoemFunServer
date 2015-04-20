package com.cjl.poetryfan.domain;

import java.util.Date;

/**
 * 用户数据
 *
 * @author CJL
 * @since 2015-04-20
 */
public class User {

    private String name;
    private String pwd;
    private String userImg;
    private Date createDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", userImg='" + userImg + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
