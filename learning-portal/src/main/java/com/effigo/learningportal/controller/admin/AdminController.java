package com.effigo.learningportal.controller.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.effigo.learningportal.model.User;
import com.effigo.learningportal.service.impl.AdminServiceImpl;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

	Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	AdminServiceImpl adminServiceImpl;

	@PostMapping("/create-user")
	public ResponseEntity<?> createUser(@RequestBody User user) {
		logger.info("This is create user controller logger");
		 Long id =  adminServiceImpl.createUser(user).getId();
		return ResponseEntity.status(HttpStatus.OK).body("User created with provided credentials whose id is " + id);
	}

	@GetMapping()
	public ResponseEntity<?> adminHome() {
		logger.info("This is  adminhome controller logger");
		return ResponseEntity.status(HttpStatus.OK).body("all okay");
	}

}
