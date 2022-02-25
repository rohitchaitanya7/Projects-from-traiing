package com.bms.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ResponceForExceptionTest {
	
	ResponseForException msg = new ResponseForException();
	
	@Test
	void testMsg() {
		msg.setMessge("Error Occured");
		assertEquals( "Error Occured", msg.getMessge());
	}
	@Test
	void testDate() {
		LocalDateTime date = LocalDateTime.now(); 
		msg.setTimestamp(date);
		assertEquals( date, msg.getTimestamp());
	}

}
