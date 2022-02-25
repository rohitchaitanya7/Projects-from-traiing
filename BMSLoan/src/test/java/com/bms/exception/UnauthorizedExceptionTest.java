package com.bms.exception;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UnauthorizedExceptionTest {
	@Test 
	public void constructorTest() {
		UnauthorizedException Exception =new UnauthorizedException("Unauthorized");
		System.out.println(Exception);
		assertEquals("Unauthorized", Exception.getMessage());	
	}

}
