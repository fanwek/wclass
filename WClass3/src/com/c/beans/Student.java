package com.c.beans;

public class Student {
	 private String sno;
     private String sname;
     private String spassword;
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSpassword() {
		return spassword;
	}
	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}
	@Override
	public String toString() {
		return "StudentBean [sno=" + sno + ", sname=" + sname + ", spassword="
				+ spassword + "]";
	}
     
     
}
