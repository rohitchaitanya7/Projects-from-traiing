
package com.bms.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class UserDataTest {

	CustomerData auth = new CustomerData();
	CustomerData auth1 = new CustomerData("kumarpr", "kumar@792", "token",true,"ROLE_USER");

	@Test
	void testUsername() {
		auth.setUsername("kumar");
		assertEquals( "kumar", auth.getUsername());
	}
	@Test
	void testAct() {
		auth.setActive(true);
		assertEquals(true, auth.isActive());

	}
	
	@Test
	void testRole() {
		auth.setRoles("USER");
		assertEquals("USER", auth.getRoles());

	}
	
	@Test
	void testName() {
		auth.setPassword("Name");
		assertEquals( "Name", auth.getPassword());
	}

	
	@Test
	void testToken() {
		auth.setAuthToken("ad");
		assertEquals("ad", auth.getAuthToken());
	}
	
	@Test
	void testToString() {
		String string = auth1.toString();
		assertEquals(auth1.toString(),string);
	}

}
