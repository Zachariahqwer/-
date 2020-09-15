package com.itzyh.service;

import com.itzyh.bean.DeparTrue;
import com.itzyh.bean.DeptBao;
import com.itzyh.bean.JobBao;
import com.itzyh.utils.PageBean;

import java.sql.SQLException;

/**
 * 报表接口
 */
public interface ITableService {

    // 部门调动报表
    PageBean<DeptBao> tableDept(int page,int size) throws SQLException;

    // 岗位调动报表
    PageBean<JobBao> jobTable(int page, int size) throws SQLException;

    // 离职员工报表
    PageBean<DeparTrue> PerTable(int page, int size) throws SQLException;
}
