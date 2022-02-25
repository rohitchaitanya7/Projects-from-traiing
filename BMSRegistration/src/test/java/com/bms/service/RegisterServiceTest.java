package com.bms.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.bms.dao.CustomerDao;
import com.bms.dao.CustomerDataDao;
import com.bms.exception.InitialDepositException;
import com.bms.exception.UnauthorizedException;
import com.bms.exception.UserExistsException;
import com.bms.exception.UserNotFoundException;
import com.bms.model.Customer;
import com.bms.model.CustomerData;
import com.bms.model.ValidateToken;
import com.bms.restclients.AuthFeign;

@SpringBootTest
public class RegisterServiceTest {

	@InjectMocks
	RegisterServiceImpl service;
	
	@Mock
	CustomerDao cd;
	
	@Mock
	CustomerDataDao cdd;
	
	@Mock
	AuthFeign auth;
	
	@Test
	void register() throws UserExistsException, InitialDepositException, ParseException {
		CustomerData login_details=new CustomerData("kumar", "kumar", "user", true, "token");
		Customer data=new Customer();
		data.setDob(new SimpleDateFormat("dd/MM/yyyy").parse("02/01/1999"));
		data.setAccountType("salary");
		data.setLoginDetails(login_details);
		when(cdd.findById("kumar")).thenReturn(Optional.ofNullable(null));	
		when(cd.save(data)).thenReturn(data);
		ResponseEntity<?> response=service.register(data);
		assertEquals(200, response.getStatusCodeValue());
	
	}
	@Test
	void registerFail() throws UserExistsException, InitialDepositException, ParseException {
		CustomerData login_details=new CustomerData("kumar", "kumar", "user", true, "token");
		Customer data=new Customer();
		data.setLoginDetails(login_details);
		when(cdd.findById("kumar")).thenReturn(Optional.of(login_details));	
		when(cd.save(data)).thenReturn(data);
		assertThrows(UserExistsException.class,()->service.register(data));
	}
	@Test
	void registerInitialAmountFail() throws ParseException {
		CustomerData login_details=new CustomerData("kumar", "kumar", "user", true, "token");
		Customer data=new Customer();
		data.setDob(new SimpleDateFormat("dd/MM/yyyy").parse("02/01/1959"));
		data.setAccountType("savings");
		data.setDepositAmount((long)0);
		data.setLoginDetails(login_details);
		when(cdd.findById("kumar")).thenReturn(Optional.ofNullable(null));	
		when(cd.save(data)).thenReturn(data);
		assertThrows(InitialDepositException.class,()->service.register(data));
	}
	@Test
	void editDetailsTest(){
		CustomerData login_details=new CustomerData("kumar", "kumar", "user", true, "token");
		Customer data=new Customer();
		data.setLoginDetails(login_details);
		data.setCustomer_id("R-001");
		when(cd.findById("R-001")).thenReturn(Optional.of(data));
		cd.save(data);
		ResponseEntity<?> response=service.editDetails("token", data, "R-001");
		assertEquals(200, response.getStatusCodeValue());
	}
	@Test
	void editDetailsFalseTest() {
		CustomerData login_details=new CustomerData("kumar", "kumar", "user", true, "token");
		Customer data=new Customer();
		data.setLoginDetails(login_details);
		data.setCustomer_id("R-001");
		when(cd.findById("R-001")).thenReturn(Optional.ofNullable(null));
		cd.save(data);
		assertThrows(UnauthorizedException.class,()->service.editDetails("token", data, "R-001"));
	}
	@Test
	void getCustomerDetails() throws UserNotFoundException {
		CustomerData login_details=new CustomerData("kumar", "kumar", "user", true, "token");
		Customer data=new Customer();
		data.setLoginDetails(login_details);
		data.setCustomer_id("R-001");
		when(cd.findById("R-001")).thenReturn(Optional.of(data));
		assertEquals(200, service.getCustomerDetails("R-001").getStatusCodeValue());
	}
	@Test
	void getCustomerDetailsFail() {
		when(cd.findById("R-001")).thenReturn(Optional.ofNullable(null));
		assertThrows(UserNotFoundException.class, ()->service.getCustomerDetails("R-001"));
	}
	@Test
	void deleteCustomer() throws UserNotFoundException {
		CustomerData login_details=new CustomerData("kumar", "kumar", "user", true, "token");
		Customer data=new Customer();
		data.setLoginDetails(login_details);
		data.setCustomer_id("R-001");
		ValidateToken tokenValid = new ValidateToken("uid", "kumar", "ADMIN", true);
		ResponseEntity<ValidateToken> response = new ResponseEntity<ValidateToken>(tokenValid, HttpStatus.OK);
		when(auth.getValidity("token")).thenReturn(response);
		when(cd.findById("R-001")).thenReturn(Optional.of(data));
		assertEquals(200, service.deleteCustomerDetails("R-001").getStatusCodeValue());
	}
	@Test
	void deleteCustomerFail() {
		CustomerData login_details=new CustomerData("kumar", "kumar", "user", true, "token");
		Customer data=new Customer();
		data.setLoginDetails(login_details);
		data.setCustomer_id("R-002");
		ValidateToken tokenValid = new ValidateToken("uid", "kumar", "USER", true);
		ResponseEntity<ValidateToken> response = new ResponseEntity<ValidateToken>(tokenValid, HttpStatus.OK);
		when(auth.getValidity("token")).thenReturn(response);
		when(cd.findById("R-001")).thenReturn(Optional.ofNullable(null));
		assertThrows(UnauthorizedException.class, ()->service.deleteCustomerDetails("R-001"));
	}
}
