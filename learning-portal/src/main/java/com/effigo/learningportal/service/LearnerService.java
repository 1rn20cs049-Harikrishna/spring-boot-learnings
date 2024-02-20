package com.effigo.learningportal.service;

import java.util.List;
import java.util.Optional;

import com.effigo.learningportal.model.CourseEntity;
import com.effigo.learningportal.model.UserEntity;

public interface LearnerService {


	public List<CourseEntity> searchCourseById(Long id);

	public List<CourseEntity> searchCourseByAuthor(Long author);

	public List<CourseEntity> searchCourseByCategory(Long id);

	public String addFavourite(Long uid, Long cid);

	public List<CourseEntity> getAllFavouriteByUserId(Long uid);

	public String enrollCourse(Long uid, Long cid);

}
