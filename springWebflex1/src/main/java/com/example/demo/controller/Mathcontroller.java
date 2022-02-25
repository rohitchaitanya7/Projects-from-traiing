package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DataTransferObj.Response;
import com.example.demo.service.MathService;

@RestController
public class Mathcontroller {
	
	@Autowired
	private MathService mathService;
	
	@GetMapping("square/{input}")
	public Response findSqure(@PathVariable int input) {
		return mathService.findSqare(input);
	}
	
	@GetMapping("table/{input}")
	public List<Response> multiplicationTable(@PathVariable int input){
		return mathService.multiplicationTable(input);
	}
	
	

}
