package com.effigo.learningportal.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.effigo.learningportal.model.CourseEntity;
import com.effigo.learningportal.model.UserEntity;

public interface LearnerService {

	public List<CourseEntity> searchCourseById(Long id);

	public List<CourseEntity> searchCourseByAuthor(Long author);

	public List<CourseEntity> searchCourseByCategory(Long id);

	public ResponseEntity<String>  addFavourite(Long uid, Long cid);

	public ResponseEntity<String> enrollCourse(Long userId, Long courseId);

	public ResponseEntity<List<CourseEntity>> getAllFavouriteByUserId(Long uid);

}
