package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {

	
	private long id;
	private String name;
	private int salary;
	private String department;

	
}