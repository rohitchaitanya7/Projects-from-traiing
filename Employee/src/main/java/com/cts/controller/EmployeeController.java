package com.cts.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.model.Employee;
import com.cts.model.EmployeeUpdate;
import com.cts.services.Employeeservices;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
/**
 * 
 * @author rohit
 *
 */
public class EmployeeController {

	@Autowired
	private Employeeservices employeeServices;
	
	@PostMapping(value = "/addemployee")
	public ResponseEntity<?> addemployee(@Valid @RequestBody Employee employee) {
		log.info("Employee add with id" + employee.getId());
		return new ResponseEntity<>(employeeServices.saveEmployee(employee), HttpStatus.OK);
		
	}

	@DeleteMapping("/deleteemployee/{id}")
	public ResponseEntity<?> deleteemployee(@PathVariable int id) throws Exception {
		try {
			log.info("Employee deleted with id :" + id);
			return new ResponseEntity<>(employeeServices.deleteEmployee(id), HttpStatus.OK);
		} catch (Exception e) {
			log.error("Employee with id :" + id + " dosen't exit");
			return new ResponseEntity<>(employeeServices.deleteEmployee(id), HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping("/deleteemployees")
	public ResponseEntity<?> deleteemployees() {
		log.info("All employees are deleted");
		return new ResponseEntity<>(employeeServices.deleteAllEmployees(), HttpStatus.OK);
	}

	@PatchMapping("/updateEmployee/{id}")
	public ResponseEntity<?> updateEmployee(@PathVariable int id, @RequestBody EmployeeUpdate employeeUpdate) {
		try {
			log.info("employee with id :" + id + "updated");
			return new ResponseEntity<>(employeeServices.updateEmployee(id, employeeUpdate), HttpStatus.OK);
		} catch (Exception e) {
			log.error("Employee with id :" + id + " dosen't exit");
			return new ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND);
		}

	}
}