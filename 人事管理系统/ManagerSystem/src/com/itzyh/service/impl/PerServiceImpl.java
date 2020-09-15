package com.itzyh.service.impl;

import com.itzyh.bean.DeparTrue;
import com.itzyh.bean.DeptBao;
import com.itzyh.bean.JobBao;
import com.itzyh.bean.Per;
import com.itzyh.dao.IPerDao;
import com.itzyh.dao.impl.PerDaoImpl;
import com.itzyh.service.IPerService;
import com.itzyh.utils.PageBean;

import java.sql.SQLException;

/**
 * 员工业务层接口实现类
 */
public class PerServiceImpl implements IPerService {

    IPerDao ipd = new PerDaoImpl();
    /**
     * 录入员工信息
     * @param per
     */
    @Override
    public void entryPer(Per per) throws SQLException {
        ipd.entryPer(per);
    }

    /**
     * 分页查询所有
     * @param page
     * @param size
     * @return
     * @throws SQLException
     */
    @Override
    public PageBean<Per> findPerAll(int page, int size) throws SQLException {
        return ipd.findPerAll(page,size);
    }

    /**
     * 查询试用员工的信息
     * @param page
     * @param size
     * @return
     * @throws SQLException
     */
    @Override
    public PageBean<Per> findPerByShi(int page, int size) throws SQLException {
        return ipd.findPerByShi(page,size);
    }

    /**
     * 将调动的员工加入到部门调动表中
     * @param deptBao
     * @throws SQLException
     */
    @Override
    public int deptBao(DeptBao deptBao) throws SQLException {
        return ipd.deptBao(deptBao);
    }

    /**
     * 将离职的员工加到离职报表中
     * @param deparTrue
     * @return
     * @throws SQLException
     */
    @Override
    public int deparTruePer(DeparTrue deparTrue) throws SQLException {
        return ipd.deparTruePer(deparTrue);
    }

    /**
     * 将岗位调动的员工信息添加到岗位调动表中
     * @param jobBao
     * @return
     * @throws SQLException
     */
    @Override
    public int jobBao(JobBao jobBao) throws SQLException {
        return ipd.JobBao(jobBao);
    }

    /**
     * 修改调动部门
     * @param nowDeptNo
     * @param nowDept
     * @throws SQLException
     */
    @Override
    public void deptBaoDo(int pDeptNo,int nowDeptNo,String nowDept) throws SQLException {
        ipd.deptBaoDo(pDeptNo,nowDeptNo,nowDept);
    }


    /**
     * 修改调动岗位
     * @param pJobNo
     * @param nowJobNo
     * @param nowJob
     * @throws SQLException
     */
    @Override
    public void jobBaoDo(int pJobNo, int nowJobNo, String nowJob) throws SQLException {
        ipd.JobBaoDo(pJobNo, nowJobNo, nowJob);
    }

    /**
     * 删除离职的员工
     * @param pNo
     * @throws SQLException
     */
    @Override
    public void delByPer(int pNo) throws SQLException {
        ipd.delByPer(pNo);
    }
}
