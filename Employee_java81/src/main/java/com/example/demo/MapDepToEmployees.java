package com.example.demo;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
//Q1 Dp-id : list of employees.
public class MapDepToEmployees {
	
	EmployeesDetails employee = new EmployeesDetails();
	
	public void mapDepToEmp() {
	
		Map<String, List<Employee>> sortemp = employee.Details().stream().collect(Collectors.groupingBy(Employee::getDepartment));
		//System.out.println(sortemp);
		
		sortemp.forEach((k,v) -> System.out.println(k +":"+ v));
	}

}
