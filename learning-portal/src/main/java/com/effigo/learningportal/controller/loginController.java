package com.effigo.learningportal.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.effigo.learningportal.model.User;

@RestController
public class loginController {

	@PostMapping("/login")
	public ResponseEntity<?> userLogin(@RequestBody User user) {
		return  ResponseEntity.status(HttpStatus.OK).body("User logged in successfully");

	}

}
