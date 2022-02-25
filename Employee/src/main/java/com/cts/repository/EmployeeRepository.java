package com.cts.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cts.model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, Integer>{

}
