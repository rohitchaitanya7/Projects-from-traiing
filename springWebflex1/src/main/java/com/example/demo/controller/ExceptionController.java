package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DataTransferObj.Response;
import com.example.demo.exception.InputException;
import com.example.demo.service.MathReactive;
import com.example.demo.service.MathService;

import reactor.core.publisher.Mono;


@RestController
public class ExceptionController {

		
	@Autowired
	MathReactive mathReactive;

	@GetMapping("square/{input}/throw")
	public Mono<Response> findSqure(@PathVariable int input) {
		if(input<10 || input > 20)
			throw new InputException(input);
	
		return mathReactive.square(input);

}
}