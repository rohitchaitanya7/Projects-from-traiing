package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.example.demo.DataTransferObj.MultiplayRequestobj;
import com.example.demo.DataTransferObj.Response;
import com.example.demo.service.MathReactive;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class RequestHandler {
	
	@Autowired
	private MathReactive mathReactive;
	
	
	public Mono<ServerResponse> squareHandler(ServerRequest serverrequest){
		int input = Integer.parseInt(serverrequest.pathVariable("input"));
		Mono<Response> responsemono = this.mathReactive.square(input);
		return ServerResponse.ok().body(responsemono,Response.class);
		//it is publisher it will eimte response class
	}
	
	public Mono<ServerResponse> table(ServerRequest serverrequest){
		int input = Integer.parseInt(serverrequest.pathVariable("input"));
		Flux<Response> responsemono = this.mathReactive.table(input);
		return ServerResponse.ok().body(responsemono,Response.class);
		//it is publisher it will eimte response class
	}
	
	public Mono<ServerResponse> tablestream(ServerRequest serverrequest){
		int input = Integer.parseInt(serverrequest.pathVariable("input"));
		Flux<Response> responsemono = this.mathReactive.table(input);
		return ServerResponse.ok()
				.contentType(MediaType.TEXT_EVENT_STREAM)
				.body(responsemono,Response.class);
		//it is publisher it will eimte response class
	}
	public Mono<ServerResponse> multiplay(ServerRequest serverrequest){
		Mono<MultiplayRequestobj> bodyToMono = serverrequest.bodyToMono(MultiplayRequestobj.class);
		Mono<Response> multiplay = mathReactive.multiplay(bodyToMono);
		return ServerResponse.ok().body(multiplay,Response.class);
		//it is publisher it will eimte response class
	}
	
	

}
