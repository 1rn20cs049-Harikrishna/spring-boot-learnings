//package com.effigo.learningportal.controller.learner;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.effigo.learningportal.model.CourseEntity;
//import com.effigo.learningportal.service.impl.LearnerServiceImpl;
//
//@RestController
//@RequestMapping("/api/learner")
//public class LearnerController {
//
//	@Autowired
//	private LearnerServiceImpl learnerServiceImpl;
//
//	/* for searching the course ,we are using the query params */
//	@GetMapping("/search")
//	public ResponseEntity<?> searchCourse(@RequestParam("courseId")  Optional<Long>  courseId,@RequestParam("courseCatId")  Optional<Long>  courseCatId,@RequestParam("userId")  Optional<Long>  userId) {
//		if(courseId.isPresent()) {
//			return ResponseEntity.status(HttpStatus.ACCEPTED).body(learnerServiceImpl.searchCourseById(courseId.get()));
//		}else if(courseCatId.isPresent()) {
//			return ResponseEntity.status(HttpStatus.ACCEPTED).body(learnerServiceImpl.searchCourseByCategory(courseCatId.get()));
//		}else if (userId.isPresent()){
//			return ResponseEntity.status(HttpStatus.ACCEPTED).body(learnerServiceImpl.searchCourseByAuthor(userId.get()));
//		}
//		return ResponseEntity.status(HttpStatus.ACCEPTED).body("write proper method to search");
//	}
//
//	/* user can add the favourite course */
//	@PostMapping("/add-favourite")
//	public ResponseEntity<String> addFavourite(@RequestParam("userId") Optional<Long> user_id,
//			@RequestParam("courseId") Optional<Long> course_id) {
//
//		return ResponseEntity.status(HttpStatus.ACCEPTED).body(learnerServiceImpl.addFavourite(user_id.get(), course_id.get()));
//	}
//
//	@GetMapping("/favourites")
//	public ResponseEntity<List<CourseEntity>> addFavourite(@RequestParam("userId") Optional<Long> user_id) {
//
//		return ResponseEntity.status(HttpStatus.ACCEPTED).body(learnerServiceImpl.getAllFavouriteByUserId(user_id.get()));
//	}
//
//	/* user can enroll to the course */
////	@PostMapping("/enroll")
////	public ResponseEntity<?> enrollCourse(@RequestParam("userId") Optional<Long> user_id,
////			@RequestParam("courseId") Optional<Long> course_id)) {
////		return ResponseEntity.status(HttpStatus.ACCEPTED).body("May or may not be enrolled to course");
////	}
//
//}
