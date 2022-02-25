package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicate;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfig {
	
	@Autowired
	RequestHandler requesthandler;
	
	@Bean
	public RouterFunction<ServerResponse> highlevelfun(){
		return RouterFunctions.route().path("router1", this::serverRouterFunction1)
				.build();
				
	}
	
	@Bean
	public RouterFunction<ServerResponse> serverRouterFunction(){
		//RequestPredicates.all()
		return RouterFunctions.route()
				.GET("/router/square/{input}", RequestPredicates.path("*/*/1?").or(RequestPredicates.path("*/*/100")),requesthandler::squareHandler)
				.GET("/router/square/{input}", req->ServerResponse.badRequest().bodyValue("only 10 to 19 are allowed"))
				.GET("/router/table/{input}",requesthandler::table)
				.GET("/router/tablestream/{input}",requesthandler::tablestream)
				.POST("/router/multiplay",requesthandler::multiplay)
				.build();
	}
	
	
	//@Bean the high level function acts as a been 
	public RouterFunction<ServerResponse> serverRouterFunction1(){
		return RouterFunctions.route()
				.GET("square/{input}", requesthandler::squareHandler)
			//   /router1/square/{input}
				.GET("table/{input}",requesthandler::table)
				.GET("tablestream/{input}",requesthandler::tablestream)
				.POST("multiplay",requesthandler::multiplay)
				.build();
	}

}
