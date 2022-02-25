package com.bms.model;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class Login_DetailsTest {

	LoginDetails login=new LoginDetails();
	LoginDetails login1=new LoginDetails("kumar", "pass", "token");
	
	@Test
	void testUsername() {
		login.setUsername("kumar");
		assertEquals("kumar", login.getUsername());
	}
	@Test
	void testPassword() {
		login.setPassword("pass");
		assertEquals("pass", login.getPassword());
	}
	@Test
	void testAuthToken() {
		login.setAuthToken("token");
		assertEquals("token", login.getAuthToken());
	}
}
