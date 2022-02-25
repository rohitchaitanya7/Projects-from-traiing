package com.cts.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.model.Employee;
import com.cts.model.Student;
import com.cts.services.EmployeeExcelExporter;
import com.cts.services.Employeeservices;
import com.cts.services.StudentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ExportExcelController {
	
	@Autowired
	Employeeservices employeeServices;
	@Autowired
	StudentService studentService;
	
	@GetMapping("/exportTOExcel")
	public String  exportTOExcel(HttpServletResponse response) throws IOException {
		log.info("seting employee excel header");
		response.setHeader("Content-Disposition", "attachment; filename=users.xlsx");
		
		List<Employee> emp = employeeServices.findById();
		List<Student> student = studentService.viewStudents();
		EmployeeExcelExporter employeeExcelExporter = new EmployeeExcelExporter(emp,student);
		log.info("exporting Employee data to excl");
		 employeeExcelExporter.export(response);
		 
		 return "downloaded";
		
		
	}

}




//response.setContentType("application/ocetet-stream");
//String headerkey = "Content-Disposition";
//String headerValue = "attachment; filename=users.xlsx";
