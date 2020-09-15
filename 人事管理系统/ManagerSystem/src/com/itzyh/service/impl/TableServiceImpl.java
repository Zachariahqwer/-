package com.itzyh.service.impl;

import com.itzyh.bean.DeparTrue;
import com.itzyh.bean.DeptBao;
import com.itzyh.bean.JobBao;
import com.itzyh.dao.ITableDao;
import com.itzyh.dao.impl.TableDaoImpl;
import com.itzyh.service.ITableService;
import com.itzyh.utils.PageBean;

import java.sql.SQLException;

/**
 * 报表接口实现了
 */
public class TableServiceImpl implements ITableService {

    ITableDao itd = new TableDaoImpl();
    /**
     * 部门调动报表
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageBean<DeptBao> tableDept(int page, int size) throws SQLException {
        return itd.tableData(page,size);
    }

    /**
     * 岗位调动报表
     * @param page
     * @param size
     * @return
     * @throws SQLException
     */
    @Override
    public PageBean<JobBao> jobTable(int page, int size) throws SQLException {
        return itd.JobTable(page,size);
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
        return itd.PerTable(page,size);
    }
}
