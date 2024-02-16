package com.effigo.learningportal.controller.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.effigo.learningportal.model.Course;
import com.effigo.learningportal.service.impl.AdminServiceImpl;
import com.effigo.learningportal.service.impl.AuthorServiceImpl;

@RestController
@RequestMapping("/api/author")
public class AuthorController {
	
	@Autowired
	AuthorServiceImpl authorServiceImpl;
	
	@PostMapping("/create-course")
	public ResponseEntity<Course> createCourse(@RequestBody Course course){
		return ResponseEntity.status(HttpStatus.CREATED).body(authorServiceImpl.createCourse(course));
	}
	
	@PutMapping("/edit-course")
	public ResponseEntity<Course> editCourse(@RequestBody Course course){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(authorServiceImpl.createCourse(course));
	}
	

}
