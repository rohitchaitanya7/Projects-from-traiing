package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DataTransferObj.MultiplayRequestobj;
import com.example.demo.DataTransferObj.Response;
import com.example.demo.service.MathReactive;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("reactive")
public class ReactiveController {

	@Autowired
	MathReactive mathReactive;

	@GetMapping("square/{input}")
	public Mono<Response> findSqure(@PathVariable int input) {
		// mono for one request.
		return mathReactive.square(input);
	}

	@GetMapping("table/{input}")
	public Flux<Response> multiplicationTable(@PathVariable int input) {
		// it keeps on collecting the values and fires all at once.
		// converted to json at last something like mono
		return mathReactive.table(input);
	}

	@GetMapping(value = "table/stream/{input}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Response> multiplicationTableStream(@PathVariable int input) {
		// when we add "MediaType.TEXT_EVENT_STREAM_VALUE" it will keep on emiting
		// values.
		// converted to json for every element and emited.
		return mathReactive.table(input);
	}

	@PostMapping("Multiplay")
	public Mono<Response> multiplay(@RequestBody Mono<MultiplayRequestobj> MultiplayRequestobj,
			@RequestHeader Map<String, String> header) {
		// @RequestHeader Map(String,String) header
		// Mono<MultiplayRequestobj> MultiplayRequestobj might be a huge value so we
		// keep mono to read the request first in nonblocking way.
		System.out.println(header);
		return mathReactive.multiplay(MultiplayRequestobj);
	}
}
// browser acts as Sudscriber and BD as producer