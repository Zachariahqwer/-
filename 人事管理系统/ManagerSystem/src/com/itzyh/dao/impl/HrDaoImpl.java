package com.itzyh.dao.impl;

import com.itzyh.bean.User;
import com.itzyh.dao.IHrDao;
import com.itzyh.utils.C3p0Db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HrDaoImpl implements IHrDao {

    Connection connection = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    /**
     * Hr登录
     * @param name
     * @param pwd
     * @return
     */
    @Override
    public User Login(String name, String pwd,String realName) throws SQLException {
        connection = C3p0Db.getConn();
        String sql = " select * from hr where user=? and pwd=? and realName=?";
        ps = connection.prepareStatement(sql);
        ps.setString(1,name);
        ps.setString(2,pwd);
        ps.setString(3,realName);
        rs = ps.executeQuery();
        User user = null;
        while (rs.next()){
            user = new User(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4)
            );
        }
        return user;
    }
}
