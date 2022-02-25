package com.bms.controller;


import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.bms.exception.InitialDepositException;
import com.bms.exception.InvalidTokenException;
import com.bms.exception.UnauthorizedException;
import com.bms.exception.UserExistsException;
import com.bms.exception.UserNotFoundException;
import com.bms.model.Customer;
import com.bms.model.ResponseForSuccess;
import com.bms.restclients.AuthFeign;
import com.bms.service.RegisterService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;



@RestController
@Validated
public class BMSRegisterController {

	@Autowired
	private RegisterService registerService;
	
	@Autowired
	private AuthFeign authFeign;
	
	@PostMapping(value = "/customer/register")
	public ResponseEntity<ResponseForSuccess> register(@Valid @RequestBody Customer customer) throws UserExistsException,InitialDepositException{
		
		return registerService.register(customer);
	}
	@HystrixCommand(fallbackMethod = "serviceDown")
	@PutMapping(value = "/customer/{customer_id}/updateDetails")
	public ResponseEntity<ResponseForSuccess> editDetails(@RequestHeader("Authorization") String token,@Valid @RequestBody Customer customer,@PathVariable @Pattern(regexp="^R-[0-9]{3,6}$",message="Customer Id Mismatch") String customer_id) throws InvalidTokenException,UnauthorizedException{
		if (authFeign.getValidity(token).getBody().isValid()) {	
			return registerService.editDetails(token,customer,customer_id);
		}
		else {
			throw new InvalidTokenException("Token Expired or Invalid , Login again ...");
		}
	}

	@GetMapping(value = "/customer/{customer_id}/getDetails")
	public ResponseEntity<Object> getUser(@PathVariable @Pattern(regexp="^R-[0-9]{3,6}$",message="Customer Id Mismatch") String customer_id) throws UserNotFoundException{	
		return registerService.getCustomerDetails(customer_id);
	}
	
	public ResponseEntity<ResponseForSuccess> serviceDown(String token,Customer customer,String cid) {
		return new ResponseEntity<>(new ResponseForSuccess("Service Down or Invalid Token Login again",null,"/home/login"),HttpStatus.GATEWAY_TIMEOUT);
	}
	
	@DeleteMapping(value = "/admin/{customer_id}/deleteCustomer")
	public ResponseEntity<Object> deleteCustomer(@RequestHeader("Authorization") String token,@PathVariable @Pattern(regexp="^R-[0-9]{3,6}$",message="Customer Id Mismatch") String customer_id) throws UserNotFoundException, InvalidTokenException{	
		if (authFeign.getValidity(token).getBody().isValid()) {	
			System.out.println(authFeign.getValidity(token).getBody().getRole());
			if(authFeign.getValidity(token).getBody().getRole().equals("ROLE_ADMIN")) {
				return registerService.deleteCustomerDetails(customer_id);
			}
			else {
				throw new UnauthorizedException("Unauthorized to delete the customer");
			}
		}
		else {
			throw new InvalidTokenException("Token Expired or Invalid , Login again ...");
		}
	}
//	Registration
//
//	{
//	  "accountType": "Salary",
//	  "address": "1-57 , Madhavaram",
//	  "bankName": "Indian Bank",
//	  "branchName": "main branch chittoor",
//	  "citizenship": "Indian",
//	  "country": "India",
//	  "contactNo": "9493407053",
//	  "depositAmount": 0,
//	  "dob": "1999-01-02",
//	  "emailAddress": "kumarpr792@gmail.com",
//	  "gender": "Male",
//	  "guardianName": "Ramesh",
//	  "guardianType": "Father",
//	  "identificationNumber": "ABCDE2132Q",
//	  "identificationProofType": "PAN",
//	  "maritalStatus": "Unmarried",
//	  "name": "kumarpr",
//	  "referenceAccountHolderAccountNo": "123345",
//	  "referenceAccountHolderAddress": "Madhavaram",
//	  "referenceAccountHolderName": "Ramesh",
//	  "state": "Andhra",
//	  "loginDetails":{
//	      "username":"kumar",
//	      "password":"kumar@792"
//	  }
//	}
//
//	Loan
//
//	Education
//
//	{
//	  "amount": 100000,
//	  "durationInYears": 5,
//	  "type": "Education",
//	  "loanDetails": {
//	    "course": "BTech",
//	    "courseFee": 35000,
//	    "fatherAnnualIncome": 100000,
//	    "fatherCurrentCompanyExp": 5,
//	    "fatherName": "Ramesh",
//	    "fatherOccupation": "Executive",
//	    "fatherTotalExp": 25,
//	    "rationCard": "12345678"
//	  }
//	}
//
//
//	Login
//
//	{
//	 
//	  "password": "a3VtYXJANzky",
//	  "username": "a3VtYXI="
//	}
//
//	Y2hhaXRhbnlhMQ
//	Y2hhaXRhbnlhQDc5Mg


	
	
}
