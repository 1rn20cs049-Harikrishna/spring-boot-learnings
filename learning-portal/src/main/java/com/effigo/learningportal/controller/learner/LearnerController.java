package com.effigo.learningportal.controller.learner;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/learner")
public class LearnerController {

	/* for searching the course ,we are using the query params */
	@PostMapping("/search")
	public ResponseEntity<?> searchCourse(@RequestBody Object obj) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("May or may not find the course");
	}

	/* user can add the favourite course */
	@PostMapping("/add-favourite")
	public ResponseEntity<?> addFavourite(@RequestBody Object obj) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("May or may not be added to favourites");
	}

	/* user can enroll to the course */
	@PostMapping("/enroll")
	public ResponseEntity<?> enrollCourse(@RequestBody Object obj) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("May or may not be enrolled to course");
	}

}
