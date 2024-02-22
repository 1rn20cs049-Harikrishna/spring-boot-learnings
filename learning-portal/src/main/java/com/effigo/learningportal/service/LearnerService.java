package com.effigo.learningportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.effigo.learningportal.dto.CourseDTO;

public interface LearnerService {

	public ResponseEntity<?> searchCourseById(Long courseId);

//	public List<CourseDTO> searchCourseByAuthor(Long author);

	public ResponseEntity<?> searchCourseByCategory(Long categoryId);

	public ResponseEntity<String> addFavourite(Long uid, Long cid);

	public ResponseEntity<String> enrollCourse(Long userId, Long courseId);

	public ResponseEntity<?> getAllFavouriteByUserId(Long uid);

}
