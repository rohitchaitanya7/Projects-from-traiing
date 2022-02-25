package com.cts.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.cts.model.Employee;
import com.cts.model.EmployeeUpdate;

@Service
public interface Employeeservices {

	String saveEmployee(Employee employee);

	String deleteEmployee(int id) throws Exception;

	String deleteAllEmployees();

	Employee updateEmployee(int id, EmployeeUpdate employeeUpdate) throws Exception;

	List<Employee> findById();

	List<Employee> highestSalary(int num);

	Page<Employee> highestSalaryinRange(int start, int end, int number);

}
