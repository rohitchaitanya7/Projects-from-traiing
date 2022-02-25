package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.DataTransferObj.MultiplayRequestobj;
import com.example.demo.DataTransferObj.Response;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class Postreq1 extends SpringWebflex1ApplicationTests{
	
	@Autowired
	private WebClient client;
	
	@Test
	public void posttest() {
		Mono<Response> doOnNext = this.client
				.post()
		.bodyValue(obj(2, 5))
		.headers(h-> h.set("headerName", "headerValue"))
		.retrieve()
		.bodyToMono(Response.class)
		.doOnNext(System.out::println);
		
		//System.out.println(doOnNext);
		
		StepVerifier.create(doOnNext)
		.expectNextCount(1)
		.expectComplete();
		
	}
	
	private MultiplayRequestobj obj(int a,int b) {
		MultiplayRequestobj obj = new MultiplayRequestobj();
		obj.setFirst(a);
		obj.setSecond(b);
		return obj;
	}

}
