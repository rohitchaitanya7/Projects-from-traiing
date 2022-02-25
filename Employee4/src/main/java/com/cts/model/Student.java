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
	@Document(collection = "Student")  
	public class Student {
		@Id
		private int id;
		@NotBlank(message = "name is a Mandatory filed")
		private String name;
		@NotBlank(message = "course is a Mandatory filed")
		private String course;
		@NotBlank(message = "email is a Mandatory filed")
		private String email;
}
