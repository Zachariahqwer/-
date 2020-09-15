package com.itzyh.controller;

import com.google.gson.Gson;
import com.itzyh.bean.DeparTrue;
import com.itzyh.bean.DeptBao;
import com.itzyh.bean.JobBao;
import com.itzyh.service.ITableService;
import com.itzyh.service.impl.TableServiceImpl;
import com.itzyh.utils.PageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/TableServlet")
public class TableServlet extends HttpServlet {

    ITableService its = new TableServiceImpl();
    Gson gson = new Gson();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String methods = request.getParameter("method");
        switch (methods){
            // 调动部门报表
            case "tableDept":
                getTableData(request,response);
                break;
            // 调动岗位报表
            case "tableJob":
                getTableJob(request,response);
                break;
            case "tablePer":
                getTablePer(request,response);
                break;
        }
    }

    /**
     * 员工离职报表
     * @param request
     * @param response
     */
    private void getTablePer(HttpServletRequest request, HttpServletResponse response) {
        Integer page = Integer.parseInt(request.getParameter("currentPage"));
        Integer size = Integer.parseInt(request.getParameter("size"));
        PageBean<DeparTrue> perJob = null;
        try {
            perJob = its.PerTable(page,size);
            String perJobStr = gson.toJson(perJob);
            response.getWriter().write(perJobStr);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 岗位调动报表
     * @param request
     * @param response
     */
    private void getTableJob(HttpServletRequest request, HttpServletResponse response) {
        Integer page = Integer.parseInt(request.getParameter("currentPage"));
        Integer size = Integer.parseInt(request.getParameter("size"));
        PageBean<JobBao> jobTable = null;
        try {
            jobTable = its.jobTable(page, size);
            String jobTableStr = gson.toJson(jobTable);
            response.getWriter().write(jobTableStr);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 部门调动报表
     * @param request
     * @param response
     */
    private void getTableData(HttpServletRequest request, HttpServletResponse response) {
        Integer page = Integer.parseInt(request.getParameter("currentPage"));
        Integer size = Integer.parseInt(request.getParameter("size"));
        System.out.println(page);
        System.out.println(size);
        PageBean<DeptBao> deptTable = null;
        try {
            deptTable = its.tableDept(page,size);
            String deptTableStr = gson.toJson(deptTable);
            System.out.println(deptTableStr);
            response.getWriter().write(deptTableStr);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
