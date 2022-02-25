package com.cts;
public class HR {

	
	private long id;
	private String name;
	private int salary;
	

	public HR(long id, String name, int salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}



	@Override
	public String toString() {
		return "Employee [id=" + id + "," + " name=" + name + "," + " salary=" + salary + "," + " department="
				+ "]";
	}
}