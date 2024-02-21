//package com.effigo.learningportal.controller.admin;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.effigo.learningportal.dto.UserDTO;
//import com.effigo.learningportal.service.impl.AdminServiceImpl;
//
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//
//@RestController
//@RequestMapping("/api/admin")
//@Slf4j
//@AllArgsConstructor
//public class AdminController {
//
//	private AdminServiceImpl adminServiceImpl;
//
//
//	@PostMapping("/create-user")
//	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
//		log.info("This is create user controller logger");
//		return ResponseEntity.status(HttpStatus.CREATED).body(adminServiceImpl.createUser(userDTO));
//	}
//
//	@GetMapping("/get-user/{userId}")
//	public ResponseEntity<?> getUser(@PathVariable("userId") Optional<Long> userOptional) {
////		log.info("This is  adminhome controller logger");
//		if (userOptional.isPresent()) {
//			return ResponseEntity.status(HttpStatus.OK).body(adminServiceImpl.searchUserDetails(userOptional.get()));
//		} else {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No such User found");
//		}
//	}
//
//	@GetMapping("/AllUsers")
//	public ResponseEntity<List<UserDTO>> getUsers() {
//		return ResponseEntity.status(HttpStatus.OK).body(adminServiceImpl.getUsers());
//	}
//
//	@DeleteMapping("/{userId}")
//	public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
//		boolean deleted = adminServiceImpl.deleteUserById(userId);
//
//		if (deleted) {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		} else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}
//
//	@DeleteMapping("deleteAll")
//	public ResponseEntity<String> deleteUsers() {
//		adminServiceImpl.deleteUsers();
//		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("ContentSuccessfully Deleted!!!");
//	}
//
//	@GetMapping()
//	public ResponseEntity<?> adminHome() {
////		log.info("This is  adminhome controller logger");
//		return ResponseEntity.status(HttpStatus.OK).body("all okay!! This is admin home page");
//	}
//
//}
