package com.itzyh.dao;

import com.itzyh.bean.DeparTrue;
import com.itzyh.bean.DeptBao;
import com.itzyh.bean.JobBao;
import com.itzyh.utils.PageBean;

import java.sql.SQLException;

/**
 * 报表持久层接口
 */
public interface ITableDao {

    // 部门调动报表
    PageBean<DeptBao> tableData(int page,int size) throws SQLException;

    // 岗位调动报表
    PageBean<JobBao> JobTable(int page, int size) throws SQLException;

    // 离职员工报表
    PageBean<DeparTrue> PerTable(int page, int size) throws SQLException;
}
