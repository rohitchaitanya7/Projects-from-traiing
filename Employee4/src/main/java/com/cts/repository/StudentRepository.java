package com.cts.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cts.model.Student;

public interface StudentRepository extends MongoRepository<Student, Integer>{
	


}
