package com.cts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
