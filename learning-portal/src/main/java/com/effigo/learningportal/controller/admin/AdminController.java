package com.effigo.learningportal.controller.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.effigo.learningportal.dto.UserDTO;
import com.effigo.learningportal.service.impl.AdminServiceImpl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/admin")
@Slf4j
@AllArgsConstructor
public class AdminController {

	private AdminServiceImpl adminServiceImpl;

	@PostMapping("/create-user")
	public ResponseEntity<?> createUser(@RequestBody Optional<UserDTO> userDTO, @RequestParam("adminId") Long adminId) {
		try {
			if (userDTO.isPresent()) {
				log.info("AdminController::createUser  started creating user");
				return adminServiceImpl.createUser(userDTO.get(), adminId);

			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Provide the request body");
			}

		} catch (Exception e) {
			log.info("Something went wrong " + e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-user/{userId}")
	public ResponseEntity<?> getUser(@PathVariable("userId") Optional<Long> userOptional) {
		try {
			log.info("AdminController::getUser controller ");
			if (userOptional.isPresent()) {
				return adminServiceImpl.searchUserDetails(userOptional.get());
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No such User found");
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@GetMapping("/AllUsers")
	public ResponseEntity<List<UserDTO>> getUsers() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(adminServiceImpl.getUsers());
		} catch (Exception e) {
			log.info("AdminController::getUsers " + e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/{adminId}")
	public ResponseEntity<?> deleteUser(@PathVariable("adminId") Long adminId, @RequestParam("userId") Optional<Long> userId) {

		try {
			if(userId.isPresent())
				return adminServiceImpl.deleteUserById(adminId, userId.get());
			else {
				return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("please provide valid user and admin id");
			}

		} catch (Exception e) {
			log.info("AdminController::deleteUser " + e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	/*
	 * @DeleteMapping("deleteAll") public ResponseEntity<String> deleteUsers() {
	 * adminServiceImpl.deleteUsers(); return
	 * ResponseEntity.status(HttpStatus.NO_CONTENT).
	 * body("ContentSuccessfully Deleted!!!"); }
	 */

	@GetMapping()
	public ResponseEntity<String> adminHome() {
		try {
			log.info("AdminController::adminHome started");
			return ResponseEntity.status(HttpStatus.OK).body(adminServiceImpl.adminHome());
		} catch (Exception e) {
			log.info("AdminController::adminHome ended with error " + e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
