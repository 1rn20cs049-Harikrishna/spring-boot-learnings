package com.effigo.learningportal.service;

import com.effigo.learningportal.model.Course;

public interface AuthorService {
	public Course createCourse(Course course);

	public Course editCourse(Course course);
}
