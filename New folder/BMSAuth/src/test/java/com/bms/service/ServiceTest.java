package com.bms.service;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

import com.bms.dao.UserDAO;
import com.bms.exception.UnauthorizedException;
import com.bms.model.CustomerData;



@SpringBootTest
 class ServiceTest {

	UserDetails userdetails;
	
	@InjectMocks
	CustomerDetailsService custdetailservice;

	@Mock
	UserDAO userservice;

	@Test
	 void loadUserByUsernameTest() {
		
		CustomerData user1=new CustomerData("kumar", "kumar@792", null,true,null);
		Optional<CustomerData> data =Optional.of(user1) ;
		when(userservice.findByUsername("kumar")).thenReturn(data);
		UserDetails loadUserByUsername2 = custdetailservice.loadUserByUsername("kumar");
		assertEquals(user1.getUsername(),loadUserByUsername2.getUsername());
	}
	
	
	
	@Test
	void userNotFound() {
		
		when(userservice.findByUsername("kumar")).thenReturn(null);
		assertThrows( UnauthorizedException.class,()->custdetailservice.loadUserByUsername("kumar"));
	}

	
}
