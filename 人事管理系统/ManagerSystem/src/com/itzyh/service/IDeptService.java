package com.itzyh.service;

import com.itzyh.bean.Dept;
import com.itzyh.bean.Per;
import com.itzyh.utils.PageBean;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/**
 * 部门的服务处接口
 */
public interface IDeptService {


    // 新建部门时，信息全填
    int newDept(int dept, String dname, String dtype, String dtel,String demail,String dmiaoshu,String ddescribe, String ddate) throws SQLException;

    // 根据编号进行查询部门
    PageBean<Dept> findByDeptno(int page,int size,int input) throws SQLException;

    // 根据名称进行查询
    PageBean<Dept> findByDname(int page,int size,String input) throws SQLException;

    // 根据类型进行查询
    PageBean<Dept> findByDtype(int page,int size,String input) throws SQLException;

    // 查询该岗位下的员工
    PageBean<Per> queryDeptPer(String name,int page,int size) throws SQLException;

    // 删除之前查询该部门下是否存在员工
    List<Per> queryPerForDel(String name) throws SQLException;

//    // 查询所有
//    List<Dept> find() throws SQLException;

    // 分页查询
    PageBean<Dept> finaAll(int page,int size) throws SQLException;

    // 删除有关部门
    void deletedById(int id) throws SQLException;

    // 修改部门信息
    void updateDept(Dept dept) throws SQLException;
}
