package com.itzyh.service.impl;

import com.itzyh.bean.Dept;
import com.itzyh.bean.Per;
import com.itzyh.dao.IDeptDao;
import com.itzyh.dao.impl.DeptDaoImpl;
import com.itzyh.service.IDeptService;
import com.itzyh.utils.PageBean;

import java.sql.SQLException;
import java.util.List;

/**
 * 部门的服务处接口实现类
 */
public class DeptServiceImpl implements IDeptService {

    IDeptDao idd = new DeptDaoImpl();

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

        return idd.newDept(dept,dname,dtype,dtel,demail,dmiaoshu,ddescribe,ddate);
    }

    /**
     * 条件查询，编号
     * @param page
     * @param size
     * @param input
     * @return
     * @throws SQLException
     */
    @Override
    public PageBean<Dept> findByDeptno(int page, int size, int input) throws SQLException {

        return idd.findByDeptno(page,size,input);
    }

    /**
     * 根据名称查询
     * @param page
     * @param size
     * @param input
     * @return
     * @throws SQLException
     */
    @Override
    public PageBean<Dept> findByDname(int page, int size, String input) throws SQLException {
        return idd.findByDname(page, size, input);
    }

    /**
     * 根据类型查询
     * @param page
     * @param size
     * @param input
     * @return
     * @throws SQLException
     */
    @Override
    public PageBean<Dept> findByDtype(int page, int size, String input) throws SQLException {
        return idd.findByDtype(page,size,input);
    }

    /**
     * 查询该部门下的员工
     * @param name
     * @param page
     * @param size
     * @return
     * @throws SQLException
     */
    @Override
    public PageBean<Per> queryDeptPer(String name, int page, int size) throws SQLException {
        return idd.queryDeptPer(name,page,size);
    }

    /**
     * 删除之前查询
     * @param name
     * @return
     * @throws SQLException
     */
    @Override
    public List<Per> queryPerForDel(String name) throws SQLException {
        return idd.queryPerForDel(name);
    }

//    /**
//     * 查询所有
//     * @return
//     */
//    @Override
//    public List<Dept> find() throws SQLException {
//        return idd.find();
//    }


    /**
     * 分页查询
     * @param page
     * @param size
     * @return
     * @throws SQLException
     */
    @Override
    public PageBean<Dept> finaAll(int page,int size) throws SQLException {
        return idd.findAll(page,size);
    }

    /**
     * 删除被选中的部门
     * @param id
     */
    @Override
    public void deletedById(int id) throws SQLException {

        idd.deletedById(id);
    }

    /**
     * 修改部门信息
     * @param dept
     */
    @Override
    public void updateDept(Dept dept) throws SQLException {

        idd.updateDept(dept);
    }
}
