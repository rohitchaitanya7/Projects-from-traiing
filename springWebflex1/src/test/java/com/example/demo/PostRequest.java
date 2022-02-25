package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.DataTransferObj.MultiplayRequestobj;
import com.example.demo.DataTransferObj.Response;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class PostRequest extends SpringWebflex1ApplicationTests {

	@Autowired
	private WebClient client;

	@Test
	public void postTest() {
		Mono<Response> postreq = this.client
				.post().uri("/reactive/Multiplay")
				.bodyValue(buildreq(2,3))
				.retrieve()
				.bodyToMono(Response.class)
				.doOnNext(System.out::println)
				.doOnNext(System.out::println);
	//	System.out.println(postreq);

		StepVerifier
			.create(postreq)
			.expectNextCount(1)
			.expectComplete();

	}

	private MultiplayRequestobj buildreq(int a, int b) {
		MultiplayRequestobj dto = new MultiplayRequestobj();
		dto.setFirst(a);
		dto.setSecond(b);
		return dto;
	}
}
