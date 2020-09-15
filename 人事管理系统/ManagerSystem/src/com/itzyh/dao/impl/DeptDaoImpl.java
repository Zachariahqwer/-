package com.itzyh.dao.impl;

import com.itzyh.bean.Dept;
import com.itzyh.bean.Per;
import com.itzyh.dao.IDeptDao;
import com.itzyh.utils.C3p0Db;
import com.itzyh.utils.PageBean;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 部门的持久层接口实现类
 */
public class DeptDaoImpl implements IDeptDao{

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;


    /**
     * 新建部门
     * @param dept
     * @param dname
     * @param dtype
     * @param dtel
     * @param demail
     * @param dmiaoshu
     * @param ddescribe
     * @param ddate
     */
    @Override
    public int newDept(int dept, String dname, String dtype, String dtel, String demail, String dmiaoshu, String ddescribe, String ddate) throws SQLException {

        conn = C3p0Db.getConn();
        String sql = "insert into dept(deptno,dname,dtype,dtel,demail,dmiaoshu,ddescribe,ddate) values (?,?,?,?,?,?,?,?)";
        ps = conn.prepareStatement(sql);
        ps.setInt(1,dept);
        ps.setString(2,dname);
        ps.setString(3,dtype);
        ps.setString(4,dtel);
        ps.setString(5,demail);
        ps.setString(6,dmiaoshu);
        ps.setString(7,ddescribe);
        ps.setString(8,ddate);
        int code = ps.executeUpdate();
        ps.close();
        conn.close();
        return code;
    }

    /**
     * 根据编号进行查询
     * @param page
     * @param size
     * @param input
     * @return
     * @throws SQLException
     */
    @Override
    public PageBean<Dept> findByDeptno(int page, int size, int input) throws SQLException {
        PageBean<Dept> pageBean = setPageByNameOrNo(page, size);
        conn = C3p0Db.getConn();
        String sql = " select * from dept where deptno = ? limit ?,? ";
        ps = conn.prepareStatement(sql);
        ps.setInt(1,input);
        ps.setInt(2,pageBean.getStartNum());
        ps.setInt(3,pageBean.getPageSize());
        rs  = ps.executeQuery();
        List<Dept> list = new ArrayList<>();
        while (rs.next()){
            list.add(new Dept(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8)
            ));
        }
        pageBean.setPageData(list);
        rs.close();
        ps.close();
        conn.close();
        return pageBean;
    }

    /**
     * 根据名称进行查询
     * @param page
     * @param size
     * @param input
     * @return
     */
    @Override
    public PageBean<Dept> findByDname(int page, int size, String input) throws SQLException {
        PageBean<Dept> pageBean = setPageByNameOrNo(page, size);
        conn = C3p0Db.getConn();
        String sql = " select * from dept where dname = ? limit ?,? ";
        ps = conn.prepareStatement(sql);
        ps.setString(1,input);
        ps.setInt(2,pageBean.getStartNum());
        ps.setInt(3,pageBean.getPageSize());
        rs  = ps.executeQuery();
        List<Dept> list = new ArrayList<>();
        while (rs.next()){
            list.add(new Dept(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8)
            ));
        }
        pageBean.setPageData(list);
        rs.close();
        ps.close();
        conn.close();
        return pageBean;
    }

    /**
     * 根据类型进行查询
     * @param page
     * @param size
     * @param input
     * @return
     * @throws SQLException
     */
    @Override
    public PageBean<Dept> findByDtype(int page, int size, String input) throws SQLException {
        PageBean<Dept> pageBean = new PageBean<>();
        pageBean.setTotalCount(getCountByDtype(input));
        if (page<1)
            page = 1;
        else if(page > pageBean.getTotalPage())
            page = pageBean.getTotalPage();
        pageBean.setCurrentPage(page);     // 设置当前页
        pageBean.setPageSize(size);        // 设置每页数据的个数
        conn = C3p0Db.getConn();
        String sql = " select * from dept where dtype = ? limit ?,? ";
        ps = conn.prepareStatement(sql);
        ps.setString(1,input);
        ps.setInt(2,pageBean.getStartNum());
        ps.setInt(3,pageBean.getPageSize());
        rs  = ps.executeQuery();
        List<Dept> list = new ArrayList<>();
        while (rs.next()){
            list.add(new Dept(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8)
            ));
        }
        pageBean.setPageData(list);
        rs.close();
        ps.close();
        conn.close();
        return pageBean;
    }

    /**
     * 查询该部门下的员工
     * @param name
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageBean<Per> queryDeptPer(String name, int page, int size) throws SQLException {
        PageBean<Per> pageBean = new PageBean<>();
        pageBean.setTotalCount(queryCount(name));
        if (page<1)
            page = 1;
        else if(page > pageBean.getTotalPage())
            page = pageBean.getTotalPage();
        pageBean.setCurrentPage(page);     // 设置当前页
        pageBean.setPageSize(size);        // 设置每页数据的个数
        conn = C3p0Db.getConn();
        String sql = " select * from dept d,talent_pool t where t.pdep = ? and d.dname = ? limit ?,? ";
        ps = conn.prepareStatement(sql);
        ps.setString(1,name);
        ps.setString(2,name);
        ps.setInt(3,pageBean.getStartNum());
        ps.setInt(4,pageBean.getPageSize());
        rs = ps.executeQuery();
        List<Per> list = new ArrayList<>();
        while (rs.next()){
            list.add(new Per(
                    rs.getInt("pdeptno"),
                    rs.getInt("pno"),
                    rs.getString("pname"),
                    rs.getString("psex"),
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
     * 删除之前查询是否存在
     * @param name
     * @return
     * @throws SQLException
     */
    @Override
    public List<Per> queryPerForDel(String name) throws SQLException {
        conn = C3p0Db.getConn();
        String sql = " select * from dept d,talent_pool t where t.pdep = ? and d.dname = ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1,name);
        ps.setString(2,name);
        rs = ps.executeQuery();
        List<Per> list = new ArrayList<>();
        Per per = new Per();
        while (rs.next()){
            per.setPdeptno(rs.getInt("pdeptno"));
            per.setPdep(rs.getString("pdep"));
            list.add(per);
        }
        rs.close();
        ps.close();
        conn.close();
        return list;
    }

    /**
     * 查询该部门下的员工记录数
     * @param name
     * @return
     * @throws SQLException
     */
    public int queryCount(String name) throws SQLException {
        conn = C3p0Db.getConn();
        String sql = " select count(*)  from dept d,talent_pool t where t.pdep = ? and d.dname = ? ";
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
     * 分页查询
     * @param page
     * @return
     * @throws SQLException
     */
    @Override
    public PageBean<Dept> findAll(int page,int size) throws SQLException {

        PageBean<Dept> pageBean = setPage(page, size);
        conn = C3p0Db.getConn();
        String sql = " select * from dept limit ?,?";
        ps = conn.prepareStatement(sql);
        ps.setInt(1,pageBean.getStartNum());   // 起始页
        ps.setInt(2,pageBean.getPageSize());   // 每页的数据个数
        rs = ps.executeQuery();
        List<Dept> dept = new ArrayList<>();
        while (rs.next()){
            dept.add(new Dept(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8)
            ));
        }
        pageBean.setPageData(dept);
        rs.close();
        ps.close();
        conn.close();
        return pageBean;
    }

    /**
     * 对部门编号，名称查询时的分页操作
     * @param page
     * @param size
     * @return
     * @throws SQLException
     */
    public PageBean<Dept> setPageByNameOrNo(int page,int size) throws SQLException{
        PageBean<Dept> pageBean = new PageBean<>();
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
     * 分页操作
     * @param page
     * @param size
     * @return
     * @throws SQLException
     */
    public PageBean<Dept> setPage(int page,int size) throws SQLException {
        PageBean<Dept> pageBean = new PageBean<>();
        pageBean.setTotalCount(getCount());
        if (page<1)
            page = 1;
        else if(page > pageBean.getTotalPage())
            page = pageBean.getTotalPage();
        pageBean.setCurrentPage(page);     // 设置当前页
        pageBean.setPageSize(size);        // 设置每页数据的个数
        return pageBean;
    }

    /**
     * 查询同一类型部门的总记录数
     * @return
     * @throws SQLException
     */
    @Override
    public int getCountByDtype(String input) throws SQLException {
        conn = C3p0Db.getConn();
        String sql = " select count(*) from dept where dtype = ?";
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
     * @throws SQLException
     */
    @Override
    public int getCount() throws SQLException {
        conn = C3p0Db.getConn();
        String sql = " select count(*) from dept ";
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
     * 删除所选择的部门
     * @param id
     */
    @Override
    public void deletedById(int id) throws SQLException {

        conn = C3p0Db.getConn();
        String sql = " delete from dept where deptno=?";
        ps = conn.prepareStatement(sql);
        ps.setInt(1,id);
        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    /**
     * 修改部门数据
     * @param dept
     */
    @Override
    public void updateDept(Dept dept) throws SQLException {

        conn = C3p0Db.getConn();
        String sql = " update dept set dname=?,dtype=?,dtel=?,demail=?,dmiaoshu=?,ddescribe=? where deptno = ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1,dept.getDname());
        ps.setString(2,dept.getDtype());
        ps.setString(3,dept.getDtel());
        ps.setString(4,dept.getDemail());
        ps.setString(5,dept.getDmiaoshu());
        ps.setString(6,dept.getDdescribe());
        ps.setInt(7,dept.getDeptno());
        ps.executeUpdate();
        ps.close();
        conn.close();
    }
}
