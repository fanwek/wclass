package com.c.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.c.beans.*;
import com.c.dao.*;

public class LoginServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
    	// TODO 自动生成的方法存根
    	doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
    	// TODO 自动生成的方法存根
    	req.setCharacterEncoding("utf-8");
    	
    	//获取用户名,密码
    	String username = req.getParameter("username");
    	String password = req.getParameter("password");
    	System.out.println(username+" , "+password);
    	
    	resp.setContentType("text/html;charset=utf-8");
    	PrintWriter out =	resp.getWriter();
    	
    	//验证
    	StudentDao studentDao = new StudentDao();
    	TeacherDao teacherDao = new TeacherDao();
    	Student s = studentDao.login(username, password);
    	Teacher t = teacherDao.login(username, password);
    	if (s != null) {
    		req.getRequestDispatcher("s_index.jsp").forward(req, resp);		
		} else if(t != null){
			req.getRequestDispatcher("t_index.jsp").forward(req, resp);
		}else{
			//封装数据
			req.setAttribute("login_msg", "用户名或密码错误！");
			//转发
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			
			
		}
    	
    	
    	
    	
    	
    }
}
