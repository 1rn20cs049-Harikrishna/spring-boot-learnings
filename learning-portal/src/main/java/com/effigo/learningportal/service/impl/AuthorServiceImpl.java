package com.effigo.learningportal.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.effigo.learningportal.dto.CourseDTO;
import com.effigo.learningportal.exception.AccessDeniedException;
import com.effigo.learningportal.exception.CourseNotFoundException;
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
	public CourseDTO createCourse(CourseDTO courseDto, Long authorId) {

		try {
			// checking user exists are not
			Optional<UserEntity> userEntityOptional = userRepository.findById(authorId);

			CourseEntity course = CoursePopulator.INSTANCE.CourseDtoToEntity(courseDto);

			// checking for user mentioned category exists are not
			Optional<CourseCategoryEntity> courseCategoryEntityOptional = courseCategoryRepository
					.findById(courseDto.getCourseCategoryId());

			// if both user and courseCategory proper then proceed to create course
			if (userEntityOptional.isPresent() && courseCategoryEntityOptional.isPresent()) {
				UserEntity userEntity = userEntityOptional.get();
				course.setPublisher(userEntity);
				CourseCategoryEntity courseCategoryEntity = courseCategoryEntityOptional.get();
				course.setCourseCategory(courseCategoryEntity);
			}

			return CoursePopulator.INSTANCE.CourseEntityToDto(courseRepository.save(course));
		} catch (Exception e) {

			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public CourseDTO editCourse(CourseDTO courseDto, Long authorId) {
		Optional<CourseEntity> existingCourseOptional = courseRepository.findById(courseDto.getId());

		if (existingCourseOptional.isPresent()) {
			CourseEntity existingCourse = existingCourseOptional.get();

			// Check if the authorId matches the publisherId of the course
			if (existingCourse.getPublisher().getId().equals(authorId)) {
				// Update the properties of the existing course with the new values from the DTO
				existingCourse.setName(courseDto.getName());
				// Update other properties as needed

				// Save the updated course
				CourseEntity updatedCourse = courseRepository.save(existingCourse);

				// Convert the updated course back to DTO and return
				return CoursePopulator.INSTANCE.CourseEntityToDto(updatedCourse);
			} else {
				// User is not authorized to modify this course
				// You can throw an exception, return a specific response, or handle it based on
				// your requirements
				throw new AccessDeniedException("User is not authorized to edit this course");
			}
		} else {
			// Course with the specified ID not found
			// You can throw an exception, return a specific response, or handle it based on
			// your requirements
			throw new EntityNotFoundException("Course with ID " + courseDto.getId() + " not found");
		}
	}

	public void deleteCourse(Long courseId, Optional<Long> authorId) {

		// Check if the course with the specified ID exists
		Optional<CourseEntity> courseOptional = courseRepository.findById(courseId);

		if (courseOptional.isPresent()) {
			CourseEntity courseToDelete = courseOptional.get();

			// Check if the authorId is provided and matches the publisherId of the course
			if (authorId.isPresent() && courseToDelete.getPublisher().getId().equals(authorId.get())) {
				// Authorized user, proceed with deletion
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

	public List<CourseDTO> getCourses(Optional<Long> authorId) {

		List<CourseEntity> courses;

		// Check if the authorId is present
		if (authorId.isPresent()) {
			// Retrieve courses for a specific author (publisher)
			courses = courseRepository.findAllByPublisherId(authorId.get());
		} else {
			// Retrieve all courses
			courses = courseRepository.findAll();
		}

		// Convert the list of CourseEntity to a list of CourseDTO
		return courses.stream().map(CoursePopulator.INSTANCE::CourseEntityToDto).collect(Collectors.toList());
	}

	@Override
	public CourseEntity editCourse(CourseEntity updatedCourse) {
		// Step 1: Retrieve the existing course from the database
		try {
			Optional<CourseEntity> existingCourseOptional = courseRepository.findById(updatedCourse.getId());

			if (existingCourseOptional.isPresent()) {
				CourseEntity existingCourse = existingCourseOptional.get();

				// Step 2: Verify that the course exists
				// (This check might not be necessary if the course should always exist)

				// Step 3: Perform the necessary updates
				// For example, update properties like name, status, etc.
				existingCourse.setName(updatedCourse.getName());
				existingCourse.setStatus(updatedCourse.isStatus());

				// Step 4: Save the updated course back to the database
				return courseRepository.save(existingCourse);

			} else {
				// Handle the case where the course doesn't exist
				throw new CourseNotFoundException("Course not found with ID: " + updatedCourse.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
