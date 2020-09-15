package com.itzyh.controller;

import com.google.gson.Gson;
import com.itzyh.bean.Dept;
import com.itzyh.bean.Per;
import com.itzyh.service.IDeptService;
import com.itzyh.service.impl.DeptServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * 部门表控制层
 */
@WebServlet("/DeptServlet")
public class DeptServlet extends HttpServlet {

    IDeptService ids = new DeptServiceImpl();
    Gson gson = new Gson();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String methods = request.getParameter("method");
        switch (methods){
            case "addDep":
                new_Dept(request,response);
                break;
            case "del":
                deleted(request,response);
                break;
            case "updata":
                updataDept(request,response);
                break;
        }
    }

    /**
     * 更新部门
     * @param request
     * @param response
     */
    private void updataDept(HttpServletRequest request, HttpServletResponse response) {

        Integer deptno = Integer.parseInt(request.getParameter("deptno"));
        String dname = request.getParameter("dname");
        String dtype = request.getParameter("dtype");
        String dtel = request.getParameter("dtel");
        String demail = request.getParameter("demail");
        String dmiaoshu = request.getParameter("dmiaoshu");
        String ddescribe = request.getParameter("ddescribe");
        String ddate1 = request.getParameter("ddate");
        if (demail == null)
            demail = "无";
        if (dmiaoshu == null)
            dmiaoshu = "无";
        if (ddescribe == null)
            ddescribe = "无";
        Dept dept = new Dept(deptno,dname,dtype,dtel,demail,dmiaoshu,ddescribe,ddate1);

        System.out.println(dept);

        try {
            ids.updateDept(dept);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * 删除部门
     * @param request
     * @param response
     */
    private void deleted(HttpServletRequest request, HttpServletResponse response) {

        String name = request.getParameter("dname");
        System.out.println("前端："+name);
        String index = request.getParameter("id");
        int id = Integer.parseInt(index);
        try {
            List<Per> list = ids.queryPerForDel(name);
            // 判断list集合不为空
            if (list != null && !list.isEmpty()){
                for (Per per:list){
                    System.out.println(per);
                    String pname = per.getPdep();
                    System.out.println("后端："+pname);
                    if (name.equals(pname)){
                        System.out.println("有员工");
                        response.getWriter().write("yes");
                        break;
                    }
                }
            }else {
                ids.deletedById(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    /**
     * 新建部门
     * @param request
     * @param response
     */
    private void new_Dept(HttpServletRequest request, HttpServletResponse response) {

        Integer dept = Integer.parseInt(request.getParameter("deptno")) ;
        String dname = request.getParameter("dname");
        String dtype = request.getParameter("dtype");
        String dtel = request.getParameter("dtel");
        String demail = request.getParameter("demail");
        String dmiaoshu = request.getParameter("dmiaoshu");
        String ddescribe = request.getParameter("ddescribe");
        String ddate1 = request.getParameter("ddate");

        if (demail == null)
            demail = "无";
        if (dmiaoshu == null)
            dmiaoshu = "无";
        if (ddescribe == null)
            ddescribe = "无";
        System.out.println(demail);
        System.out.println(dmiaoshu);
        System.out.println(ddescribe);
        try {
            int code = ids.newDept(dept, dname, dtype, dtel,demail,dmiaoshu,ddescribe, ddate1);
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
