package com.example.springboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@GetMapping(value = "/good-morning")
	public ResponseEntity<String> index() {
		return ResponseEntity.ok("Good morning!");
	}

	@GetMapping(value = "/greeting")
	public ResponseEntity<String> greeting(){
		return ResponseEntity.status(200).body("Good Afternoon!");
	}
}
