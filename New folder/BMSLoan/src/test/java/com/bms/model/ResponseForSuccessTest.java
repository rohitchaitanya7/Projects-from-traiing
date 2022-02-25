package com.bms.model;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ResponseForSuccessTest {
	
	ResponseForSuccess responce = new ResponseForSuccess();
@Test
public void ResponseForSuccess() {
	responce.setMessage("ok");
	assertEquals("ok", responce.getMessage());
}
}
