package cts.com.model;

import java.util.ArrayList;
import java.util.List;

public class EmployeesDetails {

	public List<Employee> Details() {

		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(101, "Rohit", 7000, "IT"));
		employees.add(new Employee(102, "Pavan", 3000, "HR"));
		employees.add(new Employee(103, "Raj", 4400, "IT"));
		employees.add(new Employee(104, "Ganesh", 3000, "FIN"));
		employees.add(new Employee(105, "chaitanya", 32000, "HR"));
		employees.add(new Employee(106, "divya", 4200, "HR"));
		employees.add(new Employee(107, "Venkatesh", 9200, "FIN"));
		employees.add(new Employee(108, "Lucky", 7000, "HR"));
		employees.add(new Employee(109, "venkat", 9200, "FIN"));
		employees.add(new Employee(110, "vamsi", 6200, "FIN"));

		return employees;

	}

}