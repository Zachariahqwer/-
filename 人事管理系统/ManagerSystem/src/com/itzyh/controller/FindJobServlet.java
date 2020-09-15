package com.itzyh.controller;

import com.google.gson.Gson;
import com.itzyh.bean.Job;
import com.itzyh.bean.Per;
import com.itzyh.service.IJobService;
import com.itzyh.service.impl.JobServiceImpl;
import com.itzyh.utils.PageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/FindJobServlet")
public class FindJobServlet extends HttpServlet {

    IJobService ijs = new JobServiceImpl();
    Gson gson = new Gson();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String methods = request.getParameter("method");
        switch (methods){
            // 分页查询所有
            case "findJobAll":
                findJob(request,response);
                break;
            // 输入查询
            case "find":
                findJobBy(request,response);
                break;
            case "queryPer":
                queryJobPer(request,response);
                break;
        }

    }

    /**
     * 查询该岗位下的员工
     * @param request
     * @param response
     */
    private void queryJobPer(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("queryJName");
        Integer no = Integer.parseInt(request.getParameter("queryJNo"));
        System.out.println("前端："+name);
        System.out.println("前端："+no);
        int page = Integer.parseInt(request.getParameter("currentPage"));
        int size = Integer.parseInt(request.getParameter("size"));
        PageBean<Per> per = null;
        try {
            per = ijs.queryJobPer(name,no,page,size);
            String perStr = gson.toJson(per);
            response.getWriter().write(perStr);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 输入查询
     * @param request
     * @param response
     */
    private void findJobBy(HttpServletRequest request, HttpServletResponse response) {
        String in_radios = request.getParameter("in_radio");
        System.out.println("多选框："+in_radios);
        switch (in_radios){
            case "1":
                // 编号查询
                findJobByJno(request,response);
                break;
            case "2":
                // 名称查询
                findJobByJname(request,response);
                break;
            case "3":
                // 岗位查询
                findJobByJtype(request,response);
                break;
        }

    }

    /**
     * 岗位类型查询
     * @param request
     * @param response
     */
    private void findJobByJtype(HttpServletRequest request, HttpServletResponse response) {
        Integer page = Integer.parseInt(request.getParameter("currentpage"));
        Integer size = Integer.parseInt(request.getParameter("size"));
        String input = request.getParameter("input");
        System.out.println("类型："+input);
        PageBean<Job> jobByJtype = null;
        try {
            jobByJtype = ijs.findJobByJtype(page,size,input);
            String jobByJtypeStr = gson.toJson(jobByJtype);
            response.getWriter().write(jobByJtypeStr);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 名称查询
     * @param request
     * @param response
     */
    private void findJobByJname(HttpServletRequest request, HttpServletResponse response) {
        Integer page = Integer.parseInt(request.getParameter("currentpage"));
        Integer size = Integer.parseInt(request.getParameter("size"));
        String input = request.getParameter("input");
        PageBean<Job> jobByJname = null;
        try {
            jobByJname = ijs.findJobByJname(page,size,input);
            String jobByJnameStr = gson.toJson(jobByJname);
            response.getWriter().write(jobByJnameStr);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 编号查询
     * @param request
     * @param response
     */
    private void findJobByJno(HttpServletRequest request, HttpServletResponse response) {

        Integer page = Integer.parseInt(request.getParameter("currentpage"));
        Integer size = Integer.parseInt(request.getParameter("size"));
        Integer input = Integer.parseInt(request.getParameter("input"));
        System.out.println("编号："+input);
        PageBean<Job> jobByJno = null;
        try {
            jobByJno = ijs.findJobByJno(page,size,input);
            String jobByJnoStr = gson.toJson(jobByJno);
            response.getWriter().write(jobByJnoStr);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 分页查询所有
     * @param request
     * @param response
     */
    private void findJob(HttpServletRequest request, HttpServletResponse response) {

        Integer page = Integer.parseInt(request.getParameter("currentPage"));
        Integer size = Integer.parseInt(request.getParameter("size"));
        PageBean<Job> jobs = null;
        try {
            jobs = ijs.findJobAll(page,size);
            String jobAllStr = gson.toJson(jobs);
            response.getWriter().write(jobAllStr);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
