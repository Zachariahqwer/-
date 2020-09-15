package com.itzyh.service.impl;

import com.itzyh.bean.User;
import com.itzyh.dao.IHrDao;
import com.itzyh.dao.impl.HrDaoImpl;
import com.itzyh.service.IHrService;

import java.sql.SQLException;

public class HrServiceImpl implements IHrService {

    IHrDao hd = new HrDaoImpl();
    /**
     * Hr登录
     * @param name
     * @param pwd
     * @return
     */
    @Override
    public User Login(String name, String pwd,String realName) throws SQLException {
        return hd.Login(name,pwd,realName);
    }
}
