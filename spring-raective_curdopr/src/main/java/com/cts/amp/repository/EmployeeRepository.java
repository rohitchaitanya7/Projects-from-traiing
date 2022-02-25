package com.cts.amp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cts.amp.model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, Integer>
{

}
