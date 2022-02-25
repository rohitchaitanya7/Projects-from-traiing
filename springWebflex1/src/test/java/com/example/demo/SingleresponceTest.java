package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.DataTransferObj.Response;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class SingleresponceTest extends SpringWebflex1ApplicationTests {
	
	@Autowired
	private WebClient client;
	
	@Test
	public void test() {
		Mono<Response> respon = this.client
		.get()
		.uri("reactive/square/{input}",5)
		.retrieve()
		.bodyToMono(Response.class);
		
		StepVerifier.create(respon)
		.expectNextMatches(r->r.getOutput() == 25)// "==" returns true if "r.getOutput()" and "25" refers to same address.
		.verifyComplete();
		
		
		//System.out.println(respon);
	}
	

}
