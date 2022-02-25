package com.cts.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.model.Student;
import com.cts.repository.StudentRepository;
@Service
public class StudentServiceImplementation implements StudentService{
	@Autowired
	StudentRepository studentRepository;

	@Override
	public String addstudent(Student student) {
		studentRepository.save(student);
		// TODO Auto-generated method stub
		return "Student add";
	}

	@Override
	public List<Student> viewStudents() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	public String deletestudent(int id) {
		studentRepository.deleteById(id);
		return "student with id:"+id+"deleted";
	}

}
