package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebclientConfig {

	@Bean
	public WebClient Webclient() {
		return WebClient.builder()
				.baseUrl("http://localhost:8080")
						// "http://localhost:8080"
				.build();
	}
}
