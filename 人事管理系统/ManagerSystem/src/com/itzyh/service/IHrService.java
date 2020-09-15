package com.itzyh.service;

import com.itzyh.bean.User;

import java.sql.SQLException;

/**
 * 人事登录业务层接口
 */
public interface IHrService {

    User Login(String name,String pwd,String realName) throws SQLException;
}
