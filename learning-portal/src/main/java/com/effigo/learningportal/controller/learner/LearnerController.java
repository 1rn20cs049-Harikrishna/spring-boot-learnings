package com.effigo.learningportal.controller.learner;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.effigo.learningportal.model.CourseEntity;
import com.effigo.learningportal.service.impl.LearnerServiceImpl;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/learner")
@AllArgsConstructor
@Slf4j
public class LearnerController {

	private LearnerServiceImpl learnerServiceImpl;

	/* user can enroll to the course */
	@PostMapping("/enroll")
	public ResponseEntity<String> enrollCourse(@RequestParam("userId") Optional<Long> userId,
			@RequestParam("courseId") Optional<Long> courseId) {
		try {
			if (courseId.isPresent() && userId.isPresent()) {
				return  learnerServiceImpl.enrollCourse(userId.get(), courseId.get());				
			}
				
			else
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body("Provide the both user and course category!!");
		} catch (Exception e) {
			throw new EntityNotFoundException("Provide proper user and course id ." + e.getMessage());
		}
	}

//	/* for searching the course ,we are using the query params */
//	@GetMapping("/search")
//	public ResponseEntity<?> searchCourse(@RequestParam("courseId") Optional<Long> courseId,
//			@RequestParam("courseCatId") Optional<Long> courseCatId, @RequestParam("userId") Optional<Long> userId) {
//		if (courseId.isPresent()) {
//			return ResponseEntity.status(HttpStatus.ACCEPTED).body(learnerServiceImpl.searchCourseById(courseId.get()));
//		} else if (courseCatId.isPresent()) {
//			return ResponseEntity.status(HttpStatus.ACCEPTED)
//					.body(learnerServiceImpl.searchCourseByCategory(courseCatId.get()));
//		} else if (userId.isPresent()) {
//			return ResponseEntity.status(HttpStatus.ACCEPTED)
//					.body(learnerServiceImpl.searchCourseByAuthor(userId.get()));
//		}
//		return ResponseEntity.status(HttpStatus.ACCEPTED).body("write proper method to search");
//	}
//
//	/* user can add the favourite course */
//	@PostMapping("/add-favourite")
//	public ResponseEntity<String> addFavourite(@RequestParam("userId") Optional<Long> userId,
//			@RequestParam("courseId") Optional<Long> courseId) {
//		if (userId.isPresent() && courseId.isPresent())
//			return ResponseEntity.status(HttpStatus.ACCEPTED)
//					.body(learnerServiceImpl.addFavourite((long) userId.get(), (long) courseId.get()));
//		return ResponseEntity.badRequest().body("Provide proper course and user id ");
//	}
//
	@GetMapping("/{userId}/favourites")
	public ResponseEntity<List<CourseEntity>> addFavourite(@PathVariable("userId") Optional<Long> userId) {
		try {
			if(userId.isPresent()) {
				return learnerServiceImpl.getAllFavouriteByUserId(userId.get());
			}
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("some error" + e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	}

}
