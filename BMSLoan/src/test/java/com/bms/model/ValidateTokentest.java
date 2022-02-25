package com.bms.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ValidateTokentest {
	
	
	ValidateToken ValidateToken=new ValidateToken();
	@Test
	public void ValidateTokenStringTest() {
		String string = ValidateToken.toString();
		assertNotNull(string);
	}
	@Test
	public void setuidtest() {
		ValidateToken.setName("rohit");
		
		assertEquals("rohit", ValidateToken.getName());
	}
}

