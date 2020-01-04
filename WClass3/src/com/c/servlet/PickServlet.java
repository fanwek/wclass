package com.c.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.c.beans.Student;
import com.c.dao.StudentDao;

public class PickServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	doPost(req, resp);
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		StudentDao studentDao = new StudentDao();
		Student s = studentDao.pick();
		resp.setContentType("text/html; charset=utf-8");
		req.setAttribute("student", s);
		req.getRequestDispatcher("pickresult.jsp").forward(req, resp);
	}
}