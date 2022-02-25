package cts.com.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Maxsalary {

	public static void main(String[] args) {

		EmployeesDetails employees = new EmployeesDetails();
		Student student = new Student();
		//list of employees
		//filtering  hrs
		List<Employee> hrs = employees.Details().stream().filter(emp -> emp.getDepartment() == "HR").collect(Collectors.toList());
		//find max salary
		int maxSalary = hrs.stream()
				.map(Employee::getSalary)
				.max(Integer::compare).get();
				
				
				
		System.out.println("Max salary of the HR:" + maxSalary);
		//print max salaried HRs
		System.out.println("max salaried HRs");
		hrs.stream().filter(emp->emp.getSalary()==maxSalary).forEach(System.out::println);
		
//		details.stream().filter(emp-> emp.getDepartment()=="HR").
//		filter(emp -> emp.getSalary() == maxSalary).forEach(System.out::println);
		System.out.println("test test============");
		hrs.stream().map(Employee::getSalary).collect(Collectors.toList()).forEach(System.out::println);

	}

}