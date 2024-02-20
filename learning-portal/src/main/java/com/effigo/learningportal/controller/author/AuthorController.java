package com.effigo.learningportal.controller.author;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.effigo.learningportal.dto.CourseDTO;
import com.effigo.learningportal.service.impl.AuthorServiceImpl;

@RestController
@RequestMapping("/api/author")
//@Slf4j
public class AuthorController {

	private AuthorServiceImpl authorServiceImpl;

	AuthorController(AuthorServiceImpl authorServiceImpl) {
		this.authorServiceImpl = authorServiceImpl;
	}

	@PostMapping("/{author_id}/create-course")
	public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO courseDto,
			@PathVariable("author_id") Long authorId) {
//		log.info("This is create course controller");
		return ResponseEntity.status(HttpStatus.CREATED).body(authorServiceImpl.createCourse(courseDto, authorId));
	}

//	@PutMapping("/edit-course")
//	public ResponseEntity<CourseEntity> editCourse(@RequestBody CourseEntity course) {
////		log.info("This is edit course controller");
//		return ResponseEntity.status(HttpStatus.ACCEPTED).body(authorServiceImpl.createCourse(course));
//	}

}

