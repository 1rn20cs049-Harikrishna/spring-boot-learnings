package com.effigo.learningportal.controller.learner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/learner")
public class LearnerController {

	@Autowired
//	private LearnerServiceImpl learnerServiceImpl;

	/* for searching the course ,we are using the query params */
//	@PostMapping("/search")
//	public ResponseEntity<List<CourseEntity>> searchCourse(@RequestBody Object obj) {
//		return ResponseEntity.status(HttpStatus.ACCEPTED).body(learnerServiceImpl.searchCourseById());
//	}

	/* user can add the favourite course */
	@PostMapping("/add-favourite")
	public ResponseEntity<?> addFavourite(@RequestParam("userId") Long user_id,@RequestParam("courseId") Long course_id) {
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("May or may not be added to favourites");
	}

	/* user can enroll to the course */
	@PostMapping("/enroll")
	public ResponseEntity<?> enrollCourse(@RequestBody Object obj) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("May or may not be enrolled to course");
	}

}
