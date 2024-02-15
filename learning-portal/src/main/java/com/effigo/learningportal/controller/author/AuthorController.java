package com.effigo.learningportal.controller.author;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.effigo.learningportal.model.Course;

@RestController
@RequestMapping("/api/author")
public class AuthorController {
	
	@PostMapping("/create-course")
	public ResponseEntity<?> createCourse(@RequestBody Course course){
		return ResponseEntity.status(HttpStatus.CREATED).body("New course is created !!");
	}
	
	@PutMapping("/edit-course")
	public ResponseEntity<?> editCourse(@RequestBody Course course){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("course is updated !!");
	}
	

}
