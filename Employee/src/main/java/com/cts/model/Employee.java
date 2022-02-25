package com.cts.model;

import javax.validation.constraints.NotBlank;


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
public class Employee {
	@Id
	private int id;
	@NotBlank(message = "name is a Mandatory filed")
	private String name;
	@NotBlank(message = "department is a Mandatory filed")
	private String department;
	@NotBlank(message = "email is a Mandatory filed")
	private String email;
	private double salary;
	private int experience;

}
