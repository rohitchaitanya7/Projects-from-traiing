package com.cts.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cts.model.Student;
@Service
public interface StudentService {

	String addstudent(Student student);

	List<Student> viewStudents();

	String deletestudent(int id);

}
