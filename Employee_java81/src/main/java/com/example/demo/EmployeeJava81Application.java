package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeJava81Application {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeJava81Application.class, args);
		
		Maxsalary m = new Maxsalary();
		m.empSortNameSalary();
		
		CountOnOfEmp c = new CountOnOfEmp();
		c.countNoEmp("R");
		
		MapDepToEmployees e = new MapDepToEmployees();
		e.mapDepToEmp();
		
	}

}
