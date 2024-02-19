package com.effigo.learningportal.service;

import java.util.List;

import com.effigo.learningportal.model.CourseEntity;

public interface LearnerService {
	public List<CourseEntity> searchCourseById(Long id);

	public List<CourseEntity> searchCourseByAuthor(String auhor);

	public List<CourseEntity> searchCourseByCategory(Long id);

	public String addFavourite(Long uid,Long cid);

	public String enrollCourse(Long uid,Long cid);
}
