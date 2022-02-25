package com.cts.amp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.amp.model.Employee;
import com.cts.amp.repository.EmployeeRepository;


@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@PostMapping("/addemployee")
	public String AddEmployee(@RequestBody Employee employee) {
		employeeRepository.save(employee);
		return "employee add";
	}
	@GetMapping("/getemployees")
	public List<Employee> getemployees(){
		return employeeRepository.findAll();
	}
	@DeleteMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable int id) {
		employeeRepository.deleteById(id);
		return "employee deleted";
	}
	@PutMapping("/updateEmployee/{id}")
	public String updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
		Employee employee1 = employeeRepository.findById(employee.getId()).orElseThrow();
		employee1.setId(id);
		employee1.setName(employee.getName());
		employee1.setSalary(employee.getSalary());
		employee1.setAge(employee.getAge());
		employee1.setDegination(employee.getDegination());
			 employeeRepository.save(employee1);
			 return "updated";
		} 
	}
	


