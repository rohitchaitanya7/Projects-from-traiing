package cts.com.model;

public class Student {
	
	private String sname;
	private int sID;
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getsID() {
		return sID;
	}
	public void setsID(int sID) {
		this.sID = sID;
	}
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String sname, int sID) {
		super();
		this.sname = sname;
		this.sID = sID;
	}
	
	

}
