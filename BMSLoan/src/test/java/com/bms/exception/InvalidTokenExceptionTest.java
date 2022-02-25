package com.bms.exception;



import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class InvalidTokenExceptionTest {

	@Test
	public void constructorTest() {
		InvalidTokenException exception = new InvalidTokenException("token expired");
		assertEquals("token expired", exception.getMessage());
	}

}
