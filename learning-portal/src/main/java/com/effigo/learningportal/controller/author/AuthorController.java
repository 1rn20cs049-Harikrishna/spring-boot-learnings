package com.effigo.learningportal.controller.author;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.effigo.learningportal.dto.CourseDTO;
import com.effigo.learningportal.model.CourseEntity;
import com.effigo.learningportal.service.impl.AuthorServiceImpl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/author")
@Slf4j
@AllArgsConstructor
public class AuthorController {

	private AuthorServiceImpl authorServiceImpl;

	@PostMapping("/{author_id}/create-course")
	public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO courseDto,
			@PathVariable("author_id") Long authorId) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(authorServiceImpl.createCourse(courseDto, authorId));

		} catch (Exception e) {
			log.info("AuthorController::createCourse There something wrong in controller : " + e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/edit-course")
	public ResponseEntity<CourseEntity> editCourse(@RequestBody CourseEntity course) {
//		log.info("AuthorController::editCourse Controller started");
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(authorServiceImpl.editCourse(course));
	}

	@DeleteMapping("/course/{courseId}")
	public ResponseEntity<?> deleteCourse(@PathVariable Long courseId,
			@RequestParam("userId") Optional<Long> authorId) {
		log.info("AuthorController::deleteCourse Controller started");
		authorServiceImpl.deleteCourse(courseId, authorId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deletion successfull");
	}

	@GetMapping("/courses")
	public ResponseEntity<List<CourseDTO>> getCourses(@RequestParam("userId") Optional<Long> authorId) {
		try {
			log.info("AuthorController::getCourses Controller started");

			return ResponseEntity.status(HttpStatus.OK).body(authorServiceImpl.getCourses(authorId));
		} catch (Exception e) {
			log.info("AuthorController::getCourses " + e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
