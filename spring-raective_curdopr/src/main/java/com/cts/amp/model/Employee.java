package com.cts.amp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Employee")
public class Employee 
{
	
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;
	private int age;
	private String name;
	private String salary;
	private String degination;
	

}
