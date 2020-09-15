package com.itzyh.controller;

import com.google.gson.Gson;
import com.itzyh.bean.Job;
import com.itzyh.bean.Per;
import com.itzyh.service.IJobService;
import com.itzyh.service.impl.JobServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/JobServlet")
public class JobServlet extends HttpServlet {


    Gson gson = new Gson();
    IJobService ijs = new JobServiceImpl();
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String methods = request.getParameter("method");
        switch (methods){
            case "addJ":
                // 新建岗位
                newJobs(request,response);
                break;
            case "del":
                // 删除岗位
                deletedJob(request,response);
                break;
            case "updateJ":
                // 修改岗位
                updateJob(request,response);
        }

    }

    /**
     * 修改岗位
     * @param request
     * @param response
     */
    private void updateJob(HttpServletRequest request, HttpServletResponse response) {

        Integer jno = Integer.parseInt(request.getParameter("jno"));
        String jname = request.getParameter("jname");
        String jtype = request.getParameter("jtype");
        Integer jnum = Integer.parseInt(request.getParameter("jnum"));

        Job job = new Job(jno,jname,jtype,jnum);
        System.out.println(job);
        try {
            ijs.updateJobById(job);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除岗位
     * @param request
     * @param response
     */
    private void deletedJob(HttpServletRequest request, HttpServletResponse response) {

        String name = request.getParameter("jName");
        System.out.println("前端："+name);
        String index = request.getParameter("id");
        int id = Integer.parseInt(index);
        System.out.println(id);
        try {
            List<Per> list = ijs.queryPerForDel(name);
            System.out.println(list);
            // 判断返回的list集合是否为空
            if (list == null || list.size() == 0){
                System.out.println("无员工");
                ijs.deletedJobById(id);
            }else {
                for (Per per:list){
                    String pjob = per.getPjob();
                    System.out.println("后端："+pjob);
                    if (name.equals(pjob)){
                        System.out.println("有员工");
                        response.getWriter().write("yes");
                        break;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 新建岗位
     * @param request
     * @param response
     */
    private void newJobs(HttpServletRequest request, HttpServletResponse response) {

        Integer jno = Integer.parseInt(request.getParameter("jno"));
        String jname = request.getParameter("jname");
        String jtype = request.getParameter("jtype");
        String jnumStr = request.getParameter("jnum");

        Integer jnum = Integer.parseInt(jnumStr);

        try {
            int code = ijs.newJob(jno, jname, jtype,jnum);
            String codeStr = gson.toJson(code);
            response.getWriter().write(codeStr);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
