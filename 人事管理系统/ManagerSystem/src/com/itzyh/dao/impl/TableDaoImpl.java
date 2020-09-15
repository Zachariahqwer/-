package com.itzyh.dao.impl;

import com.itzyh.bean.DeparTrue;
import com.itzyh.bean.DeptBao;
import com.itzyh.bean.JobBao;
import com.itzyh.dao.ITableDao;
import com.itzyh.utils.C3p0Db;
import com.itzyh.utils.PageBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 报表接口实现类
 */
public class TableDaoImpl implements ITableDao {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    /**
     * 部门调动报表
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageBean<DeptBao> tableData(int page, int size) throws SQLException {
        PageBean<DeptBao> pageBean = new PageBean<>();
        pageBean.setTotalCount(getCountDept());
        if (page<1)
            page = 1;
        else if(page > pageBean.getTotalPage())
            page = pageBean.getTotalPage();
        pageBean.setCurrentPage(page);     // 设置当前页
        pageBean.setPageSize(size);        // 设置每页数据的个数
        conn = C3p0Db.getConn();
        String sql = " select * from deptbao limit ?,?";
        ps = conn.prepareStatement(sql);
        ps.setInt(1,pageBean.getStartNum());
        ps.setInt(2,pageBean.getPageSize());
        rs = ps.executeQuery();
        List<DeptBao> list = new ArrayList<>();
        while (rs.next()){
            list.add(new DeptBao(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getInt(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getString(9),
                    rs.getString(10)
            ));
        }
        pageBean.setPageData(list);
        rs.close();
        ps.close();
        conn.close();
        return pageBean;
    }

    /**
     * 岗位调动报表
     * @param page
     * @param size
     * @return
     * @throws SQLException
     */
    @Override
    public PageBean<JobBao> JobTable(int page, int size) throws SQLException {

        PageBean<JobBao> pageBean = new PageBean<>();
        pageBean.setTotalCount(getCountJob());
        if (page<1)
            page = 1;
        else if(page > pageBean.getTotalPage())
            page = pageBean.getTotalPage();
        pageBean.setCurrentPage(page);     // 设置当前页
        pageBean.setPageSize(size);        // 设置每页数据的个数
        conn = C3p0Db.getConn();
        String sql = " select * from jobbao limit ?,?";
        ps = conn.prepareStatement(sql);
        ps.setInt(1,pageBean.getStartNum());
        ps.setInt(2,pageBean.getPageSize());
        rs = ps.executeQuery();
        List<JobBao> list = new ArrayList<>();
        while (rs.next()){
            list.add(new JobBao(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getString(4),
                    rs.getInt(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getString(9),
                    rs.getString(10)
            ));
        }
        pageBean.setPageData(list);
        rs.close();
        ps.close();
        conn.close();
        return pageBean;
    }

    /**
     * 离职员工报表
     * @param page
     * @param size
     * @return
     * @throws SQLException
     */
    @Override
    public PageBean<DeparTrue> PerTable(int page, int size) throws SQLException {
        PageBean<DeparTrue> pageBean = new PageBean<>();
        pageBean.setTotalCount(getCountPer());
        if (page<1)
            page = 1;
        else if(page > pageBean.getTotalPage())
            page = pageBean.getTotalPage();
        pageBean.setCurrentPage(page);     // 设置当前页
        pageBean.setPageSize(size);        // 设置每页数据的个数
        conn = C3p0Db.getConn();
        String sql = " select * from deparBao limit ?,?";
        ps = conn.prepareStatement(sql);
        ps.setInt(1,pageBean.getStartNum());
        ps.setInt(2,pageBean.getPageSize());
        rs = ps.executeQuery();
        List<DeparTrue> list = new ArrayList<>();
        while (rs.next()){
            list.add(new DeparTrue(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getString(4),
                    rs.getInt(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getString(9),
                    rs.getString(10),
                    rs.getString(11),
                    rs.getString(12)
            ));
        }
        pageBean.setPageData(list);
        rs.close();
        ps.close();
        conn.close();
        return pageBean;
    }

    /**
     * 离职报表总记录数
     * @return
     * @throws SQLException
     */
    public int getCountPer() throws SQLException {
        conn = C3p0Db.getConn();
        String sql = " select count(*) from deparBao ";
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        int count = 0;
        while (rs.next()){
            count = rs.getInt(1);
        }
        return count;
    }

    /**
     * 岗位报表总记录数
     * @return
     * @throws SQLException
     */
    public int getCountJob() throws SQLException {
        conn = C3p0Db.getConn();
        String sql = " select count(*) from jobbao";
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        int count = 0;
        while (rs.next()){
            count = rs.getInt(1);
        }
        return count;
    }

    /**
     * 部门报表总记录数
     * @return
     * @throws SQLException
     */
    public int getCountDept() throws SQLException {
        conn = C3p0Db.getConn();
        String sql = " select count(*) from deptbao";
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        int count = 0;
        while (rs.next()){
            count = rs.getInt(1);
        }
        return count;
    }
}
