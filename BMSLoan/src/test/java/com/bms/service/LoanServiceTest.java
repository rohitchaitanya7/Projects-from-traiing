package com.bms.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.bms.dao.LoanDao;
import com.bms.exception.InvalidTokenException;
import com.bms.model.Loan;
import com.bms.model.LoanDetails;
import com.bms.model.ValidateToken;
import com.bms.restclients.AuthFeign;

@SpringBootTest
class LoanServiceTest {

	@InjectMocks
	LoanServiceImpl service;
	
	@Mock
	LoanDao ld;
	
	@Mock
	AuthFeign authFeign;

	private List<Loan> l=new ArrayList<>();
	
	@Test
	void applyLoanTest() throws InvalidTokenException {
		LoanDetails details=new LoanDetails();
		Loan loan=new Loan();
		loan.setAmount(40000l);
		loan.setDurationInYears(5);
		loan.setType("Personal");
		loan.setLoanDetails(details);
		ValidateToken tokenValid = new ValidateToken("uid", "name", true);
		ResponseEntity<ValidateToken> response = new ResponseEntity<ValidateToken>(tokenValid, HttpStatus.OK);
		when(authFeign.getValidity("token")).thenReturn(response);
		when(ld.save(loan)).thenReturn(loan);
		assertEquals(200, service.applyLoan(loan, "R-001", "token").getStatusCodeValue());
	}
	@Test
	void applyLoanFailTest() {
		LoanDetails details=new LoanDetails();
		Loan loan=new Loan();
		loan.setAmount(40000l);
		loan.setDurationInYears(5);
		loan.setType("Education");
		loan.setLoanDetails(details);
		ValidateToken tokenValid = new ValidateToken("uid", "name", false);
		ResponseEntity<ValidateToken> response = new ResponseEntity<ValidateToken>(tokenValid, HttpStatus.OK);
		when(authFeign.getValidity("token")).thenReturn(response);
		when(ld.save(loan)).thenReturn(loan);
		assertThrows(InvalidTokenException.class, ()->service.applyLoan(loan, "R-001", "token"));
	}
	@Test
	void getCustomerLoan() throws InvalidTokenException {
		LoanDetails details=new LoanDetails();
		Loan loan=new Loan();
		loan.setAmount(40000l);
		loan.setDurationInYears(5);
		loan.setType("Home");
		loan.setLoanDetails(details);
		loan.setCid("R-001");
		ValidateToken tokenValid = new ValidateToken("uid", "name", true);
		ResponseEntity<ValidateToken> response = new ResponseEntity<ValidateToken>(tokenValid, HttpStatus.OK);
		when(authFeign.getValidity("token")).thenReturn(response);
		l.add(loan);
		when(ld.findByCid("R-001")).thenReturn(l);
		List<Loan> loan1=service.getCustomerLoan("token", "R-001");
		assertEquals(loan1, l);
	}
	@Test
	void getCustomerLoanFail(){
		LoanDetails details=new LoanDetails();
		Loan loan=new Loan();
		loan.setAmount(40000l);
		loan.setDurationInYears(5);
		loan.setType("Home");
		loan.setLoanDetails(details);
		loan.setCid("R-001");
		ValidateToken tokenValid = new ValidateToken("uid", "name", false);
		ResponseEntity<ValidateToken> response = new ResponseEntity<ValidateToken>(tokenValid, HttpStatus.OK);
		when(authFeign.getValidity("token")).thenReturn(response);
		l.add(loan);
		when(ld.findByCid("R-001")).thenReturn(l);
		assertThrows(InvalidTokenException.class, ()->service.getCustomerLoan("token", "R-001"));
	}
	@Test
	void getLoanByType() {
		LoanDetails details=new LoanDetails();
		Loan loan=new Loan();
		loan.setAmount(40000l);
		loan.setDurationInYears(5);
		loan.setType("Home");
		loan.setLoanDetails(details);
		loan.setCid("R-001");
		l.add(loan);
		when(ld.findAll()).thenReturn(l);
		assertEquals(l, service.getLoanByType("Home"));
	}
}
