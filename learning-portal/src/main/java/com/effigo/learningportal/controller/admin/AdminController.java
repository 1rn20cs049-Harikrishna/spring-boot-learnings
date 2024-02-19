package com.effigo.learningportal.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.effigo.learningportal.dto.UserDTO;
import com.effigo.learningportal.model.UserEntity;
import com.effigo.learningportal.service.impl.AdminServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/admin")
//@Slf4j
public class AdminController {

	@Autowired
	AdminServiceImpl adminServiceImpl;

	@PostMapping("/create-user")
	public ResponseEntity<UserEntity> createUser(@RequestBody UserDTO userDTO) {
//		log.info("This is create user controller logger");
		return ResponseEntity.status(HttpStatus.CREATED).body(adminServiceImpl.createUser(userDTO));
	}

	@GetMapping()
	public ResponseEntity<?> adminHome() {
//		log.info("This is  adminhome controller logger");
		return ResponseEntity.status(HttpStatus.OK).body("all okay");
	}

}
