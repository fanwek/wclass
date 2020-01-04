package com.c.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.c.beans.Student;


public class StudentDao extends BaseDao{
    public Student login(String username,String password){
		// TODO 自动生成的方法存根
		Student s = null;
		try {
			Connection conn = dataSource.getConnection();
		String sql = "select sno,sname,spassword from student where sno = ? and spassword = ?";
		PreparedStatement ps =  conn.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			s = new Student();
			s.setSno(rs.getString("sno"));
			s.setSname(rs.getString("sname"));
			s.setSpassword(rs.getString("spassword"));
		}
		
		return s;
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}
    
    public Student pick(){
  		// TODO 自动生成的方法存根
  		Student s = null;
  		try {
  			Connection conn = dataSource.getConnection();
  		String sql = "select * from student  order by rand() limit 1";
  		PreparedStatement ps =  conn.prepareStatement(sql);
  		
  		ResultSet rs = ps.executeQuery();

  		if (rs.next()) {
  			s = new Student();
  			s.setSno(rs.getString("sno"));
  			s.setSname(rs.getString("sname"));
  			s.setSpassword(rs.getString("spassword"));
  		}
  		
  		return s;
  		} catch (Exception e) {
  			// TODO 自动生成的 catch 块
  			e.printStackTrace();
  		}
  		return null;
  	}
}
