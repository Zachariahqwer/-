package com.itzyh.service.impl;

import com.itzyh.bean.Job;
import com.itzyh.bean.Per;
import com.itzyh.dao.IJobDao;
import com.itzyh.dao.impl.JobDaoImpl;
import com.itzyh.service.IJobService;
import com.itzyh.utils.PageBean;

import java.sql.SQLException;
import java.util.List;

/**
 * 岗位业务层接口实现类
 */
public class JobServiceImpl implements IJobService {

    IJobDao ijd = new JobDaoImpl();

    /**
     * 查询所有岗位
     * @return
     * @throws SQLException
     */
//    @Override
//    public List<Job> findJobAll() throws SQLException {
//        return ijd.findJobAll();
//    }

    /**
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageBean<Job> findJobAll(int page, int size) throws SQLException {
        return ijd.findJobAll(page,size);
    }

    /**
     * 编号查询
     * @param page
     * @param size
     * @param input
     * @return
     * @throws SQLException
     */
    @Override
    public PageBean<Job> findJobByJno(int page, int size, int input) throws SQLException {
        return ijd.findJobByJno(page,size,input);
    }

    /**
     * 名称查询
     * @param page
     * @param size
     * @param input
     * @return
     * @throws SQLException
     */
    @Override
    public PageBean<Job> findJobByJname(int page, int size, String input) throws SQLException {
        return ijd.findJobByJname(page,size,input);
    }

    /**
     * 类型查询
     * @param page
     * @param size
     * @param input
     * @return
     * @throws SQLException
     */
    @Override
    public PageBean<Job> findJobByJtype(int page, int size, String input) throws SQLException {
        return ijd.findJobByJtype(page,size,input);
    }

    /**
     * 删除之前先查询
     * @param name
     * @return
     * @throws SQLException
     */
    @Override
    public List<Per> queryPerForDel(String name) throws SQLException {
        return ijd.queryPerForDel(name);
    }

    /**
     * 查询该岗位下的员工
     * @param name
     * @param page
     * @param size
     * @return
     * @throws SQLException
     */
    @Override
    public PageBean<Per> queryJobPer(String name,int no, int page, int size) throws SQLException {
        return ijd.queryJobPer(name,no,page,size);
    }

    /**
     * 新建岗位
     * @param jno
     * @param jname
     * @param jtype
     * @return
     */
    @Override
    public int newJob(int jno, String jname, String jtype,int jnum) throws SQLException {

        return ijd.newJob(jno,jname,jtype,jnum);
    }

    /**
     * 删除岗位
     * @param id
     */
    @Override
    public void deletedJobById(int id) throws SQLException {
        ijd.deletedJobById(id);
    }

    /**
     * 修改岗位
     * @param job
     */
    @Override
    public void updateJobById(Job job) throws SQLException {
        ijd.updateJobById(job);
    }
}
