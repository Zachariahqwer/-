package com.itzyh.dao;


import com.itzyh.bean.Dept;
import com.itzyh.bean.Per;
import com.itzyh.utils.PageBean;

import java.sql.SQLException;
import java.util.List;


/**
 * 部门的持久层接口
 */
public interface IDeptDao {

    // 新建部门时，信息全填
    int newDept(int dept, String dname, String dtype, String dtel, String demail, String dmiaoshu, String ddescribe, String ddate) throws SQLException;

    // 根据编号进行查询
    PageBean<Dept> findByDeptno(int page,int size,int input) throws SQLException;

    // 根据名称进行查询
    PageBean<Dept> findByDname(int page,int size,String input) throws SQLException;

    // 根据类型进行查询
    PageBean<Dept> findByDtype(int page,int size,String input) throws SQLException;

    // 查询该部门下的员工
    PageBean<Per> queryDeptPer(String name,int page, int size) throws SQLException;

    // 删除之前先查询该部门下是否有员工
    List<Per> queryPerForDel(String name) throws SQLException;

    // 查询所有带分页
    PageBean<Dept> findAll(int page,int size) throws SQLException;

    // 查询类型的总记录数
    int getCountByDtype(String input) throws SQLException;

    // 查询总记录数
    int getCount() throws SQLException;

    // 删除所选中的部门
    void deletedById(int id) throws SQLException;

    // 修改部门数据
    void updateDept(Dept dept) throws SQLException;


}
