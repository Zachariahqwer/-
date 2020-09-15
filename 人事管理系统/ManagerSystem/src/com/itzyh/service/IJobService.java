package com.itzyh.service;

import com.itzyh.bean.Job;
import com.itzyh.bean.Per;
import com.itzyh.utils.PageBean;

import java.sql.SQLException;
import java.util.List;

/**
 * 岗位业务层接口
 */
public interface IJobService {

    // 查询岗位所有
//    List<Job> findJobAll() throws SQLException;

    // 分页查询
    PageBean<Job> findJobAll(int page,int size) throws SQLException;

    // 编号查询
    PageBean<Job> findJobByJno(int page,int size,int input)throws SQLException;

    // 名称查询
    PageBean<Job> findJobByJname(int page,int size,String input)throws SQLException;

    // 类型查询
    PageBean<Job> findJobByJtype(int page,int size,String input)throws SQLException;

    // 删除之前先查询该岗位下是否有员工
    List<Per> queryPerForDel(String name) throws SQLException;

    // 查询该岗位下的员工
    PageBean<Per> queryJobPer(String name,int no, int page, int size) throws SQLException;

    // 新建岗位
    int newJob(int jno,String jname,String jtype,int jnum) throws SQLException;

    // 删除岗位
    void deletedJobById(int id) throws SQLException;

    // 修改岗位
    void updateJobById(Job job) throws SQLException;
}
