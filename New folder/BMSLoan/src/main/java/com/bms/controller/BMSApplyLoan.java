package com.bms.controller;


import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.bms.exception.InvalidTokenException;
import com.bms.model.Loan;
import com.bms.service.LoanService;

@RestController
@Validated
public class BMSApplyLoan {

	@Autowired
	private LoanService loanService;
	
	@PostMapping(value = "/loan/{customer_id}/applyLoan")
	public ResponseEntity<Object> applyLoan(@RequestHeader("Authorization") String token,@Valid @RequestBody Loan loan,@PathVariable @Pattern(regexp="^R-[0-9]{3,6}$",message="Customer Id Mismatch") String customer_id) throws InvalidTokenException{
		return loanService.applyLoan(loan, customer_id, token);
	}
	
	@GetMapping(value = "/loan/{customer_id}/getCustomerLoans")
	public List<Loan> getCustomerLoans(@RequestHeader("Authorization") String token,@PathVariable @Pattern(regexp="^R-[0-9]{3,6}$",message="Customer Id Mismatch") String customer_id) throws InvalidTokenException{
		return loanService.getCustomerLoan(token,customer_id);
	}
	
	@GetMapping(value ="/loan/{loanType}/getLoanByType")
	public List<Loan> getLoanByType(@PathVariable @NotNull String loanType){
		return loanService.getLoanByType(loanType);
	}
	
}

