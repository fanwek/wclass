package com.c.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.c.beans.Teacher;

public class TeacherDao extends BaseDao{
   public  Teacher login(String username,String password) {
		// TODO 自动生成的方法存根
		Teacher t = null;
		try {
			Connection conn = dataSource.getConnection();
		String sql = "select tno,tname,tpassword from teacher where tno = ? and tpassword = ?";
		PreparedStatement ps =  conn.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			t = new Teacher();
			t.setTno(rs.getString("tno"));
			t.setTname(rs.getString("tname"));
			t.setTpassword(rs.getString("tpassword"));
		}
		
		return t;
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return null;
	}
   
   
}
