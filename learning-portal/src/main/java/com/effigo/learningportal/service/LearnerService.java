package com.effigo.learningportal.service;

import org.springframework.http.ResponseEntity;

public interface LearnerService {

	public ResponseEntity<?> searchCourseById(Long courseId);

	public ResponseEntity<?> searchCourseByCategory(Long categoryId);

	public ResponseEntity<String> addFavourite(Long uid, Long cid);

	public ResponseEntity<String> enrollCourse(Long userId, Long courseId);

	public ResponseEntity<?> getAllFavouriteByUserId(Long uid);

}
