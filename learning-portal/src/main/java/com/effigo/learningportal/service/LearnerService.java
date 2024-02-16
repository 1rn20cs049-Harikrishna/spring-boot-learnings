package com.effigo.learningportal.service;

import java.util.List;

import com.effigo.learningportal.model.Course;

public interface LearnerService {
	public List<Course> searchCourseById(Long id);

	public List<Course> searchCourseByAuthor(String auhor);

	public List<Course> searchCourseByCategory(Long id);

	public String addFavourite(Long uid,Long cid);

	public String enrollCourse(Long uid,Long cid);
}
