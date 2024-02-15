package com.effigo.learningportal.service;

import com.effigo.learningportal.model.Course;

public interface AuthorService {
	public String createCourse(Course course);

	public String editCourse(Course course);
}
