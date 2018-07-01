package com.example.demo.api.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.test;

@RestController
public class testController {
	
	private static final String template = "Hello %s!";
	private static AtomicLong counter = new AtomicLong();
	
	@RequestMapping("api/test")
	public test test(@RequestParam(value="name", defaultValue = "World") String name) {
		return new test(counter.incrementAndGet(),String.format(template, name));
	}
}
