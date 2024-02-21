package com.effigo.learningportal.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.effigo.learningportal.model.UserEntity;

@RestController
public class loginController {

	@PostMapping("/login")
	public ResponseEntity<String> userLogin(@RequestBody UserEntity user) {
		return  ResponseEntity.status(HttpStatus.OK).body("User logged in successfully");

	}

}
