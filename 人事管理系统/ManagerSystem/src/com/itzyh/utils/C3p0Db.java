package com.itzyh.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class C3p0Db {

    private static ComboPooledDataSource ds;
    static {

        try {
            Properties p = new Properties();
            InputStream in = C3p0Db.class.getClassLoader().getResourceAsStream("com/itzyh/utils/dbinfo1.properties");
            p.load(in);
            String driver = p.getProperty("driver");
            String url = p.getProperty("url");
            String user = p.getProperty("username");
            String pwd = p.getProperty("password");

            int initialPoolSize = Integer.parseInt(p.getProperty("initialPoolSize"));
            int maxPoolSize = Integer.parseInt(p.getProperty("maxPoolSize"));
            int minPoolSize = Integer.parseInt(p.getProperty("minPoolSize"));
            int maxIdleTime = Integer.parseInt(p.getProperty("maxIdleTime"));

            ds = new ComboPooledDataSource();
            ds.setDriverClass(driver);
            ds.setJdbcUrl(url);
            ds.setUser(user);
            ds.setPassword(pwd);
            ds.setInitialPoolSize(initialPoolSize);
            ds.setMaxPoolSize(maxPoolSize);
            ds.setMinPoolSize(minPoolSize);
            ds.setMaxIdleTime(maxIdleTime);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn() throws SQLException {
        return ds.getConnection();
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(getConn());
    }
}
