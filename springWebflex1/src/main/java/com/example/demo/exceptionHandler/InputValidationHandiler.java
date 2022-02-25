package com.example.demo.exceptionHandler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.exception.InputException;

@ControllerAdvice
public class InputValidationHandiler {
	@ExceptionHandler(InputException.class)
	public ResponseEntity<InputException> handelValidation(InputException ex){
		InputException r = new InputException();
		r.setErrorcode(ex.getErrorcode());
		r.setInput(ex.getInput());
		r.setMsg(ex.getMessage());
		return ResponseEntity.badRequest().body(r);
		
	}

}
