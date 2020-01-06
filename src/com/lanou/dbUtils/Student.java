package com.lanou.dbUtils;

public class Student {
	
	private int sid;
	
	private int snum;
	
	private String sname;
	
	private String ssex;

	private int sage;
	
	private String smajor;
	
	private String sphone;
	public int getSnum() {
		return snum;
	}
	public void setSnum(int snum) {
		this.snum = snum;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSsex() {
		return ssex;
	}
	public void setSsex(String ssex) {
		this.ssex = ssex;
	}
	public int getSage() {
		return sage;
	}
	public void setSage(int sage) {
		this.sage = sage;
	}
	public String getSmajor() {
		return smajor;
	}
	public void setSmajor(String smajor) {
		this.smajor = smajor;
	}
	public String getSphone() {
		return sphone;
	}
	public void setSphone(String sphone) {
		this.sphone = sphone;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	
	public Student(int sid, int snum, String sname, String ssex, int sage, String smajor, String sphone) {
		super();
		this.sid = sid;
		this.snum = snum;
		this.sname = sname;
		this.ssex = ssex;
		this.sage = sage;
		this.smajor = smajor;
		this.sphone = sphone;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", snum=" + snum + ", sname=" + sname + ", ssex=" + ssex + ", sage=" + sage
				+ ", smajor=" + smajor + ", sphone=" + sphone + "]";
	}
	
	
	
	
}
