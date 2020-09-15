package com.itzyh.controller;

import com.google.gson.Gson;
import com.itzyh.bean.Dept;
import com.itzyh.bean.Per;
import com.itzyh.service.IDeptService;
import com.itzyh.service.impl.DeptServiceImpl;
import com.itzyh.utils.PageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/FindServlet")
public class FindServlet extends HttpServlet {

    IDeptService ids = new DeptServiceImpl();
    Gson gson = new Gson();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String methods = request.getParameter("method");
        switch (methods){
            case "findPage":
                findDeptAll(request,response);
                break;
            case "findByDno":
                findBy(request,response);
                break;
            case "queryPer":
                queryDeptPer(request,response);
                break;
//            case "findAll":
//                find(request,response);
//                break;
        }
    }

    /**
     * 查询该部门下的员工
     * @param request
     * @param response
     */
    private void queryDeptPer(HttpServletRequest request, HttpServletResponse response) {

        String name = request.getParameter("querydname");
        int page = Integer.parseInt(request.getParameter("currentpage"));
        int size = Integer.parseInt(request.getParameter("size"));
        PageBean<Per> per = null;
        try {
            per = ids.queryDeptPer(name,page,size);
            String perStr = gson.toJson(per);
            response.getWriter().write(perStr);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 条件查询
     * @param request
     * @param response
     */
    private void findBy(HttpServletRequest request, HttpServletResponse response) {

        String in_radios = request.getParameter("in_radio");
        System.out.println("前端radio"+in_radios);
        switch (in_radios){
            case "1":
                // 编号查询
                findDeptByNo(request,response);
                break;
            case "2":
                // 名称查询
                findDeptByDname(request,response);
                break;
            case "3":
                // 岗位查询
                findDeptByType(request,response);
                break;
        }
    }

    /**
     * 根据部门类型进行查询
     * @param request
     * @param response
     */
    private void findDeptByType(HttpServletRequest request, HttpServletResponse response) {

        Integer page = Integer.parseInt(request.getParameter("currentpage"));
        Integer size = Integer.parseInt(request.getParameter("size"));
        String input = request.getParameter("input");
        System.out.println("类型："+input);
        PageBean<Dept> deptBytype = null;
        try {
            deptBytype = ids.findByDtype(page,size,input);
            String deptBytypeStr = gson.toJson(deptBytype);
            response.getWriter().write(deptBytypeStr);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据编号查询
     * @param request
     * @param response
     */
    private void findDeptByNo(HttpServletRequest request, HttpServletResponse response){

        Integer page = Integer.parseInt(request.getParameter("currentpage"));
        Integer size = Integer.parseInt(request.getParameter("size"));
        Integer input = Integer.parseInt(request.getParameter("input"));
        System.out.println("编号："+input);
        PageBean<Dept> dept = null;
        try {
            dept = ids.findByDeptno(page, size, input);

            String deptStr = gson.toJson(dept);    // 转成字符串
            response.getWriter().write(deptStr);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据名称进行查询
     * @param request
     * @param response
     */
    private void findDeptByDname(HttpServletRequest request,HttpServletResponse response){

        Integer page = Integer.parseInt(request.getParameter("currentpage"));
        Integer size = Integer.parseInt(request.getParameter("size"));
        String inputStr = request.getParameter("input");
        System.out.println("前端获取："+inputStr);
        PageBean<Dept> dept = null;
        try {
            dept = ids.findByDname(page, size, inputStr);
            String deptStr = gson.toJson(dept);    // 转成字符串
            System.out.println(deptStr);
            response.getWriter().write(deptStr);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询所有部门
     * @param request
     * @param response
     */
    private void findDeptAll(HttpServletRequest request, HttpServletResponse response) {

        String currentpageStr = request.getParameter("currentpage");
        String sizeStr = request.getParameter("size");

        Integer currentpage = Integer.parseInt(currentpageStr);
        int page = currentpage;
        Integer size = Integer.parseInt(sizeStr);

        PageBean<Dept> depts = null;
        try {
            depts = ids.finaAll(page,size);

            String deptStr = gson.toJson(depts);

            // 向前端写入数据
            response.getWriter().write(deptStr);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
