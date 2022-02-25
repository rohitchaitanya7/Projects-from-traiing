package com.cts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.cts.exception.Employeenotfound;
import com.cts.model.Employee;
import com.cts.model.EmployeeUpdate;
import com.cts.repository.EmployeeRepository;

@Service
public class EmployeeServiceImplementation implements Employeeservices {


	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	MongoTemplate mongotemp;

	@Override
	public String saveEmployee(Employee employee) {
		employeeRepository.save(employee);
		return "employee add with id :" + employee.getId();
	}

	@Override
	public String deleteEmployee(int id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if (employee.isPresent()) {
			employeeRepository.deleteById(id);
			return "employee deleted with id :" + id;
		}
		return "Employee with id :" + id + " not found";

	}

	@Override
	public String deleteAllEmployees() {
		employeeRepository.deleteAll();
		return "all employees deleted";
	}

	@Override
	public Employee updateEmployee(int id, EmployeeUpdate employeeUpdate) throws Employeenotfound {
		Optional<Employee> employee = employeeRepository.findById(id);
		if (employee.isPresent()) {
			Employee emp = employee.get();
			emp.setId(id);
			if (employeeUpdate.getName() != null) {
				emp.setName(employeeUpdate.getName());
			}
			if (employeeUpdate.getDepartment() != null) {
				emp.setDepartment(employeeUpdate.getDepartment());
			}
			return employeeRepository.save(emp);
		} else
			throw new Employeenotfound("User Not Found");
	}

	@Override
	public List<Employee> highestSalary(int num) {

		//List<Employee> list = employeeRepository.findAll(orderB);
		//List<Employee> ordersalary = new ArrayList<Employee>();
       // ordersalary = list.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).limit(num).collect(Collectors.toList());
      //return ordersalary.subList(0,5);
		
        
        Query query = new Query();
        query.with(Sort.by(Sort.Direction.DESC, "salary")).limit(num);
        List<Employee> highrstsalary = mongotemp.find(query,Employee.class);
        return highrstsalary;
		
		
		
		
		
		//=============================
		
//		Query query = new Query().with(Sort.by(Sort.Order.desc("salary"))).limit(2); 
//		 List<Employee> find = tem.find(query, Employee.class);
//		 for (Employee employee : find) {
//			 System.out.print(employee);
//		}
//		Example<Employee> example = Example.of(Employee emp){
//			
//		}
//		int maxSalary = hrs.stream().map(Employee::getSalary).max(Integer::compare).get();
//		System.out.println("Max salary of the HR:" + maxSalary);
//		//print max salaried HRs
//		System.out.println("max salaried HRs");
//		hrs.stream().filter(emp->emp.getSalary()==maxSalary).forEach(System.out::println);
	}



	@Override
	public List<Employee> findById() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Page<Employee> highestSalaryinRange(int start, int end, int number) {
		return employeeRepository.findByIdBetween(start,end,PageRequest.of(0, number, Sort.by("salary").descending()));
		//return  employeeRepository.findAll(PageRequest.of(0, end-start, Sort.by("salary").descending()));
	}

}
