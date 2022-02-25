package com.bms.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="login_details")
@AllArgsConstructor
@NoArgsConstructor
public class CustomerData {
	@Id
	@NotBlank(message = "Username is mandatory ")
	@Pattern(regexp = "[a-zA-Z0-9]*$", message = "user name should contain only alphabets and digits")
	private String username;
	@NotBlank(message = "Password is mandatory")
	@Size(min = 8, message = "minimum 8 Characters required")
	@Column
	private String password;
	@JsonIgnore
	@Column
	private String roles;
	@JsonIgnore
	@Column
	private boolean active;
	@Transient
	private String authToken;
}
