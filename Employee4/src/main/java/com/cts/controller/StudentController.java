package com.cts.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.model.Student;
import com.cts.services.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService studentService;
	
	
	@PostMapping("/addstudent")
	public String addstudent(@Valid @RequestBody Student student) {
		
		return studentService.addstudent(student);
	}
	@GetMapping("/viewStudents")
	public List<Student> viewStudents() {
		return studentService.viewStudents();
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable int id) {
		return studentService.deletestudent(id);
	}


}
