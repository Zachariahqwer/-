package com.itzyh.dao.impl;

import com.itzyh.bean.Job;
import com.itzyh.bean.Per;
import com.itzyh.dao.IJobDao;
import com.itzyh.utils.C3p0Db;
import com.itzyh.utils.PageBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 岗位持久层的接口实现类
 */
public class JobDaoImpl implements IJobDao {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    /**
     * 查询岗位所有
     * @return
     * @throws SQLException
     */
//    @Override
//    public List<Job> findJobAll() throws SQLException {
//
//        conn = C3p0Db.getConn();
//        String sql = " select * from job ";
//        ps = conn.prepareStatement(sql);
//        rs = ps.executeQuery();
//        List<Job> list = new ArrayList<>();
//        while (rs.next()){
//            list.add(
//                    new Job(
//                            rs.getInt(1),
//                            rs.getString(2),
//                            rs.getString(3),
//                            rs.getInt(4)
//                    )
//            );
//        }
//        rs.close();
//        ps.close();
//        conn.close();
//        return list;
//    }

    /**
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageBean<Job> findJobAll(int page, int size) throws SQLException {

        PageBean<Job> pageBean = new PageBean<>();
        pageBean.setTotalCount(getCount());
        if (page<1)
            page=1;
        else if (page>pageBean.getTotalPage())
            page = pageBean.getTotalPage();
        pageBean.setCurrentPage(page);
        pageBean.setPageSize(size);
        conn = C3p0Db.getConn();
        String sql = " select * from job limit ?,? ";
        ps = conn.prepareStatement(sql);
        ps.setInt(1,pageBean.getStartNum());
        ps.setInt(2,pageBean.getPageSize());
        rs = ps.executeQuery();
        List<Job> job = new ArrayList<>();
        while (rs.next()){
            job.add(new Job(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4)
            ));
        }
        pageBean.setPageData(job);
        rs.close();
        ps.close();
        conn.close();
        return pageBean;
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
        PageBean<Job> pageBean = setPageByNameOrNo(page,size);
        conn = C3p0Db.getConn();
        String sql = " select * from job where jno = ? limit ?,? ";
        ps = conn.prepareStatement(sql);
        ps.setInt(1,input);
        ps.setInt(2,pageBean.getStartNum());
        ps.setInt(3,pageBean.getPageSize());
        rs = ps.executeQuery();
        List<Job> job = new ArrayList<>();
        while (rs.next()){
            job.add(new Job(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4)
            ));
        }
        pageBean.setPageData(job);
        rs.close();
        ps.close();
        conn.close();
        return pageBean;
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
        PageBean<Job> pageBean = setPageByNameOrNo(page,size);
        conn = C3p0Db.getConn();
        String sql = " select * from job where jname = ? limit ?,? ";
        ps = conn.prepareStatement(sql);
        ps.setString(1,input);
        ps.setInt(2,pageBean.getStartNum());
        ps.setInt(3,pageBean.getPageSize());
        rs = ps.executeQuery();
        List<Job> job = new ArrayList<>();
        while (rs.next()){
            job.add(new Job(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4)
            ));
        }
        pageBean.setPageData(job);
        rs.close();
        ps.close();
        conn.close();
        return pageBean;
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
        PageBean<Job> pageBean = new PageBean<>();
        pageBean.setTotalCount(getCountByType(input));
        if (page<1)
            page=1;
        else if (page>pageBean.getTotalPage())
            page = pageBean.getTotalPage();
        pageBean.setCurrentPage(page);
        pageBean.setPageSize(size);
        conn = C3p0Db.getConn();
        String sql = " select * from job where jtype = ? limit ?,? ";
        ps = conn.prepareStatement(sql);
        ps.setString(1,input);
        ps.setInt(2,pageBean.getStartNum());
        ps.setInt(3,pageBean.getPageSize());
        rs = ps.executeQuery();
        List<Job> job = new ArrayList<>();
        while (rs.next()){
            job.add(new Job(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4)
            ));
        }
        pageBean.setPageData(job);
        rs.close();
        ps.close();
        conn.close();
        return pageBean;
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
        PageBean<Per> pageBean = new PageBean<>();
        pageBean.setTotalCount(queryCount(name));
        if (page<1)
            page = 1;
        else if(page > pageBean.getTotalPage())
            page = pageBean.getTotalPage();
        pageBean.setCurrentPage(page);     // 设置当前页
        pageBean.setPageSize(size);        // 设置每页数据的个数
        conn = C3p0Db.getConn();
        String sql = " select * from job j,talent_pool t where t.pjob = ? and j.jname = ? and t.pjobno = ? and j.jno = ? limit ?,?; ";
        ps = conn.prepareStatement(sql);
        ps.setString(1,name);
        ps.setString(2,name);
        ps.setInt(3,no);
        ps.setInt(4,no);
        ps.setInt(5,pageBean.getStartNum());
        ps.setInt(6,pageBean.getPageSize());
        rs = ps.executeQuery();
        List<Per> list = new ArrayList<>();
        while (rs.next()){
            list.add(new Per(
                    rs.getInt("pjobno"),
                    rs.getString("pname"),
                    rs.getString("psex"),
                    rs.getInt("pno"),
                    rs.getString("pjob"),
                    rs.getString("pyongg"),
                    rs.getString("pshiyong")

            ));
        }
        pageBean.setPageData(list);
        rs.close();
        ps.close();
        conn.close();
        return pageBean;
    }

    /**
     * 删除之前先查询该岗位下是否有员工
     * @param name
     * @return
     * @throws SQLException
     */
    @Override
    public List<Per> queryPerForDel(String name) throws SQLException {
        conn = C3p0Db.getConn();
        String sql = " select * from job j,talent_pool t where t.pjob = ? and j.jname = ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1,name);
        ps.setString(2,name);
        rs = ps.executeQuery();
        List<Per> list = new ArrayList<>();
        Per per = new Per();
        while (rs.next()){
            per.setPjob(rs.getString("pjob"));
            list.add(per);
        }
        rs.close();
        ps.close();
        conn.close();
        return list;
    }

    /**
     * 查询该岗位下的员工记录数
     * @param name
     * @return
     * @throws SQLException
     */
    public int queryCount(String name) throws SQLException {
        conn = C3p0Db.getConn();
        String sql = " select count(*)  from job j,talent_pool t where t.pjob = ? and j.jname = ? ";
        ps = conn.prepareStatement(sql);
        ps.setString(1,name);
        ps.setString(2,name);
        rs = ps.executeQuery();
        int count = 0;
        while (rs.next()){
            count = rs.getInt(1);
        }
        rs.close();
        ps.close();
        conn.close();
        return count;
    }

    /**
     * 对岗位编号，名称查询时的分页操作
     * @param page
     * @param size
     * @return
     * @throws SQLException
     */
    public PageBean<Job> setPageByNameOrNo(int page,int size) throws SQLException{
        PageBean<Job> pageBean = new PageBean<>();
        pageBean.setTotalCount(1);
        if (page<1)
            page = 1;
        else if(page > pageBean.getTotalPage())
            page = pageBean.getTotalPage();
        pageBean.setCurrentPage(page);     // 设置当前页
        pageBean.setPageSize(size);        // 设置每页数据的个数
        return pageBean;
    }

    /**
     * 通过类型查询的总记录数
     * @param input
     * @return
     * @throws SQLException
     */
    public int getCountByType(String input) throws SQLException {
        conn = C3p0Db.getConn();
        String sql = " select count(*) from job where jtype = ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1,input);
        rs = ps.executeQuery();
        int count = 0;
        while (rs.next()){
            count = rs.getInt(1);
        }
        rs.close();
        ps.close();
        conn.close();
        return count;
    }

    /**
     * 查询总记录数
     * @return
     */
    @Override
    public int getCount() throws SQLException {
        conn = C3p0Db.getConn();
        String sql = " select count(*) from job ";
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        int count = 0;
        while (rs.next()){
            count = rs.getInt(1);
        }
        rs.close();
        ps.close();
        conn.close();
        return count;
    }

    /**
     * 新建不岗位
     * @param jno
     * @param jname
     * @param jtype
     * @return
     * @throws SQLException
     */
    @Override
    public int newJob(int jno, String jname, String jtype,int jnum) throws SQLException {
        conn = C3p0Db.getConn();
        String sql = " insert into job(jno, jname, jtype,jnum) value (?,?,?,?) ";
        ps = conn.prepareStatement(sql);
        ps.setInt(1,jno);
        ps.setString(2,jname);
        ps.setString(3,jtype);
        ps.setInt(4,jnum);
        int i = ps.executeUpdate();
        ps.close();
        conn.close();
        return i;
    }

    /**
     * 删除岗位
     * @param id
     */
    @Override
    public void deletedJobById(int id) throws SQLException {
        conn = C3p0Db.getConn();
        String sql = " delete from job where jno = ? ";
        ps = conn.prepareStatement(sql);
        ps.setInt(1,id);
        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    /**
     * 修改岗位
     * @param job
     */
    @Override
    public void updateJobById(Job job) throws SQLException {
        conn = C3p0Db.getConn();
        String sql = " update job set jname=?,jtype=?,jnum=? where jno = ? ";
        ps = conn.prepareStatement(sql);
        ps.setString(1,job.getJname());
        ps.setString(2,job.getJtype());
        ps.setInt(3,job.getJnum());
        ps.setInt(4,job.getJno());
        ps.executeUpdate();
        ps.close();
        conn.close();
    }
}
