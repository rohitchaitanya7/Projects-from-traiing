package com.bms.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
@SpringBootTest
public class GlobalExceptionHandlerTest {
	
	@InjectMocks
	GlobalExceptionHandler handler;
	@Test
	public void invalidTokenExceptionTest() {
		ResponseEntity<?> responseEntity= handler.invalidTokenException(null);
		assertEquals(401, responseEntity.getStatusCodeValue());
		
	}
}
