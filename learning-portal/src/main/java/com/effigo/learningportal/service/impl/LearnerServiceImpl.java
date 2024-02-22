package com.effigo.learningportal.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.effigo.learningportal.exception.EnrollCourseException;
import com.effigo.learningportal.mapper.CoursePopulator;
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
	public ResponseEntity<?> searchCourseById(Long courseId) {

		try {
			List<CourseEntity> courseEntities = courseRepository.findAllCourseById(courseId);
			if (courseEntities.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body("No courses exists with the provided course id");
			}

			return ResponseEntity.status(HttpStatus.OK).body(courseEntities.stream()
					.map(CoursePopulator.INSTANCE::CourseEntityToDto).collect(Collectors.toList()));
		} catch (Exception e) {
			log.info("LearnerServiceImpl:: searchCourseById  " + e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}

	}

	@Override
	public ResponseEntity<?> searchCourseByCategory(Long categoryId) {
		// Check if the category with the given ID exists
		Optional<CourseCategoryEntity> categoryOptional = courseCategoryRepository.findById(categoryId);

		if (categoryOptional.isPresent()) {
			// Category found, retrieve courses in that category
			CourseCategoryEntity category = categoryOptional.get();

			return ResponseEntity.status(HttpStatus.OK).body(category.getCourses());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("provide proper course category id");
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

			/* Check if the course is present */
			Optional<CourseEntity> courseOptional = courseRepository.findById(cid);
			if (courseOptional.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course not found");
			}

			Optional<FavouritesEntity> existingFavourite = favouritesRepository.findByUserIdAndCourseId(uid, cid);
			if (existingFavourite.isPresent()) {
				return ResponseEntity.status(HttpStatus.CONFLICT)
						.body("Course is already added to favorites by the user");

			}

			/* If all checks pass, add the course to favorites for the user */
			UserEntity user = userOptional.get();
			CourseEntity course = courseOptional.get();

			FavouritesEntity favourite = new FavouritesEntity();
			favourite.setUser(user);
			favourite.setCourse(course);

			favouritesRepository.save(favourite);

			return ResponseEntity.status(HttpStatus.OK).body("Course added to favorites successfully");
		} catch (Exception e) {

			log.info("LearnerServiceImpl:: addFavourite  " + e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}

	}

	@Override
	public ResponseEntity<String> enrollCourse(Long userId, Long courseId) {
		try {

			Optional<UserEntity> userOptional = userRepository.findById(userId);

			if (userOptional.isPresent()) {
				UserEntity user = userOptional.get();

				/* Check if the course with the given courseId exists */
				Optional<CourseEntity> courseOptional = courseRepository.findById(courseId);

				if (courseOptional.isPresent()) {
					CourseEntity course = courseOptional.get();

					/* Check if the user is already enrolled in the course */
					boolean isEnrolled = enrollmentRepository.existsByUserAndCourse(user.getId(), course.getId());

					if (!isEnrolled) {
						/* User is not enrolled, create a new enrollment */
						EnrollmentEntity enrollment = new EnrollmentEntity();
						enrollment.setUser(user);
						enrollment.setCourse(course);

						/* Save the enrollment to the database */
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

			throw new EnrollCourseException("LearnerServiceImpl::enrollCourse something went wrong" + e.getMessage());
		}
	}

	@Override
	public ResponseEntity<?> getAllFavouriteByUserId(Long uid) {
		try {

			Optional<UserEntity> userEntity = userRepository.findById(uid);
			if (userEntity.isPresent()) {
				return new ResponseEntity<>(userEntity.get().getFavourites(), HttpStatus.OK);
			} else {
				return new ResponseEntity<>("No such user present", HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			// Handle exceptions appropriately, e.g., log the error
			log.info("LearnerServiceImpl::getAllFavouriteByUserId  Some error " + e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
//
//	@Override
//	public List<CourseDTO> searchCourseByAuthor(Long author) {
//
//		return Collections.emptyList();
//	}

}
