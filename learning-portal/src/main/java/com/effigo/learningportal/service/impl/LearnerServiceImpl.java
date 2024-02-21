package com.effigo.learningportal.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.effigo.learningportal.exception.EnrollCourseException;
import com.effigo.learningportal.model.CourseCategoryEntity;
import com.effigo.learningportal.model.CourseEntity;
import com.effigo.learningportal.model.EnrollmentEntity;
import com.effigo.learningportal.model.FavouritesEntity;
import com.effigo.learningportal.model.UserEntity;
import com.effigo.learningportal.repository.CourseCategoryRepository;
import com.effigo.learningportal.repository.CourseRepository;
import com.effigo.learningportal.repository.EnrollmentRepository;
import com.effigo.learningportal.repository.FavouritesRepository;
import com.effigo.learningportal.repository.UserRepository;
import com.effigo.learningportal.service.LearnerService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class LearnerServiceImpl implements LearnerService {
	private CourseRepository courseRepository;

	private UserRepository userRepository;

	private FavouritesRepository favouritesRepository;

	private EnrollmentRepository enrollmentRepository;

	private CourseCategoryRepository courseCategoryRepository;

	@Override
	public List<CourseEntity> searchCourseById(Long courseId) {

		return courseRepository.findAllCourseById(courseId);

	}


	@Override
	public List<CourseEntity> searchCourseByCategory(Long categoryId) {
		// Check if the category with the given ID exists
		Optional<CourseCategoryEntity> categoryOptional = courseCategoryRepository.findById(categoryId);

		if (categoryOptional.isPresent()) {
			// Category found, retrieve courses in that category
			CourseCategoryEntity category = categoryOptional.get();
			return courseRepository.findByCourseCategory(category);
		} else {
			// Category not found, return an empty list or handle accordingly
			return Collections.emptyList();
		}
	}

	@Override
	public ResponseEntity<String> addFavourite(Long uid, Long cid) {
		/*
		 * Three things should be checked that is user present or not ,course * present
		 * or not and whether is user is already added favorite
		 */

		try {
			Optional<UserEntity> userOptional = userRepository.getUserById(uid);

			if (userOptional.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
			}

			// Check if the course is present
			Optional<CourseEntity> courseOptional = courseRepository.findById(cid);
			if (courseOptional.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course not found");
			}

			Optional<FavouritesEntity> existingFavourite = favouritesRepository.findByUserIdAndCourseId(uid, cid);
			if (existingFavourite.isPresent()) {
				return ResponseEntity.status(HttpStatus.CONFLICT)
						.body("Course is already added to favorites by the user");

			}

			// If all checks pass, add the course to favorites for the user
			UserEntity user = userOptional.get();
			CourseEntity course = courseOptional.get();

			FavouritesEntity favourite = new FavouritesEntity();
			favourite.setUser(user);
			favourite.setCourse(course);

			favouritesRepository.save(favourite);

			return ResponseEntity.status(HttpStatus.OK).body("Course added to favorites successfully");
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;

	}

	@Override
	public ResponseEntity<String> enrollCourse(Long userId, Long courseId) {
		try {

			Optional<UserEntity> userOptional = userRepository.findById(userId);

			if (userOptional.isPresent()) {
				UserEntity user = userOptional.get();

				// Check if the course with the given cid exists
				Optional<CourseEntity> courseOptional = courseRepository.findById(courseId);

				if (courseOptional.isPresent()) {
					CourseEntity course = courseOptional.get();

					// Check if the user is already enrolled in the course
					boolean isEnrolled = enrollmentRepository.existsByUserAndCourse(user.getId(), course.getId());

					if (!isEnrolled) {
						// User is not enrolled, create a new enrollment
						EnrollmentEntity enrollment = new EnrollmentEntity();
						enrollment.setUser(user);
						enrollment.setCourse(course);

						// Save the enrollment to the database
						enrollmentRepository.save(enrollment);
						return ResponseEntity.status(HttpStatus.CREATED).body("Enrollment successful!");
					} else {
						return ResponseEntity.status(HttpStatus.CONFLICT)
								.body("User is already enrolled in the course!");
					}
				} else {

					return ResponseEntity.status(HttpStatus.NOT_FOUND)
							.body("Course with ID " + courseId + " not found.");
				}
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with ID " + userId + " not found.");
			}
		} catch (Exception e) {

			throw new EnrollCourseException("LearnerServiceImpl::enrollCourse something went wrong");
		}
	}

	@Override
	public ResponseEntity<List<CourseEntity>> getAllFavouriteByUserId(Long uid) {
		try {
			if (userRepository.existsById(uid)) {
				List<CourseEntity> favoriteCourses = favouritesRepository.findAllByUserId(uid);
				return new ResponseEntity<>(favoriteCourses, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			// Handle exceptions appropriately, e.g., log the error
			log.info("LearnerServiceImpl::getAllFavouriteByUserId  Some error " + e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public List<CourseEntity> searchCourseByAuthor(Long author) {

		return Collections.emptyList();
	}

}
