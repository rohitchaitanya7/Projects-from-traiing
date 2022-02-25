package com.cts.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.exception.Employeenotfound;
import com.cts.model.Employee;
import com.cts.model.EmployeeUpdate;
import com.cts.repository.EmployeeRepository;
@Service
public class EmployeeServiceImplementation implements Employeeservices{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public String saveEmployee(Employee employee) {
		employeeRepository.save(employee);
		return "employee add with id :"+ employee.getId();
	}

	@Override
	public String deleteEmployee(int id)  {
		Optional<Employee> employee=employeeRepository.findById(id); 
		if(employee.isPresent()) {
		employeeRepository.deleteById(id);
		return "employee deleted with id :"+ id;
		}
		return "Employee with id :"+id+" not found";
		
	}

	@Override
	public String deleteAllEmployees() {
		employeeRepository.deleteAll();
		return "all employees deleted";
	}

	@Override
	public Employee updateEmployee(int id,EmployeeUpdate employeeUpdate) throws Exception {
		Optional<Employee> employee=employeeRepository.findById(id); 
		if(employee.isPresent()) {
			Employee emp = employee.get();
			emp.setId(id);
			if(employeeUpdate.getName()!= null) {
				emp.setName(employeeUpdate.getName());	
			}
			if(employeeUpdate.getDepartment()!= null) {
				emp.setDepartment(employeeUpdate.getDepartment());
			}
			return employeeRepository.save(emp);
		}
		else
		throw new Exception("User Not Found");
	}



}
