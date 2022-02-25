package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import com.example.demo.DataTransferObj.Response;

@Service
public class MathService {

	public Response findSqare(int input) {
		return new Response(input * input);
	}

	public List<Response> multiplicationTable(int input) {
		return IntStream.rangeClosed(1, 10)
				.peek(i -> SleepUtil.sleepSeconds(1))
				/*peek
				 * Returns a stream consisting of the elements of this stream, truncated
			     * to be no longer than {@code maxSize} in length.
			     */
				.peek(i -> System.out.println("processing : " + i))
				.mapToObj(i -> new Response(i * input))
				.collect(Collectors.toList());
	}

}
