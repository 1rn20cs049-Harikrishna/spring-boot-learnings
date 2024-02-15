package com.effigo.learningportal.service;

import java.util.List;

import com.effigo.learningportal.model.Course;

public interface LearnerService {
	public List<Course> searchCourse(Long id);

	public String addFavourite(Long id);

	public String enrollCourse(Long id);
}
