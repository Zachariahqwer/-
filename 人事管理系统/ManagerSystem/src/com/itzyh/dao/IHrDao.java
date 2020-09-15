package com.itzyh.dao;

import com.itzyh.bean.User;

import java.sql.SQLException;

/**
 * 人事登录持久层接口
 */
public interface IHrDao {

    User Login(String name,String pwd,String realName) throws SQLException;
}
