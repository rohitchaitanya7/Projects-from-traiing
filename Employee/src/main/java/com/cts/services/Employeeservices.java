package com.cts.services;

import org.springframework.stereotype.Service;

import com.cts.model.Employee;
import com.cts.model.EmployeeUpdate;

@Service
public interface Employeeservices {

	public String saveEmployee(Employee employee);

	public String deleteEmployee(int id) throws Exception;

	public String deleteAllEmployees();

	public Employee updateEmployee(int id, EmployeeUpdate employeeUpdate) throws Exception;

}
