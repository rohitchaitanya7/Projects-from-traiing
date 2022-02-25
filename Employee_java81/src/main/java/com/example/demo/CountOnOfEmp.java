package com.example.demo;

public class CountOnOfEmp {
	
	public void countNoEmp(String s) {
	
		EmployeesDetails employees = new EmployeesDetails();
		
		long couunt = employees.Details().stream().filter(e->e.getName().startsWith(s)).count();
		System.out.println(couunt);
	}

}
