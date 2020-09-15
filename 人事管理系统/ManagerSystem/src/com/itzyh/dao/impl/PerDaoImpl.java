package com.itzyh.dao.impl;

import com.itzyh.bean.DeparTrue;
import com.itzyh.bean.DeptBao;
import com.itzyh.bean.JobBao;
import com.itzyh.bean.Per;
import com.itzyh.dao.IPerDao;
import com.itzyh.utils.C3p0Db;
import com.itzyh.utils.PageBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 员工持久层接口实现类
 */
public class PerDaoImpl implements IPerDao {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;


    /**
     * 录入员工信息
     * @param per
     * @throws SQLException
     */
    @Override
    public void entryPer(Per per) throws SQLException {
        conn = C3p0Db.getConn();
        String sql = " insert into talent_pool(pno,pname,psex,pbirthday,pidnum,pdep,pjob,pjoindate,pjobdate,pyongg,prlaiyuan,pzhenzhi,pnspace,ptel,pemail,pmar,phighl,phighd,plearnp,pgdate,pshiyong,pbshidate,poshidate) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
        ps = conn.prepareStatement(sql);
        ps.setInt(1,per.getPno());
        ps.setString(2,per.getPname());
        ps.setString(3,per.getPsex());
        ps.setString(4,per.getPbirthday());
        ps.setString(5,per.getPidnum());
        ps.setString(6,per.getPdep());
        ps.setString(7,per.getPjob());
        ps.setString(8,per.getPjoindate());
        ps.setString(9,per.getPjobdate());
        ps.setString(10,per.getPyongg());
        ps.setString(11,per.getPrlaiyuan());
        ps.setString(12,per.getPzhenzhi());
        ps.setString(13,per.getPnspace());
        ps.setString(14,per.getPtel());
        ps.setString(15,per.getPemail());
        ps.setString(16,per.getPmar());
        ps.setString(17,per.getPhighl());
        ps.setString(18,per.getPhighd());
        ps.setString(19,per.getPlearnp());
        ps.setString(20,per.getPgdate());
        ps.setString(21,per.getPshiyong());
        ps.setString(22,per.getPbshidate());
        ps.setString(23,per.getPoshidate());
        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    /**
     * 查询员工信息----分页查询
     * @param page
     * @param size
     * @return
     * @throws SQLException
     */
    @Override
    public PageBean<Per> findPerAll(int page, int size) throws SQLException {
        PageBean<Per> pageBean = setPage(page,size);
        conn = C3p0Db.getConn();
        String sql = " select * from talent_pool limit ?,?";
        ps = conn.prepareStatement(sql);
        ps.setInt(1,pageBean.getStartNum());
        ps.setInt(2,pageBean.getPageSize());
        rs = ps.executeQuery();
        List<Per> list = new ArrayList<>();
        while (rs.next()){
            list.add(new Per(
                    rs.getInt("pno"),
                    rs.getInt("pdeptno"),
                    rs.getString("pname"),
                    rs.getString("psex"),
                    rs.getString("pbirthday"),
                    rs.getString("pidnum"),
                    rs.getString("pdep"),
                    rs.getInt("pjobno"),
                    rs.getString("pjob"),
                    rs.getString("pjoindate"),
                    rs.getString("pjobdate"),
                    rs.getString("pyongg"),
                    rs.getString("prlaiyuan"),
                    rs.getString("pzhenzhi"),
                    rs.getString("pnspace"),
                    rs.getString("ptel"),
                    rs.getString("pemail"),
                    rs.getString("pmar"),
                    rs.getString("phighl"),
                    rs.getString("phighd"),
                    rs.getString("plearnp"),
                    rs.getString("pgdate"),
                    rs.getString("pshiyong"),
                    rs.getString("pbshidate"),
                    rs.getString("poshidate")
            ));
        }
        pageBean.setPageData(list);
        rs.close();
        ps.close();
        conn.close();
        return pageBean;
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

        PageBean<Per> pageBean = new PageBean<>();
        pageBean.setTotalCount(getCountByShi());
        if (page<1)
            page=1;
        else if (page>pageBean.getTotalPage())
            page = pageBean.getTotalPage();
        pageBean.setCurrentPage(page);      // 设置当前页
        pageBean.setPageSize(size);         // 设置每页数据的个数
        conn = C3p0Db.getConn();
        String sql = " select * from talent_pool where pshiyong = \"是\" limit ?,?";
        ps = conn.prepareStatement(sql);
        ps.setInt(1,pageBean.getStartNum());
        ps.setInt(2,pageBean.getPageSize());
        rs = ps.executeQuery();
        List<Per> list = new ArrayList<>();
        while (rs.next()){
            list.add(new Per(
                    rs.getInt("pno"),
                    rs.getInt("pdeptno"),
                    rs.getString("pname"),
                    rs.getString("psex"),
                    rs.getString("pbirthday"),
                    rs.getString("pidnum"),
                    rs.getString("pdep"),
                    rs.getInt("pjobno"),
                    rs.getString("pjob"),
                    rs.getString("pjoindate"),
                    rs.getString("pjobdate"),
                    rs.getString("pyongg"),
                    rs.getString("prlaiyuan"),
                    rs.getString("pzhenzhi"),
                    rs.getString("pnspace"),
                    rs.getString("ptel"),
                    rs.getString("pemail"),
                    rs.getString("pmar"),
                    rs.getString("phighl"),
                    rs.getString("phighd"),
                    rs.getString("plearnp"),
                    rs.getString("pgdate"),
                    rs.getString("pshiyong"),
                    rs.getString("pbshidate"),
                    rs.getString("poshidate")
            ));
        }
        pageBean.setPageData(list);
        rs.close();
        ps.close();
        conn.close();
        return pageBean;
    }

    /**
     *  将部门调动的员工信息插入到部门报表中
     * @param deptBao
     * @throws SQLException
     */
    @Override
    public int deptBao(DeptBao deptBao) throws SQLException {
        conn = C3p0Db.getConn();
        String sql = " insert into deptbao(bdeptno,bdept,bpno,bpname,bpsex,nowDeptno,nowDept,bpyongg,bpshiyong,bdtype) values (?,?,?,?,?,?,?,?,?,?) ";
        ps = conn.prepareStatement(sql);
        ps.setInt(1,deptBao.getBdeptno());
        ps.setString(2,deptBao.getBdept());
        ps.setInt(3,deptBao.getBpno());
        ps.setString(4,deptBao.getBpname());
        ps.setString(5,deptBao.getBpsex());
        ps.setInt(6,deptBao.getNowDeptno());
        ps.setString(7,deptBao.getNowDept());
        ps.setString(8,deptBao.getBpyongg());
        ps.setString(9,deptBao.getBpshiyong());
        ps.setString(10,deptBao.getBdtype());
        int code = ps.executeUpdate();
        ps.close();
        conn.close();
        return code;
    }

    /**
     * 将岗位调动的员工添加到岗位报表中
     * @param jobBao
     * @return
     * @throws SQLException
     */
    @Override
    public int JobBao(JobBao jobBao) throws SQLException {
        conn = C3p0Db.getConn();
        String sql = " insert into Jobbao(bJobno,bJob,nowJobno,nowJob,bpno,bpname,bpsex,bpyongg,bpshiyong,btype) values (?,?,?,?,?,?,?,?,?,?) ";
        ps = conn.prepareStatement(sql);
        ps.setInt(1,jobBao.getbJobno());
        ps.setString(2,jobBao.getbJob());
        ps.setInt(3,jobBao.getNowJobno());
        ps.setString(4,jobBao.getNowJob());
        ps.setInt(5,jobBao.getBpno());
        ps.setString(6,jobBao.getBpname());
        ps.setString(7,jobBao.getBpsex());
        ps.setString(8,jobBao.getBpyongg());
        ps.setString(9,jobBao.getBpshiyong());
        ps.setString(10,jobBao.getBtype());
        int code = ps.executeUpdate();
        ps.close();
        conn.close();
        return code;
    }

    /**
     * 将离职的员工加入到离职报表中
     * @param deparTrue
     * @return
     * @throws SQLException
     */
    @Override
    public int deparTruePer(DeparTrue deparTrue) throws SQLException {
        conn = C3p0Db.getConn();
        String sql = " insert into deparBao(ldeptno,ldept,ljobno,lJob,lpno,lpname,lpsex,lpyongg,lpshiyong,lizhi,ldate,ltype) values (?,?,?,?,?,?,?,?,?,?,?,?) ";
        ps = conn.prepareStatement(sql);
        ps.setInt(1,deparTrue.getLdeptno());
        ps.setString(2,deparTrue.getLdept());
        ps.setInt(3,deparTrue.getLjobno());
        ps.setString(4,deparTrue.getLjob());
        ps.setInt(5,deparTrue.getLpno());
        ps.setString(6,deparTrue.getLpname());
        ps.setString(7,deparTrue.getLpsex());
        ps.setString(8,deparTrue.getLpyongg());
        ps.setString(9,deparTrue.getLpshiyong());
        ps.setString(10,deparTrue.getLizhi());
        ps.setString(11,deparTrue.getLdate());
        ps.setString(12,deparTrue.getLtype());
        int code = ps.executeUpdate();
        ps.close();
        conn.close();
        return code;
    }

    /**
     * 部门改动
     * @param pDeptNo
     * @param nowDeptNo
     * @param nowDept
     * @throws SQLException
     */
    @Override
    public void deptBaoDo(int pDeptNo,int nowDeptNo,String nowDept) throws SQLException {
        conn = C3p0Db.getConn();
        String sql = " update talent_pool set pdeptno = ?,pdep = ? where pdeptno = ? ";
        ps = conn.prepareStatement(sql);
        ps.setInt(1,nowDeptNo);
        ps.setString(2,nowDept);
        ps.setInt(3,pDeptNo);
        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    /**
     * 岗位改动
     * @param pJobNo
     * @param nowJobNo
     * @param nowJob
     * @throws SQLException
     */
    @Override
    public void JobBaoDo(int pJobNo, int nowJobNo, String nowJob) throws SQLException {
        conn = C3p0Db.getConn();
        String sql = " update talent_pool set pjobno = ?,pjob = ? where pjobno = ? ";
        ps = conn.prepareStatement(sql);
        ps.setInt(1,nowJobNo);
        ps.setString(2,nowJob);
        ps.setInt(3,pJobNo);
        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    /**
     * 删除离职的员工
     * @param pNo
     * @throws SQLException
     */
    @Override
    public void delByPer(int pNo) throws SQLException {
        conn = C3p0Db.getConn();
        String sql = " delete from talent_pool where pno = ? ";
        ps = conn.prepareStatement(sql);
        ps.setInt(1,pNo);
        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    /**
     * 设置分页操作
     * @param page
     * @param size
     * @return
     * @throws SQLException
     */
    public PageBean<Per> setPage(int page,int size) throws SQLException {
        PageBean<Per> pageBean = new PageBean<>();
        pageBean.setTotalCount(getCount());
        if (page<1)
            page=1;
        else if (page>pageBean.getTotalPage())
            page = pageBean.getTotalPage();
        pageBean.setCurrentPage(page);      // 设置当前页
        pageBean.setPageSize(size);         // 设置每页数据的个数
        return pageBean;
    }

    /**
     * 获取在试用期员工总记录数
     * @return
     * @throws SQLException
     */
    public int getCountByShi() throws SQLException {
        conn = C3p0Db.getConn();
        String sql = " select count(*) from talent_pool where pshiyong = \"是\" ";
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
     * 获取总记录数
     * @return
     * @throws SQLException
     */
    public int getCount() throws SQLException {
        conn = C3p0Db.getConn();
        String sql = " select count(*) from talent_pool ";
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
}
