package com.itzyh.bean;

import java.io.Serializable;

/**
 * HR
 */
public class User implements Serializable {

    private Integer id;
    private String user;
    private String pwd;
    private String realName;

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public User(Integer id, String user, String pwd, String realName) {
        this.id = id;
        this.user = user;
        this.pwd = pwd;
        this.realName = realName;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", pwd='" + pwd + '\'' +
                ", realName='" + realName + '\'' +
                '}';
    }
}
