package com.example.demo;

import java.util.Comparator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class Maxsalary {
	
    @Autowired
	EmployeesDetails employees;
	//Q3 create a list of employees and sort them based on name and than sort ok based of salary
		public void empSortNameSalary() {
	

			Comparator<Employee> sortonname =  (e1,e2)->e1.getName().compareToIgnoreCase(e2.getName());
			Comparator<Employee> sortsalary = (s1,s2) ->Double.compare(s1.getSalary(), s2.getSalary());
			
			employees.Details().stream().sorted(sortonname.thenComparing(sortsalary))
			.forEach(employee->System.out.println(employee));

	}



		//			employees.Details().stream()
		//						.sorted((e1,e2)->e1.getName()
		//								.compareToIgnoreCase(e2.getName()))
		//									.forEach(System.out::println);

}
