package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.DataTransferObj.MultiplayRequestobj;
import com.example.demo.DataTransferObj.Response;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MathReactive {

	public Mono<Response> square(int input) {
		return Mono.fromSupplier(() -> input * input)
		.map(Response::new);
	  //.map(i->new Response(i));
//		Response r = new Response();
//		r.setOutput(input*input);
//		return Mono.fromSupplier(()->r);
	}

	public Flux<Response> table(int input) {
		return Flux.range(1, 10).doOnNext(i -> SleepUtil.sleepSeconds(1))
				.doOnNext(i -> System.out.println("processing" + i)).map(i -> new Response(i * input));
	}

	public Mono<Response> multiplay(Mono<MultiplayRequestobj> MultiplayRequestobj) {
		return MultiplayRequestobj.map(i -> i.getFirst() * i.getSecond()).map(Response::new);
		// System.out.println(Header);
	}

}
