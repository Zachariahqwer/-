package com.itzyh.controller;

import com.google.gson.Gson;
import com.itzyh.bean.User;
import com.itzyh.service.IHrService;
import com.itzyh.service.impl.HrServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/HrServlet")
public class HrServlet extends HttpServlet {

    IHrService hs = new HrServiceImpl();
    Gson gson = new Gson();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String user = request.getParameter("username");
        String pwd = request.getParameter("password");
        String realName = request.getParameter("name");
        System.out.println(user);
        System.out.println(pwd);
        System.out.println(realName);
//        HttpSession session = request.getSession();
        try {
            User u = hs.Login(user, pwd, realName);
            System.out.println("查询："+u);
            if (u == null){
                response.getWriter().write("登录错误");
            }else {
                String uStr = gson.toJson(u);
                System.out.println(uStr);
                response.getWriter().write(uStr);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
