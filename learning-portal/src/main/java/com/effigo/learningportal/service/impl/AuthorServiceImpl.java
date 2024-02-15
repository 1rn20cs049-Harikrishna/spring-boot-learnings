package com.effigo.learningportal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.effigo.learningportal.model.Course;
import com.effigo.learningportal.repository.CourseRepository;
import com.effigo.learningportal.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {

	private CourseRepository courseRepository;

	public AuthorServiceImpl(CourseRepository courseRepository) {
		super();
		this.courseRepository = courseRepository;
	}

	@Override
	public String createCourse(Course course) {

		return null;
	}

	@Override
	public String editCourse(Course course) {

		return null;
	}

}
