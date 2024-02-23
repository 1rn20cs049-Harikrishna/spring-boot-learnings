package com.effigo.learningportal.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.effigo.learningportal.dto.CourseDTO;
import com.effigo.learningportal.exception.AccessDeniedException;
import com.effigo.learningportal.mapper.CoursePopulator;
import com.effigo.learningportal.model.CourseCategoryEntity;
import com.effigo.learningportal.model.CourseEntity;
import com.effigo.learningportal.model.UserEntity;
import com.effigo.learningportal.repository.CourseCategoryRepository;
import com.effigo.learningportal.repository.CourseRepository;
import com.effigo.learningportal.repository.UserRepository;
import com.effigo.learningportal.service.AuthorService;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {

	private CourseRepository courseRepository;
	private UserRepository userRepository;
	private CourseCategoryRepository courseCategoryRepository;

	@Override
	public ResponseEntity<?> createCourse(CourseDTO courseDto, Long authorId) {

		try {
			/* checking user exists are not */
			Optional<UserEntity> userEntityOptional = userRepository.findById(authorId);

			CourseEntity course = CoursePopulator.INSTANCE.courseDtoToEntity(courseDto);

			/* checking for user mentioned category exists are not */
			Optional<CourseCategoryEntity> courseCategoryEntityOptional = courseCategoryRepository
					.findById(courseDto.getCourseCategoryId());

			// if both user and courseCategory proper then proceed to create course
			if (userEntityOptional.isPresent() && courseCategoryEntityOptional.isPresent()) {
				UserEntity userEntity = userEntityOptional.get();
				if (userEntity.getRole().getId() == 2) {
					course.setPublisher(userEntity);
					CourseCategoryEntity courseCategoryEntity = courseCategoryEntityOptional.get();
					course.setCourseCategory(courseCategoryEntity);
					return ResponseEntity.status(HttpStatus.CREATED)
							.body(CoursePopulator.INSTANCE.courseEntityToDto(courseRepository.save(course)));
				}
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("User is not an author to create the course");

			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Provide the valid author id");
			}

		} catch (Exception e) {
			log.info("AuthorServiceImpl:: createCourse " + e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@Override
	public CourseDTO editCourse(CourseDTO courseDto, Long authorId) {
		Optional<CourseEntity> existingCourseOptional = courseRepository.findById(courseDto.getId());

		if (existingCourseOptional.isPresent()) {
			CourseEntity existingCourse = existingCourseOptional.get();

			/* Check if the authorId matches the publisherId of the course */
			if (existingCourse.getPublisher().getId().equals(authorId)) {
				if (courseDto.getName() != null) {
					existingCourse.setName(courseDto.getName());
				}

				CourseEntity updatedCourse = courseRepository.save(existingCourse);
				return CoursePopulator.INSTANCE.courseEntityToDto(updatedCourse);
			} else {
				/*
				 * User is not authorized to modify this course You can throw an exception,
				 * return a specific response, or handle it based on your requirements
				 */
				throw new AccessDeniedException("User is not authorized to edit this course");
			}
		} else {
			/*
			 * Course with the specified ID not found You can throw an exception, return a
			 * specific response, or handle it based on your requirements
			 */
			throw new EntityNotFoundException("Course with ID " + courseDto.getId() + " not found");
		}
	}

	public void deleteCourse(Long courseId, Long authorId) {

		// Check if the course with the specified ID exists
		Optional<CourseEntity> courseOptional = courseRepository.findById(courseId);

		if (courseOptional.isPresent()) {
			CourseEntity courseToDelete = courseOptional.get();

			/*
			 * Check if the authorId is provided and matches the publisherId of the course
			 */
			if (courseToDelete.getPublisher().getId().equals(authorId)) {
				courseRepository.delete(courseToDelete);

			} else {
				/*
				 * User is not authorized to delete this course You can throw an exception,
				 * return a specific response, or handle it based on your requirements
				 */
				throw new AccessDeniedException("User is not authorized to delete this course");
			}
		} else {
			/*
			 * Course with the specified ID not found You can throw an exception, return a
			 * specific response, or handle it based on your requirements
			 */
			throw new EntityNotFoundException("Course with ID " + courseId + " not found");
		}

	}

	public List<CourseDTO> getCourses(Long authorId) {

		try {
			List<CourseEntity> courses = courseRepository.findAllByPublisherId(authorId);

			return courses.stream().map(CoursePopulator.INSTANCE::courseEntityToDto).toList();
		} catch (Exception e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}
}
