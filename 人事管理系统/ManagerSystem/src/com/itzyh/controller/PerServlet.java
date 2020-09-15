package com.itzyh.controller;

import com.google.gson.Gson;
import com.itzyh.bean.*;
import com.itzyh.service.IPerService;
import com.itzyh.service.impl.PerServiceImpl;
import com.itzyh.utils.PageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 员工
 */
@WebServlet("/PerServlet")
public class PerServlet extends HttpServlet {


    IPerService ips = new PerServiceImpl();
    Gson gson = new Gson();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String methods = request.getParameter("method");
        System.out.println(methods);
        switch (methods){
            // 录入员工信息
            case "entry":
                entryPers(request,response);
                break;
            // 分页查询所有员工信息
            case "findAll":
                findByPage(request,response);
                break;
            // 查询试用员工的信息
            case "findAllByShi":
                findByShi(request,response);
                break;
            // 部门调动
            case "moveDept":
                moveDept(request,response);
                break;
            // 岗位调动
            case "moveJob":
                moveJob(request,response);
                break;
            // 离职
            case "dePar":
                deparTrue(request,response);
                break;
        }

    }

    /**
     * 离职
     * @param request
     * @param response
     */
    private void deparTrue(HttpServletRequest request, HttpServletResponse response) {
        Integer pdeptno = Integer.parseInt(request.getParameter("pdeptno"));
        String pdep = request.getParameter("pdep");
        Integer pjobno = Integer.parseInt(request.getParameter("pjobno"));
        String pjob = request.getParameter("pjob");
        Integer pno = Integer.parseInt(request.getParameter("pno"));
        String pname = request.getParameter("pname");
        String psex = request.getParameter("psex");
        String pyongg = request.getParameter("pyongg");
        String pshiyong = request.getParameter("pshiyong");
        String lizhi = request.getParameter("lizhi");
        String ldate = request.getParameter("ldate");
        String ltype = request.getParameter("ltype");

        System.out.println("离职类型"+ltype);
        DeparTrue deparTrue = new DeparTrue(pdeptno,pdep,pjobno,pjob,pno,pname,psex,pyongg,pshiyong,lizhi,ldate,ltype);
        try {
            int code = ips.deparTruePer(deparTrue);
            if (code == 1){
                System.out.println("准备删除");
                System.out.println(pno);
                ips.delByPer(pno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 岗位调动
     * @param request
     * @param response
     */
    private void moveJob(HttpServletRequest request, HttpServletResponse response) {
        Integer pjobNo = Integer.parseInt(request.getParameter("pjobno"));
        String pjob = request.getParameter("pjob");
        Integer nowJobJno = Integer.parseInt(request.getParameter("nowJobjno"));
        String nowJob = request.getParameter("nowJob");
        Integer pno = Integer.parseInt(request.getParameter("pno"));
        String pname = request.getParameter("pname");
        String psex = request.getParameter("psex");
        String pyongg = request.getParameter("pyongg");
        String pshiyong = request.getParameter("pshiyong");
        String btype = request.getParameter("btype");

        JobBao jobBao = new JobBao(pjobNo,pjob,nowJobJno,nowJob,pno,pname,psex,pyongg,pshiyong,btype);
        try {
            int code = ips.jobBao(jobBao);
            if (code == 1){
                ips.jobBaoDo(pjobNo,nowJobJno,nowJob);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 部门调动
     * @param request
     * @param response
     */
    private void moveDept(HttpServletRequest request, HttpServletResponse response) {

        Integer pdeptno = Integer.parseInt(request.getParameter("pdeptno"));
        String pdep = request.getParameter("pdep");
        Integer nowDeptno = Integer.parseInt(request.getParameter("nowDeptno"));
        String nowDept = request.getParameter("nowDept");
        Integer pno = Integer.parseInt(request.getParameter("pno"));
        String pname = request.getParameter("pname");
        String psex = request.getParameter("psex");
        String pyongg = request.getParameter("pyongg");
        String pshiyong = request.getParameter("pshiyong");
        String bdtype = request.getParameter("bdtype");

        DeptBao deptBao = new DeptBao(pdeptno,pdep,pno,pname,psex,nowDeptno,nowDept,pyongg,pshiyong,bdtype);
        try {
            int code = ips.deptBao(deptBao);
            if (code == 1){
                ips.deptBaoDo(pdeptno,nowDeptno,nowDept);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询试用员工的信息
     * @param request
     * @param response
     */
    private void findByShi(HttpServletRequest request, HttpServletResponse response) {

        Integer page = Integer.parseInt(request.getParameter("currentPageS"));
        Integer size = Integer.parseInt(request.getParameter("sizeS"));
        PageBean<Per> pageBean = new PageBean<>();
        pageBean.setPageSize(size);
        PageBean<Per> pers = null;
        try {
            pers = ips.findPerByShi(page, size);
            String perStr = gson.toJson(pers);
            response.getWriter().write(perStr);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询员工信息---分页查询
     * @param request
     * @param response
     */
    private void findByPage(HttpServletRequest request, HttpServletResponse response) {

        Integer page = Integer.parseInt(request.getParameter("currentpage"));
        Integer size = Integer.parseInt(request.getParameter("size"));
        PageBean<Per> pers = null;
        try {
            pers = ips.findPerAll(page, size);
            String perStr = gson.toJson(pers);
            response.getWriter().write(perStr);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 录入员工信息
     * @param request
     * @param response
     */
    private void entryPers(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("录入开始");
        Integer pno = Integer.parseInt(request.getParameter("pno")) ;
        String pname = request.getParameter("pname");
        String psex = request.getParameter("psex");
        String pbirthday = request.getParameter("pbirthday");
        String pidnum = request.getParameter("pidnum");
        Integer pdeptno = Integer.parseInt(request.getParameter("pdeptno"));
        String pdep = request.getParameter("pdep");
        Integer pjobno = Integer.parseInt(request.getParameter("pjobno"));
        String pjob = request.getParameter("pjob");
        String pjoindate = request.getParameter("pjoindate");
        String pjobdate = request.getParameter("pjobdate");
        String pyongg = request.getParameter("pyongg");
        String prlaiyuan = request.getParameter("prlaiyuan");
        String pzhenzhi = request.getParameter("pzhenzhi");
        String pnspace = request.getParameter("pnspace");
        String ptel = request.getParameter("ptel");
        String pemail = request.getParameter("pemail");
        String pmar = request.getParameter("pmar");
        String phighl = request.getParameter("phighl");
        String phighd = request.getParameter("phighd");
        String plearnp = request.getParameter("plearnp");
        String pgdate = request.getParameter("pgdate");
        String pshiyong = request.getParameter("pshiyong");
        String pbshidate = request.getParameter("pbshidate");
        String poshidate = request.getParameter("poshidate");

        System.out.println("名字："+pname);
        if (pzhenzhi == null)
            pzhenzhi = "无";
        if (pnspace == null)
            pnspace = "无";
        if (ptel == null)
            ptel = "无";
        if (pemail == null)
            pemail = "无";
        if (pmar == null)
            pmar = "无";
        if (phighl == null)
            phighl = "无";
        if (phighd == null)
            phighd = "无";
        if (plearnp == null)
            plearnp = "无";
        if (pgdate == null)
            pgdate = "无";
        System.out.println(pzhenzhi);
        Per per = new Per(pno,pdeptno,pname,psex,pbirthday,pidnum,pdep,pjobno,pjob,pjoindate,pjobdate,pyongg,prlaiyuan,pzhenzhi,pnspace,ptel,pemail,pmar,phighl,phighd,plearnp,pgdate,pshiyong,pbshidate,poshidate);
        try {
            ips.entryPer(per);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
