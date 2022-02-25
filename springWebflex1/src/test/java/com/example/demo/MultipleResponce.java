package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.DataTransferObj.Response;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class MultipleResponce extends SpringWebflex1ApplicationTests {
	
	@Autowired
	private WebClient client;
	
	@Test
	public void test() {
		Flux<Response> respon = this.client.get()
		.uri("reactive/table/{input}",5)
		.retrieve()
		.bodyToFlux(Response.class)
		.doOnNext(System.out::println);
		
		StepVerifier.create(respon)
		.expectNextCount(10)
		.verifyComplete();
		
		
		//System.out.println(respon);
	}
	@Test
	public void test2() {
		Flux<Response> respon = this.client.get()
		.uri("reactive/table/stream/{input}",5)
		//.contentType(MediaType.APPLICATION_STREAM_JSON)
		.retrieve()
		.bodyToFlux(Response.class)
		.doOnNext(System.out::println);
		
		System.out.println(respon);
		
		StepVerifier.create(respon)
		.expectNextCount(10)
		.verifyComplete();
		
		
		//System.out.println(respon);
	}

}
