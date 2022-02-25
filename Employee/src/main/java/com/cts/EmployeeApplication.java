package com.cts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cts.services.EmployeeServiceImplementation;

@SpringBootApplication
public class EmployeeApplication {
//	@Autowired
//	static EmployeeServiceImplementation employeeServiceImplementation;

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}
//	public void salarye() {
//		System.out.println(employeeServiceImplementation.salary());
//	}
}
