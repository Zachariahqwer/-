package com.itzyh.service;

import com.itzyh.bean.DeparTrue;
import com.itzyh.bean.DeptBao;
import com.itzyh.bean.JobBao;
import com.itzyh.bean.Per;
import com.itzyh.utils.PageBean;

import java.sql.SQLException;

/**
 * 员工业务层接口
 */
public interface IPerService {

    // 录入员工信息
    void entryPer(Per per) throws SQLException;

    // 分页查询所有
    PageBean<Per> findPerAll(int page, int size) throws SQLException;

    // 分页查询试用期员工
    PageBean<Per> findPerByShi(int page, int size) throws SQLException;

    // 部门调动
    int deptBao(DeptBao deptBao) throws SQLException;

    // 离职调动
    int deparTruePer(DeparTrue deparTrue) throws SQLException;

    // 岗位调动
    int jobBao(JobBao jobBao) throws SQLException;

    // 修改部门
    void deptBaoDo(int pDeptNo,int nowDeptNo,String nowDept) throws SQLException;

    // 修改岗位
    void jobBaoDo(int pJobNo,int nowJobNo,String nowJob) throws SQLException;

    // 删除离职的员工
    void delByPer(int pNo) throws SQLException;
}
