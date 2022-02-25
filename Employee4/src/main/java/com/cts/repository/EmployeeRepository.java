package com.cts.repository;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.cts.model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, Integer>{
//	@Query(value = "{'salary':'$gt: 0?'}")
//	List<Employee> highestSalary(int sal);
	
	//List<Employee> findById();
	@Query("{salary : {$lt : ?0, $gt : ?1}}")
	List<Employee> findEmployeeBySalaryRangeAndSort(double maxSalary, double minSalary, Sort sort);
	
	List<Employee> findByIdBetween(int from, int to);

	Page<Employee> findByIdBetween(int start, int end, PageRequest of);

}
