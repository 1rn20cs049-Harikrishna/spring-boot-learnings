package com.effigo.learningportal.controller.author;

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
	public ResponseEntity<?> createCourse(@RequestBody Optional<CourseDTO> courseDto,
			@PathVariable("author_id") Long authorId) {
		try {
			if (courseDto.isPresent()) {

				return ResponseEntity.status(HttpStatus.CREATED)
						.body(authorServiceImpl.createCourse(courseDto.get(), authorId));

			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Provide the request body");
			}

		} catch (Exception e) {
			log.info("AuthorController::createCourse There something wrong in controller : " + e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@PutMapping("/{authorId}/edit-course")
	public ResponseEntity<?> editCourse(@RequestBody Optional<CourseDTO> courseDTO, @PathVariable Long authorId) {
		log.info("AuthorController::editCourse Controller started");
		try {

			if (courseDTO.isPresent()) {
				return ResponseEntity.status(HttpStatus.ACCEPTED)
						.body(authorServiceImpl.editCourse(courseDTO.get(), authorId));
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Provide the request body");
			}
		} catch (Exception e) {
			log.info("AuthorController::editCourse " + e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/course/{courseId}")
	public ResponseEntity<String> deleteCourse(@PathVariable Long courseId,
			@RequestParam("authorId") Optional<Long> authorId) {
		try {
			if (authorId.isPresent()) {
				log.info("AuthorController::deleteCourse Controller started");
				authorServiceImpl.deleteCourse(courseId, authorId.get());
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deletion successfull");
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Provide authorId");
			}

		} catch (Exception e) {
			log.info("AuthorController::deleteCourse  " + e.getMessage());

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

		}
	}

	@GetMapping("/{authorId}/courses")
	public ResponseEntity<?> getCourses(@PathVariable("authorId") Long authorId) {
		try {
			log.info("AuthorController::getCourses Controller started");

			return ResponseEntity.status(HttpStatus.OK).body(authorServiceImpl.getCourses(authorId));
		} catch (Exception e) {
			log.info("AuthorController::getCourses " + e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

}
